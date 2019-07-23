package teammates.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentDiscussionBoardPage extends AppPage {

    @FindBy(id = "topicname")
    private WebElement topicNameTextBox;

    @FindBy(id = "topicdesc")
    private WebElement topicDescTextBox;

    // id should be renamed to btnAddTopic
    @FindBy(id = "btnAddCourse")
    private WebElement submitButton;

    @FindBy(className = "modal-btn-ok")
    private WebElement deleteButton;

    @FindBy(className = "modal-btn-cancel")
    private WebElement cancelButton;

    public StudentDiscussionBoardPage(Browser browser) {
        super(browser);
    }

    @Override
    protected boolean containsExpectedPageContents() {
        return getPageSource().contains("<h1>Add New Topic</h1>");
    }

    public boolean containsTestTopic() {
        return getPageSource().contains("href=\"/page/studentRepliesBoard?topicname=A1Help");
    }

    public StudentDiscussionBoardPage addTopic(String topicName, String topicDesc) {
      fillTextBox(topicNameTextBox, topicName);
      fillTextBox(topicDescTextBox, topicDesc);

      click(submitButton);
      waitForPageToLoad();
      return this;
    }

    public StudentDiscussionBoardPage cancelDeleteTopic(String topicName) {
        click(getDeleteLink(topicName));
        waitForPageToLoad();
        click(cancelButton);
        return this;
    }

    public StudentDiscussionBoardPage deleteTopic(String topicName) {
      click(getDeleteLink(topicName));
      waitForPageToLoad();
      click(deleteButton);
      return this;
    }

    public WebElement getDeleteLink(String topicName) {
      int topicRowNumber = getRowNumberOfTopic(topicName);
      return getDeleteLinkInRow(topicRowNumber);
    }

    public String getEditLink(String topicName) {
        int topicRowNumber = getRowNumberOfTopic(topicName);
        return getEditLinkInRow(topicRowNumber);
      }

    private int getTopicCount() {
      // id should be renamed to tableActiveTopics
      By activeCoursesTable = By.id("tableActiveCourses");
      waitForElementPresence(activeCoursesTable);
      return browser.driver.findElement(activeCoursesTable).findElements(By.tagName("tr")).size();
    }

    private int getRowNumberOfTopic(String topicName) {
      for (int i = 0; i < getTopicCount(); i++) {
        if (getTopicIdCell(i).getText().equals(topicName)) {
          return i;
        }
      }
      return -1;
    }

    private WebElement getTopicIdCell(int rowId) {
      return browser.driver.findElement(By.id("topicName" + rowId));
    }

    public WebElement getDeleteLinkInRow(int rowId) {
      By deleteLink = By.className("topic_delete" + rowId);
      return browser.driver.findElement(deleteLink);
    }

    public String getEditLinkInRow(int rowId) {
        By editLink = By.className("topic_edit" + rowId);
        return browser.driver.findElement(editLink).getAttribute("href");
    }
}
