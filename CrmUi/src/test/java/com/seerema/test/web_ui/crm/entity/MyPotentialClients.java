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

package com.seerema.test.web_ui.crm.entity;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * Data for My Active Tasks
 */

public class MyPotentialClients extends AbstractModCrm {

  private static final String USER_NAME = "user1";

  public static String NAME = "entities::lead";

  private static final String TITLE = "MY_LEADS";

  private static String UPD_STATUS_ENTITY_NAME = AllMyCustomers.NAME;

  public static String[][] INIT_DATA = new String[][] { new String[] { "Temp",
      "[LL_COMPANY]", "[LL_LEAD]", "[LL_NEVER]", "[LL_NONE_F]", "", "", "", "",
      "1-888-1234567", "", "http://www.example.com/" } };

  private static String[] NEW_DATA =
      new String[] { "Temp Company", null, "test@qq.com", "", "", "", "" };

  private static String[] NEW_DATA_ROW =
      new String[] { "Temp Company", "[LL_COMPANY]", "[LL_LEAD]", "[LL_NEVER]",
          "[LL_NONE_F]", "", "", "test@qq.com", "", "", "", "" };

  private static String[] EXISTING_DATA = new String[] { "Temp Company",
      "[LL_LEAD]", null, "test@qq.com", "", "", "", "" };

  private static String[] UPDATE_DATA =
      new String[] { "ZZ Company ", "[LL_CUSTOMER]", null, "test@qq.com", "",
          "123-456-7890", "", "http://www.qq.com/" };

  private static String[] UPDATE_DATA_ROW = new String[] { "ZZ Company",
      "[LL_COMPANY]", "[LL_CUSTOMER]", "[LL_NEVER]", "[LL_NONE_F]", "", "",
      "test@qq.com", "", "123-456-7890", "", "http://www.qq.com/" };

  private static String[][] SLIDE_DATA =
      new String[][] { new String[] { "[LL_COMPANY]" } };

  private static String[] SLIDE_TITLES =
      new String[] { "LL_SELECT_CUSTOMER_TYPE" };

  private static String[] SLIDE_NAMES = new String[] { "field_cats" };

  private static String[][] STATUS_HISTORY =
      new String[][] { new String[] { "[LL_LEAD]", USER_NAME },
          new String[] { "[LL_CUSTOMER]", USER_NAME } };

  @Override
  public String[][] getInitData() {
    return INIT_DATA;
  }

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
    return EXISTING_DATA;
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
    return TITLE;
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

  @Override
  protected String[][] getStatusHistory() {
    return STATUS_HISTORY;
  }

  public String getUpdStatusEntityName() {
    return UPD_STATUS_ENTITY_NAME;
  }

  @Override
  public WebElement checkUpdateListStatus(List<WebElement> rows) {
    return checkUpdateListEx(rows);
  }

  @Override
  public void checkInitDataEx(List<WebElement> rows) {
    super.checkEmptyData(rows, NAME, "MyClients after delete");
  }
}
