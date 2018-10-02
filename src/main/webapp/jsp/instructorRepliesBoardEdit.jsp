<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/student" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor/discussionBoard" prefix="tid" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor/ReplyBoard" prefix="tir" %>

<ti:instructorPage title="Edit Reply">
  <tir:editReplyForm
      googleId="${data.account.googleId}"
      sessionToken="${data.sessionToken}"
      topicId="${data.topic.id}"
      replyId="${data.reply.id}"
      replyDesc="${data.reply.desc}"/>
</ti:instructorPage>
