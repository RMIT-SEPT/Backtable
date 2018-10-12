<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor/discussionBoard" prefix="tid" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor/ReplyBoard" prefix="tir" %>
<%@ page import="teammates.common.util.Const" %>
<c:set var="jsIncludes"></c:set>
<%-- PAGE: replies board page for Instructor --%>

<ti:instructorPage title="Replies Board" jsIncludes="${jsIncludes}" >
<%-- inserts tag for topic details, passes variables as well  --%>
<tid:topicDetails name="${data.name}" desc="${data.desc}" view ="${data.viewcount}" />

<%-- for each reply that exists in this topic, pass data to reply tag in order to display --%>
<c:forEach items="${data.replies}" var= "reply">
    <tid:reply reply="${reply}">
    </tid:reply>
</c:forEach>
 
 <%-- if there are no replies it posts this message instead --%>
<c:if test="${empty data.replies}">
<div class="col-sm-12" style="color: red">
  There are currently no responses for you for this feedback session.
</div>
</c:if>
<%-- reply form inserted here with topic Id needed to save reply to correct topic --%>
<br><br>
    <tir:replyForm topicID="${data.topic.id}"/>
    
  <t:bodyFooter />
</ti:instructorPage>
