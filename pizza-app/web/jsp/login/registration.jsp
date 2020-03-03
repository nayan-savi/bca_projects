<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Registration</title>
    <link href="../../css/defaultlogin.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body class="main">
<div id="header">

    <!-- end header -->
    <div id="wrapper">
        <!-- start page -->
        <div id="page">
            <div align="center">
                <h3 style="color: red">${errmsg}</h3>
            </div>
            <form action="/registration" method="post">

                <table border="0" align="center">
                    <tr>
                        <td colspan="2" align="center"><h1>User Registration</h1></td>
                    </tr>
                    <tr>
                        <td>
                            <div align="center">Name</div>
                        </td>
                        <td>
                            <input name="name" type="text" />
                        </td>
                    </tr>

                    <tr>
                        <td >
                            <div align="center">EmailId</div>
                        </td>
                        <td >
                            <input name="emailId" type="text" />
                        </td>
                    </tr>

                    <tr>
                        <td >
                            <div align="center">ContactNo</div>
                        </td>
                        <td >
                            <input name="contactNo" type="text" />
                        </td>
                    </tr>

                    <tr>
                        <td >
                            <div align="center">Address</div>
                        </td>
                        <td >
                            <textarea name="address" cols="30" rows="10"></textarea>
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
                    <table border="0" align="center">
                        <tr>
                            <td><input  type="submit" value="Register" /></td>
                            <td><input type="reset" value="Reset" /></td>
                        </tr>
                        <tr>
                            <td><a href="login.jsp">Click here for Login</a></td>
                        </tr>
                    </table>


                </table>
            </form>
        </div>
        <!-- end page -->
    </div>
    <div id="footer">
        <p class="copyright">&copy;&nbsp;&nbsp;2020 All Rights Reserved &nbsp;&bull;&nbsp; Design by Pizza app team</a>.</p>
    </div>
</div>
</body>
</html>