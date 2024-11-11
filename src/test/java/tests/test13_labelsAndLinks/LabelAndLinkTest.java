package tests.test13_labelsAndLinks;

import hooks.Hooks;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpConnectTimeoutException;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;
import java.util.Objects;

public class LabelAndLinkTest extends Hooks {

  @Test(priority = 1)
  public void laptopLinks() throws InterruptedException {
    scrollIntoView(page.getLabelsAndLinksLabel());

    for (var link : page.getLaptopLinks()) {
      String linkName = link.getText();
      link.click();
      Assert.assertTrue(Objects.requireNonNull(getDriver().getTitle()).contains(linkName));

      getDriver().navigate().back();
    }

    Thread.sleep(1000);
  }

  @Test(priority = 2)
  public void brokenLinks() throws InterruptedException, IOException {
    scrollIntoView(page.getLabelsAndLinksLabel());

    HttpClient client = HttpClient.newHttpClient();
    int maxRetries = 10;

    for (var link : page.getBrokenLinks()) {
      String href = link.getAttribute("href");

      Assert.assertNotNull(href, "Link missing 'href' attribute.");

      HttpRequest request = HttpRequest.newBuilder()
          .uri(URI.create(href))
          .method("HEAD", HttpRequest.BodyPublishers.noBody())
          .timeout(Duration.ofSeconds(5)).build();

      boolean success = false;
      int attempts = 0;

      while (!success && attempts < maxRetries) {
        attempts++;
        try {

          HttpResponse<Void> response = client.send(request, HttpResponse.BodyHandlers.discarding());
          int statusCode = response.statusCode();
          Assert.assertTrue(statusCode >= 400, "Not broken link");
          success = true;

        } catch (HttpConnectTimeoutException e) {
          System.out.println("Attempt " + attempts + " timed out for link: " + href);
        }
      }
      Assert.assertTrue(success, "Failed to verify link after " + maxRetries + " attempts: " + href);
    }

    Thread.sleep(1000);
  }

}
