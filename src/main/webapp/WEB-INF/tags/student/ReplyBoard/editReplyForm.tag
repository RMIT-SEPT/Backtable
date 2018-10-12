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
<%@ attribute name="editReplyButton" type="teammates.ui.template.ElementTag" required="true" %>
<%@ attribute name="deleteReplyButton" type="teammates.ui.template.ElementTag" required="true" %>

<%-- TAG: used for page edit Reply on discussion board --%>
<div class="panel panel-primary">
<%-- DIV: shows reply information --%>
  <div class="panel-heading">
    <strong>Reply:</strong>

    <div class="pull-right">
      <a ${editReplyButton.attributesToString}>
        ${editReplyButton.content}
      </a>
      <a ${deleteReplyButton.attributesToString}>
        ${deleteReplyButton.content}
      </a>
    </div>
  </div>

<%--DIV/FORM: used to post the edit reply to the edit save page --%>
  <div class="panel-body fill-plain">
    <form method="post" action="<%=Const.ActionURIs.STUDENT_REPLIES_BOARD_EDIT_SAVE%>" name="discussion_reply_edit_save" class="form form-horizontal">
      <input type="hidden" id="<%=Const.ParamsNames.STUDENT_ID%>" name="<%=Const.ParamsNames.STUDENT_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.SESSION_TOKEN%>" value="${sessionToken}">
      <input type="hidden" name="<%=Const.ParamsNames.USER_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.TOPIC_ID%>" value="${topicId}">
      <input type="hidden" name="<%=Const.ParamsNames.REPLY_ID%>" value="${replyId}">

      <div class="form-group">
        <label class="col-sm-3 control-label">Reply:</label>
        <div class="col-sm-9">
          <textarea style="max-width:100%; max-height:30%;"
                    class="form-control toggle_inputs_" cols="20" rows="4"
                    name="<%=Const.ParamsNames.REPLY_DESC%>" id="<%=Const.ParamsNames.REPLY_DESC%>"
                    value="${replyDesc}" data-toggle="tooltip" data-placement="top"
                    tabindex=2 disabled>${replyDesc}</textarea>
        </div>
      </div>
      <div class="form-group">
        <div class="col-sm-12 align-center">
          <input id="btnSaveReply" type="submit" class="btn btn-primary" value="Save Changes" tabindex="3"
            style="display:none;" value="Save Changes">
        </div>
      </div>
  </div>
</div>
