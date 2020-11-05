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

package com.seerema.test.web_ui.task.test;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import org.junit.jupiter.api.BeforeAll;

import com.seerema.test.web_ui.mod.shared.entity.AbstractEntity;
import com.seerema.test.web_ui.mod.shared.test.AbstractModWebUiTestUnit;
import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;
import com.seerema.test.web_ui.task.entity.AllMyTasks;
import com.seerema.test.web_ui.task.entity.AllTasks;
import com.seerema.test.web_ui.task.entity.MyActiveTasks;
import com.seerema.test.web_ui.task.entity.MyActiveTasksEx;
import com.seerema.test.web_ui.task.entity.TaskFieldCats;
import com.seerema.test.web_ui.task.entity.TaskFields;

public abstract class TaskWebUiTestUnit extends AbstractModWebUiTestUnit {

  private static final Map<String, Map<String, AbstractEntity>> ENTITIES_LIST =
      new HashMap<>();

  private static final Map<String, AbstractEntity> ENTITIES_USER =
      new LinkedHashMap<>();

  static {
    ENTITIES_USER.put("entities::active", new MyActiveTasks());
    ENTITIES_USER.put("entities", new AllMyTasks());
  }

  private static final Map<String, AbstractEntity> ENTITIES_USER_EX =
      new LinkedHashMap<>();

  static {
    ENTITIES_USER_EX.put("entities::active", new MyActiveTasksEx());
    ENTITIES_USER_EX.put("entities", new AllMyTasks());
  }

  private static final Map<String, AbstractEntity> ENTITIES_MANAGER =
      new LinkedHashMap<>();

  static {
    ENTITIES_MANAGER.put("entities::active", new MyActiveTasks());
    ENTITIES_MANAGER.put("entities", new AllMyTasks());
    ENTITIES_MANAGER.put("private::entities", new AllTasks());
  }

  private static final Map<String, AbstractEntity> ENTITIES_ADMIN =
      new LinkedHashMap<>();

  static {
    ENTITIES_ADMIN.put("field_cats", new TaskFieldCats());
    ENTITIES_ADMIN.put("fields", new TaskFields());
    ENTITIES_ADMIN.put("entities::active", new MyActiveTasks());
    ENTITIES_ADMIN.put("entities", new AllMyTasks());
    ENTITIES_ADMIN.put("private::entities", new AllTasks());
  }

  static {
    ENTITIES_LIST.put("user1", ENTITIES_USER);
    ENTITIES_LIST.put("user2", ENTITIES_USER);
    ENTITIES_LIST.put("user3", ENTITIES_USER_EX);
    ENTITIES_LIST.put("manager", ENTITIES_MANAGER);
    ENTITIES_LIST.put("admin", ENTITIES_ADMIN);
  }

