<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {
        	
        	var regNo = document.complaints.regNo.value;
        	var fee = document.complaints.fee.value;
        	var reason = document.complaints.reason.value;
        	var status = document.complaints.status.value;
        	
        	if(regNo == null || regNo == "") {
        		alert('Reg No is mandatory');
        		document.complaints.regNo.focus();
        		return false;
        	} else if(fee == null || fee == "") {
        		alert('Fee is mandatory');
        		document.complaints.fee.focus();
        		return false;
        	} else if(reason == null || reason == "") {
        		alert('Reason is mandatory');
        		document.complaints.reason.focus();
        		return false;
        	} else if(status == null || status == "") {
        		alert('Status is mandatory');
        		document.complaints.status.focus();
        		return false;
        	}

            document.complaints.action="addComplaint?anchor=addComplaint";
            document.complaints.submit();
        }

    </script>
</head>
<body>
<%@include file="employeeHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="" name="complaints" method="post" style="padding-left: 40px;">
            <h1>Register Complaints</h1>
            <table>
				<tr><td>Vehicle No</td><td><input type="text" name="regNo"/></td></tr>
				<tr>
                    <td>Payment Type</td>
                    <td>
                        <select disabled name="paymentType" id="paymentType">
                            <option value="-1"></option>
                            <option value="CASH">CASH</option>
                            <option value="NET">NET</option>
                            <option value="BU">BHIM/UPI</option>
                        </select>
                    </td>
                </tr>
				
				<tr><td>Payment Date</td><td><input disabled type="text" name="paymentDate"/></td></tr>
				<tr><td>Fee</td><td><input type="text" name="fee"/></td></tr>
				<tr><td>Reason</td><td><input type="text" name="reason"/></td></tr>
				<tr>
                    <td>Status</td>
                    <td>
                        <select name="status" id="status">
                        	<option value=""></option>
                            <option value="NotPaid" >Not Paid</option>
                            <option value="Paid">Paid</option>
                        </select>
                    </td>
                </tr>
				<tr><td>Comment</td><td><input type="text" name="comment"/></td></tr>

                <tr ><td colspan="3" align="center"><input type="button" value="Save" onclick="addValue()"></td></tr>
            </table>
        </form>

    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>