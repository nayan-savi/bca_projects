<%@ page import="com.college.facebook.app.model.Login" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>


</head>
<%@include file="../user/userHeader.jsp" %>
<body>
<div align="center">
    <h3 style="color: green">${success}</h3>
    <h3 style="color: red">${errmsg}</h3>
</div>
<%
    Login login = (Login) session.getAttribute("user");
%>
<form action="/post" name="user" method="post">
    <table>
        <tr>
            <td>Username</td>
            <td><input readonly type="text" value="<%=login.getUsername()%>" name="username"> </td>
        </tr>
        <tr>
            <td>Title</td>
            <td><input type="text" name="title"> </td>
        </tr>
        <tr>
            <td>Message</td>
            <td><input type="text" name="message"> </td>
        </tr>

        <tr>
            <td>
                <fieldset>
                    <legend>Access level</legend>
                    <div>
                        <input type="radio" name="visibilityLevel" id="private" value="1" checked />
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
            <td><input type="submit" value="Post" /></td>
        </tr>
    </table>
</form>
</body>
</html>
