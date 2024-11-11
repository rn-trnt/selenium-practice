package tests.test8_tables;

import hooks.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DynamicWebTableTest extends Hooks {

  @Test(priority = 1)
  public void checkCPULoad() {
    scrollIntoView(page.getDynamicWebTableLabel());
    String cpuInfo = page.getDynamicWebTableCPUInfo().getText();
    String browserName = cpuInfo.substring(cpuInfo.indexOf("CPU load of ") + "CPU load of ".length(), cpuInfo.indexOf(" process:"));
    String cpuLoad = cpuInfo.substring(cpuInfo.indexOf("process: ") + "process: ".length());
    WebElement row = page.getDynamicWebTable().findElement(By.xpath(".//tbody//td[text() = '" + browserName + "']//parent::tr"));
    int column = page.getDynamicWebTable().findElements(By.xpath(".//th[contains(.,'CPU')]/preceding-sibling::th")).size() + 1;

    Assert.assertEquals(row.findElement(By.xpath(".//td[1]")).getText(), browserName);
    Assert.assertEquals(row.findElement(By.xpath(".//td[" + column + "]")).getText(), cpuLoad);
  }

  @Test(priority = 2)
  public void checkMemorySize() {
    scrollIntoView(page.getDynamicWebTableLabel());
    String memoryInfo = page.getDynamicWebTableMemoryInfo().getText();
    String browserName = memoryInfo.substring(memoryInfo.indexOf("Memory Size of ") + "Memory Size of ".length(), memoryInfo.indexOf(" process:"));
    String memorySize = memoryInfo.substring(memoryInfo.indexOf("process: ") + "process: ".length());
    WebElement row = page.getDynamicWebTable().findElement(By.xpath(".//tbody //td[text() = '" + browserName + "']//parent::tr"));
    int column = page.getDynamicWebTable().findElements(By.xpath(".//th[contains(.,'Memory')]/preceding-sibling::th")).size() + 1;

    Assert.assertEquals(row.findElement(By.xpath(".//td[1]")).getText(), browserName);
    Assert.assertEquals(row.findElement(By.xpath(".//td[" + column + "]")).getText(), memorySize);
  }

  @Test(priority = 3)
  public void checkNetworkSpeed() {
    scrollIntoView(page.getDynamicWebTableLabel());
    String networkInfo = page.getDynamicWebTableNetworkInfo().getText();
    String browserName = networkInfo.substring(networkInfo.indexOf("Network speed of ") + "Network speed of ".length(), networkInfo.indexOf(" process:"));
    String networkSpeed = networkInfo.substring(networkInfo.indexOf("process: ") + "process: ".length());
    WebElement row = page.getDynamicWebTable().findElement(By.xpath(".//tbody //td[text() = '" + browserName + "']//parent::tr"));
    int column = page.getDynamicWebTable().findElements(By.xpath(".//th[contains(.,'Network')]/preceding-sibling::th")).size() + 1;

    Assert.assertEquals(row.findElement(By.xpath(".//td[1]")).getText(), browserName);
    Assert.assertEquals(row.findElement(By.xpath(".//td[" + column + "]")).getText(), networkSpeed);
  }

  @Test(priority = 4)
  public void checkDiskSpace() {
    scrollIntoView(page.getDynamicWebTableLabel());
    String diskInfo = page.getDynamicWebTableDiskInfo().getText();
    String browserName = diskInfo.substring(diskInfo.indexOf("Disk space of ") + "Disk space of ".length(), diskInfo.indexOf(" process:"));
    String diskSpace = diskInfo.substring(diskInfo.indexOf("process: ") + "process: ".length());
    WebElement row = page.getDynamicWebTable().findElement(By.xpath(".//tbody //td[text() = '" + browserName + "']//parent::tr"));
    int column = page.getDynamicWebTable().findElements(By.xpath(".//th[contains(.,'Disk')]/preceding-sibling::th")).size() + 1;

    Assert.assertEquals(row.findElement(By.xpath(".//td[1]")).getText(), browserName);
    Assert.assertEquals(row.findElement(By.xpath(".//td[" + column + "]")).getText(), diskSpace);
  }

}
