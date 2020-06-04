<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.club.cricket.model.Feedback" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Pizza</title>
    <script type="text/javascript">
        
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
        	List<Feedback> feedback = (List<Feedback>) request.getAttribute("feedbacks");
        %>
        <form action="" name="feedback" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Feedback Id</td>
						<td>Event Name</td>
						<td>Feedback By</td>
						<td>Email Id</td>
						<td>Rating</td>
						<td>Comments</td>

                    </tr>
                    <%for (int i = 0; i < feedback.size(); i++) { %>
                    <tr class="viewData">
                        <td><%=feedback.get(i).getFeedbackId()%></td>
						<td><%=feedback.get(i).getEventName()%></td>
						<td><%=feedback.get(i).getFeedbackBy()%></td>
						<td><%=feedback.get(i).getEmailId()%></td>
						<td><%=feedback.get(i).getRating()%></td>
						<td><%=feedback.get(i).getComments()%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

