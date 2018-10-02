<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Edit Topic Panel of Discussion Board Page" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ tag import="teammates.common.util.Const" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ attribute name="googleId" required="true" %>
<%@ attribute name="sessionToken" required="true" %>
<%@ attribute name="topicId" required="true" %>
<%@ attribute name="topicName" required="true" %>
<%@ attribute name="topicDesc" required="true" %>

<div class="well well-plain">
  <%-- The form will redirect to INSTRUCTOR_DISCUSSION_BOARD_ADD_TOPIC_PAGE which is map to StudentDiscussionBoardTopicAddPageData Action --%>

    <%-- These input are sent to InstructorDiscussionBoardTopicAddPageData to create a new Topic --%>
<form method="post" action="<%=Const.ActionURIs.INSTRUCTOR_DISCUSSION_BOARD_TOPIC_EDIT_SAVE%>" name="discussion_topic_edit_save" class="form form-horizontal">
      <input type="hidden" id="<%=Const.ParamsNames.STUDENT_ID%>" name="<%=Const.ParamsNames.STUDENT_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.SESSION_TOKEN%>" value="${sessionToken}">
      <input type="hidden" name="<%=Const.ParamsNames.USER_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.TOPIC_ID%>" value="${topicId}">
  <div>
    <label class="bold-label"  style="color:#3679B2; font-size:large;">Edit Topic</label>
  </div>
  <br>
  <div>
    <label class="label-control">Topic Name:</label>
    <input class="form-control" type="text"
           name="<%=Const.ParamsNames.TOPIC_NAME%>" id="<%=Const.ParamsNames.TOPIC_NAME%>"
           value="${topicName}" data-toggle="tooltip" data-placement="top"
           tabindex="1"/>
  </div>
  <br>
  <div>
    <label class="label-control">Topic Description: </label>
     <textarea style="max-width:100%; max-height:30%;"
               class="form-control" cols="20" rows="10"
               name="<%=Const.ParamsNames.TOPIC_DESC%>" id="<%=Const.ParamsNames.TOPIC_DESC%>"
               value="${topicDesc}" data-toggle="tooltip" data-placement="top"
               tabindex=2>${topicDesc}</textarea>
  </div>
  <br>
 <div>
     <input id="btnEditTopic" type="submit" class="btn btn-success" value="Save Changes" tabindex="3">
     <input id="resetEditTopic" type="reset" class="btn btn-warning" value="Reset Changes" tabindex="4">
     <a href="${data.studentDiscussionBoardLink }">
        <input id="cancelEditTopic" class="btn btn-danger" value="Cancel Changes" tabindex="5">
     </a>
  </div>

  </form>
</div>
