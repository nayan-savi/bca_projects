<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {
            if (document.addEmployee.employeeName.value == null || document.addEmployee.employeeName.value == "") {
                alert("Please select  employeeName");
                document.addEmployee.employeeName.focus();
                return false;
            }
            if (document.addEmployee.dateOfJoin.value == null || document.addEmployee.dateOfJoin.value == "") {
                alert("Please Enter dateOfJoin ");
                document.addEmployee.dateOfJoin.focus();
                return false;
            }
            if (document.addEmployee.qualification.value == null || document.addEmployee.qualification.value == "") {
                alert("Please Enter qualification ");
                document.addEmployee.qualification.focus();
                return false;
            }
            if (document.addEmployee.emailId.value == null || document.addEmployee.emailId.value == "") {
                alert("Please Enter emailId ");
                document.addEmployee.emailId.focus();
                return false;
            }
            if (document.addEmployee.contactNo.value == null || document.addEmployee.contactNo.value == "") {
                alert("Please Enter contactNo ");
                document.addEmployee.contactNo.focus();
                return false;
            }
            if (document.addEmployee.fatherName.value == null || document.addEmployee.fatherName.value == "") {
                alert("Please Enter fatherName ");
                document.addEmployee.fatherName.focus();
                return false;
            }
            if (document.addEmployee.motherName.value == null || document.addEmployee.motherName.value == "") {
                alert("Please Enter motherName ");
                document.addEmployee.motherName.focus();
                return false;
            }
            if (document.addEmployee.address.value == null || document.addEmployee.address.value == "") {
                alert("Please Enter address ");
                document.addEmployee.address.focus();
                return false;
            }
            if (document.addEmployee.dob.value == null || document.addEmployee.dob.value == "") {
                alert("Please Enter dob ");
                document.addEmployee.dob.focus();
                return false;
            }
            if (document.addEmployee.username.value == null || document.addEmployee.username.value == "") {
                alert("Please Enter username ");
                document.addEmployee.username.focus();
                return false;
            }
            if (document.addEmployee.password.value == null || document.addEmployee.password.value == "") {
                alert("Please Enter password ");
                document.addEmployee.password.focus();
                return false;
            }
            if (document.addEmployee.designation.value == null || document.addEmployee.designation.value == "") {
                alert("Please Enter designation ");
                document.addEmployee.designation.focus();
                return false;
            }
            if (document.addEmployee.relievingDate.value == null || document.addEmployee.relievingDate.value == "") {
                alert("Please Enter relievingDate ");
                document.addEmployee.relievingDate.focus();
                return false;
            }
            if (document.addEmployee.level.value == "-1") {
                alert("Please Enter level ");
                document.addEmployee.level.focus();
                return false;
            }
            if (document.addEmployee.active.value == null || document.addEmployee.active.value == "" || document.addEmployee.active.value == "-1") {
                alert("Please Enter active ");
                document.addEmployee.active.focus();
                return false;
            }

            document.addEmployee.action = "/employee?anchor=addEmployee";
            document.addEmployee.submit();
        }

    </script>

</head>
<body>
<%@include file="/jsp/manager/managerHeader.jsp" %>
<div id="wrapper">

    <div id="page">
        <%@include file="../login/loginDetails.jsp" %>
        <div align="center">
            <h3 style="color: green">${success}</h3>
            <h3 style="color: red">${errmsg}</h3>
        </div>
        <form action="" name="addEmployee" method="post">
            <h1>ADD EMPLOYEE DETAILS</h1>
            <table>
                <tr>
                    <td>EmployeeName</td>
                    <td><input type="text" name="employeeName"/></td>
                </tr>
                <tr>
                    <td>DateOfJoin</td>
                    <td><input type="text" name="dateOfJoin"/>(Ex:yyyy-mm-dd)</td>
                </tr>
                <tr>
                    <td>Qualification</td>
                    <td><input type="text" name="qualification"/></td>
                </tr>
                <tr>
                    <td>EmailId</td>
                    <td><input type="text" name="emailId"/></td>
                </tr>
                <tr>
                    <td>ContactNo</td>
                    <td><input type="text" name="contactNo"/></td>
                </tr>
                <tr>
                    <td>FatherName</td>
                    <td><input type="text" name="fatherName"/></td>
                </tr>
                <tr>
                    <td>MotherName</td>
                    <td><input type="text" name="motherName"/></td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td><input type="text" name="address"/></td>
                </tr>
                <tr>
                    <td>Dob</td>
                    <td><input type="text" name="dob"/>(Ex:yyyy-mm-dd)</td>
                </tr>

                <tr>
                    <td>Username</td>
                    <td><input type="text" name="username"/></td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td><input type="password" name="password"/></td>
                </tr>
                <tr>
                    <td>Designation</td>
                    <td><input type="text" name="designation"/></td>
                </tr>
                <tr>
                    <td>RelievingDate</td>
                    <td><input type="text" name="relievingDate"/>(Ex:yyyy-mm-dd)</td>
                </tr>

                <tr>
                    <td>Level</td>
                    <td><select name="level">
                        <option value="-1">--select--</option>
                        <option value="1">Manager</option>
                        <option value="2">Employee</option>
                        <%--<option value="3">User</option>--%>
                    </select></td>
                </tr>

                <tr>
                    <td>Active:</td>
                    <td>
                        <select name="active">
                            <option value="-1">--select--</option>
                            <option value="YES">YES</option>
                            <option value="NO">NO</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td colspan="3" align="center"><input type="button" value="Save" onclick="addValue()"></td>
                </tr>

            </table>
        </form>

    </div>
</div>


<%@include file="../footer.jsp" %>
</body>
</html>