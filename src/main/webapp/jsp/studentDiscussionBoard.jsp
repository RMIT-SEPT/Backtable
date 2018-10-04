<%@ page trimDirectiveWhitespaces="true" %>
<%@ page pageEncoding="UTF-8" %>
<%@ page import="teammates.common.util.Const" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib tagdir="/WEB-INF/tags" prefix="t" %>
<%@ taglib tagdir="/WEB-INF/tags/student" prefix="ts" %>
<%@ taglib tagdir="/WEB-INF/tags/student/discussionBoard" prefix="tsd" %>

<c:set var="jsIncludes">
  <script type="text/javascript" src="/js/studentTopicDelete.js"></script>
</c:set>

<ts:studentPage title="Add New Topic" jsIncludes="${jsIncludes}">
  <tsd:addTopicForm googleId="${data.account.googleId}" sessionToken="${data.sessionToken}"/>

  <br/>
  <br/>

  <table class="table-responsive table table-striped table-bordered margin-0">
    <c:choose>
      <c:when test="${not empty data.activeTopics}">
        <tsd:topic activeTopic="${data.activeTopics}"/>  <%-- it will take Active Topic Table
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
</ts:studentPage>
