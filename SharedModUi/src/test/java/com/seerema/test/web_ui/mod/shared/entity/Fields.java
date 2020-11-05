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

package com.seerema.test.web_ui.mod.shared.entity;

import com.seerema.test.web_ui.mod.shared.SharedModConstants;

/**
 * Fields entity
 */

public abstract class Fields extends AbstractSystemEntity {

  private static String[] NEW_DATA =
      new String[] { SharedModConstants.TEST_FIELD };

  private static String[] NEW_DATA_ROW = new String[] {
      SharedModConstants.TEST_FIELD_CAT, SharedModConstants.TEST_FIELD };

  private static String[] EXIST_DATA = new String[] {};

  private static String[] UPDATE_DATA = new String[] {};

  private static String[] UPDATE_DATA_ROW = new String[] {};

  private static String[][] SLIDE_DATA =
      new String[][] { new String[] { SharedModConstants.TEST_FIELD_CAT } };

  private static String[] SLIDE_NAMES = new String[] { "field_cats" };

  private static String[] ADD_FORM_LABELS =
      new String[] { "LL_CATEGORY", "LL_NAME" };

  private static String[] UPD_FORM_LABELS =
      new String[] { "LL_CATEGORY", "LL_NAME" };

  @Override
  public String[] getNewEntity() {
    return NEW_DATA;
  }

  @Override
  protected String[] getNewEntityRow() {
    return NEW_DATA_ROW;
  }

  @Override
  protected String[] getExistingEntity() {
    return EXIST_DATA;
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
  public int getSlideSize() {
    return 1;
  }

  @Override
  public String getName() {
    return getModEntityName() + "_FIELDS_FIELD";
  }

  @Override
  protected String getSlideTitle(int idx) {
    return "LL_SELECT_" + getModEntityName() + "_CATEGORY";
  }

  @Override
  protected String[] getSlideData(int idx) {
    return SLIDE_DATA[idx - 1];
  }

  @Override
  public String getSlideName(int idx) {
    return SLIDE_NAMES[idx - 1];
  }

  @Override
  protected String[] getAddFormLabels() {
    return ADD_FORM_LABELS;
  }

  @Override
  protected String[] getUpdFormLabels() {
    return UPD_FORM_LABELS;
  }
}
