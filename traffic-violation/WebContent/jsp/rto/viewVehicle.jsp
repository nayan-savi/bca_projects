<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="com.voilation.traffic.model.Vehicle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Vehicle</title>
    <script type="text/javascript">
        function modifyVehicle() {
            var chk = document.vehicle.vehicleId;
            var count = 0;
            if (chk.length == undefined) {
                if (chk.checked == true) {
                    count++;
                }
            }
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].checked == true) {
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
            document.vehicle.action = "modifyVehicle?anchor=modifyVehicle";
            document.vehicle.submit();
        }

        function deleteVehicle() {
            var chk = document.vehicle.vehicleId;
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

            document.vehicle.action = "deleteVehicle?anchor=deleteVehicle&id="+id;
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
<%@include file="adminRtoHeader.jsp" %>
<div id="wrapper">
	<div align="center">
        <h3 style="color: green">${success}</h3>
        <h3 style="color: red">${errmsg}</h3>
    </div>
    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <%
        	List<Vehicle> vehicle = (List<Vehicle>) request.getAttribute("vehicles");
        %>
        <form action="" name="vehicle" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Vehicle Id</td>
						<td>Owner Name</td>
						<td>Reg No</td>
						<td>Reg Date</td>
						<td>Dl No</td>
						<td>Address</td>
						<td>Charssis No</td>
						<td>Engine No</td>
						<td>Model</td>
						<td>Color</td>
						<td>Status</td>
						<td>Comment</td>
                    </tr>
                    <%for (int i = 0; i < vehicle.size(); i++) { %>
                    <tr class="viewData">
                        <td>
                            <input type="checkbox" name="vehicleId" value="<%=vehicle.get(i).getVehicleId() %>"/>
                            <%=vehicle.get(i).getVehicleId()%>
                        </td>
						<td><%=vehicle.get(i).getOwnerName()%></td>
						<td><%=vehicle.get(i).getRegNo()%></td>
						<td><%=vehicle.get(i).getRegDate()%></td>
						<td><%=vehicle.get(i).getDlNo()%></td>
						<td><%=vehicle.get(i).getAddress()%></td>
						<td><%=vehicle.get(i).getCharssisNo()%></td>
						<td><%=vehicle.get(i).getEngineNo()%></td>
						<td><%=vehicle.get(i).getModel()%></td>
						<td><%=vehicle.get(i).getColor()%></td>
						<td><%=vehicle.get(i).getStatus()%></td>
						<td><%=vehicle.get(i).getComment()%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="button" value="Modify" onclick="modifyVehicle()"></td>
                    <!-- <td><input type="button" value="Delete" onclick="deleteVehicle()"></td> -->
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>

