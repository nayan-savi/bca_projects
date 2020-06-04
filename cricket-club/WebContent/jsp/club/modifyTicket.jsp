<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.cricket.model.Ticket" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Flower</title>
    <script type="text/javascript">
    
    function modifyTicket() {
		var eventName = document.ticket.eventName.value;
		var eventType = document.ticket.eventType.value;
		var eventDate = document.ticket.eventDate.value;
		var eventTime = document.ticket.eventTime.value;
		var eventPlace = document.ticket.eventPlace.value;
		var price = document.ticket.price.value;
		var available = document.ticket.available.value;
		var status = document.ticket.status.value;
		var comment = document.ticket.comment.value;
		
		if(eventName == null || eventName == "") {
			alert('Event Name is mandatory');
			//document.getElementById('eventName').style.borderColor='red';
			document.ticket.eventName.focus();
			return false;
		} else 
		if(eventType == null || eventType == "") {
			alert('Event Type is mandatory');
			document.ticket.eventType.focus();
			return false;
		} else 
		if(eventDate == null || eventDate == "") {
			alert('Event Date is mandatory');
			document.ticket.eventDate.focus();
			return false;
		} else 
		if(eventTime == null || eventTime == "") {
			alert('Event Time is mandatory');
			document.ticket.eventTime.focus();
			return false;
		} else 
		if(eventPlace == null || eventPlace == "") {
			alert('Event Place is mandatory');
			document.ticket.eventPlace.focus();
			return false;
		} else 
		if(available == null || available == "") {
			alert('Available is mandatory');
			document.ticket.available.focus();
			return false;
		} else 
		if(status == null || status == "") {
			alert('Status is mandatory');
			document.ticket.status.focus();
			return false;
		} else 
		if(comment == null || comment == "") {
			alert('Comment is mandatory');
			document.ticket.comment.focus();
			return false;
		} else if(price == null || price == "") {
				alert('Price is mandatory');
				document.ticket.price.focus();
				return false;
			}

    }
    
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
<%@include file="adminClubHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	Ticket ticket = (Ticket) request.getAttribute("ticket");
        %>
        <form action="updateTicket?anchor=updateTicket" name="ticket" method="post" onSubmit="return modifyTicket()">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
					<tr>
						<td>Ticket Id</td>
						<td><input readonly type="text" name="ticketId" value="<%=ticket.getTicketId() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Event Name</td>
						<td><input type="text" name="eventName" value="<%=ticket.getEventName() %>"/></td>
					</tr>
					<tr>
						<td>Event Type</td>
						<td><input type="text" name="eventType" value="<%=ticket.getEventType() %>"/></td>
					</tr>
					<tr>
						<td>Event Date</td>
						<td><input type="text" name="eventDate" value="<%=ticket.getEventDate() %>"/></td>
					</tr>
					<tr>
						<td>Event Time</td>
						<td><input type="text" name="eventTime" value="<%=ticket.getEventTime() %>"/></td>
					</tr>
					<tr>
						<td>Event Place</td>
						<td><input type="text" name="eventPlace" value="<%=ticket.getEventPlace() %>"/></td>
					</tr>
					<tr>
						<td>Price</td>
						<td><input type="text" name="price" value="<%=ticket.getPrice() %>"/></td>
					</tr>
					<tr>
						<td>Available</td>
						<td><input type="text" name="available" value="<%=ticket.getAvailable() %>"/></td>
					</tr>
					<tr>
	                    <td>Status</td>
	                    <td>
	                        <select name="status" id="status">
	                        	<option value="<%=ticket.getStatus()%>" hidden selected><%=ticket.getStatus()%></option>
	                            <option value=""></option>
	                            <option value="active">Active</option>
	                            <option value="inactive">Inactive</option>
	                        </select>
	                    </td>
	                </tr>
					<tr>
						<td>Comment</td>
						<td><input type="text" name="comment" value="<%=ticket.getComment() %>"/></td>
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

