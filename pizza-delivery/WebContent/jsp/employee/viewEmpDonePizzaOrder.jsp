<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.PizzaOrder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Pizza</title>

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
<%@include file="employeeHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%
        	List<PizzaOrder> pizzaOrders = (List<PizzaOrder>) request.getAttribute("orderedPizza");
        %>
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
                        <td><%=pizzaOrders.get(i).getOrderId()%></td>
                        <td><%=pizzaOrders.get(i).getPizzaName()%></td>
                        <td><%=pizzaOrders.get(i).getPizzaCost()%></td>
                        <td><%=pizzaOrders.get(i).getRequestDate() %></td>
                        <td><%=pizzaOrders.get(i).getBargaining() %></td>
                        <td><%=pizzaOrders.get(i).getDeliveredDate() %></td>
                        <% if(status.equalsIgnoreCase("Pending")) {%>
                        <td style="color:yellowgreen"><%= status%></td>
                        <%} else if(status.equalsIgnoreCase("Inprogress")) {%>
                        <td style="color:blue"><%= status%></td>
                        <%} else if(status.equalsIgnoreCase("Done")) {%>
                        <td style="color:green"><%= status%></td>
                        <%} else if(status.equalsIgnoreCase("Rejected")) {%>
                        <td style="color:red"><%= status%></td>
                        <%}%>
                        <td><%=pizzaOrders.get(i).getFinalRate()%></td>
                        <td><%=pizzaOrders.get(i).getComment()%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>