<%@page import="com.system.bugtracker.model.Employee"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.system.bugtracker.model.Ticket" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Ticket</title>
    <script type="text/javascript">
        function modifyTicket() {
            var chk = document.ticket.ticketId;
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
            document.ticket.action = "modifyTicket?anchor=modifyTicket";
            document.ticket.submit();
        }

		function searchValidate() {
	    	var status = document.searchTicket.status.value;
	    	if(status == null || status == "") {
	    		alert('Status is mandatory');
	    		document.searchTicket.status.focus();
	    		return false;
	    	} 
	
	        document.searchTicket.action="searchTicket?anchor=searchTicket";
	        document.searchTicket.submit();
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
<%@include file="employeeHeader.jsp" %>
<div id="wrapper">
	
    <div id="page">
	    <div align="center">
	        <h3 style="color: green">${success}</h3>
	        <h3 style="color: red">${errmsg}</h3>
	    </div>
        <%@include file="../login/loginDetails.jsp" %>
        <form action="" name="searchTicket" method="post" style="padding-left: 50px;">
            <h1>Search Ticket</h1>
            <table>
				<tr><th>Search:</th>
					<td>Status</td>
						<td>
							<select name="status">
	                             <option value=""></option>
	                             <option value="OPEN">Open</option>
	                             <option value="INPROGRESS">In-progress</option>
	                             <option value="ASSIGNED">Assigned</option>
	                             <option value="DONE">Done</option>
	                             <option value="CLOSED">Closed</option>
                         	</select>
						<input type="button" value="Search" onclick="searchValidate()">
					</td>
				</tr>
            </table>
        </form>
        <%
        	List<Ticket> ticket = (List<Ticket>) request.getAttribute("tickets");
        	String notFound = (String) request.getAttribute("notFound");
        	if(ticket != null && !ticket.isEmpty()) {
        %>
        <form action="" name="ticket" method="post" style="padding-left: 50px;">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Ticket Id</td>
						<td>Title</td>
						<td>Assign To</td>
						<td>File Name</td>
						<td>Assign From</td>
						<td>Last Date</td>
						<!-- <td>Root Cause</td> -->
						<td>Status</td>
						<!-- <td>Comment</td> -->

                    </tr>
                    <%for (int i = 0; i < ticket.size(); i++) { %>
                    <tr class="viewData">
                        <td>
                        	<% if(!ticket.get(i).getStatus().equalsIgnoreCase("CLOSED")) { %>
                            	<input type="checkbox" name="ticketId" value="<%=ticket.get(i).getTicketId() %>"/>
                            <%} %>
                            <%=ticket.get(i).getTicketId()%>
                        </td>
						<td><%=ticket.get(i).getTitle()%></td>
						<td><%=ticket.get(i).getAssignTo()%></td>
						<td><a href="download?fileName=<%=ticket.get(i).getFileName()%>"><%=ticket.get(i).getFileName()%> </a></td>
						<td><%=ticket.get(i).getAssignFrom()%></td>
						<td><%=ticket.get(i).getLastDate()%></td>
						<%-- <td><%=ticket.get(i).getRootCause()%></td> --%>
						<% String status = ticket.get(i).getStatus();
						if(status.equals("OPEN")) { %>
							<td>Open</td>
						<%} else if (status.equals("INPROGRESS")) { %>
							<td>In-progress</td>
						<%} else if (status.equals("ASSIGNED")) { %>
							<td>Assigned</td>
						<%} else if (status.equals("DONE")) { %>
							<td>Done</td>
						<%} else if (status.equals("CLOSED")) { %>
							<td>Closed</td>
						<%}%>
						<%-- <td><%=ticket.get(i).getComment()%></td> --%>

                    </tr>
                    <% } %>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="button" value="Modify" onclick="modifyTicket()"></td>
                   <!--  <td><input type="button" value="Delete" onclick="deleteTicket()"></td> -->
                </tr>
            </table>
        </form>
        <%} else {
			 if(notFound == "") {%>
			 	<br/>
        		<h2 style="padding-left:50px">Ticket not found</h2>
		<%}} %>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

