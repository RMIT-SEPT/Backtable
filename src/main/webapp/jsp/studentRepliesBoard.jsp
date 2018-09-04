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
<ts:studentPage title="Replies Board" jsIncludes="${jsIncludes}">


<c:forEach items="${data.replies}" var= "reply">
    <tsd:reply reply="${reply}">
    </tsd:reply>
</c:forEach>
 
 
 
 <%-- 
 <!-- discussion board table -->
 
 <table class="table-responsive table table-striped table-bordered margin-0">
  <c:choose>
    <c:when test="${not empty data.topics}">
      <thead>
        <tr>
          <th>Topic ID</th>
          <th>Topic Name</th>
          <th>Topic Description</th>
          <th class="button_sortenddate button-sort-none toggle-sort"
              data-toggle-sort-comparator="sortDate"
              data-toggle-sort-extractor="dateStampExtractor">Date<span class="icon-sort unsorted"></span></th>
        </tr>
      </thead>
      <c:forEach items="${data.topics}" var="details">
        <tr class="home_evaluations_row" id="evaluation">
          <td>${details.topic.id}</td>
          <td>${details.topic.name}</td>
          <td>${details.topic.desc}</td> 
          <td data-date-stamp="${sessionRow.endTimeIso8601Utc}">${sessionRow.endTime}</td>
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
 
 
 
<!-- form to create new topic -->
 
 <div class="well well-plain">
  <div>
    <label class="label-control">Add New Topic</label>
  </div>
  <br>
  <div>
    <label class="label-control">Topic ID:</label>
    <input class="form-control" type="text" name="topicId" id="topicId" value="${topic.id}">
  </div>
  <br>
  <div>
    <label class="label-control">Topic Name: </label>
    <input class="form-control" type="text" name="topicName" id="topicName" value="${topic.name}">
  </div>
  <br>
  <div>
    <label class="label-control">Topic Description: </label>
    <input class="form-control" type="text" name="topicDesc" id="topicDesc" value="${topic.desc}">
  </div>
  <br>

  <div>
  <input type = "submit" value = "Submit"/>
    <!-- <button class="btn btn-primary addInstructorFormControl addInstructorBtn" id="btnAddInstructor">Add Topic</button> -->
  </div>
</div>

 
 --%>

 
 


  <c:if test="${empty data.replies}">
    <div class="col-sm-12" style="color: red">
      There are currently no responses for you for this feedback session.
    </div>
  </c:if>
  
  
  
  <t:bodyFooter />
<%-- above code taken from studentHome... --%>
</ts:studentPage>
