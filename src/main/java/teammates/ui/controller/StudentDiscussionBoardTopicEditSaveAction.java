package teammates.ui.controller;

import java.util.List;

import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.StatusMessage;
import teammates.common.util.StatusMessageColor;
import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.ui.pagedata.StudentDiscussionBoardPageData;

public class StudentDiscussionBoardTopicEditSaveAction extends Action {

    @Override
    public ActionResult execute() {

        System.out.println("Saving");

        StudentDiscussionBoardPageData data = new StudentDiscussionBoardPageData(account, sessionToken);

        List<TopicAttributes> allTopics = logic.getAllTopics();

        data.init(allTopics);

        return createShowPageResult(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, data);
    }

}
