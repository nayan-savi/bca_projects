<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.voilation.traffic.model.Complaint" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Complaints</title>
    <script type="text/javascript">
        function modifyComplaint() {
            var chk = document.complaint.complaintId;
            var count = 0;
            var id = 0;
            if (chk.length == undefined) {
                if (chk.checked == true) {
                    count++;
                }
            }
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].checked == true) {
                	id = chk[i].value;
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
            document.complaint.action = "modifyComplaint?anchor=modifyComplaint&id="+id;
            document.complaint.submit();
        }

        function deleteComplaint() {
            var chk = document.complaint.complaintId;
            var count = 0;
            var id = 0;
            if (chk.length == undefined) {
                if (chk.checked == true) {
                    count++;
                }
            }
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].checked == true) {
                	id = chk[i].value;
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

            document.complaint.action = "deleteComplaint?anchor=deleteComplaint&id="+id;
            document.complaint.submit();
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
                            <input type="checkbox" name="complaintId" value="<%=complaint.get(i).getComplaintId() %>"/>
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
            <table>
                <tr>
                    <td><input type="button" value="Modify" onclick="modifyComplaint()"></td>
                    <!-- <td><input type="button" value="Delete" onclick="deleteComplaint()"></td> -->
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

