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

			var eventName = document.feedback.eventName.value;
			var rating = document.feedback.rating.value;
			var comments = document.feedback.comments.value;

			if(eventName == null || eventName == "") {
				alert('Event Name is mandatory');
				document.feedback.eventName.focus();
				return false;
			} else if(rating == null || rating == "") {
				alert('Rating is mandatory');
				document.feedback.rating.focus();
				return false;
			} else if(comments == null || comments == "") {
				alert('Comments is mandatory');
				document.feedback.comments.focus();
				return false;
			}  

            document.feedback.action="addFeedback?anchor=addFeedback";
            document.feedback.submit();
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
			<% List<String> eventNames = (List<String>) request.getAttribute("tickets"); %>
			<form action="" name="feedback" method="post" style="padding-left: 40px;">
				<h1>Feedback</h1>
				<table>
					<tr><td>Event Name</td>
						<td width="170px">
							<select name="eventName" id="eventName" style="width: 170px" onchange="setPrice()">
								<option></option>
								<%
									for (int i = 0; i < eventNames.size(); i++) {
										String name = eventNames.get(i);
								%>
									<option value="<%=name%>"><%=name%></option>
								<% } %>
							</select>
						</td>
					</tr>
					<!-- <tr><td>Feedback By</td><td><input type="text" name="feedbackBy"/></td></tr>
					<tr><td>Email Id</td><td><input type="text" name="emailId"/></td></tr> -->
					<tr><td>Rating</td>
						<td>
	                        <select name="rating" id="rating">
	                            <option value=""></option>
	                            <option value="1">1</option>
	                            <option value="2">2</option>
	                            <option value="3">3</option>
	                            <option value="4">4</option>
	                            <option value="5">5</option>
	                        </select>
	                    </td>
					</tr>
					<tr><td>Comments</td><td><textarea rows="5" cols="20" name="comments"></textarea></td></tr>
					<tr ><td colspan="3" align="center"><input type="button" value="Save" onclick="addValue()"></td></tr>
				</table>
			</form>

		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>

