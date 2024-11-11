package tests.test12_mouseActions;

import hooks.Hooks;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DoubleClickTest extends Hooks {

  @Test
  public void doubleCLick() {
    scrollIntoView(page.getDoubleClickLabel());

    page.getInputField1().clear();
    page.getInputField1().sendKeys("Learn Selenium");

    Actions actions = new Actions(getDriver());
    actions.doubleClick(page.getCopyTextButton()).perform();

    Assert.assertEquals(page.getInputField2().getAttribute("value"), page.getInputField1().getAttribute("value"));

  }
}
