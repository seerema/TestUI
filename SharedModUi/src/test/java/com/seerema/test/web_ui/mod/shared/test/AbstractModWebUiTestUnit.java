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

package com.seerema.test.web_ui.mod.shared.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.springframework.jdbc.core.JdbcTemplate;

import com.seerema.test.web_ui.mod.shared.entity.AbstractEntity;
import com.seerema.test.web_ui.mod.shared.entity.AbstractStatusEntity;
import com.seerema.test.web_ui.mod.shared.entity.AbstractSystemEntity;
import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;
import com.seerema.test.web_ui.shared.utils.AbstractSharedWebUiTest;
import com.seerema.test.web_ui.shared.utils.SharedTestUtils;

public abstract class AbstractModWebUiTestUnit extends AbstractSharedWebUiTest {

  // Workflow widget class name
  private static final String WFLOW_CNAME_PREFIX = "wflow-";

  protected abstract JdbcTemplate getJdbcTemplate();

  protected abstract String getMenuName();

  protected abstract int getMenuIdx();

  protected abstract String getModName();

  protected abstract Map<String, AbstractEntity> getRoleEntities(String string);

  private static final String[] OWNER_HISTORY_HEADERS =
      new String[] { "LL_CREATED", "LL_CUST_REP", "LL_AUTHZ_USER" };

  private static String[][] OWNER_HISTORY = new String[][] {
      new String[] { "user1", "user1" }, new String[] { "user2", "manager" } };

