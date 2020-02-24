<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.Flower" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Flower</title>
    <script type="text/javascript">
        function cancelFlower() {
            var chk = document.flowers.flowerId;
            var count = 0;
            var id = 0;
            if (chk.length == undefined) {
                if (chk.checked == true) {
                    count++;
                }
            }
            for (var i = 0; i < chk.length; i++) {
                if (chk[i].checked == true) {
                    id = chk[i].value;
                    count++;
                }
            }

            if (count == 0) {
                alert("Please selected at least one checkbox");
                return false;
            }
            if (count > 1) {
                alert("Please select only one checkbox");
                return false;
            }

            document.flowers.action = "/cancelFlower?anchor=cancelFlower";
            document.flowers.submit();
        }
    </script>
</head>
<style>
    .viewHeader {
        font-weight: bold;
        background-color: lightgrey;
    }

    .viewHeader>td {
        padding: 10px 20px;
    }

    .viewData {
        text-align: center;
        font-size: 14px;
    }

    .viewData>td{
        padding-top: 10px;
        padding-bottom: 10px;
    }
</style>
<body>
<%@include file="managerHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <% Flower flower = (Flower) request.getAttribute("flower"); %>
        <form action="/updateFlower?anchor=updateFlower" name="flowers" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">

                    <tr>
                        <td>
                            <input type="hidden" name="flowerId" value="<%=flower.getFlowerId() %>"/>
                        </td>
                    </tr>
                    <tr>
                        <td>Flower Name</td>
                        <td><input readonly="true" type="text" name="flowerName" value="<%=flower.getFlowerName() %>"/></td>
                    </tr>
                    <tr>
                        <td>Flower Cost</td>
                        <td><input type="text" name="flowerCost" value="<%=flower.getFlowerCost() %>"/></td>
                    </tr>

                    <tr>
                        <td>Status</td>
                        <td>
                            <select name="status">
                                <option value="<%=flower.getStatus()%>" hidden selected><%=flower.getStatus()%></option>
                                <option value=""></option>
                                <option value="YES">YES</option>
                                <option value="NO">NO</option>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td>Comment</td>
                        <td><input type="text" name="comment" value="<%=flower.getComment() %>"/></td>
                    </tr>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="submit" value="Update"></td>
                    <td><input type="button" value="Cancel" onclick="cancelFlower()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>