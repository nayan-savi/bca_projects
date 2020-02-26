<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="college.custom.model.Employee" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View/Modify Employee</title>

    <script type="text/javascript">
        function modifyEmployee() {
            var chk = document.employee.EMPLOYEE_ID;
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
                alert("Please selected atleast one checkbox");
                return false;
            }
            if (count > 1) {
                alert("Please select only one checkbox");
                return false;
            }
            document.employee.action = "/modifyEmployee?anchor=modifyEmployee";
            document.employee.submit();
        }

        function inactiveEmployee() {
            var chk = document.employee.EMPLOYEE_ID;
            var count = 0;
            if (chk.length == undefined) {
                if (chk.checked == true) {
                    count++;
                }
            }
            for (var i = 0; i < chk.length; i++) {S
                if (chk[i].checked == true) {
                    count++;
                }
            }
            //alert(count);

            if (count == 0) {
                alert("Please select at least one record");
                return false;
            }

            var res = confirm("Are you sure to inactive this record");

            if (res == true) {
                document.employee.action = "/inactiveEmployee?anchor=inactiveEmployee";
                document.employee.submit();
            }
            else {
                return false;
            }
            document.employee.action = "/inactiveEmployee?anchor=inactiveEmployee";
            document.employee.submit();

        }
    </script>
</head>
<body>
<%@include file="../manager/managerHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <form action="" name="employee" method="post">
            <% List<Employee> employees = (List<Employee>) request.getAttribute("employees"); %>
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="1">
                    <tr>
                        <td></td>
                        <td>EmployeeName</td>
                        <%--<td>EMP_JOINDATE</td>--%>
                        <td>QUALIFICATION</td>
                        <td>EMAILID</td>
                        <td>CONTACTNO</td>
                        <%--<td>FATHERNAME</td>
                        <td>MOTHERNAME</td>
                        <td>ADDRESS</td>
                        --%>
                        <td>DOB</td>
                        <td>USERNAME</td>
                        <%--<td>PASSWORD</td>--%>
                        <td>DESIGNATION</td>
                       <%--<td>RELIVINGDATE</td>--%>
                        <td>LEVEL</td>
                        <td>ACTIVE</td>
                    </tr>
                    <%for (int i = 0; i < employees.size(); i++) { %>
                    <tr>
                        <td>
                            <input type="checkbox" name="EMPLOYEE_ID" value="<%=employees.get(i).getEmployeeId() %>"/>
                        </td>
                        <td><%=employees.get(i).getEmployeeName()%></td>
                      <%--  <td><%=employees.get(i).getDateOfJoin() %></td>--%>
                        <td><%=employees.get(i).getQualification()%></td>
                        <td><%=employees.get(i).getEmailId() %></td>
                        <td><%=employees.get(i).getContactNo() %></td>
                        <%--<td><%=employees.get(i).getFatherName() %></td>
                        <td><%=employees.get(i).getMotherName() %></td>
                        <td><%=employees.get(i).getAddress()%></td>--%>
                        <td><%=employees.get(i).getDob() %></td>
                        <td><%=employees.get(i).getUsername()%></td>
                        <%--<td><%=employees.get(i).getPassword() %></td>--%>
                        <td><%=employees.get(i).getDesignation() %></td>
                        <%--<td><%=employees.get(i).getRelievingDate() %></td>--%>
                        <td><%=employees.get(i).getLevel() %></td>
                        <td><%=employees.get(i).getActive() %></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="button" value="Modify" onclick="modifyEmployee()"></td>
                    <td><input type="button" value="Inactive" onclick="inactiveEmployee()"/></td>
                </tr>
            </table>
        </form>

    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>