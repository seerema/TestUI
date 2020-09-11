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

package com.seerema.test.web_ui.shared.controller;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

@RestController
@RequestMapping(name = SharedWebUiTestConstants.BASE_URL)
public class DummyAuthController {

  @RequestMapping(value = "/auth", method = RequestMethod.GET,
      produces = MediaType.TEXT_PLAIN_VALUE)
  public String dummyAuth() {
    return "";
  }
}
