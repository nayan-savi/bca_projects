<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.DecorationOrder" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Flower</title>

    <script type="text/javascript">
        function deleteDecorationRequest() {
            var chk = document.decorationOrder.orderId;
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

            document.decorationOrder.action = "/deleteDecorationRequest?anchor=deleteDecorationRequest&id="+id;
            document.decorationOrder.submit();
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
<%@include file="../user/userHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <% List<DecorationOrder> decorationOrder = (List<DecorationOrder>) request.getAttribute("orderedDecorations"); %>
        <form action="" name="decorationOrder" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Order Id</td>
                        <td>Decoration Name</td>
                        <td>Decoration Cost</td>
                        <td>Request Date</td>
                        <td>Bargaining</td>
                        <td>Delivered Date</td>
                        <td>Status</td>
                        <td>Final Rate</td>
                        <td>Comment</td>
                    </tr>
                    <%for (int i = 0; i < decorationOrder.size(); i++) {
                        String status = decorationOrder.get(i).getStatus();
                    %>
                    <tr class="viewData">
                        <td>
                            <input type="checkbox" name="orderId" value="<%=decorationOrder.get(i).getOrderId() %>"/>
                            <%=decorationOrder.get(i).getOrderId()%>
                        </td>
                        <td><%=decorationOrder.get(i).getDecorationName()%></td>
                        <td><%=decorationOrder.get(i).getDecorationCost()%></td>
                        <td><%=decorationOrder.get(i).getRequestDate() %></td>
                        <td><%=decorationOrder.get(i).getBargaining() %></td>
                        <td><%=decorationOrder.get(i).getDeliveredDate() %></td>
                        <% if(status.equalsIgnoreCase("Pending")) {%>
                        <td style="color:yellowgreen"><%= status%></td>
                        <%} else if(status.equalsIgnoreCase("Inprogress")) {%>
                        <td style="color:blue"><%= status%></td>
                        <%} else if(status.equalsIgnoreCase("Done")) {%>
                        <td style="color:green"><%= status%></td>
                        <%} else if(status.equalsIgnoreCase("Rejected")) {%>
                        <td style="color:red"><%= status%></td>
                        <%}%>
                        <td><%=decorationOrder.get(i).getFinalRate()%></td>
                        <td><%=decorationOrder.get(i).getComment()%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="button" value="Delete" onclick="deleteDecorationRequest()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>