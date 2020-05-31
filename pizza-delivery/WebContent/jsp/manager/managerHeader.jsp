<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Pizza Delivery</title>

    <link href="././css/default.css" rel="stylesheet" type="text/css" media="screen"/>
    <script src="././js/dropdowntabs.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="././css/ddcolortabs.css"/>
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
                            <li><a href="#" rel="dropmenu2"><span>Employee Details</span></a></li>
                            <li><a href="#" rel="dropmenu5"><span>Pizza & Amt</span></a></li>
                            <li><a href="#" rel="dropmenu4"><span>Customer Request</span></a></li>
                            <li><a href="logoff?anchor=logoff"><span>Logoff</span></a></li>
                        </ul>
                    </div>


                    <div id="dropmenu2" class="dropmenudiv_a">
                        <a href="addEmployee?anchor=addEmployee">Add Employee details</a>
                        <a href="addEmployee?anchor=viewEmployee">Modify/Delete Employee details</a>
                    </div>

                    <div id="dropmenu5" class="dropmenudiv_a">
                        <a href="addPizza?anchor=addPizza">Add Pizza Details</a>
                        <a href="viewPizza?anchor=viewPizza">Modify/Delete Pizza Details</a>
                    </div>

                    <div id="dropmenu4" class="dropmenudiv_a">
                        <a href="viewAssignPizza?anchor=viewAssignPizza">View/Assign Pizza Order</a>
                    </div>

                    <script type="text/javascript">
                        //SYNTAX: tabdropdown.init("menu_id", [integer OR "auto"])
                        tabdropdown.init("colortab", 5)
                    </script>
                </div>
            </td>
        </tr>
    </table>


</div>
<!-- end header -->
</body>
</html>