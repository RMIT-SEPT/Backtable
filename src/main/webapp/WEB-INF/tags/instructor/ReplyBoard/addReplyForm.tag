<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Add New Topic Panel of Discussion Board Page" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
 
<%@ tag import="teammates.common.util.Const" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ attribute name="googleId" required="true" %>
<%@ attribute name="sessionToken" required="true" %>
<%-- needs much work --%>

<div class="well well-plain">
  <%-- The form will redirect to STUDENT_DISCUSSION_BOARD_ADD_TOPIC_PAGE which is map to StudentDiscussionBoardTopicAddPageData Action --%>

    <%-- These input are sent to StudentDiscussionBoardTopicAddPageData to create a new Topic --%>
<form method="get" action="<%=Const.ActionURIs.INSTRUCTOR_DISCUSSION_BOARD_ADD_REPLY_PAGE%>" name="reply_add" class="form form-horizontal">
      <input type="hidden" id="<%=Const.ParamsNames.STUDENT_ID%>" name="<%=Const.ParamsNames.STUDENT_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.SESSION_TOKEN%>" value="${sessionToken}">
      <input type="hidden" name="<%=Const.ParamsNames.USER_ID%>" value="${googleId}">
  <div>
    <label class="bold-label"  style="color:#3679B2; font-size:large;">Add Reply</label>
  </div>
  <br>
  <div>
    <label class="label-control">Topic Description: </label>
     <textarea style="max-width:100%; max-height:30%;"
              class="form-control" cols="20" rows="10" 
              name="<%=Const.ParamsNames.TOPIC_DESC%>" id="<%=Const.ParamsNames.TOPIC_DESC%>"
              value="${topicDescToShow}" data-toggle="tooltip" data-placement="top"
              title="Enter the name of the topic, e.g. Assignment 1 Advice."
              tabindex=2 placeholder="e.g. Assignment 1 Advice" 
              />
          </textarea>
  </div>
  <br>
 <div>
     <input id="btnAddCourse" type="submit" class="btn btn-primary" value="Add Topic" tabindex="3">
  </div>
  
  </form>
</div>
