package teammates.ui.controller;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.exception.EntityDoesNotExistException;
import teammates.common.exception.InvalidParametersException;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.InstructorRepliesBoardPageData;


public class InstructorRepliesBoardPageAction extends Action {

    InstructorRepliesBoardPageData data;
    TopicAttributes topic;
    private static final Logger log = Logger.getLogger();

    @Override
    protected ActionResult execute() {
        //getting topic name at the moment, whereas would be better to use topic id
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        
        account.studentProfile = logic.getStudentProfile(account.googleId);
        data = new InstructorRepliesBoardPageData(account, sessionToken);
        topic = logic.getTopic(topicId);

        topic.setViewCounter(topic.getViewCounter() + 1);
        data.init(topic);
        try {
            logic.updateTopic((topic));
        } catch (InvalidParametersException e) {
            e.printStackTrace();
        } catch (EntityDoesNotExistException e) {
            e.printStackTrace();
        }

        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_REPLIES_BOARD_PAGE, data);
    }


}
