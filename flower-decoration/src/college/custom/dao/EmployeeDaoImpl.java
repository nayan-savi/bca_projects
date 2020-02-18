package college.custom.dao;

import college.custom.model.Employee;
import college.custom.model.User;
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
    public List<User> getSupports() {
        List<User> list = new ArrayList<>();
        try {
            String query = "select * from user_support_tbl where status is null";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                User user = new User();
                user.setComplaint(rs.getString("CLIENT_COMPLAINT"));
                user.setDescription(rs.getString("DESCRIPTION"));
                user.setEmployeeReply(rs.getString("EMPLOYEE_REPLY"));
                user.setManagerReply(rs.getString("MANAGER_REPLY"));
                user.setStatus(rs.getString("STATUS"));
                user.setSupportId(rs.getInt("PK_USER_SUPPORT_ID"));
                query = "select * from project_tbl where PK_PROJECT_ID =" + rs.getInt("FK_PROJECT_ID");
                ResultSet rs1 = stmt.executeQuery(query);
                while (rs1.next()) {
                    user.setProjectName(rs1.getString("PROJECT_NAME"));
                }
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return list;
    }

    @Override
    public List<User> getResolveSupports(int userId) {
        return null;
    }

    @Override
    public int startSupportRequest(int userId, int supportId) {
        return 0;
    }

    @Override
    public User modifySupportRequest(int supportId) {
        return null;
    }

    @Override
    public int updateSupportRequest(int supportId, String reply) {
        return 0;
    }

    @Override
    public List<User> getReplies(int userId) {
        return null;
    }

    @Override
    public int saveEmployee(Employee employee) {
        try {

            String query = "INSERT INTO EMPLOYEEDETAILS (EMPLOYEE_NAME, EMP_JOINDATE, QUALIFICATION, EMAIL_ID, CONTACTNO, " +
                    "FATHERNAME, MOTHERNAME, ADDRESS, DOB, USERNAME, PASSWORD, DESIGNATION, RELIVINGDATE, LEVEL, ACTIVE) " +
                    "VALUES ('"+employee.getEmployeeName()+"', '"+employee.getDateOfJoin()+"', '"+employee.getQualification()
                    +"', '"+employee.getEmailId()+"', '"+employee.getContactNo()+"', '"+employee.getFatherName()+"', '"+
                    employee.getMotherName()+"', '"+employee.getAddress()+"', '"+employee.getDob()+"', '"+employee.getUsername()
                    +"', '"+employee.getPassword()+"', '"+employee.getDesignation()+"', '"+employee.getRelievingDate()+"', '"+employee.getLevel()
                    +"', '"+employee.getActive()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
