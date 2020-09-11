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

package com.seerema.test.web_ui.bootstrap.it;

import com.seerema.test.web_ui.bootstrap.utils.BaseWebUiTestUnit;

public class BaseLangWebUiTestEx extends BaseWebUiTestUnit {

  static int LOCAL_PORT;

  @Override
  protected int getPort() {
    return LOCAL_PORT;
  }
}
