package college.custom.dao;

import college.custom.model.Flower;
import college.custom.util.ConnectionDb;

import java.sql.SQLException;
import java.sql.Statement;

public class FlowerDaoImpl implements FlowerDao {
    private Statement stmt;

    public FlowerDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Flower flower) {
        try {
            String query = "INSERT INTO FLOWERS (FLOWERNAME, FLOWERCOST, STATUS, COMMENT) " +
                    "VALUES ('"+flower.getFlowerName()+"','"+flower.getFlowerCost()+"','"+flower.getStatus()+"','"+flower.getComment()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
