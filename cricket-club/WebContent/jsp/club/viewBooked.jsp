<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.cricket.model.Book" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Pizza</title>
    <script type="text/javascript">
	    function searchValidate() {
	    	
	        document.searchBooked.action="viewBooked?anchor=viewBooked";
	        document.searchBooked.submit();
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
        
        <form action="" name="searchBooked" method="post" style="padding-left: 90px;">
            <h1>Search Vehicle</h1>
            <table>
				<tr><th>Search:</th>
					<td>
						<input type="date" name="eventDate" style="width: 200px" />
						<input type="button" value="Search" onclick="searchValidate()">
					</td>
				</tr>
            </table>
        </form>
        <%
        	List<Book> book = (List<Book>) request.getAttribute("books");
	        String notFound = (String) request.getAttribute("notFound");
	    	if(null != book) {
        %>
       
        <form action="" name="book" method="post" style="padding-left: 90px;">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Book Id</td>
                        <td>Booked By</td>
						<td>Event Name</td>
						<td>Event Date</td>
						<td>Event Time</td>
						<td>Event Place</td>
						<td>Booking</td>
						<td>Price</td>

                    </tr>
                    <%for (int i = 0; i < book.size(); i++) { %>
	                    <tr class="viewData">
	                        <td><%=book.get(i).getBookId()%></td>
	                        <td><%=book.get(i).getUsername()%></td>
							<td><%=book.get(i).getEventName()%></td>
							<td><%=book.get(i).getEventDate()%></td>
							<td><%=book.get(i).getEventTime()%></td>
							<td><%=book.get(i).getEventPlace()%></td>
							<td><%=book.get(i).getBooking()%></td>
							<td><%=book.get(i).getPrice()%></td>
	                    </tr>
                    <% } %>
                </table>
            </div>
            <!-- <table>
                <tr>
                    <td><input type="button" value="Modify" onclick="modifyBook()"></td>
                    <td><input type="button" value="Delete" onclick="deleteBook()"></td>
                </tr>
            </table> -->
        </form>
        <%} else {
			 if(notFound == null) {%>
        		<h2 style="padding-left:90px">No bookings</h2>
		<%}} %>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

