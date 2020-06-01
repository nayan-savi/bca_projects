<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="java.util.List" %>
<%@ page import="com.voilation.traffic.model.Vehicle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {
        	
        	var regNo = document.vehicle.regNo.value;
        	
        	if(regNo == null || regNo == "") {
        		alert('Vehicle Number is mandatory');
        		document.vehicle.regNo.focus();
        		return false;
        	} 

            document.vehicle.action="searchVehicle?anchor=searchVehicle&no="+regNo;
            document.vehicle.submit();
        }

    </script>
</head>
<style>
.display_content {
	height: auto;
	width: auto;
	border: 1px solid #ccc;
	overflow: auto;
	padding-left: 200px;
	font-size: 16px;
}

th {
	font-size: 16px;
	font-weight: bold;
}
</style>
<body>
<%@include file="employeeHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="" name="vehicle" method="post" style="padding-left: 40px;">
            <h1>Search Vehicle</h1>
            <table>
				<tr><th>Search:</th>
					<td>
						<input type="text" name="regNo" placeholder="vehicle number" style="width: 200px" />
						<input type="button" value="Search" onclick="addValue()">
					</td>
				</tr>
            </table>
        </form>
        <br/>
        <%
        	Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
        	String search = (String) request.getAttribute("search");
        	if(null != vehicle) {
        %>
           <div class="display_content">
               <table border="0">
				<tr>
					<th>Owner Name:</th>
					<td><label><%=vehicle.getOwnerName()%></label></td>
				</tr>
				<tr>
					<th>Reg No:</th>
					<td><label><%=vehicle.getRegNo()%></label></td>
				</tr>
				<tr>
					<th>Reg Date:</th>
					<td><label><%=vehicle.getRegDate()%></label></td>
				</tr>
				<tr>
					<th>Dl No:</th>
					<td><label><%=vehicle.getDlNo()%></label></td>
				</tr>
				<tr>
					<th>Address:</th>
					<td><label><%=vehicle.getAddress()%></label></td>
				</tr>
				<tr>
					<th>Charssis No:</th>
					<td><label><%=vehicle.getCharssisNo()%></label></td>
				</tr>
				<tr>
					<th>Engine No:</th>
					<td><label><%=vehicle.getEngineNo()%></label></td>
				</tr>
				<tr>
					<th>Model:</th>
					<td><label><%=vehicle.getModel()%></label></td>
				</tr>
				<tr>
					<th>Color:</th>
					<td><label><%=vehicle.getColor()%></label></td>
				</tr>
				<tr>
					<th>Status:</th>
					<td><label><%=vehicle.getStatus()%></label></td>
				</tr>
				<tr>
					<th>Comment:</th>
					<td><label><%=vehicle.getComment()%></label></td>
				</tr> 

               </table>
           </div>
        
        <%} else {
        	if(search == null) {%>
        		<h2 style="padding-left:40px">Vehicle not found</h2>
		<%}} %>
    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>