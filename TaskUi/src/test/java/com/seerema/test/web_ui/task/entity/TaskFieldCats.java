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

import com.seerema.test.web_ui.mod.shared.entity.FieldCats;

/**
 * Data for My Active Tasks
 */

public class TaskFieldCats extends FieldCats {

  public static String[][] INIT_DATA = new String[][] {
      new String[] { "[LL_CRM]" }, new String[] { "[LL_REGULAR]" } };

  @Override
  public String[][] getInitData() {
    return INIT_DATA;
  }

  @Override
  protected String getModEntityName() {
    return "TASK";
  }
}
