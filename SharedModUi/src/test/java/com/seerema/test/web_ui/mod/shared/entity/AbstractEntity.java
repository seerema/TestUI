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
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.springframework.jdbc.core.JdbcTemplate;

import com.seerema.test.web_ui.mod.shared.SharedModConstants;
import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;
import com.seerema.test.web_ui.shared.utils.SharedTestUtils;

/**
 * Abstract Entity
 *
 */
public abstract class AbstractEntity {

  public abstract String[][] getInitData();

  protected abstract String[] getNewEntity();

  protected abstract String[] getNewEntityRow();

  protected abstract String[] getExistingEntity();

  protected abstract String[] getUpdateEntity();

  protected abstract String[] getUpdateEntityRow();

  protected abstract String[] getAddFormLabels();

  protected abstract String[] getUpdFormLabels();

  protected abstract String getModEntityName();

  public abstract String getName();

  private WebElement ctx;

  private String modName;

  private WebElement parent;

  private JdbcTemplate jdbc;

  /**
   * Check init data for the first time
   * 
   * @param rows List of input rows
   */
  public void checkInitDataNew(List<WebElement> rows) {
    checkInitData(rows);
  }

  /**
   * Check init data after delete
   * 
   * @param rows List of input rows
   */
  public void checkInitDataEx(List<WebElement> rows) {
    checkInitData(rows);
  }

  public void checkInitData(List<WebElement> rows) {
    String[][] data = getInitData();
    int len = rows.size();

    // If single row has no cells than it's the empty one
    if (len == 2 && rows.get(1).findElements(By.tagName("td")).size() == 1)
      len = 1;

    // Don't count title
    assertEquals(data.length, len - 1,
        "Number of rows in entity list for entity " + getName() +
            " doesn't match size of init data");

    for (int i = 1; i < len; i++)
      checkRowData(data[i - 1], rows.get(i), i, "init");
  }

  public void checkEmptyData(List<WebElement> rows, String name, String msg) {
    // Check it empty
    assertEquals(2, rows.size(), "Number of records in empty entity " + name +
        " doesn't match" + (msg != null ? " " + msg : null));

    List<WebElement> zcells = rows.get(1).findElements(By.tagName("td"));
    assertEquals(1, zcells.size(), "Number of cells in empty entity " + name +
        " last record is non-zero" + (msg != null ? " " + msg : null));
  }

  public void fillAddEntity(WebElement el) throws Exception {
    String[] data = getNewEntity();
    applyFormData(el, data, getAddFormLabels());
  }

  private void applyFormData(WebElement el, String[] data, String[] labels)
      throws Exception {
    checkFormLabels(el, labels);
    applyFormData(el, data, checkFormElData(el, data));
  }

  private void applyUpdFormData(WebElement el, String[] data) throws Exception {
    checkFormLabels(el, getUpdFormLabels());
    applyUpdFormData(el, data, checkFormElData(el, data));
  }

  protected void applyUpdFormData(WebElement el, String[] data,
      List<WebElement> cells) throws Exception {
    applyFormData(el, data, cells);
  }

  protected void applyFormData(WebElement el, String[] data,
      List<WebElement> cells) throws Exception {
    for (int i = 0; i < data.length; i++)
      if (data[i] != null)
        applyFormDataItem(i, data[i], cells.get(i));
  }

  public void applyFormDataItem(int idx, String value, WebElement cell)
      throws Exception {

    String text = SharedTestUtils.getPatternText(value);

    switch (cell.getTagName()) {
    case "input":
    case "textarea":
      cell.clear();
      cell.sendKeys(text);
      break;
    case "select":
      Select select = new Select(cell);
      select.selectByVisibleText(text);
      break;
    default:
      throw new Exception("Unknown input type " + cell.getTagName() +
          " found for data idx " + idx + " for entity " + getName());
    }
  }

  private List<WebElement> checkFormElData(WebElement el, String[] data) {
    List<WebElement> cells = getFormCells(el);

    if (data == null)
      return cells;

    // Check if number of cells equal input data
    assertEquals(cells.size(), data.length,
        "Number of data doesn't matching to the available cells for entity " +
            getName());

    return cells;
  }

