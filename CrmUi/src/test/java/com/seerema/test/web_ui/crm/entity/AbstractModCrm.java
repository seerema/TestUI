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

import com.seerema.test.web_ui.mod.shared.entity.AbstractStatusEntity;

/**
 * Data for My Active Tasks
 */

public abstract class AbstractModCrm extends AbstractStatusEntity {

  // @formatter:off

  private static String[] ADD_FORM_LABELS =
      new String[] { "LL_NAME", "LL_TYPE", "LL_ADDRESS", "LL_EMAIL", "LL_FAX", 
          "LL_PHONE", "LL_SKYPE_ID", "LL_WEB_SITE" };

  protected static String[] UPD_FORM_LABELS = new String[] { "LL_NAME", "LL_TYPE",
      "LL_STATUS", "LL_LAST_CONTACTED", "LL_ADDRESS", "LL_EMAIL", "LL_FAX", 
      "LL_PHONE", "LL_SKYPE_ID", "LL_WEB_SITE" };
  
  // @formatter:on

  @Override
  protected String getModEntityName() {
    return "CUSTOMER";
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
