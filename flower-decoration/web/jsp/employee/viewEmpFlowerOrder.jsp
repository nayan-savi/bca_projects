<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
        <% List<FlowerOrder> flowerOrders = (List<FlowerOrder>) request.getAttribute("orderedFlowers"); %>
        <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
            <table border="0">
                <tr class="viewHeader">
                    <td>Order Id</td>
                    <td>Flower Name</td>
                    <td>Flower Cost</td>
                    <td>Request Date</td>
                    <td>Bargaining</td>
                    <td>Delivered Date</td>
                    <td>Status</td>
                    <td>Final Rate</td>
                    <td>Comment</td>
                </tr>
                <%for (int i = 0; i < flowerOrders.size(); i++) {
                    String status = flowerOrders.get(i).getStatus();
                %>
                <tr class="viewData">
                    <td><%=flowerOrders.get(i).getOrderId()%></td>
                    <td><%=flowerOrders.get(i).getFlowerName()%></td>
                    <td><%=flowerOrders.get(i).getFlowerCost()%></td>
                    <td><%=flowerOrders.get(i).getRequestDate() %></td>
                    <td><%=flowerOrders.get(i).getBargaining() %></td>
                    <td><%=flowerOrders.get(i).getDeliveredDate() %></td>
                    <% if(status.equalsIgnoreCase("Pending")) {%>
                    <td style="color:yellowgreen"><%= status%></td>
                    <%} else if(status.equalsIgnoreCase("Inprogress")) {%>
                    <td style="color:blue"><%= status%></td>
                    <%} else if(status.equalsIgnoreCase("Done")) {%>
                    <td style="color:green"><%= status%></td>
                    <%} else if(status.equalsIgnoreCase("Rejected")) {%>
                    <td style="color:red"><%= status%></td>
                    <%}%>
                    <td><%=flowerOrders.get(i).getFinalRate()%></td>
                    <td><%=flowerOrders.get(i).getComment()%></td>
                </tr>
                <% } %>
            </table>
        </div>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>