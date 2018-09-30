<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/student" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/student/discussionBoard" prefix="tsd" %>

<%@ taglib tagdir="/WEB-INF/tags/student/ReplyBoard" prefix="tsr" %>
<%@ page import="teammates.common.util.Const" %>
<c:set var="jsIncludes">
</c:set>
<ts:studentPage title="Replies Board" jsIncludes="${jsIncludes}" >

<tsd:topicDetails name="${data.name}" desc="${data.desc}" view ="${data.viewcount}" />

<c:forEach items="${data.replies}" var= "reply">
    <tsd:reply reply="${reply}">
    </tsd:reply>
</c:forEach>
 
 
<c:if test="${empty data.replies}">
<div class="col-sm-12" style="color: red">
  There are currently no responses for you for this feedback session.
</div>
</c:if>

<br><br>
    <tsr:replyForm topicID="${data.topic.id}"/>
  
  
  
  <t:bodyFooter />
<%-- above code taken from studentHome... --%>
</ts:studentPage>
