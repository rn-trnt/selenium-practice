package tests.test11_alertsAndPopups;

import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class PopupTest extends Hooks {

  @Test(priority = 1)
  public void newTab() {
    scrollIntoView(page.getAlertsPopupsLabel());

    String originalWindow = getDriver().getWindowHandle();
    page.getNewTabButton().click();

    List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
    getDriver().switchTo().window(windows.get(1));
    Assert.assertEquals(getDriver().getTitle(), "Your Store");

    getDriver().close();
    getDriver().switchTo().window(originalWindow);

  }

  @Test(priority = 2)
  public void popupWindows() {
    scrollIntoView(page.getAlertsPopupsLabel());

    String originalWindow = getDriver().getWindowHandle();
    page.getPopupWindowsButton().click();

    Set<String> windows = getDriver().getWindowHandles();
    for (var window : windows) {
      if (!window.equals(originalWindow)) {
        getDriver().switchTo().window(window);
        Assert.assertTrue(Objects.requireNonNull(getDriver().getTitle()).contains("Selenium") || Objects.requireNonNull(getDriver().getTitle()).contains("Playwright"));
        getDriver().close();

      }
    }

    getDriver().switchTo().window(originalWindow);
  }
}
