package tests.test1_inputFields;

import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;


public class InputFieldTest extends Hooks {

  @Test
  public void enterInput() {
    String name = faker.name().fullName();
    name = name.substring(0, Math.min(15, name.length()));

    String email = faker.internet().emailAddress();
    email = email.substring(0, Math.min(25, email.length()));

    String phoneNumber = faker.numerify("08########");
    String address = faker.address().fullAddress();

    page.enterName(name);
    page.enterEmail(email);
    page.enterPhoneNumber(phoneNumber);
    page.enterAddress(address);

    Assert.assertEquals(page.getNameField().getAttribute("value"), name, "Name didn't match");
    Assert.assertEquals(page.getEmailField().getAttribute("value"), email, "Email didn't match");
    Assert.assertEquals(page.getPhoneNumberField().getAttribute("value"), phoneNumber, "Phone Number didn't match");
    Assert.assertEquals(page.getAddressTextarea().getAttribute("value"), address, "Address didn't match");
  }
}
