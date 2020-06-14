<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.system.bugtracker.model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Pizza</title>
    <script type="text/javascript">
        function modifyEmployee() {
            var chk = document.employee.employeeId;
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
            document.employee.action = "modifyEmployee?anchor=modifyEmployee";
            document.employee.submit();
        }

        function deleteEmployee() {
            var chk = document.employee.employeeId;
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

            document.employee.action = "deleteEmployee?anchor=deleteEmployee";
            document.employee.submit();
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

    .viewData>td{
        padding-top: 10px;
        padding-bottom: 10px;
    }
</style>
<body>
<%@include file="adminHeader.jsp" %>
<div id="wrapper">
	<div align="center">
        <h3 style="color: green">${success}</h3>
        <h3 style="color: red">${errmsg}</h3>
    </div>
    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	List<Employee> employee = (List<Employee>) request.getAttribute("employees");
        %>
        <form action="" name="employee" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Employee Id</td>
						<td>Name</td>
						<td>Address</td>
						<td>Contact No</td>
						<td>Email Id</td>
						<td>Username</td>
						<td>Level</td>
						<td>Active</td>
                    </tr>
                    <%for (int i = 0; i < employee.size(); i++) { %>
                    <tr class="viewData">
                        <td>
                            <input type="checkbox" name="employeeId" value="<%=employee.get(i).getEmployeeId() %>"/>
                            <%=employee.get(i).getEmployeeId()%>
                        </td>
						<td><%=employee.get(i).getName()%></td>
						<td><%=employee.get(i).getAddress()%></td>
						<td><%=employee.get(i).getContactNo()%></td>
						<td><%=employee.get(i).getEmailId()%></td>
						<td><%=employee.get(i).getUsername()%></td>
						<%int level = employee.get(i).getLevel();
							if(level == 2) { %>
								<td>Employee</td>
							<%} else if (level == 3) { %>
								<td>Team Lead</td>
							<%}%>
						<td><%=employee.get(i).getActive()%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="button" value="Modify" onclick="modifyEmployee()"></td>
                    <!-- <td><input type="button" value="Delete" onclick="deleteEmployee()"></td> -->
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

