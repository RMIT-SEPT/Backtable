<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor" prefix="ti" %>
<%@ taglib tagdir="/WEB-INF/tags/instructor/discussionBoard" prefix="tid" %>
<%@ page import="teammates.common.util.Const" %>
<%--PAGE: instructor discussion board page --%>
<c:set var="jsIncludes">
  <script type="text/javascript" src="/js/studentTopicDelete.js"></script>
</c:set>
<%-- is an instructors page, titled discussion board --%>
<ti:instructorPage title="Discussion Board" jsIncludes="${jsIncludes}">
<%-- inserts tag for add topic form --%>
  <tid:addTopicForm googleId="${data.account.googleId}" sessionToken="${data.sessionToken}"/>
  <br/>
  <br/>
  <%-- table for active topics in order to loop through each and display to page --%>
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
</ti:instructorPage>
