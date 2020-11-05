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

package com.seerema.test.web_ui.shared.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

public abstract class AbstractSharedWebUiTest extends GenericUiTestWeb {

  public abstract void checkAfterSimpleLogin(String lang) throws Exception;

  @Test
  public void testBaseGui() throws Exception {
    // Inject user into the session b4 initialize driver
    injectUser("user1");

    init(SharedWebUiTestConstants.LANG);

    checkAfterSimpleLogin(SharedWebUiTestConstants.LANG);
  }

  @Test
  public void testCopyright() throws InterruptedException {
    // Inject user into the session b4 initialize driver
    injectUser("user1");

    init(SharedWebUiTestConstants.LANG);

    // Copyright is language independent
    String cr = getTopWebEl().findElement(By.className("footer"))
        .findElement(By.className("copyright")).getText();
    assertEquals("© Ivalab " + Calendar.getInstance().get(Calendar.YEAR), cr,
        "Invalid copyright");
  }
}
