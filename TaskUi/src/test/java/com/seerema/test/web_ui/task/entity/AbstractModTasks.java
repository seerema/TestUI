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

package com.seerema.test.web_ui.task.entity;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;

import com.seerema.test.web_ui.shared.utils.SharedTestUtils;

/**
 * Data for My Active Tasks
 */

public abstract class AbstractModTasks extends AbstractEntityMod {

  // @formatter:off

  public static String[][] INIT_DATA = new String[][] { 
    new String[] { "TO-DO", "[LL_REGULAR]", "[LL_NEW_F]", 
                                  "", "",  "Sample TO_DO task"}
  };

  // @formatter:on

  @Override
  public String[][] getInitData() {
    return INIT_DATA;
  }

  @Override
  public void fillAddEntity(WebElement el) throws Exception {
    super.fillAddEntity(el);

    // Focus on datepicker and click TAB to close datepicker
    WebElement dpicker =
        getContext().findElement(By.cssSelector("input.dpicker"));
    dpicker.click();
    dpicker.sendKeys(Keys.TAB);
    SharedTestUtils.sleep();
  }

  @Override
  protected String getModEntityName() {
    return "LL_QUEST";
  }
}
