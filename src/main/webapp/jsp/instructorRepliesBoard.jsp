<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor/discussionBoard" prefix="tid" %>
<%@ page import="teammates.common.util.Const" %>
<c:set var="jsIncludes"></c:set>


<ti:instructorPage title="Replies Board" jsIncludes="${jsIncludes}" >
<tid:topicDetails name="${data.name}" desc="${data.desc}" />

<c:forEach items="${data.replies}" var= "reply">
    <tid:reply reply="${reply}">
    </tid:reply>
</c:forEach>



<c:if test="${empty data.replies}">
    <div class="col-sm-12" style="color: red">
      There are currently no responses for you for this feedback session.
    </div>
  </c:if>
  
  
  
  <t:bodyFooter />
</ti:instructorPage>
