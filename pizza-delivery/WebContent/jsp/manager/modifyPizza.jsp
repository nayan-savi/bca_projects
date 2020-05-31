<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.Pizza" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Flower</title>
    <script type="text/javascript">
        function cancelFlower() {
            document.pizza.action="cancelPizza?anchor=cancelPizza";
            document.pizza.submit();
        }
    </script>
</head>
<style>
    .viewHeader>td {
        padding: 10px 20px;
    }

    .viewData>td{
        padding-top: 10px;
        padding-bottom: 10px;
    }
</style>
<body>
<%@include file="managerHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	Pizza pizza = (Pizza) request.getAttribute("pizza");
        %>
        <form action="updatePizza?anchor=updatePizza" name="pizza" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">

                    <tr>
                        <td>
                            <input type="hidden" name="pizzaId" value="<%=pizza.getPizzaId() %>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Flower Name</td>
                        <td><input readonly="true" type="text" name="pizzaName" value="<%=pizza.getPizzaName() %>"/></td>
                    </tr>
                    <tr>
                        <td>Flower Cost</td>
                        <td><input type="text" name="pizzaCost" value="<%=pizza.getPizzaCost() %>"/></td>
                    </tr>

                    <tr>
                        <td>Status</td>
                        <td>
                            <select name="status">
                                <option value="<%=pizza.getStatus()%>" hidden selected><%=pizza.getStatus()%></option>
                                <option value=""></option>
                                <option value="YES">YES</option>
                                <option value="NO">NO</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Comment</td>
                        <td><input type="text" name="comment" value="<%=pizza.getComment() %>"/></td>
                    </tr>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="submit" value="Update"></td>
                    <td><input type="button" value="Cancel" onclick="cancelFlower()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>