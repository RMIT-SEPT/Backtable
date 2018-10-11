package teammates.test.pageobjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class StudentRepliesBoardPage extends AppPage {

    @FindBy(id = "replyDesc")
    private WebElement replyDescTextBox;

    @FindBy(id = "btnAddReply")
    private WebElement submitButton;
    
    @FindBy(className = "label-success")
    private WebElement likes;
    
    @FindBy(className = "upvote")
    private WebElement likeButton;
    
    @FindBy(className = "label-danger")
    private WebElement dislikes;
    
    @FindBy(className = "downvote")
    private WebElement dislikeButton;
    
    @FindBy(className = "reply_delete")
    private WebElement deleteButton;
    
    @FindBy(className = "modal-btn-cancel")
    private WebElement cancelDeleteButton;
    
    @FindBy(className = "modal-btn-ok")
    private WebElement confirmDeleteButton;

    public StudentRepliesBoardPage(Browser browser) {
        super(browser);
    }

    @Override
    public boolean containsExpectedPageContents() {
        return getPageSource().contains("<h1>Replies Board</h1>");
    }

    public boolean containsExpectedTopic(String topicName, String topicDesc) {
        return getPageSource().contains(topicName) && getPageSource().contains(topicDesc);
    }

    public boolean containsExpectedReply(String creator, String replyDesc) {
        return getPageSource().contains(creator) && getPageSource().contains(replyDesc);
    }

    public StudentRepliesBoardPage addReply(String replyDesc) {
        fillTextBox(replyDescTextBox, replyDesc);
        click(submitButton);
        waitForPageToLoad();
        return this;
    }

    public boolean likeReply(String replyDesc) {
        // Record the likes before clicking the like button
        int l1 = Integer.parseInt(likes.getText().split(" ")[0]);
        click(likeButton);
        // Record the likes after clicking the like button
        int l2 = Integer.parseInt(likes.getText().split(" ")[0]);
        return l2 == l1 + 1 ? true : false;
    }

    public boolean dislikeReply(String replyDesc) {
        // Record the dislikes before clicking the dislike button
        int d1 = Integer.parseInt(dislikes.getText().split(" ")[0]);
        click(dislikeButton);
        // Record the dislikes after clicking the dislike button
        int d2 = Integer.parseInt(dislikes.getText().split(" ")[0]);
        return d2 == d1 + 1 ? true : false;
        
    }

    public StudentRepliesBoardPage cancelDeleteReply(String replyDesc) {
        click(deleteButton);
        waitForPageToLoad();
        click(cancelDeleteButton);
        waitForPageToLoad();
        return this;
    }

    public StudentRepliesBoardPage deleteReply(String replyDesc) {
        click(deleteButton);
        waitForPageToLoad();
        click(confirmDeleteButton);
        waitForPageToLoad();
        return this;
    }
}
