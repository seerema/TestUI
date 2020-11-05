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

public class MyPotentialClientsEx extends AbstractModCrm {

  private static final String USER_NAME = "user3";

  public static String NAME = "entities::lead";

  private static final String TITLE = "MY_LEADS";

  public static String[][] INIT_DATA = new String[][] {};

  private static String[] NEW_DATA = new String[] { "Demo Client", null,
      "client@company.com", "111-222-3333", "" };

  private static String[] NEW_DATA_ROW =
      new String[] { "Demo Client", "[LL_COMPANY]", "[LL_LEAD]", "[LL_NEVER]",
          "", "", "client@company.com", "111-222-3333", "", "" };

  private static String[] EXISTING_DATA = new String[] { "Demo Client",
      "[LL_LEAD]", null, "client@company.com", "111-222-3333", "" };

  private static String[] UPDATE_DATA = new String[] { "Temp Company",
      "[LL_CUSTOMER]", null, "client@company.com", "111-222-6677", "" };

  private static String[] UPDATE_DATA_ROW =
      new String[] { "Temp Company", "[LL_COMPANY]", "[LL_CUSTOMER]",
          "[LL_NEVER]", "", "", "client@company.com", "111-222-6677", "", "" };

  private static String[] SLIDE_NAMES = new String[] { "field_cats" };

  private static String[][] SLIDE_DATA =
      new String[][] { new String[] { "[LL_COMPANY]" } };

  private static String[] SLIDE_TITLES =
      new String[] { "LL_SELECT_CUSTOMER_TYPE" };

  private static String[] ADD_FORM_LABELS = new String[] { "LL_NAME", "LL_TYPE",
      "LL_ADDRESS", "LL_EMAIL", "LL_PHONE", "LL_WEB_SITE" };

  protected static String[] UPD_FORM_LABELS =
      new String[] { "LL_NAME", "LL_TYPE", "LL_STATUS", "LL_LAST_CONTACTED",
          "LL_ADDRESS", "LL_EMAIL", "LL_PHONE", "LL_WEB_SITE" };

  private static String UPD_STATUS_ENTITY_NAME = AllMyCustomers.NAME;

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
  public String getName() {
    return TITLE;
  }

  @Override
  public WebElement checkUpdateListStatus(List<WebElement> rows) {
    return checkUpdateListEx(rows);
  }

  @Override
  public void checkInitDataEx(List<WebElement> rows) {
    super.checkEmptyData(rows, NAME, "MyClients after delete");
  }

  @Override
  protected String[][] getStatusHistory() {
    return STATUS_HISTORY;
  }

  public String getUpdStatusEntityName() {
    return UPD_STATUS_ENTITY_NAME;
  }

  @Override
  protected String[] getAddFormLabels() {
    return ADD_FORM_LABELS;
  }

  @Override
  protected String[] getUpdFormLabels() {
    return UPD_FORM_LABELS;
  }
}
