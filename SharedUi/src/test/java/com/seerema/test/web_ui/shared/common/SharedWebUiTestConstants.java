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

package com.seerema.test.web_ui.shared.common;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Constants used solely by unit and/or integration test
 * 
 */

public class SharedWebUiTestConstants {

  // ID of top element
  public static final String TOP_EL_ID = "sbs";

  //Anonymous user name
  public static final String ANONYMOUS_USER = "anonymous";

  // Name of Ws Config property in multi-lang test class
  public static final String CFG_FIELD_NAME = "WS_CFG";

  public static final String GUI_SRV_URL_BASE = "/web_test/fr/";

  // Default test GUI URL
  public static final String GUI_SRV_URL =
      GUI_SRV_URL_BASE + "index.html?debug=on";

  // Test user name
  public static final String TEST_USER = "any";

  // Language used for testing specific, usually new language
  public static String LANG;

  // Language used for testLangLogin method i.e language change during 
  // test with default language test
  public static String LANG_CHANGE = "fr";
  public static String LOCALE_CHANGE = "fr_ca";

  // Initiate and load LL_SET
  public static HashMap<String, HashMap<String, String>> LL_SET =
      new LinkedHashMap<String, HashMap<String, String>>();

  // Array of known locales
  public static Map<String, Locale> LOCALES =
      new LinkedHashMap<String, Locale>();

  // Base URL
  public static final String BASE_URL = "/api/v1";

  public static final Logger LOG = LoggerFactory.getLogger("Test");

  // Default language
  public static final String DEFAULT_LANG = "en";

  static {
    LOCALES.put("en", Locale.US);
    LOCALES.put("fr", Locale.CANADA_FRENCH);
    LOCALES.put("ru", new Locale("ru", "RU"));
    LOCALES.put("es", new Locale("es", "ES"));
    LOCALES.put("de", new Locale("de", "DE"));
  }

  // Language available for test. Build automatically from shared constant
  static {
    for (String lang : LOCALES.keySet())
      LL_SET.put(lang, new HashMap<String, String>());
  };
}
