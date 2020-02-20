<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Manager</title>
</head>
<body>
<div style="text-align: right;
    font-size: 14px;
    padding-right: 26px;
    font-weight: bold;
    color: green;">Welcome <%= session.getAttribute("username")%> </div>
</body>
</html>