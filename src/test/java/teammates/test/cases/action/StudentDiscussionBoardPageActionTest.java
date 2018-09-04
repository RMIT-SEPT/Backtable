package teammates.test.cases.action;

import org.testng.annotations.Test;

import teammates.common.datatransfer.attributes.AccountAttributes;
import teammates.common.util.Const;
import teammates.test.driver.AssertHelper;
import teammates.test.driver.Priority;
import teammates.ui.controller.ShowPageResult;
import teammates.ui.controller.StudentDiscussionBoardPageAction;

@Priority(-2)
public class StudentDiscussionBoardPageActionTest extends BaseActionTest {

    @Override
    protected String getActionUri() {
        return Const.ActionURIs.STUDENT_DISCUSSION_BOARD_PAGE;
    }

    @Override
    @Test
    public void testExecuteAndPostProcess() {
      AccountAttributes student = typicalBundle.accounts.get("student1InUnregisteredCourse");
      testActionSuccess(student, "Typical case");
    }

    private void testActionSuccess(AccountAttributes student, String caseDescription) {
      gaeSimulation.loginAsStudent(student.googleId);
      ______TS(caseDescription);
      String[] submissionParams = new String[] {};
      StudentDiscussionBoardPageAction action = getAction(submissionParams);
      ShowPageResult result = getShowPageResult(action);

      AssertHelper.assertContains(
              getPageResultDestination(Const.ViewURIs.STUDENT_DISCUSSION_BOARD_PAGE, false, student.googleId),
              result.getDestinationWithParams());
      assertFalse(result.isError);
      assertEquals("", result.getStatusMessage());
    }

    @Override
    protected StudentDiscussionBoardPageAction getAction(String... params) {
        return (StudentDiscussionBoardPageAction) gaeSimulation.getActionObject(getActionUri(), params);
    }

    @Override
    @Test
    protected void testAccessControl() throws Exception {
        String[] submissionParams = new String[] {};
        verifyAnyRegisteredUserCanAccess(submissionParams);
    }

}
