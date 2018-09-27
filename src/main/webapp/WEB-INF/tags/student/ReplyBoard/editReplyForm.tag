<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Edit Topic Panel of Discussion Board Page" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ tag import="teammates.common.util.Const" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ attribute name="googleId" required="true" %>
<%@ attribute name="sessionToken" required="true" %>
<%@ attribute name="topicId" required="true" %>
<%@ attribute name="replyId" required="true" %>
<%@ attribute name="replyDesc" required="true" %>

<div class="well well-plain">
  <%-- The form will redirect to STUDENT_DISCUSSION_BOARD_REPLY_SAVE --%>

    <%-- These input are sent to StudentDiscussionBoardTopicAddPageData to create a new Topic --%>
<form method="post" action="<%=Const.ActionURIs.STUDENT_REPLIES_BOARD_EDIT_SAVE%>" name="discussion_reply_edit_save" class="form form-horizontal">
      <input type="hidden" id="<%=Const.ParamsNames.STUDENT_ID%>" name="<%=Const.ParamsNames.STUDENT_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.SESSION_TOKEN%>" value="${sessionToken}">
      <input type="hidden" name="<%=Const.ParamsNames.USER_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.TOPIC_ID%>" value="${topicId}">
      <input type="hidden" name="<%=Const.ParamsNames.REPLY_ID%>" value="${replyId}">
  <div>
    <label class="bold-label"  style="color:#3679B2; font-size:large;">Edit Topic</label>
  </div>
  <br>
  <div>
    <label class="label-control">Reply:</label>
     <textarea style="max-width:100%; max-height:30%;"
               class="form-control" cols="20" rows="10"
               name="<%=Const.ParamsNames.REPLY_DESC%>" id="<%=Const.ParamsNames.REPLY_DESC%>"
               value="${replyDesc}" data-toggle="tooltip" data-placement="top"
               tabindex=2>${replyDesc}</textarea>
  </div>
  <br>
 <div>
     <input id="btnEditReply" type="submit" class="btn btn-success" value="Save Changes" tabindex="3">
     <input id="resetEditReply" type="reset" class="btn btn-warning" value="Reset Changes" tabindex="4">
     <a href="${data.discussionBoardDetailsLink}">
        <input id="cancelEditTopic" class="btn btn-danger" value="Cancel Changes" tabindex="5">
     </a>
  </div>

  </form>
</div>
