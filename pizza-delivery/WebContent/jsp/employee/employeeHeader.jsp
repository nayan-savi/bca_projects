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
<!-- start header -->
<div id="header">
    <div id="logo">
        <h1>Pizza Delivery</h1>
    </div>
    <table align="center" bgcolor="#FFFFFF" width="100%">
        <tr>
            <td>
                <div style="background-color:#C11BC0" align="center">
                    <div id="colortab" class="navigation">
                        <ul>
                            <li><a href="#" rel="dropmenu1"><span>Pizza</span></a></li>
                            <li><a href="logoff?anchor=logoff"><span>Logoff</span></a></li>
                        </ul>
                    </div>

                    <!--1st drop down menu -->
                    <div id="dropmenu1" class="dropmenudiv_a">
                        <a href="viewEmpPizzaOrder?anchor=viewEmpPizzaOrder">Modify Pizza Request</a>
                        <a href="viewEmpDonePizzaOrder?anchor=viewEmpDonePizzaOrder">View Processed Pizza Request</a>
                        <%--<a href="EmployeeController?anchor=viewSupportRequest">Modify Flower Request</a>--%>
                    </div>

                    <script type="text/javascript">
                        //SYNTAX: tabdropdown.init("menu_id", [integer OR "auto"])
                        tabdropdown.init("colortab", 3)
                    </script>
                </div>
            </td>
        </tr>
    </table>
</div>
<!-- end header -->
</body>

</html>