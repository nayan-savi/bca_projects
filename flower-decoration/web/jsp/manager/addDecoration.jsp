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
            /* if(document.addShops.shopName.value==null || document.addShops.shopName.value=="")
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
             }*/

            document.addDecoration.action="/decoration?anchor=addDecoration";
            document.addDecoration.submit();
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
        <form action="" name="addDecoration" method="post">
            <h1>ADD DECORATOR DETAILS</h1>
            <table>
                <tr><td>Decoration Name</td><td><input type="text" name="decorationName"/></td></tr>
                <tr><td>Decoration Cost</td><td><input type="text" name="decorationCost"/></td></tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <select name="status">
                            <option value="-1">--select--</option>
                            <option value="YES">YES</option>
                            <option value="NO">NO</option>
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