<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ page import="java.util.List" %>
<%@ page import="college.custom.model.Decoration" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>View Decoration</title>
    <script type="text/javascript">
        function modifyDecoration() {
            var chk = document.decorations.decorationId;
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

            document.decorations.action = "/modifyDecoration?anchor=modifyDecoration&id="+id;
            document.decorations.submit();
        }

        function deleteDecoration() {
            var chk = document.decorations.decorationId;
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

            document.decorations.action = "/deleteDecoration?anchor=deleteDecoration";
            document.decorations.submit();
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
        <% List<Decoration> decorations = (List<Decoration>) request.getAttribute("decorations"); %>
        <form action="" name="decorations" method="post">
            <div style="height:auto;width:auto;border:1px solid #ccc;overflow:auto;">
                <table border="0">
                    <tr class="viewHeader">
                        <td>Decoration Id</td>
                        <td>Decoration Name</td>
                        <td>Decoration Cost</td>
                        <td>Status</td>
                        <td>Comment</td>
                    </tr>
                    <%for (int i = 0; i < decorations.size(); i++) {
                        String status = decorations.get(i).getStatus();
                    %>
                    <tr class="viewData">
                        <td>
                            <input type="checkbox" name="decorationId" value="<%=decorations.get(i).getDecorationId() %>"/>
                            <%=decorations.get(i).getDecorationId()%>
                        </td>
                        <td><%=decorations.get(i).getDecorationName()%></td>
                        <td><%=decorations.get(i).getDecorationCost()%></td>
                        <td>
                            <%=status%>
                        </td>
                        <td><%=decorations.get(i).getComment()%></td>
                    </tr>
                    <% } %>
                </table>
            </div>
            <table>
                <tr>
                    <td><input type="button" value="Modify" onclick="modifyDecoration()"></td>
                    <td><input type="button" value="Delete" onclick="deleteDecoration()"></td>
                </tr>
            </table>
        </form>
    </div>
</div>
<%@include file="../footer.jsp" %>
</body>
</html>