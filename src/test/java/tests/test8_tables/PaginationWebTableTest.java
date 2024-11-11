package tests.test8_tables;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class PaginationWebTableTest extends Hooks {

  @Test(priority = 1)
  public void selectAll() {
    scrollIntoView(page.getPaginationWebTableLabel());

    int numberOfRowsSelected = 0;
    boolean isFirstPage = true;

    for (WebElement pagination : page.getPaginationWebTablePagination()) {
      if (!isFirstPage) {
        pagination.click();
      }

      for (WebElement row : page.getPaginationWebTableRows()) {
        var checkbox = row.findElement(By.xpath(".//input"));
        checkbox.click();
        if (checkbox.isSelected()) {
          numberOfRowsSelected++;
        }
      }

      isFirstPage = false;
    }

    Assert.assertEquals(numberOfRowsSelected, 20, "Selected product count didn't match");
  }

  @Test(priority = 2)
  public void selectIfPrices() {
    scrollIntoView(page.getPaginationWebTableLabel());

    int numberOfRowsSelected = 0;
    boolean isFirstPage = true;
    double priceThreshold = 10.00;

    for (WebElement pagination : page.getPaginationWebTablePagination()) {
      if (!isFirstPage) {
        pagination.click();
      }

      for (WebElement row : page.getPaginationWebTableRows()) {
        double productPrice = Double.parseDouble(row.findElement(By.xpath(".//td[3]")).getText().substring(1));
        var checkbox = row.findElement(By.xpath(".//input"));

        if (productPrice < priceThreshold) {
          checkbox.click();
        }

        if (checkbox.isSelected()) {
          numberOfRowsSelected++;
        }
      }

      isFirstPage = false;
    }

    Assert.assertEquals(numberOfRowsSelected, 6, "Selected product count didn't match");
  }

}
