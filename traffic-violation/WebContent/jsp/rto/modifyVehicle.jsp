<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.voilation.traffic.model.Vehicle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Flower</title>
    <script type="text/javascript">
        function cancelVehicle() {
            document.vehicle.action="cancelVehicle?anchor=cancelVehicle";
            document.vehicle.submit();
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
<%@include file="adminRtoHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	Vehicle vehicle = (Vehicle) request.getAttribute("vehicle");
        %>
        <form action="updateVehicle?anchor=updateVehicle" name="vehicle" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    
					<tr>
						<td>Vehicle Id</td>
						<td><input readonly type="text" name="vehicleId" value="<%=vehicle.getVehicleId() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Owner Name</td>
						<td><input readonly type="text" name="ownerName" value="<%=vehicle.getOwnerName() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Reg No</td>
						<td><input readonly type="text" name="regNo" value="<%=vehicle.getRegNo() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Reg Date</td>
						<td><input readonly type="text" name="regDate" value="<%=vehicle.getRegDate() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Dl No</td>
						<td><input readonly type="text" name="dlNo" value="<%=vehicle.getDlNo() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Address</td>
						<td><input type="text" name="address" value="<%=vehicle.getAddress() %>"/></td>
					</tr>
					<tr>
						<td>Charssis No</td>
						<td><input readonly type="text" name="charssisNo" value="<%=vehicle.getCharssisNo() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Engine No</td>
						<td><input readonly type="text" name="engineNo" value="<%=vehicle.getEngineNo() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Model</td>
						<td><input type="text" name="model" value="<%=vehicle.getModel() %>"/></td>
					</tr>
					<tr>
						<td>Color</td>
						<td><input type="text" name="color" value="<%=vehicle.getColor() %>"/></td>
					</tr>
					<tr>
						<td>Status</td>
						<td><input readonly type="text" name="status" value="<%=vehicle.getStatus() %>" style="background-color: gray;"/></td>
					</tr>
					<tr>
						<td>Comment</td>
						<td><input type="text" name="comment" value="<%=vehicle.getComment() %>"/></td>
					</tr>

                </table>
            </div>
            <table>
                <tr>
                    <td><input type="submit" value="Update"></td>
                    <td><input type="button" value="Cancel" onclick="cancelVehicle()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

