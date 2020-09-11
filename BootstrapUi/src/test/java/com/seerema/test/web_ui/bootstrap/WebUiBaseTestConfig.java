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

package com.seerema.test.web_ui.bootstrap;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

import com.seerema.rest.shared.ui.AbstractSharedUiRestAppConfig;

/**
 * Configuration class for Spring Boot Test Launcher
 * 
 */

@SpringBootConfiguration
@EnableAutoConfiguration
@ComponentScan("com.seerema.test.web_ui.shared")
public class WebUiBaseTestConfig extends AbstractSharedUiRestAppConfig {

  @Override
  protected String getTestName() {
    return "BootstrapUiTest";
  }

}
