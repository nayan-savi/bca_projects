<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Flower Decoration</title>

    <link href="../../css/default.css" rel="stylesheet" type="text/css" media="screen"/>
    <script src="../../js/dropdowntabs.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="../../css/ddcolortabs.css"/>
</head>
<body>
<!-- start header -->
<div id="header">
    <div id="logo">
        <h1>Flower Decoration</h1>
    </div>

    <table align="center" bgcolor="#FFFFFF" width="100%">
        <tr>
            <td>
                <div style="background-color:#C11BC0" align="center">
                    <div id="colortab" class="navigation">
                        <ul>
                            <%--<li><a href="#" rel="dropmenu1"><span>Shop Details</span></a></li>--%>
                            <li><a href="#" rel="dropmenu2"><span>Employee Details</span></a></li>
                            <li><a href="#" rel="dropmenu5"><span>Flowers & Amt</span></a></li>
                            <li><a href="#" rel="dropmenu3"><span>Decoration Type & Amt</span></a></li>
                            <li><a href="#" rel="dropmenu4"><span>Customer Request</span></a></li>
                            <li><a href="ManagerController?anchor=viewSupportRequest"><span>Feedback</span></a></li>
                            <li><a href="/logoff?anchor=logoff"><span>Logoff</span></a></li>
                        </ul>
                    </div>

                    <!--1st drop down menu -->
                    <%--<div id="dropmenu1" class="dropmenudiv_a">
                        <a href="/addShops?anchor=addShops">Add Shop Details</a>
                        <a href="/addShops?anchor=viewOrganisation">Modify/view Shop Details</a>
                    </div>--%>

                    <div id="dropmenu2" class="dropmenudiv_a">
                        <a href="/addEmployee?anchor=addEmployee">Add Employee details</a>
                        <a href="/addEmployee?anchor=viewEmployee">Modify/Delete Employee details</a>
                    </div>

                    <div id="dropmenu5" class="dropmenudiv_a">
                        <a href="/addFlower?anchor=addFlower">Add Flowers Details</a>
                        <a href="/viewFlower?anchor=viewFlower">Modify/Delete Flowers Details</a>
                    </div>

                    <div id="dropmenu3" class="dropmenudiv_a">
                        <a href="/addDecoration?anchor=addDecoration">Add Decoration Type</a>
                        <a href="/viewDecoration?anchor=viewDecoration">Modify/Delete Decoration Type</a>
                    </div>

                    <div id="dropmenu4" class="dropmenudiv_a">
                        <a href="/viewAssignFlower?anchor=viewAssignFlower">View/Assign Flower Order</a>
                        <a href="/viewAssignDecoration?anchor=viewAssignDecoration">View/Assign Decoration Order</a>
                        <%--<a href="/flowerConfirm?anchor=flowerConfirm">Flower Request Confirmation</a>
                        <a href="/decorationConfirm?anchor=decorationConfirm">Decoration Request Confirmation</a>--%>
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