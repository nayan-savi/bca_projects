<%@page import="java.util.List"%>
<%@page import="com.system.bugtracker.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Employee</title>
    <script type="text/javascript">

        function addValue() {

			var title = document.ticket.title.value;
			var lastDate = document.ticket.lastDate.value;
			var status = document.ticket.status.value;
			
			if(title == null || title == "") {
				alert('Title is mandatory');
				document.ticket.title.focus();
				return false;
			} else if(lastDate == null || lastDate == "") {
				alert('Last Date is mandatory');
				document.ticket.lastDate.focus();
				return false;
			} else if(status == null || status == "") {
				alert('Status is mandatory');
				document.ticket.status.focus();
				return false;
			} 
            document.ticket.action="addTicket?anchor=addTicket";
            document.ticket.submit();
        }
        
    </script>
</head>
<body>
	<%@include file="employeeHeader.jsp" %>
	<%
        	List<Employee> employees = (List<Employee>) request.getAttribute("employees");
    %>
	<div id="wrapper">
		<div id="page">
			<%@include file="../login/loginDetails.jsp" %>
			<div align="center">
				<h3 style="color: green">${success}</h3>
				<h3 style="color: red">${errmsg}</h3>
			</div>
			<form action="" name="ticket" method="post" enctype="multipart/form-data" style="padding-left: 40px;">
				<h1>Create Ticket</h1>
				<table>
					<tr><td>Title</td><td><input type="text" name="title"/></td></tr>
					<tr>
						<td>Assign To</td>
						<td>
							<select name="assignTo">
								<option value=""></option>
								<%for (int i = 0; i < employees.size(); i++) { %>
									<option value="<%= employees.get(i).getUsername() %>"><%= employees.get(i).getName() %></option>
								<%} %>
							</select>
						</td>
					</tr>
					<!-- <tr><td>File Path</td><td><input type="text" name="filePath"/></td></tr> -->
					<!-- <tr><td>File Name</td><td><input type="text" name="fileName"/></td></tr> -->
					<!-- <tr><td>Assign From</td><td><input type="text" name="assignFrom"/></td></tr> -->
					<tr><td>Upload File</td><td><input type="file" name="uploadFile"/></td></tr>
					<tr><td>Last Date</td><td><input type="date" name="lastDate"/></td></tr>
					<tr><td>Root Cause</td><td><textarea name="rootCause" cols="30" rows="10"></textarea></td></tr>
					<tr><td>Status</td>
						<td>
							<select name="status">
	                             <option value=""></option>
	                             <option value="OPEN">Open</option>
	                             <option value="INPROGRESS">In-progress</option>
	                             <option value="ASSIGNED">Assigned</option>
	                             <option value="DONE">Done</option>
	                             <option value="CLOSED">Closed</option>
                         	</select>
						</td>
					</tr>
					<tr><td>Comment</td><td><textarea name="comment" cols="30" rows="10"></textarea></td></tr>
					<tr ><td colspan="3" align="center"><input type="button" value="Create" onclick="addValue()"></td></tr>
				</table>
			</form>
		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>

