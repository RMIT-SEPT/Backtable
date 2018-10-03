<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor/ReplyBoard" prefix="tir" %>

<c:set var="jsIncludes">
  <script type="text/javascript" src="/js/studentReplyEdit.js"></script>
</c:set>

<ti:instructorPage title="Edit Reply" jsIncludes="${jsIncludes}">
  <tir:editReplyForm
      googleId="${data.account.googleId}"
      sessionToken="${data.sessionToken}"
      topicId="${data.topic.id}"
      replyId="${data.reply.id}"
      replyDesc="${data.reply.desc}"
      editReplyButton="${data.editReplyButton}"
      deleteReplyButton="${data.deleteReplyButton}"/>
</ti:instructorPage>
