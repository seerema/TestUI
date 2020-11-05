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

package com.seerema.test.web_ui.crm.it;

import org.springframework.jdbc.core.JdbcTemplate;

import com.seerema.test.web_ui.crm.test.CrmWebUiTestUnit;

public class CrmWebUiTestEx extends CrmWebUiTestUnit {

  static int LOCAL_PORT;

  public static JdbcTemplate JDBC;

  @Override
  protected int getPort() {
    return LOCAL_PORT;
  }

  @Override
  protected JdbcTemplate getJdbcTemplate() {
    return JDBC;
  }
}
