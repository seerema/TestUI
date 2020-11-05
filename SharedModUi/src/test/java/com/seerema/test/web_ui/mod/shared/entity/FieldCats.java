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
 * Data for My Active Tasks
 */

public abstract class FieldCats extends AbstractSystemEntity {

  private static String[] NEW_DATA =
      new String[] { SharedModConstants.TEST_FIELD_CAT };

  private static String[] NEW_DATA_ROW =
      new String[] { SharedModConstants.TEST_FIELD_CAT };

  private static String[] EXIST_DATA = new String[] {};

  private static String[] UPDATE_DATA = new String[] {};

  private static String[] UPDATE_DATA_ROW = new String[] {};

  private static String[] ADD_FORM_LABELS = new String[] { "LL_NAME" };

  private static String[] UPD_FORM_LABELS = new String[] { "LL_NAME" };

  @Override
  public String[] getNewEntity() {
    // Inject zero date
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
  public String getName() {
    return getModEntityName() + "_FCATS_FIELD_CAT";
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
