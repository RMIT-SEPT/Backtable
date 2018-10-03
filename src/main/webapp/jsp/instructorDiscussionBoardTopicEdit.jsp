<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor/discussionBoard" prefix="tid" %>

<c:set var="jsIncludes">
  <script type="text/javascript" src="/js/studentTopicEdit.js"></script>
</c:set>

<ti:instructorPage title="Edit Topic" jsIncludes="${jsIncludes}">
  <tid:editTopicForm
      googleId="${data.account.googleId}"
      sessionToken="${data.sessionToken}"
      topicId="${data.topic.id}"
      topicName="${data.topic.name}"
      topicDesc="${data.topic.desc}"
      editTopicButton="${data.editTopicButton}"
      deleteTopicButton="${data.deleteTopicButton}"/>
</ti:instructorPage>
