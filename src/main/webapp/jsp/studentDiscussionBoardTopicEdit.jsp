<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/student" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/student/discussionBoard" prefix="tsd" %>
<%-- PAGE: student discussion board able to edit topic --%>
<c:set var="jsIncludes">
  <script type="text/javascript" src="/js/studentTopicEdit.js"></script>
</c:set>

<%-- passes required variables to the edit topic form --%>
<ts:studentPage title="Edit Topic" jsIncludes="${jsIncludes}">
  <tsd:editTopicForm
      googleId="${data.account.googleId}"
      sessionToken="${data.sessionToken}"
      topicId="${data.topic.id}"
      topicName="${data.topic.name}"
      topicDesc="${data.topic.desc}"
      editTopicButton="${data.editTopicButton}"
      deleteTopicButton="${data.deleteTopicButton}"/>
</ts:studentPage>
