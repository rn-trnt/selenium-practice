package tests.test9_tabs;

import hooks.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class TabTest extends Hooks {

  @Test(priority = 1)
  public void clickWikipediaIcon() {
    scrollIntoView(page.getTabsLabel());

    String originalWindow = getDriver().getWindowHandle();
    page.getTabWikipediaIcon().click();
    Set<String> allWindows = getDriver().getWindowHandles();

    for (var window : allWindows) {
      if (!window.equals(originalWindow)) {
        getDriver().switchTo().window(window);
        String title = getDriver().getTitle();
        assert title != null;
        Assert.assertTrue(title.contains("Wikipedia"));
      }
    }

    getDriver().close();
    getDriver().switchTo().window(originalWindow);
  }

  @Test(priority = 2)
  public void searchEmpty() {
    scrollIntoView(page.getTabsLabel());

    page.getTabSearchButton().click();
    Assert.assertTrue(page.getTabSearchResult().isDisplayed());
    Assert.assertEquals(page.getTabSearchResult().getText(), "Please enter text to search.");
  }

  @Test(priority = 3)
  public void searchSelenium() {
    scrollIntoView(page.getTabsLabel());

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    String originalWindow = getDriver().getWindowHandle();
    page.getTabInputBox().sendKeys("selenium");
    page.getTabSearchButton().click();
    Assert.assertTrue(page.getTabSearchResult().isDisplayed());

    // Iterate through each link in the search results
    var links = page.getTabResultLinks();
    for (var link : links) {
      String linkPage = link.getText();
      link.click();

      List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
      getDriver().switchTo().window(windows.get(1));

      wait.until(ExpectedConditions.titleContains(linkPage));
      String title = getDriver().getTitle();
      assert title != null;
      Assert.assertTrue(title.contains(linkPage));

      getDriver().close();
      getDriver().switchTo().window(originalWindow);
    }

    // Access "More" link
    page.getTabResultMore().click();
    List<String> windows = new ArrayList<>(getDriver().getWindowHandles());
    getDriver().switchTo().window(windows.get(1));

    wait.until(ExpectedConditions.titleContains("selenium"));
    String title = getDriver().getTitle();
    assert title != null;
    Assert.assertTrue(title.contains("selenium"));

    getDriver().close();
    getDriver().switchTo().window(originalWindow);
  }
}
