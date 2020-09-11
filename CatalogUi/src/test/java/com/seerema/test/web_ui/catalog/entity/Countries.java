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

public class Countries extends AbstractEntity {

  private static String[][] INIT_DATA =
      new String[][] { new String[] { "Canada", "LL_PROVINCE", "LL_POSTAL_CODE",
          "short_name", "get_us_address" } };

  private static String[] NEW_DATA = new String[] { "Unknown", "LL_XXX",
      "LL_ZZZ", "unknown", "unknown_address" };

  private static String[] UPDATE_DATA = new String[] { "USA", "LL_STATE",
      "LL_ZIP_CODE", "short_name", "get_us_address" };

  private static String[] FORM_LABELS = new String[] { "LL_NAME", "LL_REGION_NAME",
      "LL_POSTAL_NAME", "LL_REGION_FIELD", "LL_ADDRESS_FORMATTER" };

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
    return NEW_DATA;
  }

  @Override
  public String[] getUpdateEntity() {
    return UPDATE_DATA;
  }

  @Override
  protected String[] getUpdateEntityRow() {
    return UPDATE_DATA;
  }

  @Override
  protected String[] getFormLabels() {
    return FORM_LABELS;
  }

  @Override
  public int getSlideSize() {
    return 0;
  }

  @Override
  public String getName() {
    return "country";
  }
}
