<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.voilation.traffic.model.Complaint" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Complaints</title>
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
<%@include file="adminRtoHeader.jsp" %>
<div id="wrapper">
	<div align="center">
        <h3 style="color: green">${success}</h3>
        <h3 style="color: red">${errmsg}</h3>
    </div>
    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	List<Complaint> complaint = (List<Complaint>) request.getAttribute("complaints");
        %>
        <form action="" name="complaint" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Complaint Id</td>
						<td>Reg No</td>
						<td>Payment Type</td>
						<td>Payment Date</td>
						<td>Fee</td>
						<td>Reason</td>
						<td>Status</td>
                    </tr>
                    <%for (int i = 0; i < complaint.size(); i++) { %>
                    <tr class="viewData">
                    	<td>
                            <%=complaint.get(i).getComplaintId()%>
                        </td>
						<td><%=complaint.get(i).getRegNo()%></td>
						<td><%=complaint.get(i).getPaymentType()%></td>
						<td><%=complaint.get(i).getPaymentDate()%></td>
						<td><%=complaint.get(i).getFee()%></td>
						<td><%=complaint.get(i).getReason()%></td>
						<td><%=complaint.get(i).getStatus()%></td>
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

