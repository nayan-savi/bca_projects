<%@ page import="com.college.facebook.app.model.PostDetails" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    PostDetails postDetails = (PostDetails) request.getAttribute("postDetails");
    int level = (int) request.getAttribute("level");
%>
<html>
<head>
    <title>Title</title>
    <script>
        function postBlog() {
            document.user.action = "post";
            document.user.submit();
        }
        function load() {
            var level = ${level};
            if(level == 1) {
                document.getElementById("private").checked = true;
            } else if (level == 2) {
                document.getElementById("onlyFriends").checked = true;
            } else {
                document.getElementById("public").checked = true;
            }
        }
    </script>

</head>
<%@include file="../user/userHeader.jsp" %>
<body onload="load()">
<div align="center">
    <h3 style="color: green">${success}</h3>
    <h3 style="color: red">${errmsg}</h3>
</div>

<form action="" name="user" method="post" >
    <table>
        <tr>
            <td>Username</td>
            <td>
                <input readonly type="text" value="<%=postDetails.getUsername()%>" name="username">
                <input type="hidden" value="<%=postDetails.getPostId()%>" name="postId">
            </td>
        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title" value="<%=postDetails.getTitle()%>"> </td>
        </tr>
        <tr>
            <td>Message</td>
            <td><input type="text" name="message" value="<%=postDetails.getMessage()%>"> </td>
        </tr>

        <tr>
            <td>
                <fieldset>
                    <legend>Access level</legend>
                    <div>
                        <input type="radio" name="visibilityLevel" id="private" value="1" />
                        <label for="private">Only to me</label>
                    </div>
                    <div>
                        <input type="radio" name="visibilityLevel" id="onlyFriends" value="2" />
                        <label for="onlyFriends">Only to friends</label>
                    </div>
                    <div>
                        <input type="radio" name="visibilityLevel" id="public" value="3" />
                        <label for="public">Public</label>
                    </div>
                </fieldset>
            </td>
        </tr>
        <tr>
            <td><input type="button" value="Post" onclick="postBlog()"/></td>
        </tr>
    </table>
</form>
</body>
</html>
