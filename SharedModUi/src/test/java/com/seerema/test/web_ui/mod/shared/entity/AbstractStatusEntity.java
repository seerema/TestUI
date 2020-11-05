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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.seerema.test.web_ui.shared.utils.SharedTestUtils;

/**
 * Abstract Entity
 *
 */
public abstract class AbstractStatusEntity extends AbstractEntity {

  private static final String[] STATUS_HEADERS =
      new String[] { "LL_CREATED", "LL_STATUS", "LL_USER" };

  private static String UPD_STATUS_ENTITY_NAME = "entities";

  protected abstract String[][] getStatusHistory();

  public void checkStatusHistory(List<Long> saved) {
    checkHistory(saved, "status", STATUS_HEADERS, getStatusHistory());
  }

  @Override
  public WebElement checkUpdateList(List<WebElement> rows) {
    // No new rows expected after update
    assertEquals(getUpdRowCnt(), rows.size(),
        "Updated row doesn't disappear after status update.");
    checkInitData(rows);

    // Close existing entity
    getContext().findElement(By.cssSelector("button.wclose")).click();
    SharedTestUtils.sleep();

    String name = getUpdStatusEntityName();
    if (name != null)
      // Switch to another entity
      rows = switchEntity(name);

    return checkUpdateListStatus(rows);
  }

  public WebElement checkUpdateListStatus(List<WebElement> rows) {
    return super.checkUpdateList(rows);
  }

  /**
   * Get the number of rows after update and status change.
   * 
   * @return the number of rows
   */
  protected int getUpdRowCnt() {
    return 2;
  }

  public String getUpdStatusEntityName() {
    return UPD_STATUS_ENTITY_NAME;
  }

  /**
   * Update only status
   * 
   * @param status Status Text
   * @throws Exception 
   */
  protected void changeStatus(String status, List<WebElement> cells)
      throws Exception {
    applyFormDataItem(1, "[" + status + "]", cells.get(1));
    getContext().findElement(By.cssSelector("button.save")).click();
    SharedTestUtils.sleep(2);
  }
}
