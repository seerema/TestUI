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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

/**
 * Shared utilities
 * 
 */
public class SharedTestUtils {

  private static final Pattern LBL_PATTERN = Pattern.compile("^\\[(.*)\\]$");

  public static void testMsg(String expected, String actual, String msg) {
    if (expected != null && !expected.isEmpty() && expected.charAt(0) == 64 &&
        expected.charAt(expected.length() - 1) == 64) {
      // Process regular expression
      Pattern p = Pattern.compile(expected.substring(1, expected.length() - 1));
      assertTrue(p.matcher(actual).matches(),
          "Checking regex " + expected + " -> " + actual);
    } else {
      assertEquals(expected, actual, msg);
    }
  }

  /**
   * Default delay after UI animated update
   */
  public static void sleep() {
    sleep(1);
  }

  public static void sleep(int tsec) {
    try {
      Thread.sleep(tsec * 1000);
    } catch (InterruptedException e) {
      // Do nothing
    }
  }

  public static String getLangLabel(String key) {
    return SharedWebUiTestConstants.LL_SET.get(SharedWebUiTestConstants.LANG)
        .get(key);
  }

  public static String getPatternText(String text) {
    Matcher m = LBL_PATTERN.matcher(text);
    return m.matches() ? getLangLabel(m.group(1)) : text;
  }
}
