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

package com.seerema.test.web_ui.task.entity;

import java.util.List;

import org.openqa.selenium.WebElement;

import com.seerema.test.web_ui.mod.shared.SharedModConstants;
import com.seerema.test.web_ui.mod.shared.entity.AbstractStatusEntity;

/**
 * Data for My Active Tasks
 */

public class MyActiveTasksEx extends AbstractStatusEntity {

  private static final String userName = "user3";

  private static String[] NEW_DATA = new String[] { "ZZZ Task", "ZZ-TOP" };

  private static String[] NEW_DATA_ROW = new String[] { "ZZZ Task",
      SharedModConstants.TEST_FIELD_CAT, "[LL_NEW_F]", "", "", "", "ZZ-TOP" };

  private static String[] EXIST_DATA =
      new String[] { "ZZZ Task", "[LL_NEW_F]", "ZZ-TOP" };

  private static String[] UPDATE_DATA =
      new String[] { "XYZ Task", "[LL_COMPLETED]", "ZZ value" };

  private static String[] UPDATE_DATA_ROW =
      new String[] { "XYZ Task", SharedModConstants.TEST_FIELD_CAT,
          "[LL_COMPLETED]", "", "", "", "ZZ value" };

  private static String[][] SLIDE_DATA =
      new String[][] { new String[] { SharedModConstants.TEST_FIELD_CAT } };

  private static String[] SLIDE_TITLES =
      new String[] { "LL_SELECT_TASK_CATEGORY" };

  private static String[] SLIDE_NAMES = new String[] { "field_cats" };

  private static String UPD_STATUS_ENTITY_NAME = "entities";

  private static String[][] STATUS_HISTORY =
      new String[][] { new String[] { "[LL_NEW_F]", userName },
          new String[] { "[LL_COMPLETED]", userName } };

  private static String[] ADD_FORM_LABELS =
      new String[] { "LL_NAME", "LL_TYPE", SharedModConstants.TEST_FIELD };

  private static String[] UPD_FORM_LABELS = new String[] { "LL_NAME", "LL_TYPE",
      "LL_STATUS", SharedModConstants.TEST_FIELD };

  @Override
  public String[] getNewEntity() {
    return NEW_DATA;
  }

  @Override
  protected String[] getNewEntityRow() {
    return NEW_DATA_ROW;
  }

  @Override
  protected String[] getExistingEntity() {
    return EXIST_DATA;
  }

  @Override
  public String[] getUpdateEntity() {
    return UPDATE_DATA;
  }

  @Override
  protected String[] getUpdateEntityRow() {
    return UPDATE_DATA_ROW;
  }

  @Override
  public int getSlideSize() {
    return 1;
  }

  @Override
  public String getName() {
    return "MY_ACTIVE_QUESTS";
  }

  @Override
  protected String getSlideTitle(int idx) {
    return SLIDE_TITLES[idx - 1];
  }

  @Override
  protected String[] getSlideData(int idx) {
    return SLIDE_DATA[idx - 1];
  }

  @Override
  public String getSlideName(int idx) {
    return SLIDE_NAMES[idx - 1];
  }

  public String getUpdStatusEntityName() {
    return UPD_STATUS_ENTITY_NAME;
  }

  @Override
  protected String[][] getStatusHistory() {
    return STATUS_HISTORY;
  }

  @Override
  public String[][] getInitData() {
    return new String[][] {};
  }

  @Override
  protected String[] getAddFormLabels() {
    return ADD_FORM_LABELS;
  }

  @Override
  protected String[] getUpdFormLabels() {
    return UPD_FORM_LABELS;
  }

  @Override
  protected String getModEntityName() {
    return "LL_QUEST";
  }

  @Override
  public WebElement checkUpdateList(List<WebElement> rows) {
    // Remove empty row
    rows.remove(rows.size() - 1);
    return super.checkUpdateList(rows);
  }

  @Override
  protected int getUpdRowCnt() {
    return 1;
  }

  @Override
  public void checkInitDataEx(List<WebElement> rows) {
    // Remove empty row
    rows.remove(rows.size() - 1);

    super.checkInitDataEx(rows);
  }
}
