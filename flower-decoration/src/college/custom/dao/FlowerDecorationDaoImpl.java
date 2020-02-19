package college.custom.dao;

import college.custom.model.Decoration;
import college.custom.model.DecorationOrder;
import college.custom.model.Flower;
import college.custom.model.FlowerOrder;
import college.custom.util.ConnectionDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class FlowerDecorationDaoImpl implements FlowerDecorationDao {
    private Statement stmt;

    public FlowerDecorationDaoImpl() {
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
                    "VALUES ('" + flower.getFlowerName() + "','" + flower.getFlowerCost() + "','" + flower.getStatus() + "','" + flower.getComment() + "')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Flower> getAllFlowers() {
        List<Flower> flowers = new ArrayList<>();
        try {
            String query = "SELECT * FROM FLOWERS WHERE STATUS = 'YES'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Flower flower = new Flower();
                flower.setFlowerName(rs.getString("flowername"));
                flower.setFlowerCost(rs.getString("flowercost"));
                flower.setComment(rs.getString("comment"));
                flowers.add(flower);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return flowers;
    }

    @Override
    public List<Decoration> getAllDecorations() {
        List<Decoration> decorations = new ArrayList<>();
        try {
            String query = "SELECT * FROM DECORATIONS WHERE STATUS = 'YES'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Decoration decoration = new Decoration();
                decoration.setDecorationName(rs.getString("decorationname"));
                decoration.setDecorationCost(rs.getString("decorationcost"));
                decoration.setComment(rs.getString("comment"));
                decorations.add(decoration);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return decorations;
    }

    @Override
    public int saveFlowerRequest(FlowerOrder flowerOrder) {
        try {
            String query = "INSERT INTO FLOWERORDERS (FLOWERNAME, FLOWERCOST, REQUEST_DATE, BARGAINING, FINAL_RATE, COMMENT, STATUS) " +
                    "VALUES ('" + flowerOrder.getFlowerName() + "','" + flowerOrder.getFlowerCost()
                    + "','" + flowerOrder.getRequestDate() + "','" + flowerOrder.getBargaining()
                    + "','" + flowerOrder.getFinalRate() + "','" + flowerOrder.getComment() + "','"+flowerOrder.getStatus()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int saveDecorationRequest(DecorationOrder decorationOrder) {
        try {
            String query = "INSERT INTO DECORATIONORDERS (DECORATIONNAME, DECORATIONCOST, REQUEST_DATE, BARGAINING, FINAL_RATE, COMMENT, STATUS) " +
                    "VALUES ('" + decorationOrder.getDecorationName()+ "','" + decorationOrder.getDecorationCost()
                    + "','" + decorationOrder.getRequestDate() + "','" + decorationOrder.getBargaining()
                    + "','" + decorationOrder.getFinalRate() + "','" + decorationOrder.getComment() + "','"+decorationOrder.getStatus()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<FlowerOrder> viewFlowerOrder() {
        List<FlowerOrder> flowerOrders = new ArrayList<>();
        try {
            String query = "SELECT * FROM FLOWERORDERS";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FlowerOrder flowerOrder = new FlowerOrder();
                flowerOrder.setOrderId(rs.getInt("ORDER_ID"));
                flowerOrder.setFlowerName(rs.getString("FLOWERNAME"));
                flowerOrder.setFlowerCost(rs.getString("FLOWERCOST"));
                flowerOrder.setRequestDate(rs.getString("REQUEST_DATE"));
                flowerOrder.setDeliveredDate(rs.getString("DELIVERED_DATE"));
                flowerOrder.setStatus(rs.getString("STATUS"));
                flowerOrder.setComment(rs.getString("COMMENT"));
                flowerOrders.add(flowerOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flowerOrders;
    }

    @Override
    public List<DecorationOrder> viewDecorationOrder() {
        List<DecorationOrder> decorationOrders = new ArrayList<>();
        try {
            String query = "SELECT * FROM DECORATIONORDERS";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DecorationOrder decorationOrder = new DecorationOrder();
                decorationOrder.setOrderId(rs.getInt("ORDER_ID"));
                decorationOrder.setDecorationName(rs.getString("DECORATIONNAME"));
                decorationOrder.setDecorationCost(rs.getString("DECORATIONCOST"));
                decorationOrder.setRequestDate(rs.getString("REQUEST_DATE"));
                decorationOrder.setDeliveredDate(rs.getString("DELIVERED_DATE"));
                decorationOrder.setStatus(rs.getString("STATUS"));
                decorationOrder.setComment(rs.getString("COMMENT"));
                decorationOrders.add(decorationOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decorationOrders;
    }
}
