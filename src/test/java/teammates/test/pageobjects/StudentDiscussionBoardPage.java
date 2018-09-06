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
      // Check the discussion board for the test data
      assertTrue(getPageSource().contains("this is the name"));
      assertTrue(getPageSource().contains("this is a test topic desc"));
      assertTrue(getPageSource().contains("this is the name2"));
      assertTrue(getPageSource().contains("this is a test topic desc2"));
    }
}
