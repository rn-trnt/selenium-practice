package tests.test12_mouseActions;

import hooks.Hooks;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MouseHoverTest extends Hooks {

  @Test
  public void mouseHover () {
    scrollIntoView(page.getMouseHoverLabel());

    Actions action = new Actions(getDriver());
    action.moveToElement(page.getPointMeButton()).perform();

    Assert.assertTrue(page.getPointMeMenu().isDisplayed());
    Assert.assertTrue(page.getMobilesMenu().isDisplayed());
    Assert.assertTrue(page.getLaptopsMenu().isDisplayed());
  }

}
