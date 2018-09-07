<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/student" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/student/discussionBoard" prefix="tsd" %>
<%@ page import="teammates.common.util.Const" %>
<c:set var="jsIncludes">
<script type="text/javascript" src="/js/discussionBoard.js"></script>
</c:set>
<ts:studentPage title="Discussion Board" jsIncludes="${jsIncludes}">

 <%-- <c:forEach items="${data.topics}" var= "details">
    <tsd:topic topic="${details.topic}">
    </tsd:topic>
 </c:forEach> --%>

 <!-- discussion board table -->

<c:choose>
   <c:when test="${data.getTopicRows==0}">
     <H1> There are no topics. </h1>
   </c:when>
</c:choose>

 <table class="table-responsive table table-striped table-bordered margin-0">
  <c:choose>
    <c:when test="${not empty data.activeTopics}">
      <tsd:topic activeTopic="${data.activeTopics}"/>
    </c:when>
    <c:otherwise>
      <tr>
        <td class="align-center bold">
          Currently, there are no topics in this discussion board.
        </td>
      </tr>
    </c:otherwise>
  </c:choose>
</table>


<br/>



  <c:if test="${!data.usingAjax}">
    <tsd:addTopicForm topicNameToShow="${data.topicNameToShow}"
                      topicDescToShow="${data.topicDescToShow}"
                      googleId="${data.account.googleId}"
                      sessionToken="${data.sessionToken}"/>
    <course:loadCoursesTableByAjaxForm />
  </c:if>



  <%-- <div id="coursesList" class="align-center">
    <c:if test="${data.usingAjax}">
      <course:activeCoursesTable activeTopics="${data.activeTopics}"/>
      <br>
      <br>
      <c:if test="${empty data.activeTopics.rows}">
        No records found. <br>
        <br>
      </c:if>
      <br>
      <br>

      <c:if test="${not empty data.archivedCourses.rows}">
        <course:archivedCoursesTable archivedCourses="${data.archivedCourses}"
            activeCourses="${data.activeCourses}"/>
        <br>
        <br>
        <br>
        <br>
      </c:if>
    </c:if>
  </div> --%>








  <t:bodyFooter />
<%-- above code taken from studentHome... --%>
</ts:studentPage>
