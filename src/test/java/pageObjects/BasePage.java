package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class BasePage {

  WebDriver driver;

  public BasePage(WebDriver driver) {
    this.driver = driver;
    PageFactory.initElements(driver, this);
  }

  // =====================================
  // Test 1: Input Fields
  // =====================================

  @FindBy(xpath = "//input[@id='name']")
  WebElement nameField;

  @FindBy(xpath = "//input[@id='email']")
  WebElement emailField;

  @FindBy(xpath = "//input[@id='phone']")
  WebElement phoneNumberField;

  @FindBy(xpath = "//textarea[@id='textarea']")
  WebElement addressTextarea;

  @FindBy(xpath = "//label[@for='textarea']")
  WebElement addressTextareaLabel;

  public WebElement getNameField() {
    return nameField;
  }

  public void enterName(String name) {
    nameField.clear();
    nameField.sendKeys(name);
  }

  public WebElement getEmailField() {
    return emailField;
  }

  public void enterEmail(String email) {
    emailField.clear();
    emailField.sendKeys(email);
  }

  public WebElement getPhoneNumberField() {
    return phoneNumberField;
  }

  public void enterPhoneNumber(String phoneNumber) {
    phoneNumberField.clear();
    phoneNumberField.sendKeys(phoneNumber);
  }

  public WebElement getAddressTextarea() {
    return addressTextarea;
  }

  public void enterAddress(String address) {
    addressTextarea.clear();
    addressTextarea.sendKeys(address);
  }

  public WebElement getAddressTextareaLabel() {
    return addressTextareaLabel;
  }

  // =====================================
  // Test 2: Radio Buttons
  // =====================================

  @FindBy(xpath = "//label[@for='gender']")
  WebElement genderRadioButtonLabel;

  @FindBy(xpath = "//input[@id='male']")
  WebElement maleRadioButton;

  @FindBy(xpath = "//input[@id='female']")
  WebElement femaleRadioButton;

  public WebElement getGenderRadioButtonLabel() {
    return genderRadioButtonLabel;
  }

  public WebElement getMaleRadioButton() {
    return maleRadioButton;
  }

  public WebElement getFemaleRadioButton() {
    return femaleRadioButton;
  }

  // =====================================
  // Test 3: Checkboxes
  // =====================================

  @FindBy(xpath = "//div[@class='form-check form-check-inline']//input[@type='checkbox']")
  List<WebElement> dayCheckboxes;

  @FindBy(xpath = "//label[@for='days']")
  WebElement dayCheckboxesLabel;

  public List<WebElement> getDayCheckboxes() {
    return dayCheckboxes;
  }

  public WebElement getDayCheckboxesLabel() {
    return dayCheckboxesLabel;
  }

  // =====================================
  // Test 4: Dropdowns
  // =====================================

  @FindBy(xpath = "//label[@for='country']")
  WebElement countryDropdownLabel;

  @FindBy(xpath = "//select[@id='country']")
  WebElement countryDropdown;

  public WebElement getCountryDropdownLabel() {
    return countryDropdownLabel;
  }

  public WebElement getCountryDropdown() {
    return countryDropdown;
  }

  // =====================================
  // Test 5: List Boxes
  // =====================================

  @FindBy(xpath = "//label[@for='colors']")
  WebElement colorsListBoxLabel;

  @FindBy(xpath = "//label[@for='animals']")
  WebElement animalsListBoxLabel;

  @FindBy(xpath = "//select[@id='colors']")
  WebElement colorsListBox;

  @FindBy(xpath = "//select[@id='animals']")
  WebElement animalsListBox;

  public WebElement getColorsListBoxLabel() {
    return colorsListBoxLabel;
  }

  public WebElement getAnimalsListBoxLabel() {
    return animalsListBoxLabel;
  }

  public WebElement getColorsListBox() {
    return colorsListBox;
  }

  public WebElement getAnimalsListBox() {
    return animalsListBox;
  }

  // =====================================
  // Test 6: Date Picker
  // =====================================

  @FindBy(xpath = "//div[@id='ui-datepicker-div']")
  WebElement datePicker;

  @FindBy(xpath = "//p[normalize-space()='Date Picker 1:']")
  WebElement datePicker1Label;

  @FindBy(xpath = "//p[normalize-space()='Date Picker 2:']")
  WebElement datePicker2Label;

  @FindBy(xpath = "//label[contains(text(), 'Date Picker 3')]")
  WebElement datePicker3Label;

  @FindBy(xpath = "//input[@id='datepicker']")
  WebElement datePicker1;

  @FindBy(xpath = "//span[@class='ui-datepicker-month']")
  WebElement datePicker1Month;

  @FindBy(xpath = "//span[@class='ui-datepicker-year']")
  WebElement datePicker1Year;

  @FindBy(xpath = "//input[@id='txtDate']")
  WebElement datePicker2;

  @FindBy(xpath = "//select[@class='ui-datepicker-month']")
  WebElement datePicker2MonthDropdown;

  @FindBy(xpath = "//select[@class='ui-datepicker-year']")
  WebElement datePicker2YearDropdown;

  @FindBy(xpath = "//table[@class='ui-datepicker-calendar']//td//a")
  List<WebElement> datePickerDays;

  @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-w']")
  WebElement datePickerPrev;

  @FindBy(xpath = "//span[@class='ui-icon ui-icon-circle-triangle-e']")
  WebElement datePickerNext;

  @FindBy(xpath = "//input[@id='start-date']")
  WebElement datePicker3Start;

  @FindBy(xpath = "//input[@id='end-date']")
  WebElement datePicker3End;

  @FindBy(xpath = "//button[@class='submit-btn']")
  WebElement datePicker3SubmitButton;

  @FindBy(xpath = "//div[@id='result']")
  WebElement datePicker3Result;

  public WebElement getDatePicker() {
    return datePicker;
  }

  public WebElement getDatePicker1Label() {
    return datePicker1Label;
  }

  public WebElement getDatePicker2Label() {
    return datePicker2Label;
  }

  public WebElement getDatePicker3Label() {
    return datePicker3Label;
  }

  public List<WebElement> getDatePickerDays() {
    return datePickerDays;
  }

  public WebElement getSelectedDate(String requiredDate) {
    for (WebElement date : getDatePickerDays()) {
      if (date.getText().equals(requiredDate)) {
        return date;
      }
    }

    return null;
  }

  public void clickDatePicker1() {
    datePicker1.click();
  }

  public WebElement getDatePicker1Month() {
    return datePicker1Month;
  }

  public WebElement getDatePicker1Year() {
    return datePicker1Year;
  }

  public void datePicker1SelectDate(String date, String month, String year, boolean selectFuture) {
    while (true) {
      String currentMonth = getDatePicker1Month().getText();
      String currentYear = getDatePicker1Year().getText();

      if (currentYear.equals(year) && currentMonth.equals(month)) {
        break;
      }

      if (selectFuture) {
        datePickerNext.click();
      } else {
        datePickerPrev.click();
      }
    }

    for (WebElement datePicker : getDatePickerDays()) {
      if (datePicker.getText().equals(date)) {
        datePicker.click();
        break;
      }
    }
  }

  public void clickDatePicker2() {
    datePicker2.click();
  }

  public String getDatePicker2Month() {
    Select selectedMonth = new Select(datePicker2MonthDropdown);
    return selectedMonth.getFirstSelectedOption().getText();
  }

  public String getDatePicker2Year() {
    Select selectedYear = new Select(datePicker2YearDropdown);
    return selectedYear.getFirstSelectedOption().getText();
  }

  public void datePicker2SelectDate(String date, String month, String year) {
    Select monthDropdown = new Select(datePicker2MonthDropdown);
    Select yearDropdown = new Select(datePicker2YearDropdown);

    monthDropdown.selectByVisibleText(month);
    yearDropdown.selectByVisibleText(year);

    for (WebElement datePicker : getDatePickerDays()) {
      if (datePicker.getText().equals(date)) {
        datePicker.click();
        break;
      }
    }
  }

  public WebElement getDatePicker3Start() {
    return datePicker3Start;
  }

  public WebElement getDatePicker3End() {
    return datePicker3End;
  }

  public void setStartDatePicker3(String startDate) {
    getDatePicker3Start().sendKeys(startDate);
  }

  public void setEndDatePicker3(String endDate) {
    getDatePicker3End().sendKeys(endDate);
  }

  public void clickDatePicker3Submit() {
    datePicker3SubmitButton.click();
  }

  public WebElement getDatePicker3Result() {
    return datePicker3Result;
  }

  // =====================================
  // Test 7: Upload Files
  // =====================================

  @FindBy(xpath = "//h2[normalize-space()='Upload Files']")
  WebElement uploadFileLabel;

  @FindBy(xpath = "//input[@id='singleFileInput']")
  WebElement uploadSingleFileInput;

  @FindBy(xpath = "//*[@id='singleFileForm']//button")
  WebElement uploadSingleFileButton;

  @FindBy(xpath = "//input[@id='multipleFilesInput']")
  WebElement uploadMultipleFileInput;

  @FindBy(xpath = "//*[@id='multipleFilesForm']//button")
  WebElement uploadMultipleFileButton;

  @FindBy(xpath = "//p[@id='singleFileStatus']")
  WebElement uploadSingleFileStatus;

  @FindBy(xpath = "//p[@id='multipleFilesStatus']")
  WebElement uploadMultipleFileStatus;

  public WebElement getUploadFileLabel() {
    return uploadFileLabel;
  }

  public WebElement getUploadSingleFileInput() {
    return uploadSingleFileInput;
  }

  public WebElement getUploadSingleFileButton() {
    return uploadSingleFileButton;
  }

  public WebElement getUploadMultipleFileInput() {
    return uploadMultipleFileInput;
  }

  public WebElement getUploadMultipleFileButton() {
    return uploadMultipleFileButton;
  }

  public WebElement getUploadSingleFileStatus() {
    return uploadSingleFileStatus;
  }

  public WebElement getUploadMultipleFileStatus() {
    return uploadMultipleFileStatus;
  }

  // =====================================
  // Test 8: Tables
  // =====================================

  @FindBy(xpath = "//h2[text()='Static Web Table']")
  WebElement staticWebTableLabel;

  @FindBy(xpath = "//table[@name='BookTable']")
  WebElement staticWebTable;

  @FindBy(xpath = "//h2[text()='Dynamic Web Table']")
  WebElement dynamicWebTableLabel;

  @FindBy(xpath = "//table[@id='taskTable']")
  WebElement dynamicWebTable;

  @FindBy(xpath = "//div[@id='displayValues']//p[1]")
  WebElement dynamicWebTableCPUInfo;

  @FindBy(xpath = "//div[@id='displayValues']//p[2]")
  WebElement dynamicWebTableMemoryInfo;

  @FindBy(xpath = "//div[@id='displayValues']//p[3]")
  WebElement dynamicWebTableNetworkInfo;

  @FindBy(xpath = "//div[@id='displayValues']//p[4]")
  WebElement dynamicWebTableDiskInfo;

  @FindBy(xpath = "//h2[text()='Pagination Web Table']")
  WebElement paginationWebTableLabel;

  @FindBy(xpath = "//ul[@id='pagination']//a")
  List<WebElement> paginationWebTablePagination;

  @FindBy(xpath = "//table[@id='productTable']//tbody//tr")
  List<WebElement> paginationWebTableRows;

  public WebElement getStaticWebTableLabel() {
    return staticWebTableLabel;
  }

  public WebElement getStaticWebTable() {
    return staticWebTable;
  }

  public WebElement getDynamicWebTable() {
    return dynamicWebTable;
  }

  public WebElement getDynamicWebTableLabel() {
    return dynamicWebTableLabel;
  }

  public WebElement getDynamicWebTableCPUInfo() {
    return dynamicWebTableCPUInfo;
  }

  public WebElement getDynamicWebTableMemoryInfo() {
    return dynamicWebTableMemoryInfo;
  }

  public WebElement getDynamicWebTableNetworkInfo() {
    return dynamicWebTableNetworkInfo;
  }

  public WebElement getDynamicWebTableDiskInfo() {
    return dynamicWebTableDiskInfo;
  }

  public WebElement getPaginationWebTableLabel() {
    return paginationWebTableLabel;
  }

  public List<WebElement> getPaginationWebTablePagination() {
    return paginationWebTablePagination;
  }

  public List<WebElement> getPaginationWebTableRows() {
    return paginationWebTableRows;
  }

  // =====================================
  // Test 9: Tabs
  // =====================================

  @FindBy(xpath = "//h2[text()='Tabs']")
  WebElement tabsLabel;

  @FindBy(xpath = "//img[@class='wikipedia-icon']")
  WebElement tabWikipediaIcon;

  @FindBy(xpath = "//input[@id='Wikipedia1_wikipedia-search-input']")
  WebElement tabInputBox;

  @FindBy(xpath = "//input[@type='submit']")
  WebElement tabSearchButton;

  @FindBy(xpath = "//div[@id='Wikipedia1_wikipedia-search-results']")
  WebElement tabSearchResult;

  @FindBy(xpath = "//div[@id='wikipedia-search-result-link']//a")
  List<WebElement> tabResultLinks;

  @FindBy(xpath = " //div[@id='Wikipedia1_wikipedia-search-more']//a")
  WebElement tabResultMore;

  public WebElement getTabsLabel() {
    return tabsLabel;
  }

  public WebElement getTabWikipediaIcon() {
    return tabWikipediaIcon;
  }

  public WebElement getTabInputBox() {
    return tabInputBox;
  }

  public WebElement getTabSearchButton() {
    return tabSearchButton;
  }

  public WebElement getTabSearchResult() {
    return tabSearchResult;
  }

  public List<WebElement> getTabResultLinks() {
    return tabResultLinks;
  }

  public WebElement getTabResultMore() {
    return tabResultMore;
  }

  // =====================================
  // Test 10: Dynamic Button
  // =====================================

  @FindBy(xpath = "//h2[text()='Dynamic Button']")
  WebElement dynamicButtonLabel;

  @FindBy(xpath = "//button[@class='start']")
  WebElement dynamicButtonStart;

  @FindBy(xpath = "//button[@class='stop']")
  WebElement dynamicButtonStop;

  public WebElement getDynamicButtonLabel() {
    return dynamicButtonLabel;
  }

  public WebElement getDynamicButtonStart() {
    return dynamicButtonStart;
  }

  public WebElement getDynamicButtonStop() {
    return dynamicButtonStop;
  }

  // =====================================
  // Test 11: Alerts & Popups
  // =====================================

  @FindBy(xpath = "//h2[text()='Alerts & Popups']")
  WebElement alertsPopupsLabel;

  @FindBy(xpath = "//button[@id='alertBtn']")
  WebElement simpleAlertButton;

  @FindBy(xpath = "//button[@id='confirmBtn']")
  WebElement confirmationAlertButton;

  @FindBy(xpath = "//button[@id='promptBtn']")
  WebElement promptAlertButton;

  @FindBy(xpath = "//p[@id='demo']")
  WebElement alertMessage;

  @FindBy(xpath = "//button[normalize-space()='New Tab']")
  WebElement newTabButton;

  @FindBy(xpath = "//button[@id='PopUp']")
  WebElement popupWindowsButton;

  public WebElement getAlertsPopupsLabel() {
    return alertsPopupsLabel;
  }

  public WebElement getSimpleAlertButton() {
    return simpleAlertButton;
  }

  public WebElement getConfirmationAlertButton() {
    return confirmationAlertButton;
  }

  public WebElement getPromptAlertButton() {
    return promptAlertButton;
  }

  public WebElement getAlertMessage() {
    return alertMessage;
  }

  public WebElement getNewTabButton() {
    return newTabButton;
  }

  public WebElement getPopupWindowsButton() {
    return popupWindowsButton;
  }

  // =====================================
  // Test 12: Mouse Actions
  // =====================================

  @FindBy(xpath = "//h2[text()='Mouse Hover']")
  WebElement mouseHoverLabel;

  @FindBy(xpath = "//button[@class='dropbtn']")
  WebElement pointMeButton;

  @FindBy(xpath = " //div[@class='dropdown-content']")
  WebElement pointMeMenu;

  @FindBy(xpath = "//a[normalize-space()='Mobiles']")
  WebElement mobilesMenu;

  @FindBy(xpath = "//a[normalize-space()='Laptops']")
  WebElement laptopsMenu;

  @FindBy(xpath = "//h2[text()='Double Click']")
  WebElement doubleClickLabel;

  @FindBy(xpath = "//input[@id='field1']")
  WebElement inputField1;

  @FindBy(xpath = "//input[@id='field2']")
  WebElement inputField2;

  @FindBy(xpath = "//button[normalize-space()='Copy Text']")
  WebElement copyTextButton;

  @FindBy(xpath = "//h2[text()='Drag and Drop']")
  WebElement dragAndDropLabel;

  @FindBy(xpath = "//div[@id='draggable']")
  WebElement dragAndDropTarget;

  @FindBy(xpath = "//div[@id='droppable']")
  WebElement dragAndDropContainer;

  @FindBy(xpath = "//h2[text()='Slider']")
  WebElement sliderLabel;

  @FindBy(xpath = "//div[@id='slider-range']//span[1]")
  WebElement slider1;

  @FindBy(xpath = "//div[@id='slider-range']//span[2]")
  WebElement slider2;

  @FindBy(xpath = "//input[@id='amount']")
  WebElement sliderRange;

  public WebElement getMouseHoverLabel() {
    return mouseHoverLabel;
  }

  public WebElement getPointMeButton() {
    return pointMeButton;
  }

  public WebElement getPointMeMenu() {
    return pointMeMenu;
  }

  public WebElement getMobilesMenu() {
    return mobilesMenu;
  }

  public WebElement getLaptopsMenu() {
    return laptopsMenu;
  }

  public WebElement getDoubleClickLabel() {
    return doubleClickLabel;
  }

  public WebElement getInputField1() {
    return inputField1;
  }

  public WebElement getInputField2() {
    return inputField2;
  }

  public WebElement getCopyTextButton() {
    return copyTextButton;
  }

  public WebElement getDragAndDropLabel() {
    return dragAndDropLabel;
  }

  public WebElement getDragAndDropTarget() {
    return dragAndDropTarget;
  }

  public WebElement getDragAndDropContainer() {
    return dragAndDropContainer;
  }

  public WebElement getSliderLabel() {
    return sliderLabel;
  }

  public WebElement getSlider1() {
    return slider1;
  }

  public WebElement getSlider2() {
    return slider2;
  }

  public WebElement getSliderRange() {
    return sliderRange;
  }

  public int getSliderRangeMin() {
    String range = sliderRange.getAttribute("value");
    assert range != null;
    String minText = range.split(" - ")[0].replace("$", "");
    return Integer.parseInt(minText);
  }

  public int getSliderRangeMax() {
    String range = sliderRange.getAttribute("value");
    assert range != null;
    String maxText = range.split(" - ")[1].replace("$", "");
    return Integer.parseInt(maxText);
  }

  // =====================================
  // Test 13: Labels And Links
  // =====================================

  @FindBy(xpath = "//h2[text() = 'Labels And Links']")
  WebElement labelsAndLinksLabel;

  @FindBy(xpath = "//div[@id='laptops']//a")
  List<WebElement> laptopLinks;

  @FindBy(xpath = "//div[@id='broken-links']//a")
  List<WebElement> brokenLinks;

  public WebElement getLabelsAndLinksLabel() {
    return labelsAndLinksLabel;
  }

  public List<WebElement> getLaptopLinks() {
    return laptopLinks;
  }

  public List<WebElement> getBrokenLinks() {
    return brokenLinks;
  }

}
