<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.Pizza" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Pizza</title>
    <script type="text/javascript">
        function modifyPizza() {
            var chk = document.pizza.flowerId;
            var count = 0;
            var id = 0;
            if (chk.length == undefined) {
                if (chk.checked == true) {
                    count++;
                }
            }
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].checked == true) {
                    id = chk[i].value;
                    count++;
                }
            }

            if (count == 0) {
                alert("Please selected at least one checkbox");
                return false;
            }
            if (count > 1) {
                alert("Please select only one checkbox");
                return false;
            }

            document.pizza.action = "/modifyPizza?anchor=modifyPizza&id="+id;
            document.pizza.submit();
        }

        function deletePizza() {
            var chk = document.pizza.flowerId;
            var count = 0;
            var id = 0;
            if (chk.length == undefined) {
                if (chk.checked == true) {
                    count++;
                }
            }
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].checked == true) {
                    id = chk[i].value;
                    count++;
                }
            }

            if (count == 0) {
                alert("Please selected at least one checkbox");
                return false;
            }
            if (count > 1) {
                alert("Please select only one checkbox");
                return false;
            }

            document.pizza.action = "/deletePizza?anchor=deletePizza";
            document.pizza.submit();
        }
    </script>
</head>
<style>
    .viewHeader {
        font-weight: bold;
        background-color: lightgrey;
    }

    .viewHeader>td {
        padding: 10px 20px;
    }

    .viewData {
        text-align: center;
        font-size: 14px;
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
        	List<Pizza> pizza = (List<Pizza>) request.getAttribute("pizza");
        %>
        <form action="" name="pizza" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Pizza Id</td>
                        <td>Pizza Name</td>
                        <td>Pizza Cost</td>
                        <td>Status</td>
                        <td>Comment</td>
                    </tr>
                    <%for (int i = 0; i < pizza.size(); i++) {
                        String status = pizza.get(i).getStatus();
                    %>
                    <tr class="viewData">
                        <td>
                            <input type="checkbox" name="pizzaId" value="<%=pizza.get(i).getPizzaId() %>"/>
                            <%=pizza.get(i).getPizzaId()%>
                        </td>
                        <td><%=pizza.get(i).getPizzaName()%></td>
                        <td><%=pizza.get(i).getPizzaCost()%></td>

                        <td>
                            <%=status%>
                        </td>
                        <td><%=pizza.get(i).getComment()%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="button" value="Modify" onclick="modifyPizza()"></td>
                    <td><input type="button" value="Delete" onclick="deletePizza()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>