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

import com.seerema.test.web_ui.mod.shared.entity.Fields;

/**
 * Data for My Active Tasks
 */

public class CrmFields extends Fields {

  // @formatter:off

  public static String[][] INIT_DATA = new String[][] {
    new String[] { "[LL_COMPANY]", "[LL_ADDRESS]" },
    new String[] { "[LL_COMPANY]", "[LL_EMAIL]" },
    new String[] { "[LL_COMPANY]", "[LL_PHONE]" },
    new String[] { "[LL_COMPANY]", "[LL_WEB_SITE]" },
    new String[] { "[LL_OTHER]", "[LL_EMAIL]" },
    new String[] { "[LL_OTHER]", "[LL_PHONE]" },
    new String[] { "[LL_PERSON]", "[LL_ADDRESS]" },
    new String[] { "[LL_PERSON]", "[LL_CELL_PHONE]" },
    new String[] { "[LL_PERSON]", "[LL_EMAIL]" },
  };
  
  // @formatter:on

  @Override
  public String[][] getInitData() {
    return INIT_DATA;
  }

  @Override
  protected String getModEntityName() {
    return "CRM";
  }

  @Override
  public String[] getNonSystemRecords() {
    return new String[] { "LL_SKYPE_ID", "LL_FAX" };
  }

  @Override
  public void checkInitDataEx(List<WebElement> rows) {
    super.checkInitDataEx(rows);

    // Insert back deleted record
    getJdbc().batchUpdate(
        "insert into field(name, field_category_id) values('LL_SKYPE_ID', 1)",
        "insert into field(name, field_category_id) values('LL_FAX', 1)",
        "insert into field(name, field_category_id) values('LL_SKYPE_ID', 2)",
        "insert into field(name, field_category_id) values('LL_SKYPE_ID', 3)");
  }
}
