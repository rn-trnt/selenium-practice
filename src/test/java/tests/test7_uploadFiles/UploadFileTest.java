package tests.test7_uploadFiles;

import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFileTest extends Hooks {

  @Test(priority = 1)
  public void singleFileUpload() {
    scrollIntoView(page.getUploadFileLabel());
    String file = System.getProperty("user.dir") + "\\src\\test\\java\\tests\\test7_uploadFiles\\image1.jpg";
    String fileName = file.substring(file.lastIndexOf("\\") + 1);

    page.getUploadSingleFileInput().sendKeys(file);
    page.getUploadSingleFileButton().click();

    Assert.assertTrue(page.getUploadSingleFileStatus().getText().contains(fileName), "The status doesn't contain expected file name: " + fileName);
  }

  @Test(priority = 2)
  public void multipleFileUpload() {
    scrollIntoView(page.getUploadFileLabel());
    String file1 = System.getProperty("user.dir") + "\\src\\test\\java\\tests\\test7_uploadFiles\\image1.jpg";
    String file2 = System.getProperty("user.dir") + "\\src\\test\\java\\tests\\test7_uploadFiles\\image2.jpg";
    String fileName1 = file1.substring(file1.lastIndexOf("\\") + 1);
    String fileName2 = file2.substring(file2.lastIndexOf("\\") + 1);

    page.getUploadMultipleFileInput().sendKeys(file1 + "\n" + file2);
    page.getUploadMultipleFileButton().click();

    Assert.assertTrue(page.getUploadMultipleFileStatus().getText().contains(fileName1), "The status doesn't contain expected file name: " + fileName1);
    Assert.assertTrue(page.getUploadMultipleFileStatus().getText().contains(fileName2), "The status doesn't contain expected file name: " + fileName2);
  }

  @Test(priority = 3)
  public void emptyFileUpload() {
    scrollIntoView(page.getUploadFileLabel());

    page.getUploadSingleFileButton().click();
    page.getUploadMultipleFileButton().click();

    Assert.assertEquals(page.getUploadSingleFileStatus().getText(), "No file selected.", "The status didn't match");
    Assert.assertEquals(page.getUploadMultipleFileStatus().getText(), "No files selected.", "The status didn't match");
  }
}
