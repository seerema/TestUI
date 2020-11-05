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
    
    // LL_NEW_F
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_NEW_F",
      "New");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_NEW_F",
      "Nouvelle");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_NEW_F",
      "Новая");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_NEW_F",
      "Nueva");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_NEW_F",
      "Neue");
    
    // LL_NOTES
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_NOTES",
      "Notes");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_NOTES",
      "Remarques");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_NOTES",
      "Заметки");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_NOTES",
      "Notas");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_NOTES",
      "Anmerkungen");
    
    // LL_TYPE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_TYPE",
      "Type");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_TYPE",
      "Type");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_TYPE",
      "Тип");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_TYPE",
      "Tipo");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_TYPE",
      "Art");
    
    // LL_CREATED
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CREATED",
      "Created");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CREATED",
      "Établie");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CREATED",
      "Создана");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CREATED",
      "Creada");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CREATED",
      "Erstellt");
    
    // LL_USER
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_USER",
      "User");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_USER",
      "Utilisateur");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_USER",
      "Пользователь");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_USER",
      "Usuario");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_USER",
      "Nutzer");
    
    
    // LL_STATUS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_STATUS",
      "Status");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_STATUS",
      "Statut");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_STATUS",
      "Статус");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_STATUS",
      "Estado");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_STATUS",
      "Status");
    
    // LL_PLEASE_CONFIRM
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_PLEASE_CONFIRM",
      "Please confirm");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_PLEASE_CONFIRM",
      "S'il vous plaît confirmer");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_PLEASE_CONFIRM",
      "Пожалуйста подтвердите");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_PLEASE_CONFIRM",
      "Por favor confirmar");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_PLEASE_CONFIRM",
      "Bitte bestätigen");
    
    // LL_ADD
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD",
      "Add");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD",
      "Ajouter");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD",
      "Добавить");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD",
      "Añadir");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD",
      "Hinzufügen");
    
    // LL_CATEGORY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CATEGORY",
      "Category");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CATEGORY",
      "Catégorie");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CATEGORY",
      "Категория");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CATEGORY",
      "Categoría");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CATEGORY",
      "Kategorie");
    
    // LL_CLOSE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CLOSE",
      "Close");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CLOSE",
      "Fermer");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CLOSE",
      "Закрыть");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CLOSE",
      "Cerrar");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CLOSE",
      "Schließen");
    
    // LL_CANCEL
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CANCEL",
      "Cancel");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CANCEL",
      "Annuler");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CANCEL",
      "Отменить");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CANCEL",
      "Cancelar");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CANCEL",
      "Stornieren");
    
    // LL_SAVE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SAVE",
      "Save");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SAVE",
      "Conserver");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SAVE",
      "Сохранить");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SAVE",
      "Löschen");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SAVE",
      "Hinzufügen");
    
    // LL_NEXT
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_NEXT",
      "Next");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_NEXT",
      "Prochain");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_NEXT",
      "Следующий");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_NEXT",
      "Próximo");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_NEXT",
      "Nächster");
    
    // LL_BACK
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_BACK",
      "Back");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_BACK",
      "Arrière");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_BACK",
      "Назад");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_BACK",
      "Espalda");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_BACK",
      "Zurück");
    
    // LL_DELETE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_DELETE",
      "Delete");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_DELETE",
      "Effacer");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_DELETE",
      "Удалить");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_DELETE",
      "Borrar");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_DELETE",
      "Löschen");
    
    // LL_REFRESH
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_REFRESH",
      "Refresh");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_REFRESH",
      "Rafraîchir");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_REFRESH",
      "Обновить");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_REFRESH",
      "Actualizar");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_REFRESH",
      "Aktualisierung");
    
    // LL_ADDRESS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADDRESS",
      "Address");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADDRESS",
      "Adresse");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADDRESS",
      "Адрес");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADDRESS",
      "Habla a");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADDRESS",
      "Adresse");
    
    // LL_WEB_SITE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_WEB_SITE",
      "Web Site");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_WEB_SITE",
      "Site Internet");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_WEB_SITE",
      "Веб Сайт");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_WEB_SITE",
      "Sitio web");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_WEB_SITE",
      "Webseite");
    
    // LL_PHONE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_PHONE",
      "Phone");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_PHONE",
      "Téléphone");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_PHONE",
      "Телефон");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_PHONE",
      "Teléfono");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_PHONE",
      "Telefon");
    
    // LL_EMAIL
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_EMAIL",
      "Email");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_EMAIL",
      "Email");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_EMAIL",
      "Эл. Почта");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_EMAIL",
      "Email");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_EMAIL",
      "Email");
    
    // LL_FAX
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_FAX",
      "Fax");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_FAX",
      "Fax");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_FAX",
      "Факс");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_FAX",
      "Fax");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_FAX",
      "Fax");
    
    
    // LL_COMPANY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_COMPANY",
      "Company");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_COMPANY",
      "Compagnie");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_COMPANY",
      "Компания");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_COMPANY",
      "Empresa");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_COMPANY",
      "Unternehmen");
    
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

  protected void injectUser(String username) {
    // Inject user into session
    String url = "http://localhost:" + getPort() +
        SharedWebUiTestConstants.GUI_CTX_URL + "/login?username=" + username;
    getDriver().get(url);
    sleep(2);
  }
}