  @BeforeAll
  public static void initSharedBaseLangSet() {

    // @formatter:off
        
    // LL_HIDE_SIDEBAR
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_HIDE_SIDEBAR",
         "Hide Sidebar");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_HIDE_SIDEBAR",
        "Masquer la barre latérale");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_HIDE_SIDEBAR",
        "Спрятать боковое меню");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_HIDE_SIDEBAR",
        "Esconder barra lateral");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_HIDE_SIDEBAR",
        "Seitenleiste ausblenden");
    
    // LL_SHOW_SIDEBAR
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_SHOW_SIDEBAR",
        "Show Sidebar");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_SHOW_SIDEBAR",
        "Afficher la barre latérale");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_SHOW_SIDEBAR",
        "Показать боковое меню");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_SHOW_SIDEBAR",
        "Mostrar barra lateral");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_SHOW_SIDEBAR",
        "Seitenleiste anzeigen");
    
    // LL_CRM
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CRM",
      "CRM");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CRM",
      "CRM");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CRM",
      "CRM");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CRM",
      "CRM");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CRM",
      "CRM");
    
    // LL_OWNER_HISTORY_CHANGE
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_OWNER_HISTORY_CHANGE",
      "View history of customer representative changes");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_OWNER_HISTORY_CHANGE",
      "Afficher l'historique des modifications des représentants clients");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_OWNER_HISTORY_CHANGE",
      "Просмотреть историю изменения представителя заказчика");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_OWNER_HISTORY_CHANGE",
      "Ver el historial de cambios del representante del cliente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_OWNER_HISTORY_CHANGE",
      "Verlauf der Änderungen der Kundenvertreter anzeigen");
        
    
    // LL_CUST_REP
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_CUST_REP",
      "Customer Representative");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_CUST_REP",
      "Représentant client");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_CUST_REP",
      "Представитель Клиента");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_CUST_REP",
      "Representante del cliente");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_CUST_REP",
      "Kunden Vertreter");
    
    // LL_AUTHZ_USER
    SharedWebUiTestConstants.LL_SET.get("en").put("LL_AUTHZ_USER",
      "Authorized User");
    SharedWebUiTestConstants.LL_SET.get("fr").put("LL_AUTHZ_USER",
      "Utilisateur autorisé");
    SharedWebUiTestConstants.LL_SET.get("ru").put("LL_AUTHZ_USER",
      "Авторизованный пользователь");
    SharedWebUiTestConstants.LL_SET.get("es").put("LL_AUTHZ_USER",
      "Usuario autorizado");
    SharedWebUiTestConstants.LL_SET.get("de").put("LL_AUTHZ_USER",
      "Autorisierter Benutzer");
    
    // @formatter:on
  }

  @Test
  void testAdminEntities() throws Exception {
    ContextState cs = addTestFieldCat();

    addTestField(cs);

    // Add user record for the new field
    cs = initContext("user3", true);
    checkUser(cs, (AbstractStatusEntity) cs.getFirstEntry().getEntity(),
        cs.getFirstEntry().getName());

    // Delete new field & categories
    cs = initContext("admin");
    deleteLastEntityRecord(cs, 1);
    deleteLastEntityRecord(cs, 0);

    AbstractSystemEntity shnd =
        (AbstractSystemEntity) cs.getList().get(1).getEntity();
    // Check if non-system entities were deleted
    String[] records = shnd.getNonSystemRecords();
    if (records != null) {
      Integer fcat = getJdbcTemplate()
          .queryForObject("select id from field_category fc, module m " +
              "where fc.name = 'LL_COMPANY' and m.name = '" + getModName() +
              "' and fc.module_id = m.id", Integer.class);
      for (String record : records) {
        // Add back deleted fields
        getJdbcTemplate()
            .execute("insert into field(name, field_category_id) values('" +
                record + "', " + fcat + ")");
      }
    }
  }

  private void deleteLastEntityRecord(ContextState cs, int idx)
      throws Exception {

    EntityInfo info = cs.getList().get(idx);
    String name = info.getName();
    WebElement ctx = cs.getCtx();

    List<WebElement> rows = showEntityList(ctx, name,
        checkElementVisibleEx(
            checkElementVisibleId(getModName(), true,
                "Entities group " + getModName() + " not found."),
            ".entity[entity='" + name + "']", true,
            "Entity menu " + name + " not visible."));

    deleteLastEntityRecord(ctx, rows, name);
  }

  private void deleteLastEntityRecord(WebElement ctx, List<WebElement> rows,
      String name) {
    int cnt = rows.size();
    deleteLastEntityRecordEx(ctx, rows, name);

    // Check for number of rows reduced
    assertEquals(cnt - 1, getEnityListRows(ctx, name).size(),
        "Number or rows is not reduced after delete.");
    clickCloseButton(ctx);
  }

  private void deleteLastEntityRecordEx(WebElement ctx, List<WebElement> rows,
      String name) {

    rows.get(rows.size() - 1).click();
    deleteEntityItem(ctx);
  }

  private void addTestField(ContextState cs) throws Exception {
    String name = cs.getList().get(1).getName();

    cs.setRows(showEntityList(cs.getCtx(), name,
        checkElementVisibleEx(
            checkElementVisibleId(getModName(), true,
                "Entities group " + getModName() + " not found."),
            ".entity[entity='" + name + "']", true,
            "Entity menu " + name + " not visible.")));

    checkSystemList(cs, cs.getList().get(1).getEntity());
  }

  private ContextState addTestFieldCat() throws Exception {
    ContextState cs = initContext("admin", true);
    checkSystemList(cs, cs.getFirstEntry().getEntity());

    return cs;
  }

  private void checkSystemList(ContextState cs, AbstractEntity handler)
      throws Exception {
    AbstractSystemEntity shnd = (AbstractSystemEntity) handler;
    // Check if non-system entities needs to be deleted
    if (shnd.getNonSystemRecords() != null) {
      WebElement el = null;
      for (String record : shnd.getNonSystemRecords()) {
        el = cs.getCtx().findElement(By.cssSelector("input[type='search']"));
        el.sendKeys(SharedTestUtils.getLangLabel(record));

        List<WebElement> rows =
            getEnityListRows(cs.getCtx(), handler.getName());

        for (int i = 0; i < rows.size() - 1; i++)
          deleteLastEntityRecordEx(cs.getCtx(),
              getEnityListRows(cs.getCtx(), handler.getName()),
              handler.getName());

        el.clear();
      }

      el.sendKeys(Keys.BACK_SPACE);
      cs.setRows(getEnityListRows(cs.getCtx(), handler.getName()));
    }

    // Check all categories disabled
    handler.checkInitData(cs.getRows());

    for (int i = 1; i < cs.getRows().size(); i++) {
      WebElement row = cs.getRows().get(i);
      assertTrue(row.getAttribute("class").indexOf("row-disabled") >= 0,
          "Row with text '" + row.getText() + "' css class doesn't match.");
    }

    // Add new category
    addNewEntityItem(cs.getCtx(), cs.getFirstEntry().getName(), handler);
    clickCloseButton(cs.getCtx());
  }

  @Test
  void testManagerEntities() throws Exception {
    // Add the first entity record
    List<Long> saved = addUserEntityRecord();

    // Check that new entity is not visible for other user
    checkUserEmptyEntity();

    // Reassign new entity to user2
    changeEntityItemOwner(saved);

    // Check that entity is now available
    ContextState cs = initContext("user2", false);
    cs.getFirstEntry().getEntity().checkUpdateListEx(
        getEnityListRows(cs.getCtx(), cs.getFirstEntry().getName()));

    // Delete new entity
    cs = initContext("manager", false);
    List<WebElement> rows = loadView(cs);
    deleteLastEntityRecord(cs.getCtx(), rows, cs.getLastEntry().getName());
  }

  private void changeEntityItemOwner(List<Long> saved) throws Exception {
    ContextState cs = loadManagerView();
    cs.setSaved(saved);
    WebElement ctx = cs.getCtx();
    AbstractEntity handler = cs.getLastEntry().getEntity();
    String name = cs.getLastEntry().getName();

    // Change owner
    WebElement upd = getWidget(ctx, name);
    handler.fillUpdateEntity(upd);

    cs.addSaved();
    clickSaveButton(ctx);
    sleep();

    // Click again on updated record and check user's history
    List<WebElement> rows = getEnityListRows(ctx, name);
    rows.get(rows.size() - 1).click();
    handler.checkHistory(cs.getSaved(), "owner", OWNER_HISTORY_HEADERS,
        OWNER_HISTORY);
  }

  private ContextState loadManagerView() throws Exception {
    ContextState cs = initContext("manager", false);
    List<WebElement> rows = loadView(cs);
    cs.getLastEntry().getEntity().checkNewList(rows).click();

    return cs;
  }

  private List<WebElement> loadView(ContextState cs) throws Exception {
    WebElement ctx = cs.getCtx();
    String name = cs.getLastEntry().getName();
    return getEnityListRows(ctx, name);
  }

  private List<Long> addUserEntityRecord()
      throws NoSuchElementException, Exception {
    ContextState cs = initContext("user1", true);

    WebElement ctx = cs.getCtx();
    AbstractEntity handler = cs.getFirstEntry().getEntity();

    // Create entity
    handler.fillAddEntity(
        getAddEntityWidget(ctx, cs.getFirstEntry().getName(), handler, true));

    // Save new entity
    cs.addSaved();
    clickSaveButton(ctx);
    sleep(2);

    return cs.getSaved();
  }

  private void checkUserEmptyEntity() throws Exception {
    ContextState cs = initContext("user2", true);
    WebElement ctx = cs.getCtx();
    cs.getFirstEntry().getEntity().checkEmptyData(
        getEnityListRows(ctx, cs.getFirstEntry().getName()),
        cs.getFirstEntry().getName(), "for user2");
  }

  @Test
  void testUserEntities() throws Exception {
    ContextState cs = initContext("user1", getJdbcTemplate());
    WebElement ctx = cs.getCtx();

    for (EntityInfo entity : cs.getList()) {
      String name = entity.getName();
      AbstractStatusEntity handler = (AbstractStatusEntity) entity.getEntity();

      SharedWebUiTestConstants.LOG.debug("Testing entity " + name);

      // Click on entity
      WebElement group = checkElementVisibleId(getModName(), true,
          "Entities group " + getModName() + " not found.");

      WebElement nav =
          checkElementVisibleEx(group, ".entity[entity='" + name + "']", true,
              "Entity menu " + name + " not visible.");

      // Check entity title
      assertEquals(getLabelText(handler.getEntityTitle()), nav.getText());

      showEntityList(ctx, name, nav);
      SharedWebUiTestConstants.LOG.debug("Show initial entity " + name);

      // Close entity
      clickCloseButton(ctx);

      List<WebElement> rows = showEntityList(ctx, name, nav);

      handler.checkHeaders(rows.get(0));
      handler.checkInitDataNew(rows);
      SharedWebUiTestConstants.LOG.debug("Checked initial data");

      if (handler.hasAddButton()) {
        try {
          WebElement add = getAddEntityWidget(ctx, name, handler, false);

          // Close New Entity form
          clickCancelButton(add);
          // Check it back to entity list
          handler.checkInitData(getEnityListRows(ctx, name));
        } catch (Exception e) {
          fail(e.getMessage());
        }
      }

      checkUser(cs, handler, name);
    }
  }

  private void checkUser(ContextState cs, AbstractStatusEntity handler,
      String name) throws Exception {
    WebElement ctx = cs.getCtx();

    // Time when entities were saved
    List<Long> saved = new ArrayList<>();
    List<WebElement> rows = getEnityListRows(ctx, name);

    WebElement row;

    // Something unique, name or id for example
    String unq = null;

    if (handler.hasAddButton()) {
      EntityAddResult rs = addNewEntityItem(ctx, name, handler);
      saved.add(rs.getSaved());
      row = rs.getRow();
    } else {
      // Check button Add is not visible
      checkElementVisibleEx("button.add", false,
          "Button add should not be visible for entity " + handler.getName());

      List<WebElement> nrows = getEnityListRows(ctx, name);
      row = rows.get(nrows.size() - 1);
    }

    // Click on new data
    row.click();

    WebElement upd = getWidget(ctx, name);

    // Check Add Entity Title
    assertEquals(
        getLabelText(SharedWebUiTestConstants.LANG,
            handler.getUpdateEntityTitle()),
        upd.findElement(By.tagName("h2")).getText());

    handler.checkAddData(upd);

    unq = handler.fillUpdateEntity(upd);

    saved.add(System.currentTimeMillis());
    clickSaveButton(ctx);
    sleep(2);

    if (unq != null) {
      handler.checkUpdateList(getEnityListRows(ctx, name)).click();

      handler.checkStatusHistory(saved);

      // Check delete button disabled
      checkElementVisibleEnabled(
          ctx.findElement(By.cssSelector("button.delete")), true, false);
      clickCancelButton(ctx);

      SharedWebUiTestConstants.LOG
          .debug("Deleting entity record [" + unq + "]");

      Integer id = getJdbcTemplate().queryForObject(
          "select id from entity where name = '" + unq + "'", Integer.class);

      getJdbcTemplate().execute("delete from entity_ex ex where id = " + id);
      getJdbcTemplate().execute("delete from entity where id = " + id);
      clickRefreshButton(ctx);
      sleep(2);

      SharedWebUiTestConstants.LOG
          .debug("Deleted new entry for entity " + name);
    }

    // Verify entity data same as started
    handler.checkInitDataEx(getEnityListRows(ctx, name));

    // Close entity
    clickCloseButton(ctx);
    SharedWebUiTestConstants.LOG.debug("Entity " + name + " test completed.");
  }

  private EntityAddResult addNewEntityItem(WebElement ctx, String name,
      AbstractEntity handler) throws Exception {
    WebElement add = getAddEntityWidget(ctx, name, handler, true);

    // Check Add Entity Title
    assertEquals(
        getLabelText(SharedWebUiTestConstants.LANG,
            handler.getAddEntityTitle()),
        add.findElement(By.tagName("h2")).getText());

    // handler.checkWidgetLabels();
    handler.fillAddEntity(add);

    // Save new entity
    long msec = System.currentTimeMillis();
    clickSaveButton(ctx);
    sleep(2);

    // Check new data
    return new EntityAddResult(msec,
        handler.checkNewList(getEnityListRows(ctx, name)));
  }

  private void deleteEntityItem(WebElement ctx) {
    checkElementVisibleEnabled(ctx.findElement(By.cssSelector("button.delete")),
        true, true);
    clickDeleteButton(ctx);
    String text = closeAlertAndGetItsText(true);

    // Verify confirmation text
    assertEquals(text,
        getLabelText(SharedWebUiTestConstants.LANG, "LL_PLEASE_CONFIRM"));

    sleep();
  }

  protected WebElement getWidget(WebElement ctx, String name) {
    return checkElementVisible(ctx, "entity", true,
        "Update existing entity for " + name + " is not visible");
  }

  private WebElement getAddEntityWidget(WebElement ctx, String name,
      AbstractEntity handler, boolean fstraight)
      throws NoSuchElementException, Exception {
    clickAddButton(ctx);

    WebElement add;
    if (handler.getSlideSize() > 0)
      add = checkSlides(ctx, handler, name, fstraight);
    else
      add = checkElementVisible(ctx, "entity", true,
          "Add new entity for " + name + " is not visible");
    return add;
  }

  private WebElement checkSlides(WebElement ctx, AbstractEntity handler,
      String name, boolean fstraight) throws NoSuchElementException, Exception {
    if (!fstraight) {
      // Go back & force
      checkSlidesBackForce(ctx, handler, name);

      clickNextButton(ctx);
    }

    int start = fstraight ? 1 : 2;

    for (int i = start; i <= handler.getSlideSize(); i++) {
      // Go normal path
      WebElement slide = checkElementVisible(ctx, getSlideClassName(handler, i),
          true, "Slide #" + i + " is not visible.");

      // Check slide title
      handler.checkSlideTitle(slide, i);

      handler.fillSlide(slide, i);
      clickNextButton(slide);
    }

    return checkElementVisible(ctx, "entity", true,
        "Add new entity widget is not visible.");
  }

  private void checkSlidesBackForce(WebElement ctx, AbstractEntity handler,
      String name) throws NoSuchElementException, Exception {
    // Click cancel
    clickCancelButton(ctx);

    // Check it back to entity list
    handler.checkInitData(getEnityListRows(ctx, name));

    // Click add again
    clickAddButton(ctx);

    // Try click Next without filling
    // TODO Check for mandatory field errors

    String wname = getSlideClassName(handler, 1);
    handler.fillSlide(
        checkElementVisible(ctx, wname, true, "Slide #1 is not visible."), 1);

    clickNextButton(ctx);
    clickBackButton(ctx);

    // Check that data is the same on previous slide
    handler.checkSlide(
        checkElementVisible(ctx, wname, true, "Slide #1 is not visible."), 1);
  }

  private String getSlideClassName(AbstractEntity handler, int idx) {
    return WFLOW_CNAME_PREFIX + handler.getSlideName(idx);
  }

  private void clickAddButton(WebElement ctx) {
    clickButton(ctx, "add", "[LL_ADD]");
  }

  private void clickCloseButton(WebElement ctx) {
    clickButton(ctx, "wclose", "[LL_CLOSE]");
  }

  private void clickCancelButton(WebElement ctx) {
    clickButton(ctx, "cancel", "[LL_CANCEL]");
  }

  private void clickSaveButton(WebElement ctx) {
    clickButton(ctx, "save", "[LL_SAVE]", 3);
  }

  private void clickNextButton(WebElement ctx) {
    clickButton(ctx, "next", "[LL_NEXT]", 3);
  }

  private void clickBackButton(WebElement ctx) {
    clickButton(ctx, "back", "[LL_BACK]");
  }

  private void clickDeleteButton(WebElement ctx) {
    clickButton(ctx, "delete", "[LL_DELETE]");
  }

  private void clickRefreshButton(WebElement ctx) {
    clickButton(ctx, "refresh", "[LL_REFRESH]");
  }

  private void clickButton(WebElement ctx, String id, String title) {
    clickButton(ctx, id, title, 1);
  }

  private void clickButton(WebElement ctx, String id, String title,
      int timeout) {
    WebElement btn = checkElementVisibleEx(ctx, "button." + id, true,
        title + " button not visible.");

    assertEquals(SharedTestUtils.getPatternText(title), btn.getText(),
        "Button " + id + " text doesn't match.");

    btn.click();
    sleep(timeout);
  }

  private List<WebElement> showEntityList(WebElement parent, String name,
      WebElement entity) {
    assertFalse(checkElementPresent(parent, "entity-list"),
        "Table with entity " + name + " is not hidden.");

    entity.click();
    sleep();

    return getEnityListRows(parent, name);
  }

  private List<WebElement> getEnityListRows(WebElement parent, String name) {
    WebElement tdata = checkElementVisible("entity-list", true,
        "Table with entity " + name + " not visible.");

    return tdata.findElements(By.tagName("tr"));
  }

  private WebElement getSideNavigationEl() throws Exception {
    WebElement nav = checkElementVisibleEx("nav.sidebar", true,
        "Side navigation is not visible.");
    return nav;
  }

  private WebElement getModuleMenu(WebElement nav) {
    // Check module menu
    List<WebElement> menus = nav.findElements(By.cssSelector("li.active"));
    assertNotNull(menus, "Menu list is NULL.");
    assertTrue(menus.size() > getMenuIdx(),
        "Menu size is less then " + getMenuIdx());

    return menus.get(getMenuIdx());
  }

  private void testSideNavigation() throws Exception {
    WebElement nav = getSideNavigationEl();

    assertEquals(getLabelText(getMenuName()),
        getModuleMenu(nav).findElement(By.tagName("a")).getText());

    // Click hide navigation
    clickMenuItem("LL_HIDE_SIDEBAR");

    // Check side navigation is shited left
    assertEquals("-150px", nav.getCssValue("margin-left"),
        "Side Navigation is not shifted left");

    // Click show navigation
    clickMenuItem("LL_SHOW_SIDEBAR");

    // Check side navigation is hidden
    // Check side navigation is shited left
    assertEquals("0px", nav.getCssValue("margin-left"),
        "Side Navigation is not shifted right");

  }

  private void clickMenuItem(String lid) {
    // Click hide navigation
    List<WebElement> mitems = getMenuItems();

    // Check first item
    WebElement snav = mitems.get(0);
    assertEquals(getLabelText(lid),
        snav.findElement(By.tagName("span")).getText(),
        "Side navigation menu " + lid + " is not found");
    snav.click();
    sleep();

    // Check that both menu is hidden
    testElementVisible(snav, "menu", false);
  }

  @Override
  public void checkAfterSimpleLogin(String lang) throws Exception {
    testSideNavigation();
  }

  private ContextState initContext(String user) throws Exception {
    return initContext(user, null, null);
  }

  private ContextState initContext(String user, Boolean first)
      throws Exception {
    return initContext(user, first, null);
  }

  private ContextState initContext(String user, JdbcTemplate template)
      throws Exception {
    return initContext(user, null, template);
  }

  private ContextState initContext(String user, Boolean first,
      JdbcTemplate template) throws Exception {
    // Inject user into the session b4 initialize driver
    injectUser(user);
    init(SharedWebUiTestConstants.LANG);

    WebElement title = getModuleMenu(getSideNavigationEl());
    title.click();
    sleep();

    List<WebElement> items =
        title.findElement(By.tagName("ul")).findElements(By.tagName("a"));

    Map<String, AbstractEntity> entities = getRoleEntities(user);

    // Check that expected list is matching
    assertEquals(entities.size(), items.size(),
        "List of entities for role user doesn't match");

    ContextState cs = new ContextState(
        getTopWebEl().findElement(By.className("main-context")), user, entities,
        getModName(), getTopWebEl(), template);

    // Open entity, if required
    if (first != null) {
      String name =
          (first ? cs.getFirstEntry().getName() : cs.getLastEntry().getName());

      // Click on entity
      cs.setRows(showEntityList(cs.getCtx(), name,
          checkElementVisibleEx(
              checkElementVisibleId(getModName(), true,
                  "Entities group " + getModName() + " not found."),
              ".entity[entity='" + name + "']", true,
              "Entity menu " + name + " not visible.")));

      // Test if it works for all entities
      // handler.checkInitData(cs.getRows());
      // handler.checkHeaders(rows.get(0));
      // handler.checkInitData(rows);
    }

    return cs;
  }
}

