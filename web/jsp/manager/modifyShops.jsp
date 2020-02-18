<%@page import="college.custom.model.ShopDetails" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Modify Station</title>
</head>
<body>
<%@include file="managerHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <br/>
        <br/>
        <br/>
        <center>
            <form action="<%=request.getContextPath()%>/update?anchor=update" method="post">
                <h1>Modify Station details</h1>
                <% ShopDetails ddata = (ShopDetails) request.getAttribute("shopDetails"); %>
                <table>
                    <tr>
                        <td>
                            <input type="hidden" name="PKORGANISATION_ID" value="<%=ddata.getPKORGANISATION_ID()%>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Station Name:</td>
                        <td><input type="text" name="ORGANISATION_NAME" value="<%=ddata.getORGANISATION_NAME()%>"/></td>
                    </tr>
                    <tr>
                        <td>Address:</td>
                        <td><input type="text" name="ADDRESS" value="<%=ddata.getADDRESS() %>"/></td>
                    </tr>
                    <tr>
                        <td>City:</td>
                        <td><input type="text" name="CITY" value="<%=ddata.getCITY() %>"/></td>
                    </tr>
                    <tr>
                        <td>State:</td>
                        <td><input type="text" name="STATE" value="<%=ddata.getSTATE() %>"/></td>
                    </tr>
                    <tr>
                        <td>Country:</td>
                        <td><input type="text" name="COUNTRY" value="<%=ddata.getCOUNTRY() %>"/></td>
                    </tr>
                    <tr>
                        <td>Pincode:</td>
                        <td><input type="text" name="PINCODE" value="<%=ddata.getPINCODE() %>"/></td>
                    </tr>
                    <tr>
                        <td>Startdate:</td>
                        <td><input type="text" name="STARTDATE" value="<%=ddata.getSTARTDATE() %>"/></td>
                    </tr>
                </table>
                <table>
                    <tr>
                        <td></td>
                        <td><input type="submit" value="update"/>
                            <input type="button" value="cancel"/>
                        </td>
                    </tr>
                </table>
            </form>
        </center>
    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>
