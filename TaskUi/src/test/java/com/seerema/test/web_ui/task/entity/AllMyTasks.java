package com.seerema.test.web_ui.task.entity;
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

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.seerema.test.web_ui.shared.utils.SharedTestUtils;

/**
 * Data for My Active Tasks
 */

public class AllMyTasks extends AbstractModTasks {

  private static final String NAME = "entities";

  private static String[] EXISTING_DATA =
      new String[] { "TO-DO", "[LL_NEW_F]", "", "", "", "Sample TO_DO task" };

  private static String[][] STATUS_HISTORY =
      new String[][] { new String[] { "[LL_NEW_F]", "user1" },
          new String[] { "[LL_COMPLETED]", "user1" } };

  @Override
  protected void applyUpdFormData(WebElement el, String[] data,
      List<WebElement> cells) throws Exception {

    // Update only status
    applyFormDataItem(1, "[LL_COMPLETED]", cells.get(1));
    getContext().findElement(By.cssSelector("button.save")).click();
    SharedTestUtils.sleep(2);

    // Switch on first entity
    checkEmptyData(switchEntity(getUpdStatusEntityName()),
        getUpdStatusEntityName(), "after status change to LL_COMPLETED");

    // Switch back on our entity
    switchEntity(NAME).get(1).click();

    // Change status back
    List<WebElement> ncells =
        getFormCells(getContext().findElement(By.className("entity")));
    applyFormDataItem(1, "[LL_NEW_F]", ncells.get(1));
  }

  @Override
  public String[] getNewEntity() {
    return EXISTING_DATA;
  }

  @Override
  protected String[] getNewEntityRow() {
    return INIT_DATA[0];
  }

  @Override
  protected String[] getExistingEntity() {
    return EXISTING_DATA;
  }

  @Override
  public String[] getUpdateEntity() {
    return null;
  }

  @Override
  protected String[] getUpdateEntityRow() {
    return INIT_DATA[0];
  }

  @Override
  public int getSlideSize() {
    return 1;
  }

  @Override
  public String getName() {
    return "MY_QUESTS";
  }

  public String getUpdStatusEntityName() {
    return "entities::active";
  }

  public boolean hasAddButton() {
    return false;
  }

  @Override
  protected String[][] getStatusHistory() {
    return STATUS_HISTORY;
  }
}
