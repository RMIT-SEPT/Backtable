package teammates.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentRepliesBoardEditPage extends AppPage {
    
    @FindBy(id = "replyDesc")
    private WebElement replyDescTextBox;
    
    @FindBy(id = "btnEditReply")
    private WebElement editButton;
    
    @FindBy(id = "btnDeleteReply")
    private WebElement deleteButton;
    
    @FindBy(id = "btnSaveReply")
    private WebElement saveButton;
    
    @FindBy(className = "modal-btn-ok")
    private WebElement confirmDeleteButton;
    
    @FindBy(className = "modal-btn-cancel")
    private WebElement cancelDeleteButton;
    
    public StudentRepliesBoardEditPage(Browser browser) {
        super(browser);
    }

    @Override
    public boolean containsExpectedPageContents() {
        return getPageSource().contains("<h1>Edit Reply</h1>");
    }

    public StudentRepliesBoardEditPage editReply(String newReplyDesc) {
        click(editButton);
        waitForPageToLoad();
        fillTextBox(replyDescTextBox, newReplyDesc);
        click(saveButton);
        return this;
    }

    public StudentRepliesBoardEditPage cancelDeleteReply() {
        click(deleteButton);
        waitForPageToLoad();
        click(cancelDeleteButton);
        return this;
    }

    public StudentRepliesBoardEditPage deleteReply() {
        click(deleteButton);
        waitForPageToLoad();
        click(confirmDeleteButton);
        return this;
    }

}
