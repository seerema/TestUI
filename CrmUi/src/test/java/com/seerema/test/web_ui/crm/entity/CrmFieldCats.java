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

import com.seerema.test.web_ui.mod.shared.entity.FieldCats;

/**
 * Data for My Active Tasks
 */

public class CrmFieldCats extends FieldCats {

  public static String[][] INIT_DATA =
      new String[][] { new String[] { "[LL_COMPANY]" },
          new String[] { "[LL_OTHER]" }, new String[] { "[LL_PERSON]" } };

  @Override
  public String[][] getInitData() {
    return INIT_DATA;
  }

  @Override
  protected String getModEntityName() {
    return "CRM";
  }
}
