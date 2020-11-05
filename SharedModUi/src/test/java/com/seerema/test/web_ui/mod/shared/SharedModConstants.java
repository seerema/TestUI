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

package com.seerema.test.web_ui.mod.shared;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

/**
 * Shared Module Constants
 */
public class SharedModConstants {

  private static final Map<String, DateTimeFormatter> LOCALE_DATE_FORMATTER =
      new HashMap<>();

  // Add DateTimeFormatter for each locale
  static {
    LOCALE_DATE_FORMATTER.put("en", DateTimeFormatter.ofPattern("MM/dd/yyyy"));
    LOCALE_DATE_FORMATTER.put("fr", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    LOCALE_DATE_FORMATTER.put("ru", DateTimeFormatter.ofPattern("dd.MM.yyyy"));
    LOCALE_DATE_FORMATTER.put("es", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    LOCALE_DATE_FORMATTER.put("de", DateTimeFormatter.ofPattern("dd.MM.yyyy"));

    assertEquals(SharedWebUiTestConstants.LOCALES.size(),
        LOCALE_DATE_FORMATTER.size(),
        "The number of DateTimeFormatters doesn't match the number of support locales.");
  }

  public static final LocalDate ZERO_DATE_ = LocalDate.ofEpochDay(0);

  public static DateTimeFormatter getLocaleDateFormatter(String locale) {
    return LOCALE_DATE_FORMATTER.get(locale);
  }

  public static String getZeroDate() {
    return ZERO_DATE_
        .format(LOCALE_DATE_FORMATTER.get(SharedWebUiTestConstants.LANG));
  }

  // Used first cyrilic letter for sorting purposes to make sure record always last
  public static final String TEST_FIELD_CAT = "Яz Test Cat";

  public static final String TEST_FIELD = "Яz Test Field";
}
