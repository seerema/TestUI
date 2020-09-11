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

package com.seerema.test.web_ui.shared.utils;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;

import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

/**
 * Generic utilities for GUI Web Test
 * 
 */
public abstract class WebUiTestUtils {

  // Web driver
  private WebDriver driver;

  // Root element
  private WebElement _root;

  protected StringBuffer verificationErrors = new StringBuffer();

  @BeforeEach
  public void setUp() throws Exception {
    // Use target folder for all downloads
    File f = new File("target");

    Map<String, Object> chromePrefs = new HashMap<String, Object>();
    chromePrefs.put("download.default_directory", f.getAbsolutePath());

    ChromeOptions options = new ChromeOptions();
    options.setExperimentalOption("prefs", chromePrefs);
    // options.addArguments("start-maximized"); Doesn't work in headless mode
    options.addArguments("disable-infobars");

    System.setProperty("webdriver.chrome.driver", "../driver/chromedriver");
    System.setProperty("webdriver.chrome.silentOutput", "true");

    driver = new ChromeDriver(options);
    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);

    // Set size manually
    driver.manage().window().setSize(new Dimension(1920, 1080));

    // Check if language change required
    if (!SharedWebUiTestConstants.LANG
        .equals(SharedWebUiTestConstants.DEFAULT_LANG))
      setLang(SharedWebUiTestConstants.LANG);
  }

  @AfterEach
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString))
      fail(verificationErrorString);
  }

  protected WebElement checkElementValue(String id, String expected) {
    WebElement el = _root.findElement(By.className(id));

    assertNotNull(el);
    assertEquals(expected, el.getAttribute("value"));

    return el;
  }

  protected WebElement checkElementIsSelected(String id, boolean selected) {
    WebElement el = _root.findElement(By.className(id));

    assertNotNull(el);
    assertEquals(selected, el.isSelected());

    return el;
  }

  protected String getLabelText(String id) {
    return SharedWebUiTestConstants.LL_SET.get(SharedWebUiTestConstants.LANG)
        .get(id);
  }

  protected String getLabelText(String lang, String id) {
    return SharedWebUiTestConstants.LL_SET.get(lang).get(id);
  }

  /**
   * Find element in global DOM by id and compare by lang label find by same id
   * 
   * @param lang Test Language
   * @param id UPPER-CASE ID
   * @return found web element if it's text match language id
   */
  protected WebElement checkLangElement(String lang, String id) {
    return checkLangElement(lang, id.toLowerCase(), id);
  }

  /**
   * Find lang label text as a child in top element and compare with expected
   * 
   * @param lang Language
   * @param cname Class Name
   * @param lid Lang Label ID
   * @return
   */
  protected WebElement checkLangElement(String lang, String cname, String lid) {
    WebElement el = _root.findElement(By.className(cname));
    assertEquals(getLabelText(lang, lid), el.getText());

    return el;
  }

  /**
   * Find lang label text as a child of base element and compare with expected
   * 
   * @param lang Language
   * @param base Base Element
   * @param cname Class Name
   * @param lid Language Label ID
   * @return
   */
  protected WebElement checkLangElement(String lang, WebElement base,
      String cname, String lid) {
    WebElement el = base.findElement(By.className(cname));
    assertEquals(getLabelText(lang, lid), el.getText());

    return el;
  }

  protected WebElement checkElementVisible(String id, boolean visible)
      throws NoSuchElementException {
    return checkElementVisible(id, visible, "");
  }

  protected WebElement checkElementVisible(String id, boolean visible,
      String comment) throws NoSuchElementException {
    WebElement el = _root.findElement(By.className(id));
    testElementVisible(el, id, visible, comment);

    return el;
  }

  protected WebElement checkElementVisibleId(String id, boolean visible)
      throws NoSuchElementException {
    return checkElementVisibleId(id, visible, "");
  }

  protected WebElement checkElementVisibleId(String id, boolean visible,
      String comment) throws NoSuchElementException {
    WebElement el = _root.findElement(By.id(id));
    testElementVisible(el, id, visible, comment);

    return el;
  }

  protected WebElement checkElementVisibleEx(String selector, boolean visible,
      String comment) throws NoSuchElementException {
    WebElement el = _root.findElement(By.cssSelector(selector));
    testElementVisible(el, selector, visible, comment);

    return el;
  }

  protected WebElement checkElementVisible(WebElement parent, String id,
      boolean visible) throws NoSuchElementException {
    WebElement el = parent.findElement(By.className(id));
    testElementVisible(el, id, visible, "");

    return el;
  }

  protected WebElement checkElementVisible(WebElement parent, String id,
      boolean visible, String comment) throws NoSuchElementException {
    WebElement el = parent.findElement(By.className(id));
    testElementVisible(el, id, visible, comment);

    return el;
  }

  protected WebElement checkElementVisibleEx(WebElement el, String id,
      boolean visible) throws NoSuchElementException {
    return checkElementVisibleEx(el, id, visible, "");
  }

  protected WebElement checkElementVisibleEx(WebElement el, String id,
      boolean visible, String comment) {
    WebElement elm = el.findElement(By.cssSelector(id));
    assertEquals(visible, elm.isDisplayed(),
        comment + id + " is " + (visible ? "not" : "") + " visible");

    return elm;
  }

  protected void testElementVisible(WebElement el, String id, boolean visible)
      throws NoSuchElementException {
    testElementVisible(el, id, visible, "");
  }

  protected void testElementVisible(WebElement el, String id, boolean visible,
      String comment) throws NoSuchElementException {
    assertNotNull(el, comment + id + " is not found ");
    assertEquals(visible, el.isDisplayed(),
        comment + id + " is " + (visible ? "not" : "") + " visible");
  }

  protected boolean checkElementPresent(WebElement parent, String id)
      throws NoSuchElementException {
    try {
      parent.findElement(By.className(id));
    } catch (NoSuchElementException e) {
      return false;
    }

    return true;
  }

  protected WebElement checkButtonById(String lang, String id,
      boolean enabled) {
    return checkButtonById(lang, id, id, enabled);
  }

  protected WebElement checkButtonById(String lang, String id, String text,
      boolean enabled) {
    WebElement button = checkElementVisible(id, true);

    checkButton(button, lang, text, enabled);
    return button;
  }

  protected WebElement checkButtonById(WebElement parent, String lang,
      String id, String text, boolean visible, boolean enabled) {
    WebElement button = parent.findElement(By.className(id));
    testElementVisible(button, id, visible);

    checkButton(button, lang, text, enabled);
    return button;
  }

  protected WebElement checkElementVisibleEnabled(WebElement parent,
      String cname, boolean visible, boolean enabled) {
    WebElement el = parent.findElement(By.className(cname));
    assertEquals(enabled, el.isEnabled());
    assertEquals(visible, el.isDisplayed());

    return el;
  }

  protected WebElement checkButton(WebElement button, String lang, String text,
      boolean enabled) {
    assertEquals(

        enabled, button.isEnabled(),
        "Button '" + text + "' is " + (enabled ? "not" : "") + " enabled");
    assertEquals(getLabelText(lang, text.toUpperCase()), button.getText());

    return button;
  }

  protected void closeAlert(boolean accept) {
    closeAlertAndGetItsText(accept);
  }

  protected String closeAlertAndGetItsText(boolean accept) {
    // Wait b4 analyze alert
    sleep();

    Alert alert = driver.switchTo().alert();
    String text = alert.getText();
    if (accept) {
      alert.accept();
    } else {
      alert.dismiss();
    }
    return text;
  }

  protected void closeAlertCheckText(boolean accept, String lang, String lid) {
    assertEquals(SharedWebUiTestConstants.LL_SET.get(lang).get(lid),
        closeAlertAndGetItsText(accept));
  }

  protected void sendEscKey() {
    Actions action = new Actions(driver);
    action.sendKeys(Keys.ESCAPE).perform();
  }

  /**
   * Right click on web element
   * 
   * @param el WebElement
   */
  public void clickContext(WebElement el) {
    Actions action = new Actions(driver);
    action.contextClick(el).build().perform();
  }

  /**
   * Drag one element into another
   * 
   * @param from Web Element to drag from
   * @param to Web Element to drag into
   */
  public void dragDrop(WebElement from, WebElement to) {
    Actions builder = new Actions(driver);

    Action dragAndDrop =
        builder.clickAndHold(from).moveToElement(to).release(to).build();

    dragAndDrop.perform();
  }

  /**
   * Set focus on input element
   * 
   * @param el Web Element to set focus on
   * @param to Web Element to drag into
   */
  public void setInputFocus(WebElement el) {
    new Actions(driver).moveToElement(el).click().perform();
  }

  public void initDriver(String url) {
    SharedWebUiTestConstants.LOG.debug("Connecting to: " + url);
    driver.get(url);
    sleep(2);

    // Inject login cookie
    Cookie ck = new Cookie("ROLES", "ROLE_SBS_ADMIN");
    driver.manage().addCookie(ck);

    // Repeat url to apply cookie
    driver.get(url);
    sleep(2);

    // Initiate root element
    setTopWebEl();
  }

  public WebDriver getDriver() {
    return driver;
  }

  public void setDriver(WebDriver driver) {
    this.driver = driver;
    setTopWebEl();
  }

  public WebElement getTopWebEl() {
    return _root;
  }

  public void setTopWebEl() {
    _root =
        driver.findElement(By.className(SharedWebUiTestConstants.TOP_EL_ID));
  }

  protected void selectByVisibleText(WebElement el, String text) {
    Select jtype = new Select(el);
    // jtype.deselectAll();
    jtype.selectByVisibleText(text);
  }

  /**
   * Callback method to set language
   * @param lang
   */
  protected void setLang(String lang) {
    // Do nothing
  }

  /**
   * Default delay after UI animated update
   */
  protected void sleep() {
    sleep(1);
  }

  protected void sleep(int tsec) {
    try {
      Thread.sleep(tsec * 1000);
    } catch (InterruptedException e) {
      // Do nothing
    }
  }
}
