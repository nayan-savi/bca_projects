<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addTicket() {

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
			} else if(price == null || price == "") {
					alert('Price is mandatory');
					document.ticket.price.focus();
					return false;
				}

            document.ticket.action="addTicket?anchor=addTicket";
            document.ticket.submit();
        }

    </script>
</head>
<body>
	<%@include file="adminClubHeader.jsp" %>
	<div id="wrapper">
		<div id="page">
			<%@include file="../login/loginDetails.jsp" %>
			<div align="center">
				<h3 style="color: green">${success}</h3>
				<h3 style="color: red">${errmsg}</h3>
			</div>
			<form action="" name="ticket" method="post" style="padding-left: 40px;">
				<h1>Add Ticket</h1>
				<table>
					<tr><td>Event Name</td><td><input type="text" name="eventName" id="eventName"/></td></tr>
					<tr><td>Event Type</td><td><input type="text" name="eventType"/></td></tr>
					<tr><td>Event Date</td><td><input type="date" name="eventDate" style="width: 159px"/></td></tr>
					<tr>
	                    <td>Event Time</td>
	                    <td>
	                        <select name="eventTime" id="eventTime">
	                            <option value=""></option>
	                            <option value="8:00AM">8:00 AM</option>
	                            <option value="9:00AM">9:00 AM</option>
	                            <option value="10:00AM">10:00 AM</option>
	                            <option value="11:00AM">11:00 AM</option>
	                            <option value="12:00PM">12:00 PM</option>
	                            <option value="1:00PM">1:00 PM</option>
	                            <option value="2:00PM">2:00 PM</option>
	                            <option value="3:00PM">3:00 PM</option>
	                            <option value="4:00PM">4:00 PM</option>
	                            <option value="5:00PM">5:00 PM</option>
	                            <option value="6:00PM">6:00 PM</option>
	                            <option value="7:00PM">7:00 PM</option>
	                            <option value="8:00PM">8:00 PM</option>
	                        </select>
	                    </td>
	                </tr>
					<tr><td>Event Place</td><td><input type="text" name="eventPlace"/></td></tr>
					<tr><td>Price</td><td><input type="text" name="price"/></td></tr>
					<tr><td>Available</td><td><input type="text" name="available"/></td></tr>
					<tr>
	                    <td>Status</td>
	                    <td>
	                        <select name="status" id="status">
	                            <option value=""></option>
	                            <option value="active">Active</option>
	                            <option value="inactive">Inactive</option>
	                        </select>
	                    </td>
	                </tr>
					<tr><td>Comment</td><td><input type="text" name="comment"/></td></tr>
					<tr ><td colspan="3" align="center"><input type="button" value="Save" onclick="addTicket()"></td></tr>
				</table>
			</form>

		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>

