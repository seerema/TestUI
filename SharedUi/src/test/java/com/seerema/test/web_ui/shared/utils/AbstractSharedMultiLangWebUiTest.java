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

import static org.junit.jupiter.api.Assertions.fail;
import static org.junit.platform.engine.discovery.DiscoverySelectors.selectClass;

import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.Test;
import org.junit.platform.launcher.Launcher;
import org.junit.platform.launcher.LauncherDiscoveryRequest;
import org.junit.platform.launcher.TestIdentifier;
import org.junit.platform.launcher.core.LauncherDiscoveryRequestBuilder;
import org.junit.platform.launcher.core.LauncherFactory;
import org.junit.platform.launcher.listeners.SummaryGeneratingListener;
import org.junit.platform.launcher.listeners.TestExecutionSummary;
import org.junit.platform.launcher.listeners.TestExecutionSummary.Failure;

import com.seerema.test.web_ui.shared.common.SharedWebUiTestConstants;

/**
 * Test GUI with all languages
 * 
 */

public abstract class AbstractSharedMultiLangWebUiTest {

  public abstract Class<? extends AbstractSharedWebUiTest> getTestGuiClass();

  @AfterAll
  public static void resetLang() {
    SharedWebUiTestConstants.LANG = null;
  }

  @Test
  public void testMultiLang() throws NoSuchFieldException, SecurityException {
    for (String lang : SharedWebUiTestConstants.LL_SET.keySet()) {
      // Skip default language since it's already tested in regular test
      if (lang.equals(SharedWebUiTestConstants.DEFAULT_LANG))
        continue;

      // Set test language
      SharedWebUiTestConstants.LANG = lang;

      try {
        Class<?> tclazz = getTestGuiClass();
        LauncherDiscoveryRequest request = LauncherDiscoveryRequestBuilder
            .request().selectors(selectClass(tclazz)).build();
        Launcher launcher = LauncherFactory.create();
        SummaryGeneratingListener listener = new SummaryGeneratingListener();
        launcher.registerTestExecutionListeners(listener);

        launcher.execute(request);
        TestExecutionSummary res = listener.getSummary();

        long tcnt = res.getTestsFoundCount();
        if (tcnt == 0)
          fail("No tests found in " + tclazz.getSimpleName());

        long fcnt = res.getTestsFailedCount();

        if (fcnt != 0) {

          List<Failure> list = res.getFailures();
          for (int i = 0; i < list.size(); i++) {
            Failure f = list.get(i);
            TestIdentifier ti = f.getTestIdentifier();
            System.err.println("\t ERROR #" + i + " - " +
                f.getException().getClass().getName() + ": " +
                f.getException() + "; " + ti.getSource());
          }

          fail("Test fail for lang: " + lang + ". " + fcnt +
              " errors detected.");
        }
      } catch (Exception e) {
        fail("Test fail for lang: " + lang + ". " + e.getMessage());
      }
    }
  }
}
