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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.seerema.test.web_ui.mod.shared.entity.AbstractStatusEntity;
import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;
import com.seerema.test.web_ui.shared.utils.SharedTestUtils;
import com.seerema.test.web_ui.mod.shared.SharedModConstants;

/**
 * Data for Task Module
 */

public abstract class AbstractEntityMod extends AbstractStatusEntity {

  private static final int[] DPICKER_IDX = new int[] { 2, 4 };

  private static String[] ADD_FORM_LABELS =
      new String[] { "LL_NAME", "LL_TYPE", "LL_DUE_DATE", "LL_NOTES" };

  private static String[] UPD_FORM_LABELS = new String[] { "LL_NAME", "LL_TYPE",
      "LL_STATUS", "LL_DUE_DATE", "LL_NOTES" };

  @Override
  protected void applyUpdFormData(WebElement el, String[] data,
      List<WebElement> cells) throws Exception {
    // TODO Auto-generated method stub
    // super.applyFormData(data, cells);
    for (int i = 0; i < data.length; i++) {
      // Skip datepicker fields
      int[] didx = getDatePickerIdx();

      if (i >= didx[0] && i <= didx[1])
        continue;

      applyFormDataItem(i, data[i], cells.get(i));
    }

    // Check now button available
    WebElement bnow = el.findElement(By.className("now"));
    checkElVisibleEnabled(bnow, true, true);

    // Click clear button
    WebElement bclear = el.findElement(By.className("clear"));
    checkElVisible(bclear, true);

    if (bclear.isEnabled()) {
      // After click button should be disabled
      bclear.click();
    }

    checkElVisibleEnabled(bclear, true, false);
    checkElVisibleEnabled(bnow, true, true);
    checkDateInput(new String[] { "", "", "" }, cells);

    // Set field now
    bnow.click();
    checkElVisibleEnabled(bclear, true, true);
    checkElVisibleEnabled(bnow, true, true);

    // Date input result
    LocalDateTime dts = LocalDateTime.now();
    int hour = dts.getHour();
    int min = (dts.getMinute() / 5) * 5;
    checkDateInput(
        new String[] {
            dts.format(SharedModConstants
                .getLocaleDateFormatter(SharedWebUiTestConstants.LANG)),
            (hour < 10 ? "0" : "") + hour, (min < 10 ? "0" : "") + min },
        cells);

    // Clear again
    bclear.click();

    // Pick date from datepicker
    WebElement input = el.findElement(By.cssSelector("input.dpicker"));
    input.click();

    WebElement dpk = getParent().findElement(By.id("ui-datepicker-div"));
    checkElVisible(dpk, true);

    WebElement date = dpk.findElement(By.className("ui-state-highlight"));
    date.click();
    SharedTestUtils.sleep();

    // Check date && time
    checkDateInput(new String[] {
        LocalDate.now()
            .format(SharedModConstants
                .getLocaleDateFormatter(SharedWebUiTestConstants.LANG)),
        "18", "00" }, cells);
  }

  protected int[] getDatePickerIdx() {
    return DPICKER_IDX;
  }

  private void checkDateInput(String[] data, List<WebElement> cells) {
    int[] didx = getDatePickerIdx();
    for (int i = 0; i <= didx[1] - didx[0]; i++) {
      assertEquals(data[i], getInputValue(cells.get(didx[0] + i)),
          "Date Input value #" + (i + 1) + " doesn't match.");
    }
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
