<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ page import="com.college.facebook.app.model.PostDetails" %>
<%@ page import="java.util.List" %>
<html>
<head>
    <title>MyBolgs</title>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" type="text/css" href="./css/post.css"/>
    <script>
        function deletePost(postId) {
            document.posts.action = "deletePost?postId="+postId;
            document.posts.submit();
        }

        function editPost(postId) {
            document.posts.action = "editPost?postId="+postId;
            document.posts.submit();
        }
    </script>
</head>
<%@include file="../user/userHeader.jsp" %>
<body>
<div align="center">
    <h3 style="color: green">${success}</h3>
    <h3 style="color: red">${errmsg}</h3>
</div>
<%
    List<PostDetails> postDetails = (List<PostDetails>) request.getAttribute("posts");
%>
<form action="" name="posts" method="post">
<% for (int i = 0; i < postDetails.size(); i++) {%>

<div class="row">
    <div class="rightcolumn">
        <div class="card">
            <div style="text-align: right">
                <img src="./images/edit-icon.png" style="width: 20px"  onclick="editPost('<%=postDetails.get(i).getPostId()%>')" />
                <img src="./images/delete-icon.png" style="width: 20px" onclick="deletePost('<%=postDetails.get(i).getPostId()%>')" />
            </div>
            <h3><%=postDetails.get(i).getUsername()%></h3>
            <h2><%=postDetails.get(i).getTitle()%></h2>
            <p><%=postDetails.get(i).getMessage()%></p>
            <div style="display: inline-flex">
                <label><b>Likes: </b><%=postDetails.get(i).getLike()%></label>
                <div style="padding-left: 30px">
                    <% if(postDetails.get(i).getVisibilityLevel() == 1) { %>
                    <label><b>Access: </b>Private</label>
                    <%} else if(postDetails.get(i).getVisibilityLevel() == 2) { %>
                    <label><b>Access: </b>Friends</label>
                    <%} else { %>
                    <label><b>Access: </b>Public</label>
                    <%}%>
                </div>
            </div>
        </div>
    </div>
</div>
<%}%>
</form>
</body>
</html>
