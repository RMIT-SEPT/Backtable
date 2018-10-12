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
<%@ attribute name="editTopicButton" type="teammates.ui.template.ElementTag" required="true" %>
<%@ attribute name="deleteTopicButton" type="teammates.ui.template.ElementTag" required="true" %>

<%-- TAG: edit topic form used for editing a topic accessed via discussion board --%>

<div class="panel panel-primary">
  <div class="panel-heading">
    <strong>Topic:</strong>

    <div class="pull-right">
      <a ${editTopicButton.attributesToString}>
        ${editTopicButton.content}
      </a>

      <a ${deleteTopicButton.attributesToString}>
        ${deleteTopicButton.content}
      </a>
    </div>
  </div>
  <%-- DIV: contains form that posts to the save topic page action, holds hidden attributes required for saving successfully --%>
  <div class="panel-body fill-plain">
    <form method="post" action="<%=Const.ActionURIs.STUDENT_DISCUSSION_BOARD_TOPIC_EDIT_SAVE%>" name="discussion_topic_edit_save" class="form form-horizontal">
      <input type="hidden" id="<%=Const.ParamsNames.STUDENT_ID%>" name="<%=Const.ParamsNames.STUDENT_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.SESSION_TOKEN%>" value="${sessionToken}">
      <input type="hidden" name="<%=Const.ParamsNames.USER_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.TOPIC_ID%>" value="${topicId}">

      <div class="form-group">
        <label class="col-sm-3 control-label">Topic Name:</label>
        <div class="col-sm-3">
          <input class="form-control toggle_inputs_" type="text"
            name="<%=Const.ParamsNames.TOPIC_NAME%>" id="<%=Const.ParamsNames.TOPIC_NAME%>"
            value="${topicName}" data-toggle="tooltip" data-placement="top"
            tabindex="1" disabled/>
        </div>
      </div>

      <div class="form-group">
        <label class="col-sm-3 control-label">Topic Description:</label>
        <div class="col-sm-9">
          <textarea style="max-width:100%; max-height:30%;"
            class="form-control toggle_inputs_" cols="20" rows="10"
            name="<%=Const.ParamsNames.TOPIC_DESC%>" id="<%=Const.ParamsNames.TOPIC_DESC%>"
            value="${topicDesc}" data-toggle="tooltip" data-placement="top"
            tabindex=2 disabled>${topicDesc}</textarea>
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-12 align-center">
          <input type="submit" class="btn btn-primary" id="btnSaveTopic" name="btnSaveTopic"
            style="display:none;" value="Save Changes">
        </div>
      </div>

      <input type="hidden" name="<%=Const.ParamsNames.USER_ID%>" value="${data.account.googleId}">
    </form>
  </div>
</div>
