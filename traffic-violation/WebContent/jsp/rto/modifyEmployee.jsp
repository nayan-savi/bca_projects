<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.voilation.traffic.model.Registration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Flower</title>
    <script type="text/javascript">
        function cancelRegistration() {
            document.registration.action="cancelRegistration?anchor=cancelRegistration";
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
<%@include file="adminRtoHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	Registration registration = (Registration) request.getAttribute("employee");
        %>
        <form action="updateEmployee?anchor=updateEmployee" name="registration" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    
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
						<td><input type="text" name="emailId" value="<%=registration.getEmailId() %>"/></td>
					</tr>
					<tr>
						<td>Username</td>
						<td><input readonly type="text" name="username" value="<%=registration.getUsername() %>"/></td>
					</tr>
					<tr>
						<td>Level</td>
						<td><input readonly type="text" name="level" value="<%=registration.getLevel() %>"/></td>
					</tr>
					<tr>
                        <td>Status</td>
                        <td>
                            <select name="status">
                            	<option value="<%=registration.getStatus()%>" hidden selected><%=registration.getStatus()%></option>
                                <option value=""></option>
                                <option value="YES">YES</option>
                                <option value="NO">NO</option>
                            </select>
                        </td>
                    </tr>
					
					
					<tr>
						<td>Designation</td>
						<td><input type="text" name="designation" value="<%=registration.getDesignation() %>"/></td>
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

