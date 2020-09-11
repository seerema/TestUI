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

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

/**
 * Abstract Entity
 *
 */
public abstract class AbstractEntity {

  public abstract String[][] getInitData(List<WebElement> rows);

  protected abstract String[] getNewEntity();

  protected abstract String[] getNewEntityRow();

  protected abstract String[] getUpdateEntity();

  protected abstract String[] getUpdateEntityRow();

  protected abstract String[] getFormLabels();

  public abstract String getName();

  public abstract int getSlideSize();

  private static final Pattern LBL_PATTERN = Pattern.compile("^\\[(.*)\\]$");

  public void checkInitData(List<WebElement> rows) {
    String[][] data = getInitData(rows);
    int len = rows.size();
    assertEquals(data.length, len - 1,
        "Number of rows in entity list for entity " + getName() +
            " doesn't match size of init data");

    for (int i = 1; i < len; i++)
      checkRowData(data[i - 1], rows.get(i), i, "init");
  }

  private void checkRowData(String[] data, WebElement row, int idx,
      String msg) {
    List<WebElement> cells = row.findElements(By.tagName("td"));

    assertEquals(data.length, cells.size(),
        "Number of cells in entity list for entity " + getName() +
            " doesn't match size of data for " + msg);

    for (int i = 0; i < data.length; i++)
      assertEquals(checkPatternText(data[i]), cells.get(i).getText(),
          "Data item for cell [" + idx + "," + i + "] for entity " + getName() +
              " doesn't match.");
  }

  private String checkPatternText(String text) {
    Matcher m = LBL_PATTERN.matcher(text);
    return m.matches() ? getLabelText(m.group(1)) : text;
  }

  public void fillAddEntity(WebElement el) throws Exception {
    // TODO Check Add Titles

    String[] data = getNewEntity();

    applyFormData(el, data);
  }

  private void applyFormData(WebElement el, String[] data) throws Exception {
    checkFormLabels(el);
    List<WebElement> cells = checkFillDataForm(el, data);
    applyFormData(data, cells);
  }

  private void applyFormData(String[] data, List<WebElement> cells)
      throws Exception {
    for (int i = 0; i < data.length; i++) {
      WebElement cell = cells.get(i);

      String text = checkPatternText(data[i]);

      switch (cell.getTagName()) {
      case "input":
        cell.clear();
        cell.sendKeys(text);
        break;
      case "select":
        Select select = new Select(cell);
        select.selectByVisibleText(text);
        break;
      default:
        throw new Exception("Unknown input type " + cell.getTagName() +
            " found for data idx " + i + " for entity " + getName());
      }
    }
  }

  private List<WebElement> checkFillDataForm(WebElement el, String[] data) {
    List<WebElement> cells =
        el.findElements(By.cssSelector("input.field,select.field"));

    // Check if number of cells equal input data
    assertEquals(cells.size(), data.length,
        "Number of new data doesn't matching to the available cells for entity " +
            getName());

    return cells;
  }

  public void checkHeaders(WebElement webElement) {
    // TODO 
  }

  private void checkFormLabels(WebElement el) {
    List<WebElement> cells = el.findElements(By.className("field-title"));

    String[] labels = getFormLabels();

    // Check if number of cells equal the number of labels
    assertEquals(labels.length, cells.size(),
        "Number of form labels doesn't match for entity " + getName());

    for (int i = 0; i < cells.size(); i++)
      assertEquals(getLabelText(labels[i]) + ":", cells.get(i).getText());
  }

  public void fillSlide(WebElement el, int idx) throws Exception {
    String[] data = getSlideData(idx);

    // Try apply data
    applyFormData(data, checkFillDataForm(el, data));
  }

  protected String[] getSlideData(int idx) {
    // By default return nothing
    return null;
  }

  public void checkSlide(WebElement el, int idx) throws Exception {
    String[] data = getSlideData(idx);

    // Check all input and select fields are not empty
    List<WebElement> inputs =
        el.findElements(By.cssSelector("input.field,select.field"));

    // Check both match
    assertEquals(data.length, inputs.size(),
        "Number of data and input fields doesn't match for entity " +
            getName());

    for (int i = 0; i < data.length; i++) {
      String value;
      WebElement input = inputs.get(i);
      switch (input.getTagName()) {
      case "input":
        value = input.getText();
        break;

      case "select":
        Select select = new Select(input);
        WebElement selected = select.getFirstSelectedOption();
        value = selected.getText();
        break;

      default:
        throw new Exception("Unknown input field type " + input.getTagName() +
            " for field #" + i);
      }

      assertEquals(checkPatternText(data[i]), value,
          "Input data #" + i + " doesn't match input field for slide #" + idx +
              " for entity " + getName());
    }
  }

  public WebElement checkNewList(List<WebElement> rows) {
    String[] data = getNewEntityRow();
    WebElement row = rows.remove(rows.size() - 1);

    checkInitData(rows);
    checkRowData(data, row, rows.size() + 1, "new");
    return row;
  }

  public WebElement checkUpdateList(List<WebElement> rows) {
    String[] data = getUpdateEntityRow();
    WebElement row = rows.remove(rows.size() - 1);

    checkInitData(rows);
    checkRowData(data, row, rows.size() + 1, "update");

    return row;
  }

  public void fillUpdateEntity(WebElement el) throws Exception {
    // TODO Check update title
    String[] data = getUpdateEntity();

    applyFormData(el, data);
  }

  public String getSlideName(int idx) {
    return null;
  }

  public String getAddEntityTitle() {
    return "LL_ADD_NEW_" + getEntityTitle();
  }

  public String getUpdateEntityTitle() {
    return "LL_UPDATE_EXISTING_" + getEntityTitle();
  }

  public String getEntityTitle() {
    return getName().toUpperCase();
  }

  public void checkSlideTitle(WebElement slide, int i) {
    assertEquals(getLabelText(getSlideTitle(i)),
        slide.findElement(By.tagName("h2")).getText());
  }

  protected String getSlideTitle(int i) {
    return null;
  }

  private String getLabelText(String id) {
    return SharedWebUiTestConstants.LL_SET.get(SharedWebUiTestConstants.LANG)
        .get(id);
  }
}
