<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.PizzaOrder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Pizza</title>
    <script type="text/javascript">
        function deletePizzaRequest() {
            var chk = document.pizzaOrder.orderId;
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
            document.pizzaOrder.action = "/deletePizzaRequest?anchor=deletePizzaRequest&id="+id;
            document.pizzaOrder.submit();
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
<%@include file="../user/userHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	List<PizzaOrder> pizzaOrders = (List<PizzaOrder>) request.getAttribute("orderedPizza");
        %>
        <form action="" name="pizzaOrder" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Order Id</td>
                        <td>Pizza Name</td>
                        <td>Pizza Cost</td>
                        <td>Request Date</td>
                        <td>Bargaining</td>
                        <td>Delivered Date</td>
                        <td>Status</td>
                        <td>Final Rate</td>
                        <td>Comment</td>
                    </tr>
                    <%for (int i = 0; i < pizzaOrders.size(); i++) {
                        String status = pizzaOrders.get(i).getStatus();
                    %>
                    <tr class="viewData">
                        <td>
                            <% if(!status.equalsIgnoreCase("Done")) {%>
                                <input type="checkbox" name="orderId" value="<%=pizzaOrders.get(i).getOrderId() %>"/>
                            <%}%>
                            <%=pizzaOrders.get(i).getOrderId()%>
                        </td>
                        <td><%=pizzaOrders.get(i).getPizzaName()%></td>
                        <td><%=pizzaOrders.get(i).getPizzaCost()%></td>
                        <td><%=pizzaOrders.get(i).getRequestDate() %></td>
                        <td><%=pizzaOrders.get(i).getBargaining() %></td>
                        <td><%=pizzaOrders.get(i).getDeliveredDate() %></td>
                        <% if(status.equalsIgnoreCase("Pending")) {%>
                        <td style="color:yellowgreen"><label name="status"><%= status%></label></td>
                        <%} else if(status.equalsIgnoreCase("Inprogress")) {%>
                        <td style="color:blue"><label name="status"><%= status%></label></td>
                        <%} else if(status.equalsIgnoreCase("Done")) {%>
                        <td style="color:green"><label name="status"><%= status%></label></td>
                        <%} else if(status.equalsIgnoreCase("Rejected")) {%>
                        <td style="color:red"><label name="status"><%= status%></label></td>
                        <%}%>
                        <td><%=pizzaOrders.get(i).getFinalRate()%></td>
                        <td><%=pizzaOrders.get(i).getComment()%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="button" value="Delete" onclick="deletePizzaRequest()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>