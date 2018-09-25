<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Display Topics on Discussion Board Page" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="activeTopic" type="teammates.ui.template.ActiveTopicsTable" required="true" %>

<h2>Active Topics</h2>
<table class="table table-bordered table-striped" id="tableActiveCourses">
  <thead class="fill-primary">
  <tr>
    <th id="button_sortcourseid">
      Name
    </th>
    <th id="button_sortcoursename">
     Description
    </th>

    <th class="align-center no-print">
      Action(s)
    </th>
  </tr>
  </thead>

  <%-- Active topic table have table rows, loop all instances to display content --%>
  <c:forEach items="${activeTopic.rows}" var="topicrow" varStatus="i">
  <tr>
    <td id="topicName${i.index}" style="vertical-align: middle;">${topicrow.name}</td>
    <td id="topicDesc${i.index}" style="vertical-align: middle;">${topicrow.desc}</td>
    <td class="align-center no-print">
      <c:forEach items="${topicrow.actions}" var="button">
        <a ${button.attributesToString}>
            ${button.content}
        </a>
      </c:forEach>
    </td>
  </tr>
  </c:forEach>