  public List<WebElement> getFormCells(WebElement el) {
    return el.findElements(
        By.cssSelector("input.field,select.field,textarea.field"));
  }

  public void checkHeaders(WebElement webElement) {
    // TODO 
  }

  private void checkFormLabels(WebElement el, String[] labels) {
    List<WebElement> cells = el.findElements(By.className("field-title"));

    // Check if number of cells equal the number of labels
    assertEquals(labels.length, cells.size(),
        "Number of form labels doesn't match for entity " + getName());

    for (int i = 0; i < cells.size(); i++)
      assertEquals(getLabelText(labels[i]) + ":", cells.get(i).getText());
  }

  public void fillSlide(WebElement el, int idx) throws Exception {
    String[] data = getSlideData(idx);

    // Try apply data
    applyFormData(el, data, checkFormElData(el, data));
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

      assertEquals(SharedTestUtils.getPatternText(data[i]), value,
          "Input data #" + (i + 1) + " doesn't match input field for slide #" +
              idx + " for entity " + getName());
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
    WebElement row = checkUpdateListEx(rows);
    checkInitData(rows);

    return row;
  }

  public WebElement checkUpdateListEx(List<WebElement> rows) {
    String[] data = getUpdateEntityRow();
    WebElement row = rows.remove(rows.size() - 1);
    checkRowData(data, row, rows.size() + 1, "update");

    return row;
  }

  public String fillUpdateEntity(WebElement el) throws Exception {
    String[] data = getUpdateEntity();
    applyUpdFormData(el, data);

    return data != null ? data[0] : null;
  }

  public String getSlideName(int idx) {
    return null;
  }

  public String getAddEntityTitle() {
    return "LL_ADD_NEW_" + getName();
  }

  public String getUpdateEntityTitle() {
    return "LL_UPDATE_EXISTING_" + getName();
  }

  public String getEntityTitle() {
    return "LL_" + getName();
  }

  public void checkSlideTitle(WebElement slide, int i) {
    assertEquals(getLabelText(getSlideTitle(i)),
        slide.findElement(By.tagName("h2")).getText());
  }

  public int getSlideSize() {
    return 0;
  }

  protected String getSlideTitle(int i) {
    return null;
  }

  private String getLabelText(String id) {
    return id.indexOf("LL_") == 0 ? SharedTestUtils.getLangLabel(id) : id;
  }

  public void checkAddData(WebElement el) throws Exception {
    String[] data = getExistingEntity();
    checkAddData(el, data, checkFormElData(el, data));
  }

  protected void checkAddData(WebElement el, String[] data,
      List<WebElement> cells) throws Exception {
    // Check the number of data and cells matches
    assertEquals(data.length, cells.size(),
        "The number of data and cells doesn't match for Update Entity for entity " +
            getName());
    for (int i = 0; i < data.length; i++) {
      if (data[i] == null)
        continue;

      WebElement input = cells.get(i);
      assertEquals(SharedTestUtils.getPatternText(data[i]),
          getInputValue(input), "Text in cell #" + (i + 1) +
              " doesn't match expected for entity " + getName());
    }
  }

  protected String getInputValue(WebElement input) {
    if (input.getTagName().equals("select")) {
      Select select = new Select(input);
      WebElement selected = select.getFirstSelectedOption();
      return selected.getText();
    } else {
      return input.getAttribute("value");
    }
  }

  protected void checkElVisibleEnabled(WebElement el, boolean visible,
      boolean enabled) {
    assertEquals(enabled, el.isEnabled());
    assertEquals(visible, el.isDisplayed());
  }

  protected void checkElVisible(WebElement el, boolean visible) {
    assertEquals(visible, el.isDisplayed());
  }

  protected WebElement getContext() {
    return ctx;
  }

  protected WebElement getParent() {
    return parent;
  }

  public void init(String modName, WebElement parent, WebElement ctx,
      JdbcTemplate jdbc) {
    this.ctx = ctx;
    this.modName = modName;
    this.parent = parent;
    this.jdbc = jdbc;
  }

