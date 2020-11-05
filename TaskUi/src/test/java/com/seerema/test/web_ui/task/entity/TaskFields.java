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

import com.seerema.test.web_ui.mod.shared.entity.Fields;

/**
 * Data for My Active Tasks
 */

public class TaskFields extends Fields {

  // @formatter:off

  public static String[][] INIT_DATA = new String[][] {
    new String[] { "[LL_CRM]", "[LL_CRM_ID]" },
    new String[] { "[LL_CRM]", "[LL_DUE_DATE]" },
    new String[] { "[LL_CRM]", "[LL_NOTES]" },
    new String[] { "[LL_REGULAR]", "[LL_DUE_DATE]" },
    new String[] { "[LL_REGULAR]", "[LL_NOTES]" }
  };

  // @formatter:on

  @Override
  public String[][] getInitData() {
    return INIT_DATA;
  }

  @Override
  protected String getModEntityName() {
    return "TASK";
  }
}
