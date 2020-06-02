<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ page import="com.voilation.traffic.model.Vehicle" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">
		function validateForm() {
			var username = document.reg.username.value;
			var pwd = document.reg.password.value;
			var email = document.reg.emailId.value;
			if(username == null || username == "") {
				alert('Username is manadatory');
				document.reg.username.focus();
				return false;
			} else if(pwd == null || pwd == "") {
				alert('Password is mandatory');
				document.reg.password.focus();
				return false;
			} else if(email == null || email == "") {
				alert('Email is mandatory');
				document.reg.email.focus();
				return false;
			}
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
		<form action="registration" name="reg" method="post" onSubmit="return validateForm()">
             <table width="333" height="188" border="0" align="center">
                 <tr>
                     <td colspan="2" align="center"><h1>Registration</h1></td>
                 </tr>
                 <tr>
                     <td width="110">
                         <div align="center">Name</div>
                     </td>
                     <td width="213">
                         <input name="name" type="text" />
                     </td>
                 </tr>
                 <tr>
                     <td width="110">
                         <div align="center">Address</div>
                     </td>
                     <td width="213">
                         <textarea name="address" cols="30" rows="10"></textarea>
                     </td>
                 </tr>
                 <tr>
                     <td width="110">
                         <div align="center">ContactNo</div>
                     </td>
                     <td width="213">
                         <input name="contactNo" type="text" />
                     </td>
                 </tr>
                 <tr>
                     <td width="110">
                         <div align="center">EmailId</div>
                     </td>
                     <td width="213">
                         <input name="emailId" type="text" />
                     </td>
                 </tr>
                 <tr>
                     <td width="110">
                         <div align="center">Username</div>
                     </td>
                     <td width="213">
                         <input name="username" type="text" />
                     </td>
                 </tr>
                 <tr>
                     <td>
                         <div align="center">Password</div>
                     </td>
                     <td>
                         <input name="password" type="password" />
                     </td>
                 </tr>
                 <tr>
                     <td>Status</td>
                     <td>
                         <select name="status">
                             <option value=""></option>
                             <option value="YES">YES</option>
                             <option value="NO">NO</option>
                         </select>
                     </td>
                 </tr>
                 <tr>
                     <td width="110">
                         <div align="center">Designation</div>
                     </td>
                     <td width="213">
                         <input name="designation" type="text" />
                     </td>
                 </tr>
                 <tr>
                     <td>
                         <div align="center">
                             <input  type="submit" value="Register" />
                         </div>
                     </td>
                     <td>
                         <input name="" type="reset" />
                     </td>
                 </tr>
             </table>
         </form>
    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>