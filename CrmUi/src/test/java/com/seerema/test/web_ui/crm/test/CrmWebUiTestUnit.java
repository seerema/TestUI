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

package com.seerema.test.web_ui.crm.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;

import com.seerema.test.web_ui.crm.entity.AllCustomers;
import com.seerema.test.web_ui.crm.entity.AllMyCustomers;
import com.seerema.test.web_ui.crm.entity.CrmFieldCats;
import com.seerema.test.web_ui.crm.entity.CrmFields;
import com.seerema.test.web_ui.crm.entity.DummyEntity;
import com.seerema.test.web_ui.crm.entity.MyPotentialClients;
import com.seerema.test.web_ui.crm.entity.MyPotentialClientsEx;
import com.seerema.test.web_ui.crm.entity.MyPotentialClientsUser2;
import com.seerema.test.web_ui.mod.shared.entity.AbstractEntity;
import com.seerema.test.web_ui.mod.shared.test.AbstractModWebUiTestUnit;
import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

public abstract class CrmWebUiTestUnit extends AbstractModWebUiTestUnit {

  private static final Map<String, Map<String, AbstractEntity>> ENTITIES_LIST =
      new HashMap<>();

  private static final Map<String, AbstractEntity> ENTITIES_USER =
      new LinkedHashMap<>();

  static {
    ENTITIES_USER.put(MyPotentialClients.NAME, new MyPotentialClients());
    ENTITIES_USER.put(AllMyCustomers.NAME, new AllMyCustomers());
  }

  private static final Map<String, AbstractEntity> ENTITIES_USER_TEMP =
      new LinkedHashMap<>();

  static {
    ENTITIES_USER_TEMP.put(MyPotentialClients.NAME,
        new MyPotentialClientsUser2());
    ENTITIES_USER_TEMP.put(AllMyCustomers.NAME, new DummyEntity());
  }

  private static final Map<String, AbstractEntity> ENTITIES_USER_EX =
      new LinkedHashMap<>();

  static {
    ENTITIES_USER_EX.put(MyPotentialClients.NAME, new MyPotentialClientsEx());
    ENTITIES_USER_EX.put(AllMyCustomers.NAME, new AllMyCustomers());
  }

  private static final Map<String, AbstractEntity> ENTITIES_MANAGER =
      new LinkedHashMap<>();

  static {
    ENTITIES_MANAGER.put(MyPotentialClients.NAME, new MyPotentialClients());
    ENTITIES_MANAGER.put(AllMyCustomers.NAME, new DummyEntity());
    ENTITIES_MANAGER.put("private::entities", new AllCustomers());
  }

  private static final Map<String, AbstractEntity> ENTITIES_ADMIN =
      new LinkedHashMap<>();

  static {
    ENTITIES_ADMIN.put("field_cats", new CrmFieldCats());
    ENTITIES_ADMIN.put("fields", new CrmFields());
    ENTITIES_ADMIN.put(MyPotentialClients.NAME, new MyPotentialClients());
    ENTITIES_ADMIN.put("entities", new AllMyCustomers());
    ENTITIES_ADMIN.put("private::entities", new AllCustomers());
  }

  static {
    ENTITIES_LIST.put("user1", ENTITIES_USER);
    ENTITIES_LIST.put("user2", ENTITIES_USER_TEMP);
    ENTITIES_LIST.put("user3", ENTITIES_USER_EX);
    ENTITIES_LIST.put("manager", ENTITIES_MANAGER);
    ENTITIES_LIST.put("admin", ENTITIES_ADMIN);
  }

