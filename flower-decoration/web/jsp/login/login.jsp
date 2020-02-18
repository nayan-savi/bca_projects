<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Flower Decoration</title>
    <link href="../../css/default.css" rel="stylesheet" type="text/css" media="screen" />
    <script src="../../js/dropdowntabs.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../../css/ddcolortabs.css" />

</head>
<body>
<div id="header">
    <div id="logo">
        <h1><span>Flower Decoration</span></h1>
    </div>

    <!-- end header -->
    <div id="wrapper">
        <!-- start page -->
        <div id="page">
            <div align="center">
                <h3 style="color: green">${success}</h3>
            </div>
            <form action="/login" method="post">
                <table width="333" height="188" border="0" align="center">
                    <tr>
                        <td colspan="2" align="center"><h1>User Login page</h1></td>
                    </tr>
                    <tr>
                        <td width="110">
                            <div align="center">Username</div>
                        </td>
                        <td width="213">
                            <input name="username" type="text" value="admin" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div align="center">Password</div>
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
                        <td align="right"><a href="<%=request.getContextPath() %>/jsp/login/registration.jsp">User Registration</a></td>
                    </tr>
                </table>
            </form>

        </div>
        <!-- end page -->
    </div>
    <div id="footer">
        <p class="copyright">&copy;&nbsp;&nbsp;2020 All Rights Reserved &nbsp;&bull;&nbsp; Design by Flower Decoration team</a>.</p>
    </div>
</div>
</body>
</html>