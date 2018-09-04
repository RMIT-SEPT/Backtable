package teammates.test.pageobjects;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.testng.annotations.Test;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentDiscussionBoardPage extends AppPage {

    public StudentDiscussionBoardPage(Browser browser) {
        super(browser);
    }

    @Override
    protected boolean containsExpectedPageContents() {
        return getPageSource().contains("<h1>Discussion Board</h1>");
    }

    public void ensureDiscussionBoardContainsTestData() {
      assertTrue(getPageSource().contains("this is the name"));
      assertTrue(getPageSource().contains("this is a test topic desc"));
      assertTrue(getPageSource().contains("this is the name2"));
      assertTrue(getPageSource().contains("this is a test topic desc2"));
      // // Find each row in the topics table
      // List<WebElement> rows = browser.driver.findElements(By.className("clickable-row"));
      //
      // // Assert the first row contains the test data
      // WebElement row1 = rows.get(0);
      // assertEquals("this is the name", row1.findElements(By.tagName("td"))[0].value());
      // assertEquals("this is a test topic desc", row1.findElements(By.tagName("td"))[1].value());
      //
      // // Assert the seccond row contains the test data
      // WebElement row2 = rows.get(1);
      // assertEquals("this is the name2", row2.findElements(By.tagName("td"))[0].value());
      // assertEquals("this is a test topic desc2", row2.findElements(By.tagName("td"))[1].value());
    }
}
