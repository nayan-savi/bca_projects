<%@ page import="college.custom.model.Flower" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {
            document.orderFlower.action = "/orderFlower?anchor=orderFlower";
            document.orderFlower.submit();
        }

        function setCost() {
 selectElement= document.querySelector('#flowerName');
                 output =  

selectElement.options[selectElement.selectedIndex].value; 
document.getElementById('flowerCost').value = output;
        }

    </script>

</head>
<body>
<%@include file="../user/userHeader.jsp" %>
<div id="wrapper">
    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="/orderFlower?anchor=orderFlower" name="orderFlower" method="post">
            <h1>Request Flowers</h1>
            <% List<Flower> flowers = (List<Flower>) request.getAttribute("flowers"); %>
            <table>
                <tr>
                    <td>Flower Name</td>
                    <td width="172px">
                        <select name="flowerName" id="flowerName" 
                             style="width: 172px" onchange="setCost()">
                            <option></option>
                            <%for (int i = 0; i < flowers.size(); i++) {
                                String flower = flowers.get(i).getFlowerName();
                                String cost = flowers.get(i).getFlowerCost();
                            %>
                                <option value="<%=cost%>"><%=flower%></option>
                            <% } %>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Flower Cost</td>
                    <td><input type="text" name="flowerCost" id="flowerCost"/></td>
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
                    <td><input disabled type="text" name="finalRate"/></td>
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
