<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@page import="java.util.ArrayList" %>
<%@page import="college.custom.model.Manager" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <title>Insert title here</title>
    <script type="text/javascript">

        function addValue() {
            if (document.employee.employeeName.value == null || document.employee.employeeName.value == "") {
                alert("Please select  employeeName");
                document.employee.employeeName.focus();
                return false;
            }
            if (document.employee.dateOfJoin.value == null || document.employee.dateOfJoin.value == "") {
                alert("Please enter dateOfJoin ");
                document.employee.dateOfJoin.focus();
                return false;
            }
            if (document.employee.qualification.value == null || document.employee.qualification.value == "") {
                alert("Please enter qualification ");
                document.employee.qualification.focus();
                return false;
            }
            if (document.employee.emailId.value == null || document.employee.emailId.value == "") {
                alert("Please enter emailId ");
                document.employee.emailId.focus();
                return false;
            }
            if (document.employee.contactNo.value == null || document.employee.contactNo.value == "") {
                alert("Please enter contactNo ");
                document.employee.contactNo.focus();
                return false;
            }
            if (document.employee.fatherName.value == null || document.employee.fatherName.value == "") {
                alert("Please enter fatherName ");
                document.employee.fatherName.focus();
                return false;
            }
            if (document.employee.motherName.value == null || document.employee.motherName.value == "") {
                alert("Please enter motherName ");
                document.employee.motherName.focus();
                return false;
            }
            if (document.employee.address.value == null || document.employee.address.value == "") {
                alert("Please enter address ");
                document.employee.address.focus();
                return false;
            }
            if (document.employee.dob.value == null || document.employee.dob.value == "") {
                alert("Please enter dob ");
                document.employee.dob.focus();
                return false;
            }
            if (document.employee.username.value == null || document.employee.username.value == "") {
                alert("Please enter username ");
                document.employee.username.focus();
                return false;
            }
            if (document.employee.password.value == null || document.employee.password.value == "") {
                alert("Please enter password ");
                document.employee.password.focus();
                return false;
            }
            if (document.employee.designation.value == null || document.employee.designation.value == "") {
                alert("Please enter designation ");
                document.employee.designation.focus();
                return false;
            }
            if (document.employee.relievingDate.value == null || document.employee.relievingDate.value == "") {
                alert("Please enter relievingDate ");
                document.employee.relievingDate.focus();
                return false;
            }
            if (document.employee.level.value == "-1") {
                alert("Please enter level");
                document.employee.level.focus();
                return false;
            }
            if (document.employee.active.value == null || document.employee.active.value == "" || document.employee.active.value == "-1") {
                alert("Please enter active ");
                document.employee.active.focus();
                return false;
            }

            document.employee.action = "<%=request.getContextPath()%>/ManagerController?anchor=saveEmployee";
            document.employee.submit();
        }

    </script>

</head>
<body>
<%@include file="../manager/managerHeader.jsp" %>
<div id="wrapper">
    <div id="page">
        <form action="" name="employee" method="post">
            <h6>${success}</h6>
            <h6>${errmsg}</h6>
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
                    <td><input type="text" name="adress"/></td>
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
                    <td><input type="text" name="password"/></td>
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
                    <td>
                        <select name="level">
                            <option value="-1">-- select --</option>
                            <option value="1">Manager</option>
                            <option value="2">Employee</option>
                            <option value="3">User</option>
                        </select>
                    </td>
                </tr>

                <tr>
                    <td>Active</td>
                    <td>
                        <select name="active">
                            <option value="-1">-- select --</option>
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