<%--
  Created by IntelliJ IDEA.
  User: NAYAN
  Date: 2/25/20
  Time: 11:17 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Facebook</title>
    <link href="../../css/defaultlogin.css" rel="stylesheet" type="text/css" media="screen" />
</head>
<body class="main">
    <div class="header">
        <div class="logo">
            <label>facebook</label>
        </div>
        <div class="page">
            <div align="center">
                <h3 style="color: green">${success}</h3>
                <h3 style="color: red">${errmsg}</h3>
            </div>

            <form action="/login" method="post">
                <table border="0" align="center">
                    <tr>
                        <td>
                            <input name="username" type="text" placeholder="username" value="nayan" style="font-size: 20px" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <input name="password" type="password" placeholder="password" value="nayan" style="font-size: 20px" />
                        </td>
                    </tr>
                    <tr>
                        <td>
                            <div align="center">
                                <input  type="submit" value="Log in" />
                            </div>
                        </td>
                    </tr>
                    <tr>
                        <td align="center" style="padding-top: 40px;" ><a class="reg" href="/registration">Signup for Facebook</a></td>
                    </tr>
                </table>
            </form>

        </div>
    </div>
</body>
</html>
