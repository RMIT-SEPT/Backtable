package teammates.test.pageobjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentDiscussionBoardPage extends AppPage {

    @FindBy(id = "topics-table")
    private WebElement topicsTable;

    public StudentDiscussionBoardPage(Browser browser) {
        super(browser);
    }

    @Override
    protected boolean containsExpectedPageContents() {
        return getPageSource().contains("<h1>Discussion Board</h1>");
    }

    public void ensureDiscussionBoardContainsTestData() {
      // Find each row in the topics table
      List<WebElement> rows = browser.driver.findElements(By.className("clickable-row"));

      // Assert rows exist
      assertTrue(rows.size() > 0);

      WebElement row1 = rows[0];
      // Assert the first row contains the test data
      assertEquals("this is the name", row1.findElements(By.tagName("td"))[0]);
      assertEquals("this is a test topic desc", row1.findElements(By.tagName("td"))[1]);

      // Assert the seccond row contains the test data
      WebElement row2 = rows[1];
      assertEquals("this is the name2", row2.findElements(By.tagName("td"))[0]);
      assertEquals("this is a test topic desc2", row2.findElements(By.tagName("td"))[1]);
    }
}
