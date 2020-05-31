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
            if(document.addShops.address.value==null || document.addShops.address.value=="")
            {
                alert("Please select  address");
                document.addShops.address.focus();
                return false;
            }
            if(document.addShops.city.value==null || document.addShops.city.value=="")
            {
                alert("Please Enter city ");
                document.addShops.city.focus();
                return false;
            }
            if(document.addShops.state.value==null || document.addShops.state.value=="")
            {
                alert("Please Enter state ");
                document.addShops.state.focus();
                return false;
            }
            if(document.addShops.country.value==null || document.addShops.country.value=="")
            {
                alert("Please Enter country ");
                document.addShops.country.focus();
                return false;
            }
            if(document.addShops.pincode.value==null || document.addShops.pincode.value=="")
            {
                alert("Please Enter pincode ");
                document.addShops.pincode.focus();
                return false;
            }
            if(document.addShops.startdate.value==null || document.addShops.startdate.value=="")
            {
                alert("Please Enter startdate ");
                document.addShops.startdate.focus();
                return false;
            }

            document.addShops.action="manage?anchor=save";
            document.addShops.submit();
        }

    </script>

</head>
<body>
<%@include file="managerHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="" name="addShops" method="post">
            <h1>ADD STATION DETAILS</h1>
            <table>
                <tr><td>Shop Name</td><td><input type="text" name="shopName"/></td></tr>
                <tr><td>address</td><td><input type="text" name="address"/></td></tr>
                <tr><td>city</td><td><input type="text" name="city"/></td></tr>
                <tr><td>state</td><td><input type="text" name="state"/></td></tr>
                <tr><td>country</td><td><input type="text" name="country"/></td></tr>
                <tr><td>pincode</td><td><input type="text" name="pincode"/></td></tr>
                <tr><td>Start date</td><td><input type="text" name="startdate"/></td></tr>
                <tr ><td colspan="3" align="center"><input type="button" value="Save" onclick="addValue()"></td></tr>
            </table>
        </form>

    </div>
</div>



<%@include file="../footer.jsp" %>
</body>
</html>