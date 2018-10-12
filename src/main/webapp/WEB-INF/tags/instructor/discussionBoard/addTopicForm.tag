<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Add New Topic Panel of Discussion Board Edit Topic Page" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@ tag import="teammates.common.util.Const" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ attribute name="googleId" required="true" %>
<%@ attribute name="sessionToken" required="true" %>

<div class="panel panel-primary">
  <div class="panel-body fill-plain">
    <form method="get" action="<%=Const.ActionURIs.INSTRUCTOR_DISCUSSION_BOARD_ADD_TOPIC_PAGE%>" name="discussion_topic_add" class="form form-horizontal">
      <input type="hidden" id="<%=Const.ParamsNames.STUDENT_ID%>" name="<%=Const.ParamsNames.STUDENT_ID%>" value="${googleId}">
      <input type="hidden" name="<%=Const.ParamsNames.SESSION_TOKEN%>" value="${sessionToken}">
      <input type="hidden" name="<%=Const.ParamsNames.USER_ID%>" value="${googleId}">

      <div class="form-group">
        <label class="col-sm-3 control-label">Topic Name:</label>
        <div class="col-sm-3">
          <input class="form-control" type="text"
                 name="<%=Const.ParamsNames.TOPIC_NAME%>" id="<%=Const.ParamsNames.TOPIC_NAME%>"
                 value="${topicNameToShow}" data-toggle="tooltip" data-placement="top"
                 title="Enter the identifier of the topic, e.g.1234-2018Semester1."
                 tabindex="1" placeholder="e.g. 1234-2018Semester1"/>
        </div>
      </div>

      <div class="form-group">
        <label class="col-sm-3 control-label">Topic Description:</label>
        <div class="col-sm-9">
          <textarea style="max-width:100%; max-height:30%;"
                    class="form-control" cols="20" rows="4"
                    name="<%=Const.ParamsNames.TOPIC_DESC%>" id="<%=Const.ParamsNames.TOPIC_DESC%>"
                    value="${topicDescToShow}" data-toggle="tooltip" data-placement="top"
                    title="Enter the name of the topic, e.g. Assignment 1 Advice."
                    tabindex=2 placeholder="e.g. Assignment 1 Advice"></textarea>
        </div>
      </div>

      <div class="form-group">
        <div class="col-sm-offset-3 col-sm-9">
          <input id="btnAddCourse" type="submit" class="btn btn-primary" value="Add Topic" tabindex="3">
        </div>
      </div>
    </form>
  </div>
</div>
