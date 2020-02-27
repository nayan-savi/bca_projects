<%@ page import="com.college.facebook.app.model.Registration" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>

    <script type="text/javascript">
        function confirmRequest() {
            var chk = document.user.friendId;
            var count = 0;
            if (chk.length == undefined) {
                if (chk.checked == true) {
                    count++;
                }
            }
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].checked == true) {
                    count++;
                }
            }
            if (count == 0) {
                alert("Please select at least one user");
                return false;
            }

            if (count > 1) {
                alert("Please select only one user at a time");
                return false;
            }

            document.user.action = "/notification?anchor=confirm";
            document.user.submit();
        }

        function deleteRequest() {
            var chk = document.user.friendId;
            var count = 0;
            if (chk.length == undefined) {
                if (chk.checked == true) {
                    count++;
                }
            }
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].checked == true) {
                    count++;
                }
            }
            if (count == 0) {
                alert("Please select at least one user");
                return false;
            }

            if (count > 1) {
                alert("Please select only one user at a time");
                return false;
            }

            document.user.action = "/delete?anchor=delete";
            document.user.submit();
        }
    </script>
</head>
<%@include file="../user/userHeader.jsp" %>
<body>
<div align="center">
    <h3 style="color: green">${success}</h3>
    <h3 style="color: red">${errmsg}</h3>
</div>
<form action="" name="user" method="post">
    <table>
        <tr>
            <td></td>
            <td>Username</td>
            <td>EmailId</td>
            <td>ContactNo</td>
        </tr>
        <% List<Registration> friendRequests = (List<Registration>) request.getAttribute("friendRequests"); %>
        <% for (int i = 0; i < friendRequests.size(); i++) {%>
        <tr>
            <td>
                <input type="checkbox" name="friendId" value="<%=friendRequests.get(i).getUserId()%>" />
            </td>

            <td><%=friendRequests.get(i).getUsername()%></td>
            <td><%=friendRequests.get(i).getEmailId()%></td>
            <td><%=friendRequests.get(i).getContactNo()%></td>
        </tr>
        <%}%>
        <tr>
            <td><input type="button" value="Confirm" onclick="confirmRequest()" /></td>
            <td><input type="button" value="Delete" onclick="deleteRequest()" /></td>
        </tr>
    </table>
</form>
</body>
</html>
