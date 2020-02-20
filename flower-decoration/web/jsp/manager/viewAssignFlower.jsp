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
        function modifyFlower() {
            var chk = document.flowerOrder.orderId;
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
                alert("Please selected at least one checkbox");
                return false;
            }
            if (count > 1) {
                alert("Please select only one checkbox");
                return false;
            }
            document.flowerOrder.action = "/modifyFlowerManager?anchor=modifyFlowerManager";
            document.flowerOrder.submit();
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
</style>
<body>
<%@include file="managerHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <% List<FlowerOrder> flowerOrders = (List<FlowerOrder>) request.getAttribute("orderedFlowers"); %>
        <form action="" name="flowerOrder" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Order Id</td>
                        <td>Flower Name</td>
                        <td>Flower Cost</td>
                        <td>Request Date</td>
                        <td>Assigned To</td>
                        <td>Delivered Date</td>
                        <td>Status</td>
                        <td>Final Rate</td>
                    </tr>
                    <%for (int i = 0; i < flowerOrders.size(); i++) {
                        String status = flowerOrders.get(i).getStatus();
                    %>
                    <tr class="viewData">
                        <td>
                            <input type="checkbox" name="orderId" value="<%=flowerOrders.get(i).getOrderId() %>"/>
                            <%=flowerOrders.get(i).getOrderId()%>
                        </td>
                        <td><%=flowerOrders.get(i).getFlowerName()%></td>
                        <td><%=flowerOrders.get(i).getFlowerCost()%></td>
                        <td><%=flowerOrders.get(i).getRequestDate() %></td>
                        <td><%=flowerOrders.get(i).getAssignedTo() %></td>
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
                    </tr>
                    <% } %>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="button" value="Modify" onclick="modifyFlower()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>