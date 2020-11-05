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

package com.seerema.test.web_ui.catalog.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;

import com.seerema.test.web_ui.catalog.entity.AbstractEntity;
import com.seerema.test.web_ui.catalog.entity.Addresses;
import com.seerema.test.web_ui.catalog.entity.Cities;
import com.seerema.test.web_ui.catalog.entity.Companies;
import com.seerema.test.web_ui.catalog.entity.Countries;
import com.seerema.test.web_ui.catalog.entity.Regions;
import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;
import com.seerema.test.web_ui.shared.utils.AbstractSharedWebUiTest;

public abstract class CatalogWebUiTestUnit extends AbstractSharedWebUiTest {

  // Workflow widget class name
  private static final String WFLOW_CNAME_PREFIX = "wflow-";

  private static final Map<String, AbstractEntity> ENTITIES =
      new LinkedHashMap<>();

  static {
    ENTITIES.put("countries", new Countries());
    ENTITIES.put("regions", new Regions());
    ENTITIES.put("cities", new Cities());
    ENTITIES.put("addresses", new Addresses());
    ENTITIES.put("entities", new Companies());
  }

  @BeforeAll
  public static void initBaseLangSet() {

    // @formatter:off

    // LL_HIDE_SIDEBAR
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_HIDE_SIDEBAR",
         "Hide Sidebar");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_HIDE_SIDEBAR",
        "Masquer la barre latérale");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_HIDE_SIDEBAR",
        "Спрятать боковое меню");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_HIDE_SIDEBAR",
        "Esconder barra lateral");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_HIDE_SIDEBAR",
        "Seitenleiste ausblenden");
    
    // LL_SHOW_SIDEBAR
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SHOW_SIDEBAR",
        "Show Sidebar");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SHOW_SIDEBAR",
        "Afficher la barre latérale");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SHOW_SIDEBAR",
        "Показать боковое меню");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SHOW_SIDEBAR",
        "Mostrar barra lateral");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SHOW_SIDEBAR",
        "Seitenleiste anzeigen");
    
    // LL_CATALOGS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CATALOGS",
        "Catalogs");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CATALOGS",
      "Catalogues");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CATALOGS",
      "Каталоги");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CATALOGS",
      "Catálogos");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CATALOGS",
      "Kataloge");
    
    // LL_ADDRESS_FORMATTER
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADDRESS_FORMATTER",
        "Address Formatter");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADDRESS_FORMATTER",
        "Formateur d'adresse");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADDRESS_FORMATTER",
        "Форматирование Адреса");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADDRESS_FORMATTER",
        "Formateador de direcciones");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADDRESS_FORMATTER",
        "Adressformatierer");
    
    // LL_ADD_NEW_COUNTRY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_COUNTRY",
      "Add New Country");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_COUNTRY",
      "Ajouter un nouveau pays");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_COUNTRY",
      "Добавить Новую Страну");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_COUNTRY",
      "Agregar nuevo país");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_COUNTRY",
      "Neues Land hinzufügen");
    
    // LL_UPDATE_EXISTING_COUNTRY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_COUNTRY",
      "Update Existing Country");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_COUNTRY",
      "Mettre à jour le pays existant");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_COUNTRY",
      "Редактировать Существующую Страну");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_COUNTRY",
      "Actualizar país existente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_COUNTRY",
      "Aktualisieren Sie das vorhandene Land");
    
    // LL_ADD_NEW_PROVINCE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_PROVINCE",
      "Add New Province");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_PROVINCE",
      "Ajouter une nouvelle province");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_PROVINCE",
      "Добавить Новую Провинцию");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_PROVINCE",
      "Añadir nueva provincia");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_PROVINCE",
      "Neue Provinz hinzufügen");
    
    // LL_UPDATE_EXISTING_PROVINCE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_PROVINCE",
      "Update Existing Province");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_PROVINCE",
      "Mettre à jour la province existante");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_PROVINCE",
      "Редактировать Существующую Провинцию");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_PROVINCE",
      "Actualizar provincia existente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_PROVINCE",
      "Bestehende Provinz aktualisieren");
      
    // LL_ADD_NEW_CITY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_CITY",
      "Add New City");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_CITY",
      "Ajouter une nouvelle ville");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_CITY",
      "Добавить Новый Город");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_CITY",
      "Agregar nueva ciudad");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_CITY",
      "Neue Stadt hinzufügen");
    
    // LL_UPDATE_EXISTING_CITY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_CITY",
      "Update Existing City");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_CITY",
      "Ajouter une nouvelle ville");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_CITY",
      "Редактировать Существующий Город");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_CITY",
      "Agregar nueva ciudad");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_CITY",
      "Neue Stadt hinzufügen");

    // LL_ADD_NEW_ADDRESS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_ADDRESS",
      "Add New Address");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_ADDRESS",
      "Liste des adresses");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_ADDRESS",
      "Добавить Новый Адрес");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_ADDRESS",
      "Lista de direcciones");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_ADDRESS",
      "Liste der Adressen");

    // LL_UPDATE_EXISTING_ADDRESS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_ADDRESS",
      "Update Existing Address");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_ADDRESS",
      "Mettre à jour l'adresse existante");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_ADDRESS",
      "Редактировать Существующий Адрес");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_ADDRESS",
      "Actualizar dirección existente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_ADDRESS",
      "Vorhandene Adresse aktualisieren");

    // LL_ADD_NEW_COMPANY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_COMPANY",
      "Add New Business Unit");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_COMPANY",
      "Ajouter une nouvelle unité commerciale");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_COMPANY",
      "Добавить Новую Бизнес Единицу");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_COMPANY",
      "Agregar nueva unidad de negocios");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_COMPANY",
      "Neuen Geschäftsbereich hinzufügen");
    
    // LL_UPDATE_EXISTING_COMPANY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_COMPANY",
      "Update Existing Business Unit");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_COMPANY",
      "Mettre à jour l'unité commerciale existante");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_COMPANY",
      "Редактировать Существующую Бизнес Единицу");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_COMPANY",
      "Actualizar la unidad de negocio existente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_COMPANY",
      "Bestehende Geschäftseinheit aktualisieren");

    // LL_REGION_NAME
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_REGION_NAME",
      "Region Name");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_REGION_NAME",
      "Nom de la région");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_REGION_NAME",
      "Имя Региона");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_REGION_NAME",
      "Nombre de región");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_REGION_NAME",
      "Regionsname");

    // LL_POSTAL_NAME
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_POSTAL_NAME",
      "Postal Name");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_POSTAL_NAME",
      "Nom postal");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_POSTAL_NAME",
      "Почтовое Имя");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_POSTAL_NAME",
      "Nombre postal");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_POSTAL_NAME",
      "Postname");

    // LL_REGION_FIELD
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_REGION_FIELD",
      "Region Field");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_REGION_FIELD",
      "Champ Région");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_REGION_FIELD",
      "Поле Региона");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_REGION_FIELD",
      "Campo de la región");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_REGION_FIELD",
      "Regionsfeld");
    
    // LL_ADDRESS_FORMATTER
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADDRESS_FORMATTER",
      "Address Formatter");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADDRESS_FORMATTER",
      "Formateur d'adresse");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADDRESS_FORMATTER",
      "Форматирование Адреса");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADDRESS_FORMATTER",
      "Formateador de direcciones");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADDRESS_FORMATTER",
      "Adressformatierer");

    // LL_SHORT_NAME
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SHORT_NAME",
      "Short Name");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SHORT_NAME",
      "Nom court");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SHORT_NAME",
      "Короткое Имя");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SHORT_NAME",
      "Nombre corto");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SHORT_NAME",
      "Kurzer Name");

    // LL_COUNTRY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_COUNTRY",
      "Country");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_COUNTRY",
      "Pays");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_COUNTRY",
      "Страна");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_COUNTRY",
      "País");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_COUNTRY",
      "Land");

    // LL_PROVINCE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_PROVINCE",
      "Province");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_PROVINCE",
      "Province");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_PROVINCE",
      "Провинция");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_PROVINCE",
      "Provincia");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_PROVINCE",
      "Provinz");

    // LL_ADDR_LINE_1
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADDR_LINE_1",
      "Address Line 1");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADDR_LINE_1",
      "Adresse 1");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADDR_LINE_1",
      "Адрессная Линия 1");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADDR_LINE_1",
      "Dirección Línea 1");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADDR_LINE_1",
      "Anschrift Zeile 1");

    // LL_ADDR_LINE_2
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADDR_LINE_2",
      "Address Line 2");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADDR_LINE_2",
      "Adresse 2");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADDR_LINE_2",
      "Адрессная Линия 2");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADDR_LINE_2",
      "Dirección Línea 2");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADDR_LINE_2",
      "Anschrift Zeile 2");

    // LL_CITY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CITY",
      "City");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CITY",
      "Ville");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CITY",
      "Город");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CITY",
      "Ciudad");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CITY",
      "Stadt");

    // LL_POSTAL_CODE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_POSTAL_CODE",
      "Postal Code");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_POSTAL_CODE",
      "Code Postal");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_POSTAL_CODE",
      "Почтовый Код");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_POSTAL_CODE",
      "Código postal");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_POSTAL_CODE",
      "Postleitzahl");
    
    // LL_SELECT_COUNTRY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SELECT_COUNTRY",
        "Select Country");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SELECT_COUNTRY",
      "Choisissez le pays");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SELECT_COUNTRY",
      "Выберите Страну");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SELECT_COUNTRY",
      "Seleccionar país");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SELECT_COUNTRY",
      "Land auswählen");
    
    // LL_SELECT_PROVINCE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SELECT_PROVINCE",
        "Select Province");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SELECT_PROVINCE",
      "Sélectionnez la province");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SELECT_PROVINCE",
      "Выберите Провинцию");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SELECT_PROVINCE",
      "Seleccione provincia");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SELECT_PROVINCE",
      "Wählen Sie Provinz");
    
    // LL_SELECT_CITY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SELECT_CITY",
      "Select City");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SELECT_CITY",
      "Sélectionnez une ville");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SELECT_CITY",
      "Выберите Город");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SELECT_CITY",
      "Ciudad selecta");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SELECT_CITY",
      "Stadt wählen");
    
    // LL_SELECT_BUSINESS_CATEGORY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SELECT_BUSINESS_CATEGORY",
      "Select Business Category");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SELECT_BUSINESS_CATEGORY",
      "Sélectionnez la catégorie d'entreprisee");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SELECT_BUSINESS_CATEGORY",
      "Выберите Бизнес Инфо Категорию");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SELECT_BUSINESS_CATEGORY",
      "Seleccionar categoría empresarial");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SELECT_BUSINESS_CATEGORY",
      "Wählen Sie Geschäftskategorie");
    
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

  @Test
  void testEntities() throws Exception {
    injectUser("manager");
    init(SharedWebUiTestConstants.LANG);

    WebElement nav = getSideNavigationEl();
    WebElement title = nav.findElement(By.cssSelector("li.active"));
    WebElement ctx = getTopWebEl().findElement(By.className("main-context"));

    // Initial state is hidden
    WebElement catalogs =
        checkElementVisibleId("catalog", false, "Catalogs menu is not hidden.");
    title.click();
    sleep();

    testElementVisible(catalogs, "catalog", true,
        "Catalogs menu is not visible.");

    for (Entry<String, AbstractEntity> entry : ENTITIES.entrySet()) {
      String name = entry.getKey();
      AbstractEntity handler = entry.getValue();
      SharedWebUiTestConstants.LOG.debug("Testing entity " + name);

      // Click on entity
      WebElement entity = checkElementVisibleEx(".entity[entity=" + name + "]",
          true, "Entity menu " + name + " not visible.");

      showEntityList(ctx, name, entity);
      SharedWebUiTestConstants.LOG.debug("Show initial entity " + name);

      // Close entity
      clickCloseButton(ctx);

      List<WebElement> rows = showEntityList(ctx, name, entity);

      handler.checkHeaders(rows.get(0));
      handler.checkInitData(rows);
      SharedWebUiTestConstants.LOG.debug("Checked initial data");

      try {
        WebElement add = getAddEntityWidget(ctx, name, handler, false);

        // Close New Entity form
        clickCancelButton(add);

        // Check it back to entity list
        handler.checkInitData(getEnityListRows(ctx, name));

        // Start workflow again but this time straight
        add = getAddEntityWidget(ctx, name, handler, true);

        // Check Add Entity Title
        assertEquals(
            getLabelText(SharedWebUiTestConstants.LANG,
                handler.getAddEntityTitle()),
            add.findElement(By.tagName("h2")).getText());

        // handler.checkWidgetLabels();
        handler.fillAddEntity(add);

        // Save entity
        clickSaveButton(ctx);

        // Check new data
        WebElement row = handler.checkNewList(getEnityListRows(ctx, name));

        // Click on new data
        row.click();

        WebElement upd = checkElementVisible(ctx, "entity", true,
            "Update existing entity for " + name + " is not visible");

        // Check Add Entity Title
        assertEquals(
            getLabelText(SharedWebUiTestConstants.LANG,
                handler.getUpdateEntityTitle()),
            upd.findElement(By.tagName("h2")).getText());

        handler.fillUpdateEntity(upd);

      } catch (Exception e) {
        fail(e.getMessage());
      }

      clickSaveButton(ctx);

      WebElement row = handler.checkUpdateList(getEnityListRows(ctx, name));

      // Delete new entity
      row.click();
      clickDeleteButton(ctx);

      String text = closeAlertAndGetItsText(true);
      sleep(3);

      // Verify confirmation text
      assertEquals(text,
          getLabelText(SharedWebUiTestConstants.LANG, "LL_PLEASE_CONFIRM"));

      // Verify entity data same as started
      handler.checkInitData(getEnityListRows(ctx, name));
      SharedWebUiTestConstants.LOG
          .debug("Deleted new entry for entity " + name);

      // Close entity
      clickCloseButton(ctx);
    }
  }

  private WebElement getAddEntityWidget(WebElement ctx, String name,
      AbstractEntity handler, boolean fstraight)
      throws NoSuchElementException, Exception {
    clickAddButton(ctx);

    WebElement add;
    if (handler.getSlideSize() > 0)
      add = checkSlides(ctx, handler, name, fstraight);
    else
      add = checkElementVisible(ctx, "entity", true,
          "Add new entity for " + name + " is not visible");
    return add;
  }

  private WebElement checkSlides(WebElement ctx, AbstractEntity handler,
      String name, boolean fstraight) throws NoSuchElementException, Exception {
    if (!fstraight) {
      // Go back&Force
      checkSlidesBackForce(ctx, handler, name);

      clickNextButton(ctx);
    }

    int start = fstraight ? 1 : 2;

    for (int i = start; i <= handler.getSlideSize(); i++) {
      // Go normal path
      WebElement slide = checkElementVisible(ctx, getSlideClassName(handler, i),
          true, "Slide #" + i + " is not visible.");

      // Check slide title
      handler.checkSlideTitle(slide, i);

      handler.fillSlide(slide, i);
      clickNextButton(slide);
    }

    return checkElementVisible(ctx, "entity", true,
        "Add new entity widget is not visible.");
  }

  private void checkSlidesBackForce(WebElement ctx, AbstractEntity handler,
      String name) throws NoSuchElementException, Exception {
    // Click cancel
    clickCancelButton(ctx);

    // Check it back to entity list
    handler.checkInitData(getEnityListRows(ctx, name));

    // Click add again
    clickAddButton(ctx);

    // Try click Next without filling
    // TODO Check for mandatory field errors

    String wname = getSlideClassName(handler, 1);
    handler.fillSlide(
        checkElementVisible(ctx, wname, true, "Slide #1 is not visible."), 1);

    clickNextButton(ctx);

    clickBackButton(ctx);

    // Check that data is the same on previous slide
    handler.checkSlide(
        checkElementVisible(ctx, wname, true, "Slide #1 is not visible."), 1);
  }

  private String getSlideClassName(AbstractEntity handler, int idx) {
    return WFLOW_CNAME_PREFIX + handler.getSlideName(idx);
  }

  private void clickAddButton(WebElement ctx) {
    clickButton(ctx, "add", "Add");
  }

  private void clickCloseButton(WebElement ctx) {
    clickButton(ctx, "wclose", "Close");
  }

  private void clickCancelButton(WebElement ctx) {
    clickButton(ctx, "cancel", "Cancel");
  }

  private void clickSaveButton(WebElement ctx) {
    clickButton(ctx, "save", "Save", 3);
  }

  private void clickNextButton(WebElement ctx) {
    clickButton(ctx, "next", "Next", 3);
  }

  private void clickBackButton(WebElement ctx) {
    clickButton(ctx, "back", "Back");
  }

  private void clickDeleteButton(WebElement ctx) {
    clickButton(ctx, "delete", "Delete");
  }

  private void clickButton(WebElement ctx, String id, String title) {
    clickButton(ctx, id, title, 1);
  }

  private void clickButton(WebElement ctx, String id, String title,
      int timeout) {
    WebElement btn = checkElementVisibleEx(ctx, "button." + id, true,
        title + " button not visible.");

    // TODO Check button visible name
    btn.click();
    sleep(timeout);
  }

  private List<WebElement> showEntityList(WebElement parent, String name,
      WebElement entity) {
    assertFalse(checkElementPresent(parent, "entity-list"),
        "Table with entity " + name + " is not hidden.");

    entity.click();
    sleep(2);

    return getEnityListRows(parent, name);
  }

  private List<WebElement> getEnityListRows(WebElement parent, String name) {
    WebElement tdata = checkElementVisible("entity-list", true,
        "Table with entity " + name + " not visible.");

    return tdata.findElements(By.tagName("tr"));
  }

  private WebElement getSideNavigationEl() throws Exception {
    WebElement nav = checkElementVisibleEx("nav.sidebar", true,
        "Side navigation is not visible.");
    return nav;
  }

  private void testSideNavigation() throws Exception {
    WebElement nav = getSideNavigationEl();

    // Check catalog title
    assertEquals(getLabelText(SharedWebUiTestConstants.LANG, "LL_CATALOGS"),
        nav.findElement(By.cssSelector("li.active"))
            .findElement(By.tagName("a")).getText());

    // Click hide navigation
    clickMenuItem("LL_HIDE_SIDEBAR");

    // Check side navigation is shited left
    assertEquals("-150px", nav.getCssValue("margin-left"),
        "Side Navigation is not shifted left");

    // Click show navigation
    clickMenuItem("LL_SHOW_SIDEBAR");

    // Check side navigation is hidden
    // Check side navigation is shited left
    assertEquals("0px", nav.getCssValue("margin-left"),
        "Side Navigation is not shifted right");

  }

  private void clickMenuItem(String lid) {
    // Click hide navigation
    List<WebElement> mitems = getMenuItems();

    // Check first item
    WebElement snav = mitems.get(0);
    assertEquals(getLabelText(SharedWebUiTestConstants.LANG, lid),
        snav.findElement(By.tagName("span")).getText(),
        "Side navigation menu " + lid + " is not found");
    snav.click();
    sleep();

    // Check that both menu is hidden
    testElementVisible(snav, "menu", false);
  }

  @Override
  public void checkAfterSimpleLogin(String lang) throws Exception {
    testSideNavigation();
  }

  @Override
  protected int getMenuSize() {
    return 2;
  }
}
