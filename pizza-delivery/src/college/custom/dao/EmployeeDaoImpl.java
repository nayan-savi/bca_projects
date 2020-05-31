package college.custom.dao;

import college.custom.model.Employee;
import college.custom.util.ConnectionDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDaoImpl implements EmployeeDao {

	private Statement stmt;

	public EmployeeDaoImpl() {
		try {
			stmt = ConnectionDb.getConnection().createStatement();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public int saveEmployee(Employee employee) {
		try {
			String query = "INSERT INTO EMPLOYEEDETAILS (EMPLOYEE_NAME, EMP_JOINDATE, QUALIFICATION, EMAIL_ID, CONTACTNO, "
					+ "FATHERNAME, MOTHERNAME, ADDRESS, DOB, USERNAME, PASSWORD, DESIGNATION, RELIVINGDATE, LEVEL, ACTIVE) "
					+ "VALUES ('" + employee.getEmployeeName() + "', '" + employee.getDateOfJoin() + "', '"
					+ employee.getQualification() + "', '" + employee.getEmailId() + "', '" + employee.getContactNo()
					+ "', '" + employee.getFatherName() + "', '" + employee.getMotherName() + "', '"
					+ employee.getAddress() + "', '" + employee.getDob() + "', '" + employee.getUsername() + "', '"
					+ employee.getPassword() + "', '" + employee.getDesignation() + "', '" + employee.getRelievingDate()
					+ "', '" + employee.getLevel() + "', '" + employee.getActive() + "')";
			String reg = "INSERT INTO REGISTRATION (NAME, ADDRESS, CONTACT_NO, EMAIL_ID, USERNAME, PASSWORD, LEVEL, ACTIVE) "
					+ "VALUES('" + employee.getEmployeeName() + "','" + employee.getAddress() + "','"
					+ employee.getContactNo() + "','" + employee.getEmailId() + "','" + employee.getUsername() + "','"
					+ employee.getPassword() + "','" + employee.getLevel() + "','" + employee.getActive() + "')";

			String updateEmpId = "UPDATE REGISTRATION SET EMPLOYEE_ID = (SELECT EMPLOYEE_ID FROM EMPLOYEEDETAILS WHERE USERNAME = '"
					+ employee.getUsername() + "')  WHERE USERNAME = '" + employee.getUsername() + "'";

			stmt.addBatch(query);
			stmt.addBatch(reg);
			stmt.addBatch(updateEmpId);
			int[] rows = stmt.executeBatch();
			return (rows[0] * rows[1]);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<Employee> viewEmployee() {
		List<Employee> employees = new ArrayList<>();
		try {
			String query = "SELECT * FROM EMPLOYEEDETAILS WHERE USERNAME NOT IN ('admin') AND ACTIVE = 'YES'";
			ResultSet rs = stmt.executeQuery(query);
			while (rs.next()) {
				Employee employee = new Employee();
				employee.setEmployeeId(rs.getInt("EMPLOYEE_ID"));
				employee.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
				employee.setDateOfJoin(rs.getString("EMP_JOINDATE"));
				employee.setQualification(rs.getString("QUALIFICATION"));
				employee.setEmailId(rs.getString("EMAIL_ID"));
				employee.setContactNo(rs.getString("CONTACTNO"));
				employee.setFatherName(rs.getString("FATHERNAME"));
				employee.setMotherName(rs.getString("MOTHERNAME"));
				employee.setAddress(rs.getString("ADDRESS"));
				employee.setDob(rs.getString("DOB"));
				employee.setUsername(rs.getString("USERNAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setDesignation(rs.getString("DESIGNATION"));
				employee.setRelievingDate(rs.getString("RELIVINGDATE"));
				employee.setLevel(rs.getInt("LEVEL"));
				employee.setActive(rs.getString("ACTIVE"));
				employees.add(employee);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return employees;
	}

	@Override
	public Employee modifyEmployee(int employeeId) {
		Employee employee = new Employee();
		try {
			ResultSet rs = stmt.executeQuery("SELECT * FROM EMPLOYEEDETAILS WHERE EMPLOYEE_ID='" + employeeId + "'");
			while (rs.next()) {
				employee.setEmployeeName(rs.getString("EMPLOYEE_NAME"));
				employee.setDateOfJoin(rs.getString("EMP_JOINDATE"));
				employee.setQualification(rs.getString("QUALIFICATION"));
				employee.setEmailId(rs.getString("EMAIL_ID"));
				employee.setContactNo(rs.getString("CONTACTNO"));
				employee.setFatherName(rs.getString("FATHERNAME"));
				employee.setMotherName(rs.getString("MOTHERNAME"));
				employee.setAddress(rs.getString("ADDRESS"));
				employee.setDob(rs.getString("DOB"));
				employee.setUsername(rs.getString("USERNAME"));
				employee.setPassword(rs.getString("PASSWORD"));
				employee.setDesignation(rs.getString("DESIGNATION"));
				employee.setRelievingDate(rs.getString("RELIVINGDATE"));
				employee.setLevel(rs.getInt("LEVEL"));
				employee.setActive(rs.getString("ACTIVE"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return employee;
	}

	@Override
	public int updateEmployee(Employee employee) {
		try {
			String query = "UPDATE EMPLOYEEDETAILS SET " + "EMPLOYEE_NAME = '" + employee.getEmployeeName() + "',"
					+ "EMP_JOINDATE = '" + employee.getDateOfJoin() + "'," + "QUALIFICATION = '"
					+ employee.getQualification() + "'," + "EMAIL_ID = '" + employee.getEmailId() + "',"
					+ "CONTACTNO = '" + employee.getContactNo() + "'," + "FATHERNAME = '" + employee.getFatherName()
					+ "'," + "MOTHERNAME = '" + employee.getMotherName() + "'," + "ADDRESS = '" + employee.getAddress()
					+ "'," + "DOB = '" + employee.getDob() + "'," + "USERNAME = '" + employee.getUsername() + "',"
					+ "PASSWORD = '" + employee.getPassword() + "'," + "DESIGNATION = '" + employee.getDesignation()
					+ "'," + "RELIVINGDATE = '" + employee.getRelievingDate() + "'," + "LEVEL = '" + employee.getLevel()
					+ "'," + "ACTIVE = '" + employee.getActive() + "'" + " WHERE EMPLOYEE_ID = '"
					+ employee.getEmployeeId() + "'";
			return stmt.executeUpdate(query);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
