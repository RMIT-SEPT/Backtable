<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/student/discussionBoard" prefix="tsd" %>
<ts:instructorPage title="Edit Topic">
  <tsd:editTopicForm
      googleId="${data.account.googleId}"
      sessionToken="${data.sessionToken}"
      topicId="${data.topic.id}"
      topicName="${data.topic.name}"
      topicDesc="${data.topic.desc}"/>
</ts:instructorPage>
