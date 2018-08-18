<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/student" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/student/discussionBoard" prefix="discussionBoard" %>
<%@ page import="teammates.common.util.Const" %>
<c:set var="jsIncludes">
</c:set>
<ts:studentPage title="Discussion Board" jsIncludes="${jsIncludes}">

 <%--<c:if test="${empty data.account.googleId}">
    <div id="registerMessage" class="alert alert-info">
      ${data.registerMessage}
    </div>
  </c:if>
  --%>
  
<%-- following code is taken from studentHome.jsp, 
attempting to rework into a table fit for discussion board --%>

<%-- <t:statusMessage statusMessagesToUser="${data.statusMessagesToUser}" />
  <br>
  <c:forEach items="${data.courseTables}" var="courseTable">
    <home:coursePanel courseTable="${courseTable}">
      <home:courseTable sessionRows="${courseTable.rows}" />
    </home:coursePanel>
    <br><br>
  </c:forEach>
--%>  
 
 <c:forEach items="${data.topics}" var= "details">
     <div class="panel panel-default">
       <div class="panel-heading">
         ID =           <c:out value="${details.topic.id}"        />       </br>
         Description =  <c:out value="${details.topic.desc}"   />       </br>
         Student Name = <c:out value="${details.topic.name}"  />       </br>
      </div>
    </div>
 </c:forEach>


  <c:if test="${empty data.topics}">
    <div class="col-sm-12" style="color: red">
      There are currently no responses for you for this feedback session.
    </div>
  </c:if>
  
<%-- above code taken from studentHome... --%>
</ts:studentPage>
