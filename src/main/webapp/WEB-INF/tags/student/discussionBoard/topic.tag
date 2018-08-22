<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Student Message of the day" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ attribute name="topic" type="teammates.common.datatransfer.attributes.TopicAttributes" required="true" %>
<div class="panel panel-default">
  <div class="panel-heading">
    ID =           <c:out value="${topic.id}"        />       </br>
    Description =  <c:out value="${topic.desc}"   />       </br>
    Student Name = <c:out value="${topic.name}"  />       </br>
  </div>
</div>