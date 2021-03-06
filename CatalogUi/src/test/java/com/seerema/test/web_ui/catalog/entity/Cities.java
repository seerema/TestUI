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
 * Data for Cities test
 *
 */
public class Cities extends AbstractEntity {

  // @formatter:off

  private static String[][] INIT_DATA = new String[][] { 
    new String[] { "London", "Ontario", "Canada" }
  };

  private static String[][] SLIDE_DATA = new String[][] { 
    new String[] { "Canada" },
    new String[] { "Ontario" }
  };
  
  private static String[] SLIDE_NAMES = new String[] { 
        "countries", "regions" };
  
  private static String[] SLIDE_TITLES = new String[] {
      "LL_SELECT_COUNTRY", "LL_SELECT_PROVINCE"
  };
  
  // @formatter:on

  private static String[] NEW_DATA = new String[] { "Unknown" };

  private static String[] NEW_DATA_ROW =
      new String[] { "Unknown", "Ontario", "Canada" };

  private static String[] UPDATE_DATA = new String[] { "Toronto" };

  private static String[] UPDATE_DATA_ROW =
      new String[] { "Toronto", "Ontario", "Canada" };

  private static String[] FORM_LABELS =
      new String[] { "LL_NAME", "LL_PROVINCE", "LL_COUNTRY" };

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
    return SLIDE_NAMES.length;
  }

  @Override
  public String getName() {
    return "city";
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
