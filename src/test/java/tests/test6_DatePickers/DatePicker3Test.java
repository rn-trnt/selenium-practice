package tests.test6_DatePickers;

import hooks.Hooks;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.Date;

public class DatePicker3Test extends Hooks {

  @Test(priority = 1)
  public void setValidRange() throws ParseException {
    String startDate = "01/11/2030";
    String endDate = "01/21/2030";

    scrollIntoView(page.getDatePicker3Label());
    page.setStartDatePicker3(startDate);
    page.setEndDatePicker3(endDate);
    page.clickDatePicker3Submit();

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(page.getDatePicker3Result()));

    Assert.assertEquals(page.getDatePicker3Start().getAttribute("value"), changeFormat(startDate), "Start date didn't match");
    Assert.assertEquals(page.getDatePicker3End().getAttribute("value"), changeFormat(endDate), "End date didn't match");
    Assert.assertEquals(page.getDatePicker3Result().getText(), "You selected a range of " + calculateDays(startDate, endDate) + " days.");
  }

  @Test(priority = 2)
  public void setInvalidRange() throws ParseException {
    String startDate = "01/11/2040";
    String endDate = "01/21/2030";

    scrollIntoView(page.getDatePicker3Label());
    page.setStartDatePicker3(startDate);
    page.setEndDatePicker3(endDate);
    page.clickDatePicker3Submit();

    WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
    wait.until(ExpectedConditions.visibilityOf(page.getDatePicker3Result()));

    Assert.assertEquals(page.getDatePicker3Start().getAttribute("value"), changeFormat(startDate), "Start date didn't match");
    Assert.assertEquals(page.getDatePicker3End().getAttribute("value"), changeFormat(endDate), "End date didn't match");
    Assert.assertEquals(page.getDatePicker3Result().getText(), "End date must be after start date.");
  }

  public String changeFormat(String date) throws ParseException {
    SimpleDateFormat inputFormat = new SimpleDateFormat("MM/dd/yyyy");
    SimpleDateFormat outputFormat = new SimpleDateFormat("yyyy-MM-dd");

    Date parsedDate = inputFormat.parse(date);

    return outputFormat.format(parsedDate);
  }

  public String calculateDays(String startDate, String endDate) throws ParseException {
    String startDateFormatted = changeFormat(startDate);
    String endDateFormatted = changeFormat(endDate);

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    LocalDate start = LocalDate.parse(startDateFormatted, formatter);
    LocalDate end = LocalDate.parse(endDateFormatted, formatter);

    long daysBetween = ChronoUnit.DAYS.between(start, end);

    return String.valueOf(daysBetween);
  }
}
