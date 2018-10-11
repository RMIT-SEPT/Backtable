package teammates.test.pageobjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentDiscussionBoardTopicEditPage extends AppPage {

    @FindBy(id = "btnEditTopic")
    private WebElement editTopicButton;

    @FindBy(id = "topicname")
    private WebElement topicNameTextBox;

    @FindBy(id = "topicdesc")
    private WebElement topicDescTextBox;

    @FindBy(id = "btnSaveTopic")
    private WebElement saveTopicButton;

    @FindBy(id = "btnDeleteTopic")
    private WebElement deleteTopicButton;
    
    @FindBy(className = "modal-btn-ok")
    private WebElement confirmDeleteButton;
    
    @FindBy(className = "modal-btn-cancel")
    private WebElement cancelDeleteButton;

    public StudentDiscussionBoardTopicEditPage(Browser browser) {
        super(browser);
    }

    @Override
    public boolean containsExpectedPageContents() {
        return getPageSource().contains("<h1>Edit Topic</h1>");
    }
    
    public boolean containsExpectedTopic(String topicName, String topicDesc) {
        return getPageSource().contains(topicName) && getPageSource().contains(topicDesc);
    }

    public StudentDiscussionBoardTopicEditPage editTopic(String topicName, String topicDesc) {
      click(editTopicButton);
      waitForPageToLoad();
      fillTextBox(topicNameTextBox, topicName);
      fillTextBox(topicDescTextBox, topicDesc);
      click(saveTopicButton);
      waitForPageToLoad();
      return this;
    }
    
    public StudentDiscussionBoardTopicEditPage cancelDeleteTopic() {
        click(deleteTopicButton);
        waitForPageToLoad();
        click(cancelDeleteButton);
        waitForPageToLoad();
        return this;
      }

    
    public StudentDiscussionBoardTopicEditPage deleteTopic() {
      click(deleteTopicButton);
      waitForPageToLoad();
      click(confirmDeleteButton);
      waitForPageToLoad();
      return this;
    }

}
