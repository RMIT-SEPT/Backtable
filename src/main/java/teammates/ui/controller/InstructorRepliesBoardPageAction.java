/**
 * 
 */
package teammates.ui.controller;

import teammates.common.datatransfer.attributes.TopicAttributes;
import teammates.common.util.Assumption;
import teammates.common.util.Const;
import teammates.common.util.Logger;
import teammates.ui.pagedata.InstructorRepliesBoardPageData;

/**
 * @author Christina
 *
 */
public class InstructorRepliesBoardPageAction extends Action {

    InstructorRepliesBoardPageData data;
    TopicAttributes topic;
    private static final Logger log = Logger.getLogger();

    @Override
    protected ActionResult execute() {
        //getting topic name at the moment, whereas would be better to use topic id
        String topicId = getRequestParamValue(Const.ParamsNames.TOPIC_ID);
        Assumption.assertPostParamNotNull(Const.ParamsNames.TOPIC_ID, topicId);
        data = new InstructorRepliesBoardPageData(account, sessionToken);
        topic = logic.getTopic(topicId);
        data.init(topic);
        
        return createShowPageResult(Const.ViewURIs.INSTRUCTOR_REPLIES_BOARD_PAGE, data);
    }

}
