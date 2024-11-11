package tests.test10_dynamicButton;

import hooks.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DynamicButtonTest extends Hooks {

  @Test
  public void dynamicButton() throws InterruptedException {
    scrollIntoView(page.getDynamicButtonLabel());
    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    var startButton = wait.until(ExpectedConditions.visibilityOf(page.getDynamicButtonStart()));
    Assert.assertTrue(startButton.isDisplayed());
    startButton.click();

    Thread.sleep(1000);

    var stopButton = wait.until(ExpectedConditions.visibilityOf(page.getDynamicButtonStop()));
    Assert.assertTrue(stopButton.isDisplayed());
    stopButton.click();

    Thread.sleep(1000);
  }
}