  protected String getModName() {
    return modName;
  }

  public boolean hasAddButton() {
    return true;
  }

  public void checkHistory(List<Long> saved, String type,
      String[] statusHeaders, String[][] data) {
    getContext().findElement(By.className(type + "-history")).click();

    // Find spec dialog
    WebElement dialog = getContext().findElement(By.className("spec-dialog"));

    // Check title
    assertEquals(getLabelText("LL_" + type.toUpperCase() + "_HISTORY_CHANGE"),
        dialog.findElement(By.tagName("h2")).getText());

    // View history of task status changes
    List<WebElement> rows = dialog.findElement(By.tagName("table"))
        .findElement(By.tagName("tbody")).findElements(By.tagName("tr"));

    // Check first row
    List<WebElement> headers = rows.remove(0).findElements(By.tagName("th"));
    assertEquals(statusHeaders.length, headers.size(),
        "Number of headers in " + type + " history doesn't match.");

    for (int i = 0; i < statusHeaders.length; i++)
      assertEquals(getLabelText(statusHeaders[i]), headers.get(i).getText());

    assertEquals(data.length, rows.size(),
        "Number of " + type + " history records doesn't match.");

    assertEquals(data.length, saved.size(),
        "Number of " + type + " history saved times doesn't match.");

    for (int i = 0; i < data.length; i++) {
      String[] ditem = data[i];
      List<WebElement> cells = rows.get(i).findElements(By.tagName("td"));

      // First cell is create date
      String[] dstr = cells.get(0).getText().split(" ");

      // Parse first date part of the created date
      LocalDate ld = LocalDate.parse(dstr[0], SharedModConstants
          .getLocaleDateFormatter(SharedWebUiTestConstants.LANG));

      LocalDateTime ldt = LocalDateTime.parse(ld + "T" + dstr[1]);

      // Expecting max 1 sec difference between real event time and display
      long diff = saved.get(i) -
          ldt.atZone(ZoneId.systemDefault()).toInstant().toEpochMilli();
      assertTrue(diff < 1000,
          "Difference between saved time and created time " + diff +
              " is more than 1000 msec");

      for (int j = 0; j < 2; j++)
        assertEquals(SharedTestUtils.getPatternText(ditem[j]),
            cells.get(j + 1).getText());
    }

    // Close dialog
    dialog.findElement(By.cssSelector("button.close")).click();
  }

  protected void checkRowData(String[] data, WebElement row, int idx,
      String msg) {
    List<WebElement> cells = row.findElements(By.tagName("td"));

    assertEquals(data.length, cells.size(),
        "Number of cells in entity list for entity " + getName() +
            " doesn't match size of data for " + msg);

    for (int i = 0; i < data.length; i++)
      assertEquals(SharedTestUtils.getPatternText(data[i]),
          cells.get(i).getText(), "Data item for cell [" + idx + "," + i +
              "] for entity " + getName() + " doesn't match.");
  }

  protected List<WebElement> switchEntity(String name) {
    SharedWebUiTestConstants.LOG.debug("Switching to entity " + name);

    // Click on entity
    WebElement group = getParent().findElement(By.id(getModName()));
    group.findElement(By.cssSelector(".entity[entity='" + name + "']")).click();

    // Now examine but the new entity
    return getEntityListRows();
  }

  protected List<WebElement> getEntityListRows() {
    return getContext().findElement(By.className("entity-list"))
        .findElements(By.tagName("tr"));
  }

  protected WebElement getWidget(WebElement ctx) {
    return ctx.findElement(By.className("entity"));
  }

  protected void clickRefreshButton() {
    clickButton("refresh");
  }

  protected void clickCloseButton() {
    clickButton("wclose");
  }

  protected void clickDeleteButton() {
    clickButton("delete");
  }

  private void clickButton(String name) {
    getContext().findElement(By.cssSelector("button." + name)).click();
    SharedTestUtils.sleep();
  }

  public JdbcTemplate getJdbc() {
    return jdbc;
  }
}
