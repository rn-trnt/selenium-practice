package tests.test12_mouseActions;

import hooks.Hooks;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SliderTest extends Hooks {

  @Test
  public void slider() {
    scrollIntoView(page.getSliderLabel());

    int targetMinValue = 0;
    int targetMaxValue = 500;

    Actions actions = new Actions(getDriver());

    while (page.getSliderRangeMin() != targetMinValue) {
      actions.dragAndDropBy(page.getSlider1(), -5, 0).perform();
    }

    while (page.getSliderRangeMax() != targetMaxValue) {
      actions.dragAndDropBy(page.getSlider2(), 5, 0).perform();
    }

    Assert.assertEquals(page.getSliderRange().getAttribute("value"), "$0 - $500");
  }

}
