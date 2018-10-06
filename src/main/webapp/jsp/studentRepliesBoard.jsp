<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/student" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/student/discussionBoard" prefix="tsd" %>

<%@ taglib tagdir="/WEB-INF/tags/student/ReplyBoard" prefix="tsr" %>
<%@ page import="teammates.common.util.Const" %>
<%-- PAGE: Replies board for student --%>
<c:set var="jsIncludes">
  <script type="text/javascript" src="/js/studentReplyDelete.js"></script>
</c:set>
<%-- student page titled Replies Board --%>
<ts:studentPage title="Replies Board" jsIncludes="${jsIncludes}" >
<%-- posts details of topic such as descriptions --%>
<tsd:topicDetails name="${data.name}" desc="${data.desc}" view ="${data.viewcount}" />
<%-- for each reply it passes the data to reply tag in order to display to page --%>
<c:forEach items="${data.replies}" var= "reply">
    <tsd:reply reply="${reply}">
    </tsd:reply>
</c:forEach>
<%-- if replies is empty then it posts to page the message --%>
<c:if test="${empty data.replies}">
<div class="col-sm-12" style="color: red">
  There are currently no responses for you for this feedback session.

</div>
</c:if>
<%-- reply form is visible on page in order to add reply --%>
<br><br>
    <tsr:replyForm topicID="${data.topic.id}"/>



  <t:bodyFooter />
<%-- above code taken from studentHome... --%>
</ts:studentPage>
