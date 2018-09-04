<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Student Message of the day" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="reply" type="teammates.common.datatransfer.attributes.RepliesAttributes" required="true" %>
<div class="panel panel-default">
  <div class="panel-heading">  
    <c:out value="${reply.student}"  /> posted that:</br>        
      <div class="panel-body">
        <c:out value="${reply.desc}"   /></br>
        </div>
  </div>
</div>