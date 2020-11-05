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

import java.time.LocalDate;

import com.seerema.test.web_ui.mod.shared.SharedModConstants;
import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

/**
 * Data for My Active Tasks
 */

public class AllTasks extends AbstractModTasks {

  // @formatter:off
  
  public static String[][] INIT_DATA = new String[][] { new String[] { "TO-DO",
      "[LL_REGULAR]", "[LL_NEW_F]", "user1", "", "", "Sample TO_DO task" } };

  // @formatter:on

  private static String[] NEW_DATA =
      new String[] { "ZZZ Task", null, "15", "00", "Test task as you ask" };

  private static String[] NEW_DATA_ROW = new String[] { "ZZZ Task",
      "[LL_REGULAR]", "[LL_NEW_F]", "user1", "", null, "Test task as you ask" };

  private static String[] EXIST_DATA = new String[] { "ZZZ Task", "[LL_NEW_F]",
      null, "15", "00", "Test task as you ask" };

  private static LocalDate today = LocalDate.now();

  private static String[] UPDATE_DATA = new String[] { "XYZ Task",
      "[LL_COMPLETED]", "user2", null, "18", "00", "XYZ Test task as you ask" };

  private static String[] UPDATE_DATA_ROW =
      new String[] { "XYZ Task", "[LL_REGULAR]", "[LL_NEW_F]", "user2", "",
          null, "XYZ Test task as you ask" };

  private static String[][] SLIDE_DATA =
      new String[][] { new String[] { "[LL_REGULAR]" } };

  private static String[] SLIDE_TITLES =
      new String[] { "LL_SELECT_TASK_CATEGORY" };

  private static String[] SLIDE_NAMES = new String[] { "field_cats" };

  private static String UPD_STATUS_ENTITY_NAME = "entities";

  private static String[][] STATUS_HISTORY =
      new String[][] { new String[] { "[LL_NEW_F]", "user1" },
          new String[] { "[LL_COMPLETED]", "user1" } };

  private static String[] UPD_FORM_LABELS = new String[] { "LL_NAME", "LL_TYPE",
      "LL_STATUS", "LL_USER", "LL_DUE_DATE", "LL_NOTES" };

  private static final int[] DPICKER_IDX = new int[] { 3, 5 };

  @Override
  public String[][] getInitData() {
    return INIT_DATA;
  }

  @Override
  public String[] getNewEntity() {
    // Inject zero date
    NEW_DATA[1] = SharedModConstants.getZeroDate();
    return NEW_DATA;
  }

  @Override
  protected String[] getNewEntityRow() {
    NEW_DATA_ROW[5] = SharedModConstants.getZeroDate() + " 15:00";
    return NEW_DATA_ROW;
  }

  @Override
  protected String[] getExistingEntity() {
    EXIST_DATA[2] = SharedModConstants.getZeroDate();
    return EXIST_DATA;
  }

  @Override
  public String[] getUpdateEntity() {
    UPDATE_DATA[3] = today.format(SharedModConstants
        .getLocaleDateFormatter(SharedWebUiTestConstants.LANG));
    return UPDATE_DATA;
  }

  @Override
  protected String[] getUpdateEntityRow() {
    UPDATE_DATA_ROW[5] = SharedModConstants.getZeroDate() + " 15:00";
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
  protected String[] getUpdFormLabels() {
    return UPD_FORM_LABELS;
  }

  @Override
  protected int[] getDatePickerIdx() {
    return DPICKER_IDX;
  }
}
