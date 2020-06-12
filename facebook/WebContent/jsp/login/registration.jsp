<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <link href="././css/defaultlogin.css" rel="stylesheet" type="text/css" media="screen" />
    <style>
        .same {
	        width: 100%;
		    padding: 12px 20px;
		    margin: 8px 0;
		    display: inline-block;
		    border: 1px solid #ccc;
		    border-radius: 4px;
		    box-sizing: border-box;
    	}
    </style>
</head>
<script type="text/javascript">
	function validateForm() {
		var name = document.reg.name.value;
		var username = document.reg.username.value;
		var pwd = document.reg.password.value;
		var email = document.reg.emailId.value;
		var contactNo = document.reg.contactNo.value;
		if(name == null || name == "") {
			alert('Name is manadatory');
			document.reg.name.focus();
			return false;
		} else if(username == null || username == "") {
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
		} else if(contactNo != null || contactNo != "") {
			if(contactNo.length != 10) {
				alert('Contact Number is invalid');
				document.reg.contactNo.focus();
				return false;
			}
		}
	}
</script>
<body class="main">
<div id="header">
    <div class="logo">
        <label>User Registration</label>
    </div>
    <!-- end header -->
    <div id="wrapper">
        <!-- start page -->
        <div id="page">
            <div align="center">
                <h3 style="color: red">${errmsg}</h3>
            </div>
            <form action="registration" name="reg" method="post" onSubmit="return validateForm()">
                <table border="0" align="center">
                    <tr>
                        <td>
                            <div align="center">Name</div>
                        </td>
                        <td>
                            <input name="name" type="text" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <div align="center">EmailId</div>
                        </td>
                        <td>
                            <input name="emailId" type="text" />
                        </td>
                    </tr>

                    <tr>
                        <td>
                            <div align="center">ContactNo</div>
                        </td>
                        <td>
                            <input name="contactNo" type="number" class="same" />
                        </td>
                    </tr>

                    <tr>
                        <td >
                            <div align="center">Address</div>
                        </td>
                        <td >
                            <textarea name="address" cols="50" rows="10" class="same"></textarea>
                        </td>
                    </tr>
                    <tr>
                        <td >
                            <div align="center">Username</div>
                        </td>
                        <td >
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
                </table>
                <table border="0" align="center">
                        <tr>
                            <td><input  type="submit" value="Register" /></td>
                            <td><input type="reset" value="Reset" /></td>
                        </tr>
                        <tr>
                            <td><a href="log?anchor=log">Click here for Login</a></td>
                        </tr>
                </table>
            </form>
        </div>
        <!-- end page -->
    </div>
    <div id="footer">
        <p class="copyright">&copy;&nbsp;&nbsp;2020 All Rights Reserved &nbsp;&bull;&nbsp; Design by Facebook app team</a>.</p>
    </div>
</div>
</body>
</html>