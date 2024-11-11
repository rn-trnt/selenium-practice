package tests.test6_DatePickers;

import hooks.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DatePicker2Test extends Hooks {

  @Test(priority = 1)
  public void selectPastDate() {
    String requiredYear = "2021";
    String requiredMonth = "Jun";
    String requiredDate = "15";

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    scrollIntoView(page.getDatePicker2Label());
    page.clickDatePicker2();
    page.datePicker2SelectDate(requiredDate, requiredMonth, requiredYear);

    page.clickDatePicker2();
    wait.until(ExpectedConditions.visibilityOf(page.getDatePicker()));
    Assert.assertEquals(page.getDatePicker2Month(), requiredMonth, "Month didn't match");
    Assert.assertEquals(page.getDatePicker2Year(), requiredYear, "Year didn't match");
    var selectedDate = page.getSelectedDate(requiredDate);
    Assert.assertTrue(Boolean.parseBoolean(selectedDate.getAttribute("aria-current")), "The required date is not selected.");
  }

  @Test(priority = 2)
  public void selectFutureDate() {
    String requiredYear = "2030";
    String requiredMonth = "Jun";
    String requiredDate = "15";

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));

    scrollIntoView(page.getDatePicker2Label());
    page.clickDatePicker2();
    page.datePicker2SelectDate(requiredDate, requiredMonth, requiredYear);

    page.clickDatePicker2();
    wait.until(ExpectedConditions.visibilityOf(page.getDatePicker()));
    Assert.assertEquals(page.getDatePicker2Month(), requiredMonth, "Month didn't match");
    Assert.assertEquals(page.getDatePicker2Year(), requiredYear, "Year didn't match");
    var selectedDate = page.getSelectedDate(requiredDate);
    Assert.assertTrue(Boolean.parseBoolean(selectedDate.getAttribute("aria-current")), "The required date is not selected.");
  }
}
