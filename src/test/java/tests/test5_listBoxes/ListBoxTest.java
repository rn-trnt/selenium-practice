package tests.test5_listBoxes;

import hooks.Hooks;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

public class ListBoxTest extends Hooks {

  @Test(priority = 1)
  public void selectBy() {
    scrollIntoView(page.getColorsListBoxLabel());
    Select listBox = new Select(page.getColorsListBox());
    listBox.selectByValue("yellow");
    listBox.selectByVisibleText("Green");
    listBox.selectByIndex(1);

    var options = listBox.getAllSelectedOptions();
    for (WebElement option : options) {
      Assert.assertTrue(option.isSelected(), "Option " + option.getText() + " is not selected");
    }

    Assert.assertEquals(listBox.getAllSelectedOptions().size(), options.size(), "Selected options didn't match");
  }


  @Test(priority = 2)
  public void deselectBy() {
    scrollIntoView(page.getColorsListBoxLabel());
    Select listBox = new Select(page.getColorsListBox());
    listBox.selectByValue("yellow");
    listBox.selectByVisibleText("Green");
    listBox.selectByIndex(1);

    listBox.deselectByIndex(1);
    listBox.deselectByVisibleText("Green");
    listBox.deselectByValue("yellow");

    Assert.assertEquals(listBox.getAllSelectedOptions().size(), 0, "Selected options didn't match");
  }

  @Test(priority = 3)
  public void selectAll() {
    scrollIntoView(page.getAnimalsListBoxLabel());
    Select listBox = new Select(page.getAnimalsListBox());

    for (WebElement option : listBox.getOptions()) {
      listBox.selectByVisibleText(option.getText());
      Assert.assertTrue(option.isSelected(), "Option " + option.getText() + " is not selected");
    }

    Assert.assertEquals(listBox.getAllSelectedOptions().size(), listBox.getOptions().size(), "Not all options are selected");
  }

  @Test(priority = 4)
  public void deselectAll() {
    scrollIntoView(page.getAnimalsListBoxLabel());
    Select listBox = new Select(page.getAnimalsListBox());

    for (WebElement option : listBox.getOptions()) {
      listBox.selectByVisibleText(option.getText());
    }

    listBox.deselectAll();
    Assert.assertEquals(listBox.getAllSelectedOptions().size(), 0, "Not all options are deselected");
  }
}
