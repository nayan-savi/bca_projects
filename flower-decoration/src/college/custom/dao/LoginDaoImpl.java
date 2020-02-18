package college.custom.dao;

import college.custom.model.Login;
import college.custom.util.ConnectionDb;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class LoginDaoImpl implements LoginDao {

    private Connection con;

    public LoginDaoImpl() {
        con = ConnectionDb.getConnection();
    }

    @Override
    public Login login(String username, String password) {
        Login login = new Login();
        String query;
        try {
            Statement stmt = con.createStatement();
            query = "select * from registration where USERNAME='"+username+"' and PASSWORD='"+password+"' and active = 'YES'";
            ResultSet result = stmt.executeQuery(query);
            while(result.next()) {
                login.setUsername(username);
            /*    if(!type.equals("3")) {
                    login.setEmployeeId(result.getInt("EMPLOYEE_ID"));
                }*/
                login.setEmailId(result.getString("EMAIL_ID"));
                login.setLevel(result.getInt("LEVEL"));
                login.setActive(result.getString("ACTIVE"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return login;
    }
}
