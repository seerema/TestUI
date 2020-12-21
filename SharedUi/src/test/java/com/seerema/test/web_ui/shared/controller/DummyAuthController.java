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

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

@RestController
public class DummyAuthController {

  @RequestMapping(value = "/login")
  public void dummyAuth(HttpServletRequest req, HttpServletResponse resp,
      @RequestParam("username") String username) {
    HttpSession session = req.getSession();
    session.setAttribute("userName", username);

    addCookie(resp, "USER_ID", username);
    String roles = SharedWebUiTestConstants.TEST_USERS.get(username);
    if (roles != null)
      addCookie(resp, "ROLES", roles);
  }

  private void addCookie(HttpServletResponse resp, String name, String value) {
    Cookie cookie = new Cookie(name, value);
    cookie.setMaxAge(Integer.MAX_VALUE);
    // Inject role into response
    resp.addCookie(cookie);
  }
}
