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
 * Data for My Active Tasks for User 2
 */
public class MyPotentialClientsUser2 extends MyPotentialClientsEx {

  private static String[] UPDATE_DATA_ROW =
      new String[] { "Temp Company", "[LL_COMPANY]", "[LL_CUSTOMER]",
          "[LL_NEVER]", "", "", "test@qq.com", "", "", "", "" };

  @Override
  protected String[] getUpdateEntityRow() {
    return UPDATE_DATA_ROW;
  }
}
