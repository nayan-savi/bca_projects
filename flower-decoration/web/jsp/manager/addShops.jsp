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
            if(document.addShops.shopName.value==null || document.addShops.shopName.value=="")
            {
                alert("Please Enter Shop name ");
                document.addShops.shopName.focus();
                return false;
            }
            if(document.addShops.ADDRESS.value==null || document.addShops.ADDRESS.value=="")
            {
                alert("Please select  ADDRESS");
                document.addShops.ADDRESS.focus();
                return false;
            }
            if(document.addShops.CITY.value==null || document.addShops.CITY.value=="")
            {
                alert("Please Enter CITY ");
                document.addShops.CITY.focus();
                return false;
            }
            if(document.addShops.STATE.value==null || document.addShops.STATE.value=="")
            {
                alert("Please Enter STATE ");
                document.addShops.STATE.focus();
                return false;
            }
            if(document.addShops.COUNTRY.value==null || document.addShops.COUNTRY.value=="")
            {
                alert("Please Enter COUNTRY ");
                document.addShops.COUNTRY.focus();
                return false;
            }
            if(document.addShops.PINCODE.value==null || document.addShops.PINCODE.value=="")
            {
                alert("Please Enter PINCODE ");
                document.addShops.PINCODE.focus();
                return false;
            }
            if(document.addShops.STARTDATE.value==null || document.addShops.STARTDATE.value=="")
            {
                alert("Please Enter STARTDATE ");
                document.addShops.STARTDATE.focus();
                return false;
            }

            document.addShops.action="<%=request.getContextPath()%>/save?anchor=save";
            document.addShops.submit();
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
        <form action="/manage?anchor=save" method="post">
            <h1>ADD STATION DETAILS</h1>
            <table>
                <tr><td>Shop Name</td><td><input type="text" name="shopName"/></td></tr>
                <tr><td>Address</td><td><input type="text" name="address"/></td></tr>
                <tr><td>City</td><td><input type="text" name="city"/></td></tr>
                <tr><td>State</td><td><input type="text" name="state"/></td></tr>
                <tr><td>Country</td><td><input type="text" name="country"/></td></tr>
                <tr><td>Pincode</td><td><input type="text" name="pincode"/></td></tr>
                <tr><td>Start date</td><td><input type="text" name="startdate"/></td></tr>
                <tr ><td colspan="3" align="center"><input type="submit" value="Save" onclick="addValue()"></td></tr>
            </table>
        </form>

    </div>
</div>



<%@include file="../footer.jsp" %>
</body>
</html>