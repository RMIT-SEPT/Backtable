<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/student" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/student/discussionBoard" prefix="tsd" %>
<%@ taglib tagdir="/WEB-INF/tags/student/ReplyBoard" prefix="tsr" %>

<c:set var="jsIncludes">
  <script type="text/javascript" src="/js/studentReplyEdit.js"></script>
</c:set>

<ts:studentPage title="Edit Reply" jsIncludes="${jsIncludes}">
  <tsr:editReplyForm
      googleId="${data.account.googleId}"
      sessionToken="${data.sessionToken}"
      topicId="${data.topic.id}"
      replyId="${data.reply.id}"
      replyDesc="${data.reply.desc}"
      editReplyButton="${data.editReplyButton}"
      deleteReplyButton="${data.deleteReplyButton}"/>
</ts:studentPage>
