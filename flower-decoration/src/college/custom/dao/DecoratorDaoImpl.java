package college.custom.dao;

import college.custom.model.Decoration;
import college.custom.util.ConnectionDb;

import java.sql.SQLException;
import java.sql.Statement;

public class DecoratorDaoImpl implements DecoratorDao {

    private Statement stmt;

    public DecoratorDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Decoration decoration) {
        try {
            String query = "INSERT INTO DECORATIONS (DECORATIONNAME, DECORATIONCOST, STATUS, COMMENT) " +
                    "VALUES ('"+ decoration.getDecorationName()+"','"+ decoration.getDecorationCost()+"','"+ decoration.getStatus()+"','"+ decoration.getComment()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
