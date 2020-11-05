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

/**
 * Data for My Active Tasks
 */

public class AllCustomers extends AbstractModCrm {

  // @formatter:off
  
  public static String[][] INIT_DATA = new String[][] { new String[] { "Temp",
      "[LL_COMPANY]", "[LL_LEAD]", "[LL_NEVER]", "user1", "", "", "", "",
      "1-888-1234567", "", "http://www.example.com/" } };
//  Potential Client  Never user1               
  // @formatter:on

  private static String[] NEW_DATA = new String[] {};

  private static String[] NEW_DATA_ROW =
      new String[] { "Temp Company", "[LL_COMPANY]", "[LL_LEAD]", "[LL_NEVER]",
          "user1", "", "", "test@qq.com", "", "", "", "" };

  // Save as NEW_DATA_ROW but different user and LL_CUSTOMER
  private static String[] UPDATE_DATA = new String[] { "Temp Company",
      "[LL_CUSTOMER]", "user2", null, "test@qq.com", "", "", "", "" };

  private static final String[] EXIST_DATA = new String[] {};

  private static String[] UPDATE_DATA_ROW = new String[] {};

  private static String[] UPD_LABELS = new String[UPD_FORM_LABELS.length + 1];

  static {
    // Insert user after last contacted
    int idx = 4;

    for (int i = 0; i < idx; i++)
      UPD_LABELS[i] = UPD_FORM_LABELS[i];

    UPD_LABELS[idx] = "LL_USER";

    for (int i = idx + 1; i < UPD_FORM_LABELS.length + 1; i++)
      UPD_LABELS[i] = UPD_FORM_LABELS[i - 1];
  }

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
  public String getName() {
    return "LL_ALL_CUSTOMERS";
  }

  @Override
  protected String[][] getStatusHistory() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  protected String[] getUpdFormLabels() {
    return UPD_LABELS;
  }

}
