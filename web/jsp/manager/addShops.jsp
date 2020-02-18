<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue()
        {
            if(document.addOrganisation.ORGANISATION_NAME.value==null || document.addOrganisation.ORGANISATION_NAME.value=="")
            {
                alert("Please Enter ORGANISATION_NAME ");
                document.addOrganisation.ORGANISATION_NAME.focus();
                return false;
            }
            if(document.addOrganisation.ADDRESS.value==null || document.addOrganisation.ADDRESS.value=="")
            {
                alert("Please select  ADDRESS");
                document.addOrganisation.ADDRESS.focus();
                return false;
            }
            if(document.addOrganisation.CITY.value==null || document.addOrganisation.CITY.value=="")
            {
                alert("Please Enter CITY ");
                document.addOrganisation.CITY.focus();
                return false;
            }
            if(document.addOrganisation.STATE.value==null || document.addOrganisation.STATE.value=="")
            {
                alert("Please Enter STATE ");
                document.addOrganisation.STATE.focus();
                return false;
            }
            if(document.addOrganisation.COUNTRY.value==null || document.addOrganisation.COUNTRY.value=="")
            {
                alert("Please Enter COUNTRY ");
                document.addOrganisation.COUNTRY.focus();
                return false;
            }
            if(document.addOrganisation.PINCODE.value==null || document.addOrganisation.PINCODE.value=="")
            {
                alert("Please Enter PINCODE ");
                document.addOrganisation.PINCODE.focus();
                return false;
            }
            if(document.addOrganisation.STARTDATE.value==null || document.addOrganisation.STARTDATE.value=="")
            {
                alert("Please Enter STARTDATE ");
                document.addOrganisation.STARTDATE.focus();
                return false;
            }

            document.addOrganisation.action="<%=request.getContextPath()%>/ManagerController?anchor=addOrganisation";
            document.addOrganisation.submit();
        }

    </script>

</head>
<body>
<%@include file="managerHeader.jsp" %>
<div id="wrapper">

    <div id="page">

        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="/save?anchor=save" method="post">
            <h1>ADD STATION DETAILS</h1>
            <table>
                <tr><td>Shop Name</td><td><input type="text" name="shopName"/></td></tr>
                <tr><td>Address</td><td><input type="text" name="address"/></td></tr>
                <tr><td>City</td><td><input type="text" name="city"/></td></tr>
                <tr><td>State</td><td><input type="text" name="state"/></td></tr>
                <tr><td>Country</td><td><input type="text" name="country"/></td></tr>
                <tr><td>Pincode</td><td><input type="text" name="pincode"/></td></tr>
                <tr><td>Start date</td><td><input type="text" name="startdate"/></td></tr>
                <tr ><td colspan="3" align="center"><input type="button"  value="Save" onclick="addValue()"></td></tr>
            </table>
        </form>

    </div>
</div>



<%@include file="../footer.jsp" %>
</body>
</html>