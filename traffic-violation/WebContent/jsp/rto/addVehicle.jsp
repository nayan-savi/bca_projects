<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {
			
        	var ownerName = document.vehicle.ownerName.value;
        	var regNo = document.vehicle.regNo.value;
        	var regDate = document.vehicle.regDate.value;
        	var dlNo = document.vehicle.dlNo.value;
        	var address = document.vehicle.address.value;
        	var charssisNo = document.vehicle.charssisNo.value;
        	var engineNo = document.vehicle.engineNo.value;
        	var model = document.vehicle.model.value;
        	var color = document.vehicle.color.value;
        	var status = document.vehicle.status.value;
        	var comment = document.vehicle.comment.value;

			if (ownerName == null || ownerName == "") {
				alert('Owner Name is mandatory');
				document.vehicle.ownerName.focus();
				return false;
			} else if (regNo == null || regNo == "") {
				alert('Reg No is mandatory');
				document.vehicle.regNo.focus();
				return false;
			} else if (regDate == null || regDate == "") {
				alert('Reg Date is mandatory');
				document.vehicle.regDate.focus();
				return false;
			} else if (dlNo == null || dlNo == "") {
				alert('Dl No is mandatory');
				document.vehicle.dlNo.focus();
				return false;
			} else if (address == null || address == "") {
				alert('Address is mandatory');
				document.vehicle.address.focus();
				return false;
			} else if (charssisNo == null || charssisNo == "") {
				alert('Charssis No is mandatory');
				document.vehicle.charssisNo.focus();
				return false;
			} else if (engineNo == null || engineNo == "") {
				alert('Engine No is mandatory');
				document.vehicle.engineNo.focus();
				return false;
			} else if (model == null || model == "") {
				alert('Model is mandatory');
				document.vehicle.model.focus();
				return false;
			} else if (color == null || color == "") {
				alert('Color is mandatory');
				document.vehicle.color.focus();
				return false;
			} else if (status == null || status == "") {
				alert('Status is mandatory');
				document.vehicle.status.focus();
				return false;
			} else if (comment == null || comment == "") {
				alert('Comment is mandatory');
				document.vehicle.comment.focus();
				return false;
			}

			document.vehicle.action = "addVehicle?anchor=addVehicle";
			document.vehicle.submit();
		}
	</script>
</head>
<body>
	<%@include file="adminRtoHeader.jsp" %>
	<div id="wrapper">
		<div id="page">
			<%@include file="../login/loginDetails.jsp" %>
			<div align="center">
				<h3 style="color: green">${success}</h3>
				<h3 style="color: red">${errmsg}</h3>
			</div>
			<form action="" name="vehicle" method="post" style="padding-left: 40px;">
				<h1>Add Vehicle Details</h1>
				<table>
					<tr><td>Owner Name</td><td><input type="text" name="ownerName"/></td></tr>
					<tr><td>Vehicle No</td><td><input type="text" name="regNo"/></td></tr>
					<tr><td>Reg Date</td><td><input type="date" name="regDate" style="width: 159px"/></td></tr>
					<tr><td>Dl No</td><td><input type="text" name="dlNo"/></td></tr>
					<tr><td>Address</td><td><input type="text" name="address"/></td></tr>
					<tr><td>Charssis No</td><td><input type="text" name="charssisNo"/></td></tr>
					<tr><td>Engine No</td><td><input type="text" name="engineNo"/></td></tr>
					<tr><td>Model</td><td><input type="text" name="model"/></td></tr>
					<tr><td>Color</td><td><input type="text" name="color"/></td></tr>
					<tr>
                    <td>Status</td>
                    <td>
                        <select name="status" id="status">
                            <option value=""></option>
                            <option value="active">Active</option>
                            <option value="inactive">Inactive</option>
                        </select>
                    </td>
                </tr>
					<tr><td>Comment</td><td><input type="text" name="comment"/></td></tr>
					<tr >
						<td colspan="3" align="center"><input type="button" value="Save" onclick="addValue()"></td>
					</tr>
				</table>
			</form>

		</div>
	</div>
	<%@include file="../footer.jsp" %>
</body>
</html>

