<%@page import="college.custom.model.Employee" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Modify Employee</title>
    <script type="text/javascript">
        function navigate() {
            document.updateEmployee.action = "/cancelEmployee?anchor=cancelEmployee";
            document.updateEmployee.submit();
        }
    </script>
</head>
<body>
<%@include file="../manager/managerHeader.jsp" %>
<div id="wrapper">
    <div id="page">
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="/updateEmployee?anchor=updateEmployee" name="updateEmployee" method="post">
            <h3>Modify Employee details</h3>
            <% Employee employee = (Employee) request.getAttribute("employeeDetails"); %>
            <table>
                <tr>
                    <td>
                        <input type="hidden" name="employeeId" value="<%=employee.getEmployeeId() %>"/>
                    </td>
                </tr>
                <tr>
                    <td>Employee Name</td>
                    <td><input type="text" name="employeeName" value="<%=employee.getEmployeeName() %>"/></td>
                </tr>
                <tr>
                    <td>Date Of Join</td>
                    <td><input type="text" name="dateOfJoin" value="<%=employee.getDateOfJoin() %>"/></td>
                </tr>
                <tr>
                    <td>Qualification</td>
                    <td><input type="text" name="qualification" value="<%=employee.getQualification() %>"/></td>
                </tr>
                <tr>
                    <td>Email Id</td>
                    <td><input readonly="true" type="text" name="emailId" value="<%=employee.getEmailId() %>"/></td>
                </tr>
                <tr>
                    <td>Contact No</td>
                    <td><input type="text" name="contactNo" value="<%=employee.getContactNo() %>"/></td>
                </tr>
                <tr>
                    <td>Father Name</td>
                    <td><input type="text" name="fatherName" value="<%=employee.getFatherName() %>"/></td>
                </tr>
                <tr>
                    <td>Mother Name</td>
                    <td><input type="text" name="motherName" value="<%=employee.getMotherName()%>"/></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address" value="<%=employee.getAddress()%>"/></td>
                </tr>
                <tr>
                    <td>Dob</td>
                    <td><input type="text" name="dob" value="<%=employee.getDob()%>"/></td>
                </tr>
                <tr>
                    <td>Username</td>
                    <td><input readonly="true" type="text" name="username" value="<%=employee.getUsername()%>"/></td>
                </tr>
                <tr>
                    <td>password</td>
                    <td><input type="password" name="password" value="<%=employee.getPassword() %>"/></td>
                </tr>
                <tr>
                    <td>Designation</td>
                    <td><input type="text" name="designation" value="<%=employee.getDesignation() %>"/></td>
                </tr>
                <tr>
                    <td>Relieving Date</td>
                    <td><input type="text" name="relievingDate" value="<%=employee.getRelievingDate() %>"/></td>
                </tr>
                <%--<tr>
                    <td>Level</td>
                    <td><input type="text" name="level" value="<%=employee.getLevel() %>"/></td>
                </tr>--%>
                <tr>
                    <td>Level</td>
                    <td><select name="level" value="<%=employee.getLevel() %>">
                            <option value="-1">--select--</option>
                            <option value="1">Manager</option>
                            <option value="2">Employee</option>
                            <%--<option value="3">User</option>--%>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Active</td>
                    <td><input type="text" name="active" value="<%=employee.getActive() %>"/></td>
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
