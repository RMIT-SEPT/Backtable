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

 <c:forEach items="${data.topics}" var= "details">
    <tsd:topic topic="${details.topic}">
    </tsd:topic>
 </c:forEach>
 
  
 <div class="well well-plain">
  <div>
    <label class="label-control">Add Topic</label>
  </div>
  <br>
  <div>
    <label class="label-control">Topic ID:</label>
    <input class="form-control addInstructorFormControl" type="text" id="topicId" value="${topic.id}">
  </div>
  <br>
  <div>
    <label class="label-control">Topic Name: </label>
    <input class="form-control" type="text" id="topicName" value="${topic.name}">
  </div>
  <br>
  <div>
    <label class="label-control">Topic Description: </label>
    <input class="form-control addInstructorFormControl" type="text" id="topicDesc" value="${topic.desc}">
  </div>
  <br>

  <div>
    <button class="btn btn-primary addInstructorFormControl addInstructorBtn" id="btnAddInstructor">Add Topic</button>
  </div>
</div>

 
 

 
 


  <c:if test="${empty data.topics}">
    <div class="col-sm-12" style="color: red">
      There are currently no responses for you for this feedback session.
    </div>
  </c:if>
  
<%-- above code taken from studentHome... --%>
</ts:studentPage>
