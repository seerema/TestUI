package com.seerema.test.web_ui.crm.entity;
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

import org.openqa.selenium.WebElement;

import com.seerema.crm.srv.shared.CrmConstants;

/**
 * Data for My Active Tasks
 */

public class AllMyCustomers extends AbstractModCrm {

  private static final String USER_NAME = "user1";

  public static final String NAME = "entities::customer";

  private static final String TITLE = "MY_CUSTOMERS";

  private static String UPD_STATUS_ENTITY_NAME = MyPotentialClients.NAME;

  private static String TEST_NAME = "XYZ Company";

  public static String[][] INIT_DATA = new String[][] {
      new String[] { TEST_NAME, "[LL_COMPANY]", "[LL_CUSTOMER]", "[LL_NEVER]",
          "", "", "", "", "000-123-4567", "", "http://www.xyz.com/" } };

  public static String[][] UPDATE_DATA = new String[][] {
      new String[] { TEST_NAME, "[LL_COMPANY]", "[LL_LEAD]", "[LL_NEVER]", "",
          "", "", "", "000-123-4567", "", "http://www.xyz.com/" } };

  private static String[] EXISTING_DATA =
      new String[] { TEST_NAME, "[LL_CUSTOMER]", null, "", "", "000-123-4567",
          "", "http://www.xyz.com/" };

  private static String[][] STATUS_HISTORY =
      new String[][] { new String[] { "[LL_LEAD]", USER_NAME },
          new String[] { "[LL_CUSTOMER]", USER_NAME } };

  @Override
  public String[][] getInitData() {
    return INIT_DATA;
  }

  @Override
  protected void applyUpdFormData(WebElement el, String[] data,
      List<WebElement> cells) throws Exception {

    // Update only status
    changeStatus("LL_LEAD", cells);

    List<WebElement> rows = switchEntity(getUpdStatusEntityName());

    // Check last record
    int idx = rows.size() - 1;
    WebElement row = rows.get(idx);
    checkRowData(UPDATE_DATA[0], row, idx, "init");

    // Click and update status
    row.click();
    changeStatus("LL_CUSTOMER", getFormCells(getWidget(getContext())));

    // Switch back on our entity
    switchEntity(NAME).get(1).click();
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
    return TITLE;
  }

  public String getUpdStatusEntityName() {
    return UPD_STATUS_ENTITY_NAME;
  }

  public boolean hasAddButton() {
    return false;
  }

  @Override
  protected String[][] getStatusHistory() {
    return STATUS_HISTORY;
  }

  @Override
  public void checkInitDataNew(List<WebElement> rows) {
    Integer fcat = getJdbc().queryForObject(
        "select id from field_category fc, module m " +
            "where fc.name = 'LL_COMPANY' and m.name = '" +
            CrmConstants.MODULE_NAME + "' and fc.module_id = m.id",
        Integer.class);

    getJdbc().execute(
        "insert into entity(module_id, name, field_cat_id) values(2, '" +
            TEST_NAME + "', " + fcat + ")");
    Integer id = getJdbc().queryForObject(
        "select id from entity where name = '" + TEST_NAME + "'",
        Integer.class);

    Integer id1 = getJdbc().queryForObject(
        "select id from field f " +
            "where f.name = 'LL_WEB_SITE' and f.field_category_id = " + fcat,
        Integer.class);

    Integer id2 = getJdbc().queryForObject(
        "select id from field f " +
            "where f.name = 'LL_PHONE' and f.field_category_id = " + +fcat,
        Integer.class);

    Integer status = getJdbc().queryForObject(
        "select id from status s, module m " +
            "where s.name = 'LL_CUSTOMER' and m.name = '" +
            CrmConstants.MODULE_NAME + "' and s.module_id = m.id",
        Integer.class);

    // Insert new records
    getJdbc().batchUpdate(
        "insert into entity_ex(id, entity_id, user_id, status_id) values(" +
            id + ", " + id + ", 1, " + status + ")",
        "insert into entity_field(entity_id, field_id, value) values(" + id +
            ", " + id1 + ", 'http://www.xyz.com/')",
        "insert into entity_field(entity_id, field_id, value) values(" + id +
            ", " + id2 + ", '000-123-4567')",
        "insert into entity_status_history(entity_id, status_id, user_id, created) values(" +
            id + ", 2, 1, current_timestamp)",
        "insert into entity_user_history(entity_id, owner_id, user_id, created) values(" +
            id + ", 1, 1, current_timestamp)");

    clickRefreshButton();

    super.checkInitDataNew(getEntityListRows());
  }

  @Override
  public void checkInitDataEx(List<WebElement> rows) {
    super.checkInitDataEx(rows);

    if (getJdbc() == null)
      return;

    // Remove record from database
    Integer id = getJdbc().queryForObject(
        "select id from entity where name = '" + TEST_NAME + "'",
        Integer.class);

    getJdbc().execute("delete from entity_ex ex where id = " + id);
    getJdbc().execute("delete from entity where id = " + id);

    clickRefreshButton();
  }
}
