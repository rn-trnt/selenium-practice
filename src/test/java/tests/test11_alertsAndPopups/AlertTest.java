package tests.test11_alertsAndPopups;

import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AlertTest extends Hooks {

  @Test(priority = 1)
  public void simpleAlert(){
    scrollIntoView(page.getAlertsPopupsLabel());

    page.getSimpleAlertButton().click();
    var simpleAlert = getDriver().switchTo().alert();
    Assert.assertEquals(simpleAlert.getText(), "I am an alert box!");
    simpleAlert.accept();
  }

  @Test(priority = 2)
  public void confirmationAlert(){
    scrollIntoView(page.getAlertsPopupsLabel());

    // Test Accepting the Alert
    page.getConfirmationAlertButton().click();
    var alert = getDriver().switchTo().alert();
    Assert.assertEquals(alert.getText(), "Press a button!");
    alert.accept();
    Assert.assertEquals(page.getAlertMessage().getText(), "You pressed OK!");

    // Test Dismissing the Alert
    page.getConfirmationAlertButton().click();
    alert = getDriver().switchTo().alert();
    alert.dismiss();
    Assert.assertEquals(page.getAlertMessage().getText(), "You pressed Cancel!");
  }

  @Test(priority = 3)
  public void promptAlert() {
    scrollIntoView(page.getAlertsPopupsLabel());

    page.getPromptAlertButton().click();
    var prompt = getDriver().switchTo().alert();
    prompt.sendKeys("Selenium Test");
    prompt.accept();

    Assert.assertTrue(page.getAlertMessage().getText().contains("Selenium Test"));
  }

}
