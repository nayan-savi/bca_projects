<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Traffic Violation</title>
    <link href="././css/default.css" rel="stylesheet" type="text/css" media="screen" />
    <script src="././js/dropdowntabs.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../../css/ddcolortabs.css" />
</head>
<script type="text/javascript">
	function loginValidation() {
		var username = document.login.username.value;
		var pwd = document.login.password.value;
		if(username == null || username == "") {
			alert('Username is mandatory');
			document.login.username.focus();
			return false;
		} else if(pwd == null || pwd == "") {
			alert('Password is mandatory');
			document.login.password.focus();
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
                <h3 style="color: green">${success}</h3>
                <h3 style="color: red">${errmsg}</h3>
            </div>
            <form action="login" name="login" method="post" onSubmit="return loginValidation()">
                <table width="333" height="188" border="0" align="center">
                    <tr>
                        <td colspan="2" align="center"><h1>User Login page</h1></td>
                    </tr>
                    <tr>
                        <td width="110">
                            <div align="right">Username</div>
                        </td>
                        <td width="213">
                            <input name="username" type="text" value="admin" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div align="right">Password</div>
                        </td>
                        <td>
                            <input name="password" type="password" value="admin"/>
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div align="center">
                                <input  type="submit" value="Login" />
                            </div>
                        </td>
                        <td>
                            <input name="reset" type="reset" />
                        </td>
                    </tr>
                    <tr>
                        <td align="right"><a href="registration?anchor=reg">User Registration</a></td>
                    </tr>
                </table>
            </form>

        </div>
        <!-- end page -->
    </div>
    <div id="footer">
        <p class="copyright">&copy;&nbsp;&nbsp;2020 All Rights Reserved &nbsp;&bull;&nbsp; Design by Traffic Violation team</a>.</p>
    </div>
</div>
</body>
</html>