<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Student Message of the day" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<%@ attribute name="reply" type="teammates.ui.template.RepliesDiv" required="true" %>

<%-- TAG: used for displaying reply  --%>

<div class="panel panel-default">
  <div class="panel-body">
    <h5 style="display:inline-block;"><strong>${reply.name}</strong></h5>
    <p style="display:inline;"> replied on ${reply.dateTime}.</p>
    <br>
    <br>
    <p>
      ${reply.desc}
      <br>
      <br>
      <span class="label label-success">${reply.like}&nbsp;&nbsp;<span class="glyphicon glyphicon-thumbs-up"></span></span>
      <span class="label label-danger">${reply.dislike}&nbsp;&nbsp;<span class="glyphicon glyphicon-thumbs-down"></span></span>
      <br>
    </p>
    <c:forEach items="${reply.actions}" var="button">
      <a ${button.attributesToString}>${button.content}</a>
    </c:forEach>
  </div>
</div>
