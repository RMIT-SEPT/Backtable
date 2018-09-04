package teammates.test.pageobjects;

import java.util.List;

import org.openqa.selenium.By;

public class StudentDiscussionBoardPage extends AppPage {

    public StudentDiscussionBoardPage(Browser browser) {
        super(browser);
    }

    @Override
    protected boolean containsExpectedPageContents() {
        return getPageSource().contains("<h1>Discussion Board</h1>");
    }
}
