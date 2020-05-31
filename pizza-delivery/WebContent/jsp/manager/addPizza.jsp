<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {
        	var pizzaName = document.addPizza.pizzaName.value;
        	var pizzaCost = document.addPizza.pizzaCost.value;
        	var status = document.addPizza.status.value;
        	
        	if(pizzaName == null || pizzaName == "") {
        		alert('Pizza Name is mandatory');
        		document.addPizza.pizzaName.focus();
        		return false;
        	} else if(pizzaCost == null || pizzaCost == "") {
        		alert('Pizza Cost is mandatory');
        		document.addPizza.pizzaCost.focus();
        		return false;
        	} else if(status == null || status == "") {
        		alert('Status is mandatory');
        		document.addPizza.status.focus();
        		return false;
        	}

            document.addPizza.action="pizza?anchor=addPizza";
            document.addPizza.submit();
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
        <form action="" name="addPizza" method="post">
            <h1>ADD PIZZA DETAILS</h1>
            <table>
                <tr><td>Pizza Name</td><td><input type="text" name="pizzaName"/></td></tr>
                <tr><td>Pizza Cost</td><td><input type="text" name="pizzaCost"/></td></tr>
                <tr>
                    <td>Status</td>
                    <td>
                        <select name="status" id="status">
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