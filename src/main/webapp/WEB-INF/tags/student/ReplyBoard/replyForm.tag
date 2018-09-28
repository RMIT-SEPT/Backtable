<%@ tag description="Add New Reply Panel of ReplyBoard Page" pageEncoding="UTF-8" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ tag import="teammates.common.util.Const" %>
<%@ attribute name="topicID" required="true" %>


<div class="panel panel-primary">
    <div class="panel-body fill-plain">
        <form method="get" action="<%=Const.ActionURIs.STUDENT_REPLIES_BOARD_ADD_REPLY_PAGE%>" name="form_addreply" class="form form-horizontal">
        
            <input type="hidden" id="<%=Const.ParamsNames.TOPIC_ID%>" name="<%=Const.ParamsNames.TOPIC_ID%>" value="${topicID}">
             <div class="col-sm-9">
                <b>
                <label>
                   Reply:
                </label>
                </b>
                <br>
                   <textarea style="max-width:100%; max-height:30%;"
                             class="form-control" cols="20" rows="10"
                             name="<%=Const.ParamsNames.REPLY_DESC%>" id="<%=Const.ParamsNames.REPLY_DESC%>"
                             placeholder="Write something for this reply"></textarea>
                

            <br>
            <div class="form-group">
                    <input id="btnAddReply" type="submit" class="btn btn-primary" value="Add Reply" tabindex="2">
            </div>
            </div>
            
        </form>
    </div>
</div>
