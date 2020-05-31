package college.custom.dao;

import college.custom.model.Registration;
import college.custom.util.ConnectionDb;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public class RegistrationDaoImpl implements RegistrationDao {

    private Connection con;
    public RegistrationDaoImpl() {
        con = ConnectionDb.getConnection();
    }

    @Override
    public int save(Registration reg) {
        try {
            Statement statement = con.createStatement();
            String query = "INSERT INTO REGISTRATION( NAME, ADDRESS, CONTACT_NO, EMAIL_ID, USERNAME, PASSWORD, LEVEL, ACTIVE, DESCRIPTION) " +
                    "VALUES('"+reg.getName()+"','"+reg.getAddress()+"','"+reg.getContactNo()+"','"
                    +reg.getEmailId()+"','"+reg.getUsername()+"','"+reg.getPassword()+"','"
                    +reg.getLevel()+"','"+reg.getStatus()+"','"+reg.getDescription()+"')";
            return statement.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
