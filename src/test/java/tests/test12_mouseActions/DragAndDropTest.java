package tests.test12_mouseActions;

import hooks.Hooks;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DragAndDropTest extends Hooks {

  @Test
  public void dragAndDrop() {
    scrollIntoView(page.getDragAndDropLabel());

    Actions actions = new Actions(getDriver());
    actions.dragAndDrop(page.getDragAndDropTarget(), page.getDragAndDropContainer()).perform();

    Assert.assertEquals(page.getDragAndDropContainer().getText(), "Dropped!");
  }

}
