<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.cricket.model.Ticket" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Pizza</title>
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
<%@include file="adminClubHeader.jsp" %>
<div id="wrapper">
	<div align="center">
        <h3 style="color: green">${success}</h3>
        <h3 style="color: red">${errmsg}</h3>
    </div>
    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	List<Ticket> ticket = (List<Ticket>) request.getAttribute("tickets");
        %>
        <form action="" name="ticket" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Ticket Id</td>
						<td>Event Name</td>
						<td>Event Type</td>
						<td>Event Date</td>
						<td>Event Time</td>
						<td>Event Place</td>
						<td>Price</td>
						<td>Available</td>
						<td>Booked</td>
						<td>Status</td>
						<td>Comment</td>

                    </tr>
                    <%for (int i = 0; i < ticket.size(); i++) { %>
	                    <tr class="viewData">
	                        <td>
	                            <input type="checkbox" name="ticketId" value="<%=ticket.get(i).getTicketId() %>"/>
	                            <%=ticket.get(i).getTicketId()%>
	                        </td>
							<td><%=ticket.get(i).getEventName()%></td>
							<td><%=ticket.get(i).getEventType()%></td>
							<td><%=ticket.get(i).getEventDate()%></td>
							<td><%=ticket.get(i).getEventTime()%></td>
							<td><%=ticket.get(i).getEventPlace()%></td>
							<td><%=ticket.get(i).getPrice()%></td>
							<td><%=ticket.get(i).getAvailable()%></td>
							<td><%=ticket.get(i).getBooked()%></td>
							<td><%=ticket.get(i).getStatus()%></td>
							<td><%=ticket.get(i).getComment()%></td>
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
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

