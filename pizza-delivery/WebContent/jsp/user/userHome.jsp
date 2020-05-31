<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Pizza Delivery</title>

    <link href="../../css/default.css" rel="stylesheet" type="text/css" media="screen"/>
    <script src="../../js/dropdowntabs.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../../css/ddcolortabs.css"/>

</head>
<body>
<%@include file="userHeader.jsp" %>
<div id="wrapper">
    <!-- start page -->
    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <!-- start content -->
        <div id="content">
            <div class="post">
                <h2 class="title"></h2>
                <p class="byline"></p>
            </div>
        </div>
        <!-- end content -->
        <!-- start sidebars -->
        <!-- end sidebars -->
        <div style="clear: both;">&nbsp;</div>
    </div>
<%@include file="../footer.jsp" %>
</body>
</html>
