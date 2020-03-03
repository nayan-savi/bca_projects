<%@ page import="com.collage.app.pizza.model.Login" %>
<!DOCTYPE html>
<html>
<head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" type="text/css" href="../../css/header.css"/>
</head>
<body>
<% Login user = (Login)session.getAttribute("user"); %>

<div class="navbar">
    <a href="/home">Home</a>
    <%--<a href="#news">News</a>--%>
    <div class="dropdown">
        <button class="dropbtn">Notifications</button>
            <a href="/notification">Accept Request</a>
            <a href="/friends">My Friends</a>
        </div>
    </div>
    <div class="dropdown">
        <button class="dropbtn">Actions</button>
        <div class="dropdown-content">
            <a href="/send">Send Friend Request</a>
            <a href="/post">Post</a>
            <a href="/myblog">My Blogs</a>
        </div>
    </div>
    <a href="/logout">Logout</a>
</div>
<div style="padding-top: 10px;padding-right: 10px; text-align: right; font-weight: bold; color:green">
<label>Welcome <%=user.getUsername()%></label>
</div>
</body>
</html>
