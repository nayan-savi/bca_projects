<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.voilation.traffic.model.Complaint" %>
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
	        document.vehicle.action="myComplaint?anchor=myComplaint";
	        document.vehicle.submit();
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
<%@include file="userHeader.jsp" %>
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
					</td>
					<td>
                       <select name="status" id="status">
                       	<option value=""></option>
                           <option value="NotPaid" >Not Paid</option>
                           <option value="Paid">Paid</option>
                       </select>
                   	</td>
					<td><input type="button" value="Search" onclick="searchValidate()"></td>
				</tr>
            </table>
        </form>
        <br/>
        
        <%
        List<Complaint> complaint = (List<Complaint>) request.getAttribute("complaints");
        	String notFound = (String) request.getAttribute("notFound");
        	if(null != complaint) {
        %>
        <form action="" style="padding-left: 90px;">
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
		                   	<td><%=complaint.get(i).getComplaintId()%></td>
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
		 <%} else {
			 if(notFound == null) {%>
        		<h2 style="padding-left:90px">Vehicle not found</h2>
		<%}} %>
    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>