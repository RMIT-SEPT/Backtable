<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/student" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/student/discussionBoard" prefix="tsd" %>
<%@ page import="teammates.common.util.Const" %>
<c:set var="jsIncludes">
</c:set>
<ts:studentPage title="Discussion Board" jsIncludes="${jsIncludes}">

 <%-- <c:forEach items="${data.topics}" var= "details">
    <tsd:topic topic="${details.topic}">
    </tsd:topic>
 </c:forEach> --%>
 
 <!-- discussion board table -->
 
 <table class="table-responsive table table-striped table-bordered margin-0">
  <c:choose>
    <c:when test="${not empty data.topics}">
      <thead>
        <tr>
          <th>Topic Name</th>
          <th>Topic Description</th>
          <th>Created At</th>
        </tr>
      </thead>
      <c:forEach items="${data.topics}" var="details">
        <tr class="home_evaluations_row" id="evaluation">
          <td>${details.topic.name}</td>
          <td>${details.topic.desc}</td> 
          
          
        </tr>
      </c:forEach>
    </c:when>
    <c:otherwise>
      <tr>
        <th class="align-center bold color_white">
          Currently, there are no topics in this discussion board.
        </th>
      </tr>
    </c:otherwise>
  </c:choose>
</table>


<br/>
 
 
 

 
 
 


  <c:if test="${empty data.topics}">
    <div class="col-sm-12" style="color: red">
      There are currently no responses for you for this feedback session.
    </div>
  </c:if>
  
  
  
  
  
  
   
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
