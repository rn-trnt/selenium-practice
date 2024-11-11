package tests.test2_radioButtons;

import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RadioButtonTest extends Hooks {

  @Test(priority = 1)
  public void selectMale() {
    scrollIntoView(page.getGenderRadioButtonLabel());
    page.getMaleRadioButton().click();
    Assert.assertTrue(page.getMaleRadioButton().isSelected(), "Gender Male not selected");
  }

  @Test(priority = 2)
  public void selectFemale() {
    scrollIntoView(page.getGenderRadioButtonLabel());
    page.getFemaleRadioButton().click();
    Assert.assertTrue(page.getFemaleRadioButton().isSelected(), "Gender Female not selected");
  }
}
