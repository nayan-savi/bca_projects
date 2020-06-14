<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.system.bugtracker.model.Employee" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Flower</title>
    <script type="text/javascript">
        function cancelRegistration() {
            document.registration.action="cancelEmployee?anchor=cancelEmployee";
            document.registration.submit();
        }
    </script>
</head>
<style>
    .viewHeader>td {
        padding: 10px 20px;
    }

    .viewData>td{
        padding-top: 10px;
        padding-bottom: 10px;
    }
</style>
<body>
<%@include file="adminHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	Employee registration = (Employee) request.getAttribute("employee");
        %>
        <form action="updateEmployee?anchor=updateEmployee" name="registration" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                                        
					<tr>
						<td><input hidden type="text" name="employeeId" value="<%=registration.getEmployeeId() %>"/></td>
					</tr>
					<tr>
						<td>Name</td>
						<td><input type="text" name="name" value="<%=registration.getName() %>"/></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address" value="<%=registration.getAddress() %>"/></td>
					</tr>
					<tr>
						<td>Contact No</td>
						<td><input type="text" name="contactNo" value="<%=registration.getContactNo() %>"/></td>
					</tr>
					<tr>
						<td>Email Id</td>
						<td><input readonly type="text" name="emailId" value="<%=registration.getEmailId() %>"/></td>
					</tr>
					<tr>
						<td>Username</td>
						<td><input readonly type="text" name="username" value="<%=registration.getUsername() %>"/></td>
					</tr>
					<tr>
                        <td>Designation</td>
                        <td>
                            <select name="level">
	                            <%int level = registration.getLevel();
								if(level == 2) { %>
									<option value="<%=level%>" hidden selected>Employee</option>
								<%} else if (level == 3) { %>
									<option value="<%=level%>" hidden selected>Team Lead</option>
								<%}%>
                                <option value=""></option>
                                <option value="2">Employee</option>
                             	<option value="3">Team Lead</option>
                            </select>
                        </td>
                    </tr>
					
					<tr>
                        <td>Active</td>
                        <td>
                            <select name="active">
                            	<option value="<%=registration.getActive()%>" hidden selected><%=registration.getActive()%></option>
                                <option value=""></option>
                                <option value="YES">YES</option>
                                <option value="NO">NO</option>
                            </select>
                        </td>
                    </tr>

                </table>
            </div>
            <table>
                <tr>
                    <td><input type="submit" value="Update"></td>
                    <td><input type="button" value="Cancel" onclick="cancelRegistration()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

