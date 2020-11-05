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

package com.seerema.test.web_ui.bootstrap.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;
import com.seerema.test.web_ui.shared.utils.AbstractSharedWebUiTest;

public abstract class BaseWebUiTestUnit extends AbstractSharedWebUiTest {

  @BeforeAll
  public static void initBaseLangSet() {

    // @formatter:off

    // LL_DEMO_MSG
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_DEMO_MSG",
        "Wed, 31 Dec 1969, 19:00:00 - Demo Application Ready !!!");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_DEMO_MSG",
        "mer., 31 déc. 1969, 19:00:00 - Démo Application Ready !!!");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_DEMO_MSG",
        "срд, 31 Дек 1969, 19:00:00 - Демо Программа готова !!!");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_DEMO_MSG",
        "mié, 31 dic 1969, 19:00:00 - Aplicación de demostración listo !!!");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_DEMO_MSG",
        "Mi, 31 Dez 1969, 19:00:00 - Demo-Anwendung fertig !!!");

    // LL_DETAIL_MSG_SHORT
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_DETAIL_MSG_SHORT",
        "Short Detail Message.");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_DETAIL_MSG_SHORT",
        "Message détaillé court.");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_DETAIL_MSG_SHORT",
        "Короткое детально сообщение.");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_DETAIL_MSG_SHORT",
        "Mensaje de detalle corto.");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_DETAIL_MSG_SHORT",
        "Kurze Detailmeldung.");

    // LL_DETAIL_MSG_LONG
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_DETAIL_MSG_LONG",
        "Very long detail message that can exceed the default window width.");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_DETAIL_MSG_LONG",
        "Message de détail très long pouvant dépasser la largeur de fenêtre par défaut.");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_DETAIL_MSG_LONG",
        "Очень детальное сообщение которое может превысить нормальную ширину окна.");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_DETAIL_MSG_LONG",
        "Mensaje de detalle muy largo que puede exceder el ancho de ventana predeterminado.");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_DETAIL_MSG_LONG",
        "Sehr lange Detailmeldung, die die Standardfensterbreite überschreiten kann.");

    /*
    //
    SharedWebUiTestConstants.LL_SET.get("en").put("", "");
    SharedWebUiTestConstants.LL_SET.get("fr").put("", "");
    SharedWebUiTestConstants.LL_SET.get("ru").put("", "");
    SharedWebUiTestConstants.LL_SET.get("es").put("", "");
    SharedWebUiTestConstants.LL_SET.get("de").put("", "");
    */

    // @formatter:on
  }

  @Override
  public void checkAfterLogout(String lang) {
    // Check bye msg
    assertEquals(getLabelText(lang, "LL_BYE_BYE"),
        getTopWebEl().findElement(By.tagName("h2")).getText(),
        "h2 element text doesn't match");
  }

  private void checkDemoPage(String lang) {
    checkElementVisible("page-loader", false);
    // checkElementVisible("login_widget", false);
    checkElementVisible("webapp-ctx", true);
    checkElementVisible("error-window", false);
    checkSuccessWin(lang, "LL_DEMO_MSG");

    // Extra check
    checkWidgetsOnLogin();

    // Check color of message
    WebElement dmsg = getTopWebEl().findElement(By.className("demo"));
    assertEquals("rgba(33, 37, 41, 1)", dmsg.getCssValue("color"),
        "demo message color doesn't match");

    List<WebElement> mitems = getMenuItems();

    // Find &  Press error button
    WebElement err = mitems.get(0); //.findElement(By.className("ll_error"));
    err.click();
    sleep();

    checkErrorWin(lang, "C-DEMO", "99", getLabelText(lang, "LL_INFO_MSG"),
        getLabelText(lang, "LL_DETAIL_MSG_SHORT"),
        getLabelText(lang, "LL_DETAIL_MSG_LONG"));
  }

  @Override
  public void checkAfterSimpleLogin(String lang) throws Exception {
    checkDemoPage(lang);
  }

  @Override
  protected int getMenuSize() {
    return 2;
  }
}
