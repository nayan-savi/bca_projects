<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="com.voilation.traffic.model.Vehicle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">
    
	    function searchValidate() {
	    	
	    	var regNo = document.vehicle.regNo.value;
	    	
	    	if(regNo == null || regNo == "") {
	    		alert('Vehicle Number is mandatory');
	    		document.vehicle.regNo.focus();
	    		return false;
	    	} 
	
	        document.vehicle.action="lookup?anchor=lookup&no="+regNo;
	        document.vehicle.submit();
	    }

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
        <form action="" name="vehicle" method="post" style="padding-left: 90px;">
            <h1>Search Vehicle</h1>
            <table>
				<tr><th>Search:</th>
					<td>
						<input type="text" name="regNo" placeholder="vehicle number" style="width: 200px" />
						<input type="button" value="Search" onclick="searchValidate()">
					</td>
				</tr>
            </table>
        </form>
        <br/>
        
        <%
        	Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
        	String notFound = (String) request.getAttribute("notFound");
        	if(null != vehicle) {
        %>
	        <form action="" name="complaints" method="post" style="padding-left: 90px;">
	            <h1>Register Complaints</h1>
	            <table>
					<tr><td>Vehicle No</td><td><input readonly type="text" name="regNo" value="<%=vehicle.getRegNo()%>"/></td></tr>
					<tr>
						<td>Reg Date</td>
						<td><input disabled readonly type="text" value="<%=vehicle.getRegDate()%>" /></td>
					</tr>
					<tr>
						<td>Dl No</td>
						<td><input disabled readonly type="text" value="<%=vehicle.getDlNo()%>" /></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input disabled readonly type="text" value="<%=vehicle.getAddress()%>" /></td>
					</tr>
					<tr>
	                    <td>Payment Type</td>
	                    <td>
	                        <select name="paymentType" id="paymentType">
	                            <option value="-1"></option>
	                            <option value="CASH">Cash</option>
	                            <option value="NET">Net Banking</option>
	                            <option value="BU">BHIM/UPI</option>
	                        </select>
	                    </td>
	                </tr>
					
					<tr><td>Payment Date</td><td><input type="date" name="paymentDate"/></td></tr>
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
		 <%} else {
			 if(notFound == null) {%>
        		<h2 style="padding-left:90px">Vehicle not found</h2>
		<%}} %>
    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>