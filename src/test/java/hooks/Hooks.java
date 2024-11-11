package hooks;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
import net.datafaker.Faker;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.testng.ITestResult;
import org.testng.annotations.*;
import pageObjects.BasePage;

import java.time.Duration;

public class Hooks {

  private WebDriver driver;
  protected BasePage page;
  protected Faker faker;

  private static ExtentReports extent;
  private ExtentTest test;
  private String browserName;

  // Setup before any test methods are run
  @BeforeClass
  @Parameters("browser")
  public void setup(String browser) {
    this.browserName = browser;

    // Initialize ExtentReports only once
    if (extent == null) {
      ExtentSparkReporter sparkReporter = new ExtentSparkReporter(System.getProperty("user.dir") + "/reports/myReport.html");
      sparkReporter.config().setTheme(Theme.DARK);
      sparkReporter.config().setDocumentTitle("Automation Report");
      sparkReporter.config().setReportName("Test Report");
      extent = new ExtentReports();
      extent.attachReporter(sparkReporter);
    }

    // Set up browser-specific WebDriver
    switch (browser.toLowerCase()) {
      case "chrome":
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--headless");
        driver = new ChromeDriver(chromeOptions);
        break;
      case "edge":
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--headless");
        driver = new EdgeDriver(edgeOptions);
        break;
      default:
        System.out.println("Invalid Browser");
        return;
    }

    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    driver.manage().window().maximize();
    page = new BasePage(driver);
    faker = new Faker();
  }

  // Runs before each test method, setting up the environment
  @BeforeMethod
  public void refresh(ITestResult result) {
    driver.manage().deleteAllCookies();
    driver.get("https://testautomationpractice.blogspot.com/");

    // Set up ExtentTest with method and class info
    String methodName = result.getMethod().getMethodName();
    String className = result.getTestClass().getName();
    test = extent.createTest(browserName + ": " + className + " - " + methodName)
        .assignCategory(browserName);

    test.info("Starting test method: " + methodName);
  }

  // After each test method, log the result and capture status
  @AfterMethod
  public void captureStatus(ITestResult result) {
    if (result.getStatus() == ITestResult.FAILURE) {
      test.fail(result.getThrowable());
    } else if (result.getStatus() == ITestResult.SUCCESS) {
      test.pass("Test passed");
    } else if (result.getStatus() == ITestResult.SKIP) {
      test.skip("Test skipped");
    }
    test.info("Completed test method: " + result.getMethod().getMethodName());
  }

  // After all tests, clean up and close the browser
  @AfterClass
  public void tearDown() {
    if (driver != null) {
      driver.quit();
      test.info("Browser closed");
    }
    if (extent != null) {
      extent.flush();  // Write the report at the end
    }
  }

  // Getter for WebDriver instance
  public WebDriver getDriver() {
    return driver;
  }

  // Scroll an element into view using JavaScript
  public void scrollIntoView(WebElement element) {
    ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
  }
}
