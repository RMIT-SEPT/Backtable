<%@ tag trimDirectiveWhitespaces="true" %>
<%@ tag description="Add New Topic Panel of Discussion Board Page" pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- <%@ attribute name="topic" type="teammates.common.datatransfer.attributes.TopicAttributes" required="true" %>
 --%>
 
<%@ tag import="teammates.common.util.Const" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ attribute name="name" required="true" %> 
<%@ attribute name="desc" required="true" %>

<%@ attribute name="view" required="true" %>


<div class="well well-plain">
    <label class="bold-label"  style="color:#3679B2; font-size:large;">${name}</label>
  <br>
    <label class="label-control">
    <br>
    ${desc}
    </label>
  <br>
  <label class="label-control">
    <br>
    Total views: ${view}
  </label>
  <br>
</div>
