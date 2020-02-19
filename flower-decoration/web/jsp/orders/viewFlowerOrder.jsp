<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="college.custom.model.Employee" %>
<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.FlowerOrder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Flower</title>

    <script type="text/javascript">

    </script>
</head>
<body>
<%@include file="../user/userHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <% List<FlowerOrder> flowerOrders = (List<FlowerOrder>) request.getAttribute("orderedFlowers"); %>
        <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
            <table border="1">
                <tr>
                    <td>Order Id</td>
                    <td>Flower Name</td>
                    <td>Flower Cost</td>
                    <td>request_date</td>
                    <td>delivered_date</td>
                    <td>status</td>
                    <td>final_rate</td>
                </tr>
                <%for (int i = 0; i < flowerOrders.size(); i++) { %>
                <tr>
                    <td><%=flowerOrders.get(i).getOrderId()%></td>
                    <td><%=flowerOrders.get(i).getFlowerName()%></td>
                    <td><%=flowerOrders.get(i).getFlowerCost()%></td>
                    <td><%=flowerOrders.get(i).getRequestDate() %></td>
                    <td><%=flowerOrders.get(i).getDeliveredDate() %></td>
                    <td><%=flowerOrders.get(i).getStatus() %></td>
                    <td><%=flowerOrders.get(i).getFinalRate()%></td>
                </tr>
                <% } %>
            </table>
        </div>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>