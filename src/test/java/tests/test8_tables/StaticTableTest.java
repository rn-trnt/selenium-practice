package tests.test8_tables;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class StaticTableTest extends Hooks {

  @Test(priority = 1)
  public void countRowAndColumn() {
    scrollIntoView(page.getStaticWebTableLabel());
    Assert.assertEquals(page.getStaticWebTable().findElements(By.xpath(".//tr[position() > 1]")).size(), 6, "Number of rows didn't match");
    Assert.assertEquals(page.getStaticWebTable().findElements(By.xpath(".//th")).size(), 4, "Number of column didn't match");
  }

  @Test(priority = 2)
  public void countPrice() {
    scrollIntoView(page.getStaticWebTableLabel());

    int price = 0;
    List<WebElement> rows = page.getStaticWebTable().findElements(By.xpath(".//tr[position() > 1]"));

    for (var row : rows) {
      price += Integer.parseInt(row.findElement(By.xpath(".//td[4]")).getText());
    }

    Assert.assertEquals(price, 7100, "Price didn't match");
  }

  @Test(priority = 3)
  public void countAppearance(){
    scrollIntoView(page.getStaticWebTableLabel());

    int mukeshAppearance = page.getStaticWebTable().findElements(By.xpath(".//tr[position() > 1]//td[contains(text(),'Mukesh')]")).size();
    int seleniumAppearance = page.getStaticWebTable().findElements(By.xpath(".//tr[position() > 1]//td[text()='Selenium']")).size();

    Assert.assertEquals(mukeshAppearance, 2, "Mukesh appearance didn't match");
    Assert.assertEquals(seleniumAppearance, 2, "Selenium appearance didn't match");
  }
}
