<%@page import="college.custom.model.Employee" %>
<%@ page import="college.custom.model.FlowerOrder" %>
<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.DecorationOrder" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Modify Employee</title>
    <script type="text/javascript">
        function navigate() {
            document.updateFlowerOrder.action = "/cancelEmployee?anchor=cancelEmployee";
            document.updateFlowerOrder.submit();
        }

        function setValue() {
            element = document.querySelector("#status").value;
            console.log(element)
        }
    </script>
</head>
<body>
<%@include file="employeeHeader.jsp" %>
<div id="wrapper">
    <div id="page">
        <div align="center">
            <%@include file="../login/loginDetails.jsp" %>
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="/updateEmpDecorationOrder?anchor=updateEmpDecorationOrder" name="updateDecorationOrder" method="post">
            <h3>Modify Decoration details</h3>
            <% DecorationOrder decorationOrder = (DecorationOrder) request.getAttribute("decorationDetails"); %>
            <table>
                <tr>
                    <td>
                        <input type="hidden" name="orderId" value="<%=decorationOrder.getOrderId() %>"/>
                    </td>
                </tr>
                <tr>
                    <td>Decoration Name</td>
                    <td><input readonly="true" type="text" name="DecorationName" value="<%=decorationOrder.getDecorationName() %>"/></td>
                </tr>
                <tr>
                    <td>Decoration Cost</td>
                    <td><input readonly="true" type="text" name="DecorationCost" value="<%=decorationOrder.getDecorationCost() %>"/></td>
                </tr>
                <tr>
                    <td>Request Date</td>
                    <td><input readonly="true" type="text" name="requestDate" value="<%=decorationOrder.getRequestDate() %>"/></td>
                </tr>
                <tr>
                    <td>Bargaining</td>
                    <td><input readonly="true" type="text" name="bargaining" value="<%=decorationOrder.getBargaining() %>"/></td>
                </tr>

                <tr>
                    <td>Assigned To</td>
                    <td><input readonly="true" type="text" name="assignedTo" value="<%=decorationOrder.getAssignedTo() %>"/></td>
                </tr>

                <tr>
                    <td>Final Rate</td>
                    <td><input readonly="true" type="text" name="finalRate" value="<%=decorationOrder.getFinalRate() %>"/></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <select name="status" id="status" value="<%=decorationOrder.getStatus()%>" >
                            <option></option>
                            <option value="Pending">Pending</option>
                            <option value="Inprogress" selected>Inprogress</option>
                            <option value="Done">Done</option>
                            <option value="Rejected">Rejected</option>
                        </select>
                    </td>
                </tr>
                <tr>
                    <td>Comment</td>
                    <td><input type="text" name="comment" value="<%=decorationOrder.getComment() %>"/></td>
                </tr>
            </table>
            <table>
                <tr>
                    <td></td>
                    <td><input type="submit" value="Update"/>
                        <input type="button" value="Cancel" onclick="navigate()"/>
                    </td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>
