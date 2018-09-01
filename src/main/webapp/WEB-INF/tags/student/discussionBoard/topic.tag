<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Display Topics on Discussion Board Page" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ attribute name="topic" type="teammates.common.datatransfer.attributes.TopicAttributes" required="true" %>
<%@ tag import="teammates.common.util.Const" %>
<%-- <%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ attribute name="googleId" required="true" %>
<%@ attribute name="topicIdToShow" required="true" %>
<%@ attribute name="topicNameToShow" required="true" %>
<%@ attribute name="sessionToken" required="true" %> --%>
 

<div class="panel panel-default">
  <div class="panel-heading">
    Name = <c:out value="${topic.name}"  />       </br>
    Description =  <c:out value="${topic.desc}"   />       </br>
    <%-- Created At = <c:out value="${topic.createdAt}"  />       </br>
    Time Zone = <c:out value="${topic.timeZone}"  />       </br> --%>
  </div>
</div> 
