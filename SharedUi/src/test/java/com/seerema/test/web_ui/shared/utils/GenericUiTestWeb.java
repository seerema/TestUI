/*
 * Seerema Business Solutions - http://www.seerema.com/
 * 
 * Copyright 2020 IvaLab Inc. and by respective contributors (see below).
 * 
 * Released under the LGPL v3 or higher
 * See http://www.gnu.org/licenses/lgpl.txt
 *
 * Contributors:
 * 
 */

package com.seerema.test.web_ui.shared.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

/**
 * Generic utilities for GUI Web Test
 * 
 */
public abstract class GenericUiTestWeb extends WebUiTestUtils {

  protected abstract int getPort();

  protected abstract int getMenuSize();

  // Language flag. Used when language defined;
  public static boolean FLANG;

  @BeforeAll
  public static void setLog() throws IOException {
    // Check if system lang variable set and use it for LANG parameter
    String lang = System.getProperty("lang");

    if (lang != null)
      SharedWebUiTestConstants.LANG = lang;

    FLANG = SharedWebUiTestConstants.LANG != null;

    if (!FLANG) {
      System.out.println("GUI test for default language: " +
          SharedWebUiTestConstants.DEFAULT_LANG);
      SharedWebUiTestConstants.LANG = SharedWebUiTestConstants.DEFAULT_LANG;
    } else {
      System.out
          .println("GUI test for language: " + SharedWebUiTestConstants.LANG);
    }

    // @formatter:off
 
    // LL_ERROR_C
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ERROR_C",
        "ERROR");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ERROR_C",
        "ERREUR");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ERROR_C",
        "ОШИБКА");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ERROR_C",
        "ERROR");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ERROR_C",
        "ERROR");

    // LL_REQUEST_ID
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_REQUEST_ID",
        "Request #");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_REQUEST_ID",
        "Demande #");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_REQUEST_ID",
        "Запрос №");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_REQUEST_ID",
        "Solicitud #");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_REQUEST_ID",
        "Anfrage #");

    // LL_INFO_MSG
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_INFO_MSG",
        "Info Message");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_INFO_MSG",
        "Message d'information");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_INFO_MSG",
        "Информационное Сообщение");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_INFO_MSG",
        "Mensaje de información");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_INFO_MSG",
        "Info Nachricht");

    // LL_NAME
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_NAME",
      "Name");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_NAME",
      "Nom");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_NAME",
      "Имя");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_NAME",
      "Nombre");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_NAME",
      "Name");
    
    /*
    //
    SharedWebUiTestConstants.LL_SET.get("en").put("",
      "");
    SharedWebUiTestConstants.LL_SET.get("fr").put("",
      "");
    SharedWebUiTestConstants.LL_SET.get("ru").put("",
      "");
    SharedWebUiTestConstants.LL_SET.get("es").put("",
      "");
    SharedWebUiTestConstants.LL_SET.get("de").put("",
      "");
    */
    
    // @formatter:on
  }

  public void checkErrorWin(String lang, String id, String rid, String info,
      String dshort, String dlong) {
    // Check error messages
    WebElement err = checkElementVisible("error-window", true);
    checkElementVisible(err, "err-info", false);

    assertEquals(getLabelText(lang, "LL_ERROR_C"),
        err.findElement(By.className("ll-error-c")).getText());
    assertEquals(id, err.findElement(By.className("err-code")).getText());
    assertEquals(info, err.findElement(By.className("err-details")).getText());

    // Check Request ID
    WebElement req = checkElementVisible(err, "req-text", true);

    assertEquals(getLabelText(lang, "LL_REQUEST_ID"),
        req.findElement(By.className("ll-request-id")).getText(),
        "Reguest Id text doesn't match.");
    assertEquals(rid, req.findElement(By.className("req-id")).getText(),
        "Request Id doesn't match.");

    if (!(dshort == null || dlong == null)) {
      String msg = dshort + (dlong != null ? "\n" + dlong : "");

      // Click to see details
      err.findElement(By.className("btn-err-toggle")).click();
      sleep();

      SharedTestUtils.testMsg(msg,
          checkElementVisible(err, "err-info", true).getText(),
          "Error info doesn't match");

      // Click to hide details
      err.findElement(By.className("btn-err-toggle")).click();
      sleep();
      checkElementVisible(err, "err-info", false);
    }

    // Close error window
    err.findElement(By.className("b-close")).click();
    sleep();
    checkElementVisible("error-window", false);
  }

  public void init(String lang) {
    initDriver(getGuiUrl());
  }

  public void checkWidgetsOnLogin() {
  }

  public void checkAfterLogout(String lang) {
    sleep();
  }

  protected String getBaseGuiUrl() {
    return SharedWebUiTestConstants.GUI_SRV_URL_BASE;
  }

  protected String getGuiUrl() {
    return "http://localhost:" + getPort() +
        SharedWebUiTestConstants.GUI_SRV_URL +
        (FLANG ? "&lang=" + SharedWebUiTestConstants.LANG : "");
  }

  protected String getLoginUser() {
    return SharedWebUiTestConstants.ANONYMOUS_USER;
  }

  protected void checkSuccessWin(String lang, String id) {
    checkElementVisible("success-window", true);

    // Check success message
    assertEquals(getLabelText(lang, id),
        getTopWebEl().findElement(By.className("ok-msg")).getText(),
        "Success message doesn't match");

    // Click on close button
    getTopWebEl().findElement(By.className("success-window"))
        .findElement(By.className("b-close")).click();

    sleep();
    checkElementVisible("success-window", false);
  }

  public List<WebElement> getMenuItems() {
    // Find & Press menu button
    WebElement mbutton = getTopWebEl().findElement(By.cssSelector("img.menu"));
    mbutton.click();
    sleep();

    WebElement menu = getTopWebEl().findElement(By.cssSelector("ul.menu"));
    List<WebElement> items = menu.findElements(By.tagName("li"));
    assertEquals(getMenuSize(), items.size(), "Menu size doesn't match");

    return items;
  }

}
