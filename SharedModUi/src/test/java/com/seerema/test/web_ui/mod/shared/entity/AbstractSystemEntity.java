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

/**
 * Abstract System Entity
 *
 */
public abstract class AbstractSystemEntity extends AbstractEntity {

  public String[] getNonSystemRecords() {
    return null;
  }
}
