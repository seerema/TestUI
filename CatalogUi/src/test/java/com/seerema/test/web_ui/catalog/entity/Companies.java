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

package com.seerema.test.web_ui.catalog.entity;

import java.util.List;

import org.openqa.selenium.WebElement;

/**
 * Data for Companies Test
 *
 */
public class Companies extends AbstractEntity {

  // @formatter:off

  private static String[][] INIT_DATA = new String[][] { 
    new String[] { "Example", "[LL_COMPANY]", "Here we are", "info@example.com", 
        "", "", "1-888-1234567", "http://www.example.com/", "", "" }
  };

  // @formatter:on

  private static String[] NEW_DATA = new String[] { "Qq Company",
      "Here we are, London, ON ABC123, Canada", "", "", "", "", "" };

  private static String[] NEW_DATA_ROW = new String[] { "Qq Company",
      "[LL_COMPANY]", "Here we are", "", "", "", "", "", "", "" };

  private static String[] UPDATE_DATA =
      new String[] { "Qq Inc.", "Here we are, London, ON ABC123, Canada", "",
          "", "Test", "", "http://qq.com/" };

  private static String[] UPDATE_DATA_ROW =
      new String[] { "Qq Inc.", "[LL_COMPANY]", "Here we are", "", "", "Test",
          "", "http://qq.com/", "", "" };

  private static String[] FORM_LABELS = new String[] { "LL_NAME", "LL_CATEGORY",
      "LL_ADDRESS", "LL_EMAIL", "LL_FAX", "LL_NOTES", "LL_PHONE", "LL_SITE" };

  private static String[][] SLIDE_DATA =
      new String[][] { new String[] { "[LL_COMPANY]" } };

  private static String[] SLIDE_TITLES =
      new String[] { "LL_SELECT_BUSINESS_CATEGORY" };

  private static String[] SLIDE_NAMES = new String[] { "field_cats" };

  @Override
  public String[][] getInitData(List<WebElement> rows) {
    return INIT_DATA;
  }

  @Override
  public String[] getNewEntity() {
    return NEW_DATA;
  }

  @Override
  protected String[] getNewEntityRow() {
    return NEW_DATA_ROW;
  }

  @Override
  public String[] getUpdateEntity() {
    return UPDATE_DATA;
  }

  @Override
  protected String[] getUpdateEntityRow() {
    return UPDATE_DATA_ROW;
  }

  @Override
  protected String[] getFormLabels() {
    return FORM_LABELS;
  }

  @Override
  public int getSlideSize() {
    return 1;
  }

  @Override
  public String getName() {
    return "company";
  }

  @Override
  protected String getSlideTitle(int idx) {
    return SLIDE_TITLES[idx - 1];
  }

  @Override
  protected String[] getSlideData(int idx) {
    return SLIDE_DATA[idx - 1];
  }

  @Override
  public String getSlideName(int idx) {
    return SLIDE_NAMES[idx - 1];
  }
}
