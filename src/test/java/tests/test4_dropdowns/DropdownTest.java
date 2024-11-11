package tests.test4_dropdowns;

import hooks.Hooks;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DropdownTest extends Hooks {

  @Test(priority = 1)
  public void selectFromVisibleText() {
    scrollIntoView(page.getCountryDropdownLabel());
    Select dropdown = new Select(page.getCountryDropdown());
    dropdown.selectByVisibleText("India");
    Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "India", "The value didn't match");
  }

  @Test(priority = 2)
  public void selectFromValue() {
    scrollIntoView(page.getCountryDropdownLabel());
    Select dropdown = new Select(page.getCountryDropdown());
    dropdown.selectByValue("uk");
    Assert.assertEquals(dropdown.getFirstSelectedOption().getAttribute("value"), "uk", "The value didn't match");
  }

  @Test(priority = 3)
  public void selectFromIndex() {
    scrollIntoView(page.getCountryDropdownLabel());
    Select dropdown = new Select(page.getCountryDropdown());
    dropdown.selectByIndex(3);
    Assert.assertEquals(dropdown.getFirstSelectedOption().getText(), "Germany", "The value didn't match");
  }
}