class ContextState {

  private final String user;

  private WebElement ctx;

  private final Map<String, AbstractEntity> entities;

  private List<EntityInfo> list = new ArrayList<>();

  // Time when entities were saved
  List<Long> saved = new ArrayList<>();

  private List<WebElement> rows;

  public ContextState(WebElement ctx, String user,
      Map<String, AbstractEntity> entities, String modName, WebElement root,
      JdbcTemplate jdbc) {
    this.ctx = ctx;
    this.user = user;
    this.entities = entities;

    // Get the first entity
    for (Entry<String, AbstractEntity> entry : entities.entrySet()) {
      AbstractEntity entity = entry.getValue();
      list.add(new EntityInfo(entry.getKey(), entity));
      entity.init(modName, root, ctx, jdbc);
    }
  }

  public List<WebElement> getRows() {
    return rows;
  }

  public void setRows(List<WebElement> rows) {
    this.rows = rows;
  }

  public WebElement getCtx() {
    return ctx;
  }

  public String getUser() {
    return user;
  }

  public Map<String, AbstractEntity> getEntities() {
    return entities;
  }

  public EntityInfo getFirstEntry() {
    return list.get(0);
  }

  public EntityInfo getLastEntry() {
    return list.get(list.size() == 0 ? 0 : list.size() - 1);
  }

  public void addSaved() {
    saved.add(System.currentTimeMillis());
  }

  public List<Long> getSaved() {
    return saved;
  }

  public void setSaved(List<Long> saved) {
    this.saved = saved;
  }

  public List<EntityInfo> getList() {
    return list;
  }
}

class EntityAddResult {
  private final long saved;

  private final WebElement row;

  public EntityAddResult(long saved, WebElement row) {
    this.row = row;
    this.saved = saved;
  }

  public WebElement getRow() {
    return row;
  }

  public long getSaved() {
    return saved;
  }
}

class EntityInfo {
  private final String name;

  private final AbstractEntity entity;

  public EntityInfo(String name, AbstractEntity entity) {
    this.name = name;
    this.entity = entity;
  }

  public String getName() {
    return name;
  }

  public AbstractEntity getEntity() {
    return entity;
  }
}