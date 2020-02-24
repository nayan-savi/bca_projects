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
            document.updateDecorationOrder.action = "/cancelEmployee?anchor=cancelEmployee";
            document.updateDecorationOrder.submit();
        }
    </script>
</head>
<body>
<%@include file="../manager/managerHeader.jsp" %>
<div id="wrapper">
    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="/updateDecorationOrder?anchor=updateDecorationOrder" name="updateDecorationOrder" method="post">
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
                    <td><input readonly="true" type="text" name="flowerName" value="<%=decorationOrder.getDecorationName() %>"/></td>
                </tr>
                <tr>
                    <td>Decoration Cost</td>
                    <td><input readonly="true" type="text" name="flowerCost" value="<%=decorationOrder.getDecorationCost() %>"/></td>
                </tr>
                <tr>
                    <td>Request Date</td>
                    <td><input readonly="true" type="text" name="requestDate" value="<%=decorationOrder.getRequestDate() %>"/></td>
                </tr>
                <tr>
                    <td>Bargaining</td>
                    <td><input readonly="true" type="text" name="bargaining" value="<%=decorationOrder.getBargaining() %>"/></td>
                </tr>

                <% List<Employee> employees = (List<Employee>) request.getAttribute("employees"); %>
                <tr>
                    <td>Assigned To</td>
                    <td width="172px">
                        <select name="assignedTo" style="width: 172px">
                            <option value="<%=decorationOrder.getAssignedTo()%>" hidden selected><%=decorationOrder.getAssignedTo()%></option>
                            <option></option>
                            <%for (int i = 0; i < employees.size(); i++) {
                                String employeeName = employees.get(i).getEmployeeName();
                            %>
                            <option value="<%=employeeName%>"><%=employeeName%></option>
                            <% } %>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Final Rate</td>
                    <td><input type="text" name="finalRate" value="<%=decorationOrder.getFinalRate() %>"/></td>
                </tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <select name="status">
                            <option></option>
                            <option value="<%=decorationOrder.getStatus()%>" hidden selected><%=decorationOrder.getStatus()%></option>
                            <option value="Pending">Pending</option>
                            <option value="Inprogress">Inprogress</option>
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
