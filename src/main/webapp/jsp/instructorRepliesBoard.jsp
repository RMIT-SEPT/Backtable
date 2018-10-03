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


<ti:instructorPage title="Replies Board" jsIncludes="${jsIncludes}" >
<tid:topicDetails name="${data.name}" desc="${data.desc}" view ="${data.viewcount}" />

<c:forEach items="${data.replies}" var= "reply">
    <tid:reply reply="${reply}">
    </tid:reply>
</c:forEach>
 
 
<c:if test="${empty data.replies}">
<div class="col-sm-12" style="color: red">
  There are currently no responses for you for this feedback session.
</div>
</c:if>

<br><br>
    <tir:replyForm topicID="${data.topic.id}"/>
  
  
  
  <t:bodyFooter />
<%-- above code taken from studentHome... --%>
</ti:instructorPage>
