package tests.test1_inputFields;

import hooks.Hooks;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

public class AdjustTextareaTest extends Hooks {

  @Test(priority = 1)
  public void adjustBigger() {
    scrollIntoView(page.getAddressTextareaLabel());
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.height='500px';", page.getAddressTextarea());
  }

  @Test(priority = 2)
  public void adjustSmaller() {
    scrollIntoView(page.getAddressTextareaLabel());
    ((JavascriptExecutor) getDriver()).executeScript("arguments[0].style.height='10px';", page.getAddressTextarea());
  }
}
