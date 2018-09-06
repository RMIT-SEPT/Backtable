<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Display Topics on Discussion Board Page" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="activeTopic" type="teammates.ui.template.ActiveTopicsTable" required="true" %>
<%@ tag import="teammates.common.util.Const" %>
<%-- <%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ attribute name="googleId" required="true" %>
<%@ attribute name="topicIdToShow" required="true" %>
<%@ attribute name="topicNameToShow" required="true" %>
<%@ attribute name="sessionToken" required="true" %> --%>


<h2>Active Topic</h2>
<table class="table table-bordered table-striped" id="tableActiveCourses">
  <thead class="fill-primary">
  <tr>
    <th id="button_sortcourseid" class="button-sort-none toggle-sort">
      Name<span class="icon-sort unsorted"></span>
    </th>
    <th id="button_sortcoursename" class="button-sort-none toggle-sort">
     Desc<span class="icon-sort unsorted"></span>
    </th>

    <th class="align-center no-print">
      Action(s)
    </th>
  </tr>
  </thead>
  <c:forEach items="${activeTopic.rows}" var="topicrow" varStatus="i">
  <tr>
    <td id="topicName${i.index}">${topicrow.name}</td>
    <td id="coursename${i.index}">${topic.desc}</td>
    <td class="align-center no-print">
      <c:forEach items="${topicrow.actions}" var="button">
        <a ${button.attributesToString}>
            ${button.content}
        </a>
      </c:forEach>
    </td>
  </tr>
  </c:forEach>
