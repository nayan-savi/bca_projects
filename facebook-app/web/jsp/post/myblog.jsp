<%@ page import="com.college.facebook.app.model.Login" %>
<%@ page import="com.college.facebook.app.model.PostDetails" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MyBolgs</title>
    <link rel="stylesheet" type="text/css" href="../../css/post.css"/>
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
<% for (int i = 0; i < postDetails.size(); i++) {%>
<div class="row">
    <div class="rightcolumn">
        <div class="card">
            <div style="text-align: right">
                <img src="../../images/edit-icon.png" style="width: 20px" onclick="editPost()">
                <img src="../../images/delete-icon.png" style="width: 20px" onclick="deletePost()">
            </div>
            <h3><%=postDetails.get(i).getUsername()%></h3>
            <h2><%=postDetails.get(i).getTitle()%></h2>
            <img class="fakeimg" src="../../images/nature.jpeg" />
            <p><%=postDetails.get(i).getMessage()%></p>
            <div>
                <label><b>Likes: </b><%=postDetails.get(i).getLike()%></label>
            </div>
        </div>
    </div>
</div>
<%}%>
</body>
</html>
