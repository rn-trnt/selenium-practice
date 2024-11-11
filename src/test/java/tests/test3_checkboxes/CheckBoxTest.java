package tests.test3_checkboxes;

import hooks.Hooks;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Objects;

public class CheckBoxTest extends Hooks {

  @Test(priority = 1)
  public void selectDay() {
    scrollIntoView(page.getDayCheckboxesLabel());
    String selectedDay = "Friday";
    boolean dayFound = false;

    for (WebElement checkbox : page.getDayCheckboxes()) {
      if (Objects.equals(checkbox.getAttribute("value"), selectedDay.toLowerCase())) {
        checkbox.click();
        dayFound = true;
        break;
      }
    }

    Assert.assertTrue(dayFound, selectedDay + " not selected");
  }

  @Test(priority = 2)
  public void selectAll() {
    scrollIntoView(page.getDayCheckboxesLabel());
    for (WebElement checkbox : page.getDayCheckboxes()) {
      checkbox.click();
    }

  }

  @Test(priority = 3)
  public void selectLast3(){
    scrollIntoView(page.getDayCheckboxesLabel());
    var checkboxes = page.getDayCheckboxes();

    for (int i = checkboxes.size() - 3; i < checkboxes.size(); i++) {
      checkboxes.get(i).click();
    }
  }
}