  @BeforeAll
  public static void initBaseLangSet() {

    // @formatter:off
    
    // LL_TASKS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_TASKS",
      "Tasks");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_TASKS",
      "Tâches");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_TASKS",
      "Задачи");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_TASKS",
      "Tareas");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_TASKS",
      "Aufgaben");
    
    // LL_MY_QUESTS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_MY_QUESTS",
      "All My Tasks");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_MY_QUESTS",
      "Toutes mes tâches");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_MY_QUESTS",
      "Все Мои Задачи");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_MY_QUESTS",
      "Todas mis tareas");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_MY_QUESTS",
      "Alle meine Aufgaben");
    
    // LL_MY_ACTIVE_QUESTS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_MY_ACTIVE_QUESTS",
      "My Active Tasks");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_MY_ACTIVE_QUESTS",
      "Mes tâches actives");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_MY_ACTIVE_QUESTS",
      "Мои Активные Задачи");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_MY_ACTIVE_QUESTS",
      "Mis tareas activas");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_MY_ACTIVE_QUESTS",
      "Aktive Aufgaben");
    
    // LL_REGULAR
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_REGULAR",
        "Regular");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_REGULAR",
      "Régulier");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_REGULAR",
      "Обычный");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_REGULAR",
      "Regular");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_REGULAR",
      "Regulär");
    
    // LL_SELECT_TASK_CATEGORY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SELECT_TASK_CATEGORY",
      "Select Task Category");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SELECT_TASK_CATEGORY",
      "Sélectionnez la catégorie de tâche");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SELECT_TASK_CATEGORY",
      "Выберите Категорию Задачи");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SELECT_TASK_CATEGORY",
      "Seleccionar categoría de tarea");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SELECT_TASK_CATEGORY",
      "Wählen Sie Aufgabenkategorie");
    
    // LL_ADD_NEW_MY_ACTIVE_QUESTS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_MY_ACTIVE_QUESTS",
      "Add New Task");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_MY_ACTIVE_QUESTS",
      "Ajouter une nouvelle tâche");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_MY_ACTIVE_QUESTS",
      "Добавить Новую Задачу");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_MY_ACTIVE_QUESTS",
      "Agregar nueva tarea");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_MY_ACTIVE_QUESTS",
      "Neue Aufgabe hinzufügen");
    
    // LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS_ENTITY
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS",
      "Update Existing Task");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS",
      "Mettre à jour la tâche existante");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS",
      "Обновить Существующую Задачу");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS",
      "Actualizar tarea existente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS",
      "Vorhandene Aufgabe aktualisieren");
    
    // LL_UPDATE_EXISTING_MY_QUESTS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_UPDATE_EXISTING_MY_QUESTS",
        SharedWebUiTestConstants.LL_SET.get("en").get("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS"));
      SharedWebUiTestConstants.LL_SET.get("fr").put("LL_UPDATE_EXISTING_MY_QUESTS",
          SharedWebUiTestConstants.LL_SET.get("fr").get("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS"));
      SharedWebUiTestConstants.LL_SET.get("ru").put("LL_UPDATE_EXISTING_MY_QUESTS",
          SharedWebUiTestConstants.LL_SET.get("ru").get("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS"));
      SharedWebUiTestConstants.LL_SET.get("es").put("LL_UPDATE_EXISTING_MY_QUESTS",
          SharedWebUiTestConstants.LL_SET.get("es").get("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS"));
      SharedWebUiTestConstants.LL_SET.get("de").put("LL_UPDATE_EXISTING_MY_QUESTS",
          SharedWebUiTestConstants.LL_SET.get("de").get("LL_UPDATE_EXISTING_MY_ACTIVE_QUESTS"));
      
    // LL_DUE_DATE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_DUE_DATE",
      "Due Date");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_DUE_DATE",
      "Date d'échéance");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_DUE_DATE",
      "Срок");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_DUE_DATE",
      "Fecha de vencimiento");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_DUE_DATE",
      "Geburtstermin");
    
    // LL_STARTED
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_STARTED",
      "Started");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_STARTED",
      "Commencé");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_STARTED",
      "Начата");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_STARTED",
      "Iniciada");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_STARTED",
      "Gestartet");
    
    // LL_COMPLETED
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_COMPLETED",
      "Completed");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_COMPLETED",
      "Terminé");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_COMPLETED",
      "Завершена");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_COMPLETED",
      "Terminada");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_COMPLETED",
      "Abgeschlossen");
    
    // LL_LIST_OF_MY_QUESTS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_LIST_OF_MY_QUESTS",
      "List of All My Tasks");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_LIST_OF_MY_QUESTS",
      "Liste de toutes mes tâches");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_LIST_OF_MY_QUESTS",
      "Список Всех Моих Задач");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_LIST_OF_MY_QUESTS",
      "Lista de todas mis tareas");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_LIST_OF_MY_QUESTS",
      "Liste aller meiner Aufgaben");
    
    // LL_MY_QUESTS
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_MY_QUESTS",
      "All My Tasks");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_MY_QUESTS",
      "Toutes mes tâches");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_MY_QUESTS",
      "Все Мои Задачи");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_MY_QUESTS",
      "Todas mis tareas");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_MY_QUESTS",
      "Alle meine Aufgaben");
    
    // LL_STATUS_HISTORY_CHANGE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_STATUS_HISTORY_CHANGE",
      "View history of task status changes");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_STATUS_HISTORY_CHANGE",
      "Afficher l'historique des modifications de l'état des tâches");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_STATUS_HISTORY_CHANGE",
      "Просмотреть историю изменения статуса задачи");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_STATUS_HISTORY_CHANGE",
      "Ver el historial de cambios de estado de la tarea");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_STATUS_HISTORY_CHANGE",
      "Verlauf der Aufgabenstatusänderungen anzeigen");
    
    // LL_CRM_ID
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CRM_ID",
      "Crm #");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CRM_ID",
      "Crm #");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CRM_ID",
      "Crm №");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CRM_ID",
      "Crm #");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CRM_ID",
      "Crm #");
    
    // LL_ADD_NEW_TASK_FCATS_FIELD_CAT
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_TASK_FCATS_FIELD_CAT",
      "Add New Task Category");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_TASK_FCATS_FIELD_CAT",
      "Ajouter une nouvelle catégorie de tâches");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_TASK_FCATS_FIELD_CAT",
      "Добавить новую категорию задач");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_TASK_FCATS_FIELD_CAT",
      "Agregar nueva categoría de tarea");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_TASK_FCATS_FIELD_CAT",
      "Neue Aufgabenkategorie hinzufügen");
    
    // LL_ADD_NEW_TASK_FIELDS_FIELD
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_ADD_NEW_TASK_FIELDS_FIELD",
      "Add New Task Field");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_ADD_NEW_TASK_FIELDS_FIELD",
      "Ajouter un nouveau champ de tâche");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_ADD_NEW_TASK_FIELDS_FIELD",
      "Добавить новое поле задачи");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_ADD_NEW_TASK_FIELDS_FIELD",
      "Agregar nuevo campo de tarea");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_ADD_NEW_TASK_FIELDS_FIELD",
      "Neues Aufgabenfeld hinzufügen");
    
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
    return "LL_TASKS";
  }

  protected int getMenuIdx() {
    return 1;
  }

  protected String getModName() {
    return "task";
  }

  protected Map<String, AbstractEntity> getRoleEntities(String user) {
    return ENTITIES_LIST.get(user);
  }
}
