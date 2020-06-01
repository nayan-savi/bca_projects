<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.voilation.traffic.model.Complaint" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Flower</title>
    <script type="text/javascript">
	    function validateComplaint() {
	    	var paymentType = document.complaint.paymentType.value;
	    	var paymentDate = document.complaint.paymentDate.value;
	    	
	    	if(paymentType == null || paymentType == "") {
	    		alert('Payment Type is mandatory');
	    		document.complaint.paymentType.focus();
	    		return false;
	    	} else if(paymentDate == null || paymentDate == "") {
	    		alert('Payment Date is mandatory');
	    		document.complaint.paymentDate.focus();
	    		return false;
	    	}
	    }
    
        function cancelComplaint() {
            document.complaint.action="cancelComplaint?anchor=cancelComplaint";
            document.complaint.submit();
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
<%@include file="employeeHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	Complaint complaint = (Complaint) request.getAttribute("complaint");
        %>
        <form action="updateComplaint?anchor=updateComplaint" name="complaint" method="post" style="padding-left: 40px;" onSubmit="return validateComplaint()">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    
					<tr>
						<td>Complaint Id</td>
						<td><input readonly type="text" name="complaintId" value="<%=complaint.getComplaintId() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Reg No</td>
						<td><input readonly type="text" name="regNo" value="<%=complaint.getRegNo() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
	                    <td>Payment Type</td>
	                    <td>
	                        <select name="paymentType" id="paymentType">
	                            <option value="" selected></option>
	                            <option value="CASH">CASH</option>
	                            <option value="NET">NET</option>
	                            <option value="BU">BHIM/UPI</option>
	                        </select>
	                    </td>
	                </tr>
					<tr>
						<td>Payment Date</td>
						<td><input type="date" name="paymentDate" value="<%=complaint.getPaymentDate() %>"/></td>
					</tr>
					<tr>
						<td>Fee</td>
						<td><input readonly type="text" name="fee" value="<%=complaint.getFee() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Reason</td>
						<td><input readonly type="text" name="reason" value="<%=complaint.getReason() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
                        <td>Status</td>
                        <td>
                            <select name="status">
                                <option value="<%=complaint.getStatus()%>" hidden selected><%=complaint.getStatus()%></option>
                                <option value=""></option>
	                            <option value="NotPaid" >Not Paid</option>
	                            <option value="Paid">Paid</option>
                            </select>
                        </td>
                    </tr>
					<tr>
						<td>Comment</td>
						<td><input type="text" name="comment" value="<%=complaint.getComment() %>"/></td>
					</tr>

                </table>
            </div>
            <table>
                <tr>
                    <td><input type="submit" value="Update"></td>
                    <td><input type="button" value="Cancel" onclick="cancelComplaint()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

