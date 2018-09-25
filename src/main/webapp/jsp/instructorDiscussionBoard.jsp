<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor/discussionBoard" prefix="tid" %>
<%@ page import="teammates.common.util.Const" %>
<c:set var="jsIncludes"></c:set>

<ti:instructorPage title="Discussion Board" jsIncludes="${jsIncludes}">

<%-- Check whether if there is any topic in database, if yes, display all of them --%>

  <table class="table-responsive table table-striped table-bordered margin-0">
  <c:choose>
    <c:when test="${not empty data.activeTopics}">
      <tid:topic activeTopic="${data.activeTopics}"/>  <%-- it will take Active Topic Table
       value from the backend and pass to the tag "topic.tag" go to topic.tag to read more --%>
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

  <%-- Form for creating Topics --%>
  <%-- variables are unneccessary for now  --%>
    <tid:addTopicForm
        googleId="${data.account.googleId}"
        sessionToken="${data.sessionToken}"/>
  <t:bodyFooter />

</ti:instructorPage>
