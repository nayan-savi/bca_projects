<%@ page import="college.custom.model.Pizza" %>
<%@ page import="java.util.List" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%
	List<Pizza> pizza = (List<Pizza>) request.getAttribute("pizza");
%>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {
            document.orderPizza.action="orderPizza?anchor=orderPizza";
            var pizzaName = document.orderPizza.pizzaName.value;
        	if(pizzaName == null || pizzaName == "") {
    			alert('Pizza Name is mandatory');
    			document.orderPizza.pizzaName.focus();
    			return false;
    		} 
            document.orderPizza.submit();
        }

        function setCost() {
            selectElement = document.querySelector('#pizzaShowName');
            output = selectElement.options[selectElement.selectedIndex].value;
            document.getElementById('pizzaCost').value = output.split('-')[1].trim();
            document.getElementById('pizzaName').value = output.split('-')[0].trim();
        }
        
    </script>

</head>
<body>
<%@include file="../user/userHeader.jsp" %>
<div id="wrapper">
    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="orderPizza?anchor=orderPizza" name="orderPizza" method="post">
            <h1>Request Pizza</h1>

            <table>
                <tr>
                    <td>Pizza Name</td>
                    <td width="172px">
                        <select name="pizzaShowName" id="pizzaShowName" style="width: 172px" onchange="setCost()">
                            <option></option>
                            <%
                                for (int i = 0; i < pizza.size(); i++) {
                                    String flower = pizza.get(i).getPizzaName();
                                    String cost = pizza.get(i).getPizzaCost();
                            %>
                                <option value="<%=flower%> - <%=cost%> "><%=flower%></option>
                            <% } %>
                        </select>
                    </td>
                </tr>

                <tr style="display:none;">
                    <td><input type="hidden" id="pizzaName" name="pizzaName"  /> </td>
                </tr>

                <tr>
                    <td>Pizza Cost</td>
                    <td><input readonly type="text" name="pizzaCost" id="pizzaCost"/></td>
                </tr>
                <tr>
                    <td>Requested Date</td>
                    <td><input type="text" name="requestDate"/>(Ex:dd-mm-yyyy)</td>
                </tr>
                <tr>
                    <td>Bargaining</td>
                    <td><input type="text" name="bargaining"/></td>
                </tr>
                <tr>
                    <td>Final Rate</td>
                    <td><input readonly="true" type="text" name="finalRate" value=""/></td>
                </tr>
                <tr>
                    <td>Comment</td>
                    <td><input type="text" name="comment"/></td>
                </tr>
                <tr>
                    <td colspan="3" align="center"><input type="button" value="Order" onclick="addValue()"></td>
                </tr>
            </table>
        </form>

    </div>
</div>

<%@include file="../footer.jsp" %>
</body>
</html>
