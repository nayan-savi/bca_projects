<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="com.club.cricket.model.Ticket" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {

			var eventName = document.book.eventName.value;
			var booking = document.book.booking.value;
			var avaliable = document.book.available.value;
			
			
			if(eventName == null || eventName == "") {
				alert('Event Name is mandatory');
				document.book.eventName.focus();
				return false;
			} else if(booking == null || booking == "") {
				alert('No. of booking is mandatory');
				document.book.booking.focus();
				return false;
			} 
			
			if(parseInt(booking) > parseInt(avaliable)) {
				alert('Tickets are not available.');
				document.book.booking.focus();
				return false;
			}
            document.book.action="addBook?anchor=addBook";
            document.book.submit();
        }
        
        function calPrice() {
        	var bookings = document.getElementById("booking").value;
        	var price = document.getElementById("price").value;
        	var totalPrice = bookings * price;
        	console.log(totalPrice);
        	document.getElementById("totalPrice").value = totalPrice;
        }
        
        function setPrice() {
            selectElement = document.querySelector('#ticketShowName');
            output = selectElement.options[selectElement.selectedIndex].value;
            document.getElementById('eventName').value = output.split(',')[0].trim();
            document.getElementById('price').value = output.split(',')[1].trim();
            document.getElementById('eventDate').value = output.split(',')[2].trim();
            document.getElementById('eventTime').value = output.split(',')[3].trim();
            document.getElementById('eventPlace').value = output.split(',')[4].trim();
            document.getElementById('available').value = output.split(',')[5].trim();
        }

    </script>
</head>
<body>
	<%@include file="customerHeader.jsp" %>
	<div id="wrapper">
		<div id="page">
			<%@include file="../login/loginDetails.jsp" %>
			<div align="center">
				<h3 style="color: green">${success}</h3>
				<h3 style="color: red">${errmsg}</h3>
			</div>
			<% List<Ticket> tickets = (List<Ticket>) request.getAttribute("tickets"); %>
			<form action="" name="book" method="post" style="padding-left: 40px;">
				<h1>Book Ticket</h1>
				<table>
					<tr><td>Event Name</td>
						<td width="170px">
							<select name="ticketShowName" id="ticketShowName" style="width: 165px" onchange="setPrice()">
								<option></option>
								<%
									for (int i = 0; i < tickets.size(); i++) {
										String ticket = tickets.get(i).getEventName();
										double price = tickets.get(i).getPrice();
										String date = tickets.get(i).getEventDate();
										String time = tickets.get(i).getEventTime();
										String place = tickets.get(i).getEventPlace();
										int available = tickets.get(i).getAvailable();
								%>
									<option value="<%=ticket%>,<%=price%>,<%= date%>,<%= time%>,<%= place%>,<%=available%>"><%=ticket%></option>
								<% } %>
							</select>
						</td>
						<td>Available Tickets:</td><td><input disabled id="available" name="available" /> </td>
					</tr>
					<tr style="display:none;">
	                    <td><input type="hidden" id="eventName" name="eventName" /> </td>
	                </tr>
					<tr><td>Event Date</td><td><input readonly type="text" name="eventDate" id="eventDate"/></td></tr>
					<tr><td>Event Time</td><td><input readonly type="text" name="eventTime" id="eventTime"/></td></tr>
					<tr><td>Event Place</td><td><input readonly type="text" name="eventPlace" id="eventPlace"/></td></tr>
					<tr><td>Price<td><input readonly type="text" name="price" id="price"/></td></tr>
					<tr>
						<td>No. of Booking</td>
						<td><input type="number" name="booking" id="booking" onchange="calPrice()"/></td>
						<td>Total Price</td><td><input disabled id="totalPrice" name="totalPrice" />
					</tr>
					<tr ><td colspan="3" align="center"><input type="button" value="Book" onclick="addValue()"></td></tr>
				</table>
			</form>

		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>

