<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {

            document.addFlower.action = "/flower?anchor=addFlower";
            document.addFlower.submit();
        }

    </script>

</head>
<body>
<%@include file="../user/userHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="/orderFlower?anchor=orderFlower" method="post">
            <h1>Request Flowers</h1>
            <table>
                <tr>
                    <td>Flower Name</td>
                    <td><input type="text" name="flowername"/></td>
                </tr>
                <tr>
                    <td>Flower Cost</td>
                    <td><input type="text" name="flowerCost"/></td>
                </tr>
                <tr>
                    <td>Requested Date</td>
                    <td><input type="text" name="requestDate"/></td>
                </tr>
                <tr>
                    <td>Bargaining</td>
                    <td><input type="text" name="bargaining"/></td>
                </tr>
                <tr>
                    <td>Final Rate</td>
                    <td><input type="text" name="finalRate"/></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <select name="status">
                            <option value="-1">--select--</option>
                            <option value="inprogress">Inprogress</option>
                            <option value="done">Done</option>
                            <option value="rejected">Rejected</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Comment</td>
                    <td><input type="text" name="comment"/></td>
                </tr>
                <tr>
                    <td colspan="3" align="center"><input type="button" value="Order" onclick="addValue()"></td>
                </tr>
            </table>
        </form>

    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>