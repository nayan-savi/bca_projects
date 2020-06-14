<%@page import="com.system.bugtracker.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.system.bugtracker.model.Ticket" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Modify Ticket</title>
    <script type="text/javascript">
        function cancelTicket() {
            document.ticket.action="cancelTicket?anchor=cancelTicket";
            document.ticket.submit();
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
<%@include file="employeeHeader.jsp" %>
<%
	List<Employee> employees = (List<Employee>) request.getAttribute("employees");
%>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	Ticket ticket = (Ticket) request.getAttribute("ticket");
        %>
        <form action="updateTicket?anchor=updateTicket&id=<%=ticket.getTicketId() %>" name="ticket" method="post" enctype="multipart/form-data" style="padding-left: 40px;">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    
					<tr>
						<td><input hidden type="text" name="ticketId" value="<%=ticket.getTicketId() %>"/></td>
					</tr>
					<tr>
						<td>Title</td>
						<td><input readonly type="text" name="title" value="<%=ticket.getTitle() %>"/></td>
					</tr>
					<% int desig = (int) session.getAttribute("designation");
						String username = (String) session.getAttribute("username"); 
						String name = (String) session.getAttribute("name"); 
                    	if(desig == 3) {%>
                        	<tr>
								<td>Assign To</td>
								<td><input readonly type="text" name="assignTo" value="<%=ticket.getAssignTo()%>"/></td>
							</tr>
                        <%} else {%>
							<tr>
								<td>Assign To</td>
								<td>
									<select name="assignTo">
									<option value="<%=ticket.getAssignTo() %>" hidden selected><%=ticket.getAssignTo() %></option>
										<option value=""></option>
										<%for (int i = 0; i < employees.size(); i++) { %>
											<option value="<%= employees.get(i).getUsername()%>"><%= employees.get(i).getUsername()%></option>
										<%} %>
									</select>
								</td>
							</tr>
						<%} %>
					<%-- <tr>
						<td>File Path</td>
						<td><input type="text" name="filePath" value="<%=ticket.getFilePath() %>"/></td>
					</tr> --%>
					
					<tr>
						<td>Upload File</td>
						<td><input type="file" name="uploadFile"/></td>
						<td>Download File:</td>
						<td><a style="text-decoration: underline;" href="download?fileName=<%=ticket.getFileName()%>"><%=ticket.getFileName()%> </a></td>
					</tr>
					<tr>
						<td>Last Date</td>
						<% int level1 = (int) session.getAttribute("designation"); 
                    	if(level1 == 3) {%>
                        	<td><input readonly type="date" name="lastDate" value="<%=ticket.getLastDate() %>"/></td>
                        <%} else {%>
                        	<td><input type="date" name="lastDate" value="<%=ticket.getLastDate() %>"/></td>
                        <%} %>
					</tr>
					<tr>
						<td>Root Cause</td>
						<td><textarea name="rootCause" cols="30" rows="10" ><%=ticket.getRootCause() %></textarea></td>
					</tr>
					<tr><td>Status</td>
						<td>
							<select name="status">
								 <%String status = ticket.getStatus();
									if(status.equals("OPEN")) { %>
										<option value="<%=status%>" hidden selected>Open</option>
									<%} else if (status.equals("INPROGRESS")) { %>
										<option value="<%=status%>" hidden selected>In-progress</option>
									<%} else if (status.equals("ASSIGNED")) { %>
										<option value="<%=status%>" hidden selected>Assigned</option>
									<%} else if (status.equals("DONE")) { %>
										<option value="<%=status%>" hidden selected>Done</option>
									<%} else if (status.equals("CLOSED")) { %>
										<option value="<%=status%>" hidden selected>Closed</option>
									<%}%>
	                             <option value=""></option>
	                             <option value="OPEN">Open</option>
	                             <option value="INPROGRESS">In-progress</option>
	                             <option value="ASSIGNED">Assigned</option>
	                             <option value="DONE">Done</option>
	                             <option value="CLOSED">Closed</option>
                         </select>
						</td>
					</tr>
					<tr>
						<td>Comment</td>
						<td><textarea name="comment" cols="30" rows="10"><%=ticket.getComment()%></textarea></td>
					</tr>

                </table>
            </div>
            <table>
                <tr>
                    <td><input type="submit" value="Update"></td>
                    <td><input type="button" value="Cancel" onclick="cancelTicket()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