  @BeforeAll
  public static void initBaseLangSet() {

    // @formatter:off
    
    // LL_MY_LEADS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_MY_LEADS",
      "My Potential Clients");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_MY_LEADS",
      "Mes clients potentiels");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_MY_LEADS",
      "Мои Потенциальные Клиенты");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_MY_LEADS",
      "Mis clientes potenciales");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_MY_LEADS",
      "Meine potentiellen Kunden");
    
    // LL_NEVER
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_NEVER",
      "Never");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_NEVER",
      "Jamais");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_NEVER",
      "Никогда");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_NEVER",
      "Nunca");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_NEVER",
      "Noch nie");
    
    // LL_SKYPE_ID
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SKYPE_ID",
      "Skype Id");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SKYPE_ID",
      "Identifiant Skype");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SKYPE_ID",
      "Скайп Имя");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SKYPE_ID",
      "Identificación del skype");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SKYPE_ID",
      "Skype ID");
    
    // LL_SELECT_CUSTOMER_TYPE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SELECT_CUSTOMER_TYPE",
      "Select Customer Type");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SELECT_CUSTOMER_TYPE",
      "Sélectionnez le type de client");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SELECT_CUSTOMER_TYPE",
      "Выбрать Тип Клиента");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SELECT_CUSTOMER_TYPE",
      "Seleccione el tipo de cliente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SELECT_CUSTOMER_TYPE",
      "Wählen Sie Kundentyp");
    
    // LL_LAST_CONTACTED
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_LAST_CONTACTED",
      "Last Contacted");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_LAST_CONTACTED",
      "Dernier contact");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_LAST_CONTACTED",
      "Последний раз контактировали");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_LAST_CONTACTED",
      "Último contactado");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_LAST_CONTACTED",
      "Zuletzt kontaktiert");
  
    // LL_LEADS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_LEADS",
      "Potential Clients");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_LEADS",
      "Clients potentiels");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_LEADS",
      "Потенциальные Контакты");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_LEADS",
      "Clientes potenciales");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_LEADS",
      "Potentielle Kunden");
    
    // LL_LEAD
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_LEAD",
      "Potential Client");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_LEAD",
      "Client potentiel");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_LEAD",
      "Потенциальный Контакт");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_LEAD",
      "Cliente potencial");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_LEAD",
      "Potenziellen Kunden");
    
    // LL_ADD_NEW_MY_LEADS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_MY_LEADS",
      "Add New Potential Client");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_MY_LEADS",
      "Ajouter un nouveau client potentiel");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_MY_LEADS",
      "Добавить Нового Потенциального Клиента");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_MY_LEADS",
      "Agregar nuevo cliente potencial");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_MY_LEADS",
      "Neuen potenziellen Kunden hinzufügen");
    
    // LL_UPDATE_EXISTING_MY_LEADS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_MY_LEADS",
      "Update Existing Potential Client");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_MY_LEADS",
      "Mettre à jour le client potentiel existant");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_MY_LEADS",
      "Обновить Существующий Потенциального Клиента");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_MY_LEADS",
      "Actualizar cliente potencial existente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_MY_LEADS",
      "Aktualisieren Sie den vorhandenen potenziellen Client");
    
    // LL_CUSTOMER
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CUSTOMER",
      "Customer");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CUSTOMER",
      "Client");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CUSTOMER",
      "Клиент");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CUSTOMER",
      "Cliente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CUSTOMER",
      "Kunde");
    
    // LL_STATUS_HISTORY_CHANGE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_STATUS_HISTORY_CHANGE",
      "View history of customer status changes");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_STATUS_HISTORY_CHANGE",
      "Afficher l'historique des changements de statut des clients");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_STATUS_HISTORY_CHANGE",
      "Просмотреть историю изменения статуса клиента");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_STATUS_HISTORY_CHANGE",
      "Ver el historial de cambios de estado del cliente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_STATUS_HISTORY_CHANGE",
      "Verlauf der Änderungen des Kundenstatus anzeigen");
 
    // LL_MY_CUSTOMERS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_MY_CUSTOMERS",
      "My Customers");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_MY_CUSTOMERS",
      "Mes clients");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_MY_CUSTOMERS",
      "Мои Клиенты");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_MY_CUSTOMERS",
      "Mis clientes");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_MY_CUSTOMERS",
      "Meine Kunden");
 
    // LL_LIST_OF_MY_CUSTOMERS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_LIST_OF_MY_CUSTOMERS",
      "List of My Customers");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_LIST_OF_MY_CUSTOMERS",
      "Liste de mes clients");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_LIST_OF_MY_CUSTOMERS",
      "Список Моих Клиентов");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_LIST_OF_MY_CUSTOMERS",
      "Lista de mis clientes");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_LIST_OF_MY_CUSTOMERS",
      "Liste meiner Kunden");

    // LL_PERSON
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_PERSON",
      "Person");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_PERSON",
      "La personne");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_PERSON",
      "Индивидуал");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_PERSON",
      "Persona");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_PERSON",
      "Person");

    // LL_UPDATE_EXISTING_MY_CUSTOMERS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_MY_CUSTOMERS",
      "Update Existing Customer");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_MY_CUSTOMERS",
      "Mettre à jour le client existant");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_MY_CUSTOMERS",
      "Обновить Существующего Клиента");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_MY_CUSTOMERS",
      "Actualizar cliente existente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_MY_CUSTOMERS",
      "Bestehenden Client aktualisieren");

    // LL_OTHER
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_OTHER",
      "Other");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_OTHER",
      "Autre");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_OTHER",
      "Другое");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_OTHER",
      "Otra");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_OTHER",
      "Andere");
    
    // LL_ADD_NEW_CRM_FCATS_FIELD_CAT
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_CRM_FCATS_FIELD_CAT",
      "Add New CRM Category");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_CRM_FCATS_FIELD_CAT",
      "Ajouter une nouvelle catégorie CRM");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_CRM_FCATS_FIELD_CAT",
      "Добавить новую категорию CRM");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_CRM_FCATS_FIELD_CAT",
      "Agregar nueva categoría de CRM");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_CRM_FCATS_FIELD_CAT",
      "Neue CRM-Kategorie hinzufügen");
    
    // LL_CELL_PHONE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CELL_PHONE",
      "Cell Phone");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CELL_PHONE",
      "Téléphone portable");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CELL_PHONE",
      "Мобильный Телефон");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CELL_PHONE",
      "Teléfono móvil");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CELL_PHONE",
      "Handy");
    
    // LL_SELECT_CRM_CATEGORY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SELECT_CRM_CATEGORY",
      "Select CRM Category");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SELECT_CRM_CATEGORY",
      "Sélectionnez la catégorie CRM");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SELECT_CRM_CATEGORY",
      "Выберите CRM Категорию");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SELECT_CRM_CATEGORY",
      "Seleccione la categoría CRM");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SELECT_CRM_CATEGORY",
      "Wählen Sie die CRM-Kategorie");
  
    // LL_ADD_NEW_CRM_FIELDS_FIELD
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_CRM_FIELDS_FIELD",
      "Add New CRM Field");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_CRM_FIELDS_FIELD",
      "Ajouter un nouveau champ CRM");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_CRM_FIELDS_FIELD",
      "Добавить новое поле CRM");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_CRM_FIELDS_FIELD",
      "Agregar nuevo campo CRM");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_CRM_FIELDS_FIELD",
      "Neues CRM-Feld hinzufügen");
    
    // LL_UPDATE_EXISTING_CRM_FIELDS_FIELD
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_CRM_FIELDS_FIELD",
      "Update Existing CRM Field");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_CRM_FIELDS_FIELD",
      "Mettre à jour le champ CRM existant");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_CRM_FIELDS_FIELD",
      "Изменить Существующее Поле CRM");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_CRM_FIELDS_FIELD",
      "Actualizar el campo CRM existente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_CRM_FIELDS_FIELD",
      "Vorhandenes CRM-Feld aktualisieren");
    
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

  @Override
  protected int getMenuSize() {
    return 2;
  }

  protected String getMenuName() {
    return "LL_CRM";
  }

  protected int getMenuIdx() {
    return 2;
  }

  protected String getModName() {
    return "crm";
  }

  protected Map<String, AbstractEntity> getRoleEntities(String user) {
    return ENTITIES_LIST.get(user);
  }
}
