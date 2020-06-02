<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Traffic Violation</title>

    <link href="././css/default.css" rel="stylesheet" type="text/css" media="screen" />
    <script src="././js/dropdowntabs.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="././css/ddcolortabs.css" />
</head>

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

<body>
<div id="header">
    <div id="logo">
        <h1><span>Traffic Violation</span></h1>
    </div>

    <!-- end header -->
    <div id="wrapper">
        <!-- start page -->
        <div id="page">
            <div align="center">
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
                    <!-- <tr>
                        <td>Status</td>
                        <td>
                            <select name="status">
                                <option value="-1">-- select --</option>
                                <option value="YES">YES</option>
                                <option value="NO">NO</option>
                            </select>
                        </td>
                    </tr> -->
                    <!-- <tr>
                        <td width="110">
                            <div align="center">Designation</div>
                        </td>
                        <td width="213">
                            <input name="designation" type="text" />
                        </td>
                    </tr> -->
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
                    <tr>
                        <td align="right"><a href="log?anchor=log">Click here to Login</a></td>
                    </tr>
                </table>
            </form>

        </div>
        <!-- end page -->
    </div>
    <div id="footer">
        <p class="copyright">&copy;&nbsp;&nbsp;2020 All Rights Reserved &nbsp;&bull;&nbsp; Design by Traffic Violation team.</p>
    </div>
</div>
</body>
</html>