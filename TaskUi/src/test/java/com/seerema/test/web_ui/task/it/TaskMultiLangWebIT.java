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

package com.seerema.test.web_ui.task.it;

import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import com.seerema.test.web_ui.shared.utils.AbstractSharedMultiLangWebUiTest;

/**
 * Run multi-language test for TaskUI
 */

@DirtiesContext
@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT,
    value = { "spring.config.name=test" })
public class TaskMultiLangWebIT extends AbstractSharedMultiLangWebUiTest {

  @LocalServerPort
  private void setPort(int port) {
    TaskWebUiTestEx.LOCAL_PORT = port;
  }

  @Autowired
  private void setJdbcTemplate(JdbcTemplate jdbc) {
    TaskWebUiTestEx.JDBC = jdbc;
  }

  @Override
  public Class<TaskWebUiTestEx> getTestGuiClass() {
    return TaskWebUiTestEx.class;
  }

}
