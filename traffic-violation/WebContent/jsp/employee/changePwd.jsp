<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="com.voilation.traffic.model.Vehicle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">
    
	    function pwdValidate() {
	    	
	    	var pwd1 = document.employee.password.value;
	    	var pwd2 = document.employee.cpassword.value;
	    	
	    	if(pwd1 == null || pwd1 == "") {
	    		alert('New Password is mandatory');
	    		document.employee.password.focus();
	    		return false;
	    	} else if(pwd2 == null || pwd2 == "") {
	    		alert('Confirm Password is mandatory');
	    		document.employee.cpassword.focus();
	    		return false;
	    	} else if(pwd1 != pwd2) {
	    		alert('Password doesnot match');
	    		return false;
	    	}
	
	        document.employee.action="updatePwd?anchor=updatePwd";
	        document.employee.submit();
	    }

    </script>
</head>
<body>
<%@include file="employeeHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="" name="employee" method="post" style="padding-left: 40px;">
			<h1>Change Password</h1>
			<table>
				<tr><td>New Password</td><td><input type="password" name="password"/></td></tr>
				<tr><td>Confirm Password</td><td><input type="password" name="cpassword"/></td></tr>
				<tr><td><input type="button" value="Save" onclick="pwdValidate()"/></td></tr>
			</table>
		</form>
        
    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>