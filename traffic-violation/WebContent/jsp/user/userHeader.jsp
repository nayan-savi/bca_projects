<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Traffic Violation</title>

    <link href="././css/default.css" rel="stylesheet" type="text/css" media="screen"/>
    <script src="././js/dropdowntabs.js" type="text/javascript"></script>
    <link rel="stylesheet" type="text/css" href="././css/ddcolortabs.css"/>
</head>
<body>
<!-- start header -->
<div id="header">
    <div id="logo">
        <h1>Traffic Violation</h1>
    </div>
    <table align="center" bgcolor="#FFFFFF" width="100%">
        <tr>
            <td>
                <div style="background-color:#C11BC0" align="center">
                    <div id="colortab" class="navigation">
                        <ul>
                            <li><a href="#" rel="dropmenu1"><span>Complaints</span></a></li>
                            <li><a href="logOff?anchor=logOff"><span>LogOff</span></a></li>
                        </ul>
                    </div>

                    <!--1st drop down menu -->
                    <div id="dropmenu1" class="dropmenudiv_a">
                        <a href="myComplaint?anchor=myComplaint">My Complaints</a>
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