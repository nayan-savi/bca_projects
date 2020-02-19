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

    </script>
</head>
<body>
<%@include file="../user/userHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <% List<DecorationOrder> decorationOrder = (List<DecorationOrder>) request.getAttribute("orderedDecorations"); %>
        <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
            <table border="1">
                <tr>
                    <td>Order Id</td>
                    <td>Decoration Name</td>
                    <td>Decoration Cost</td>
                    <td>request_date</td>
                    <td>delivered_date</td>
                    <td>status</td>
                    <td>final_rate</td>
                </tr>
                <%for (int i = 0; i < decorationOrder.size(); i++) { %>
                <tr>
                    <td><%=decorationOrder.get(i).getOrderId()%></td>
                    <td><%=decorationOrder.get(i).getDecorationName()%></td>
                    <td><%=decorationOrder.get(i).getDecorationCost()%></td>
                    <td><%=decorationOrder.get(i).getRequestDate() %></td>
                    <td><%=decorationOrder.get(i).getDeliveredDate() %></td>
                    <td><%=decorationOrder.get(i).getStatus() %></td>
                    <td><%=decorationOrder.get(i).getFinalRate()%></td>
                </tr>
                <% } %>
            </table>
        </div>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>