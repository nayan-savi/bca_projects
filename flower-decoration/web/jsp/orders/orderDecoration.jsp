<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.Decoration" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {
            document.orderDecoration.action = "/orderDecoration?anchor=orderDecoration";
            document.orderDecoration.submit();
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
        <form action="/orderDecoration?anchor=orderDecoration" name="orderDecoration" method="post">
            <h1>Request Flowers</h1>
            <% List<Decoration> decorations = (List<Decoration>) request.getAttribute("decorations"); %>
            <table>
                <%--<tr>
                    <td>Flower Name</td>
                    <td><input type="text" name="flowername"/></td>
                </tr>--%>
                <tr>
                    <td>Decoration Name</td>
                    <td width="172px">
                        <select name="decorationName" style="width: 172px" onclick="setCost()">
                            <option></option>
                            <%for (int i = 0; i < decorations.size(); i++) {
                                String decorationName = decorations.get(i).getDecorationName();
                            %>
                            <option value="<%=decorationName%>"><%=decorationName%></option>
                            <% } %>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Decoration Cost</td>
                    <td><input type="text" name="decorationCost" /></td>
                </tr>
                <tr>
                    <td>Requested Date</td>
                    <td><input type="text" name="requestDate"/>(Ex:yyyy-mm-dd)</td>
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