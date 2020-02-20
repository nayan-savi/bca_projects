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
            String query = "INSERT INTO FLOWERORDERS (FLOWERNAME, FLOWERCOST, REQUEST_DATE, BARGAINING, FINAL_RATE, COMMENT, STATUS, ORDERBY) " +
                    "VALUES ('" + flowerOrder.getFlowerName() + "','" + flowerOrder.getFlowerCost()
                    + "','" + flowerOrder.getRequestDate() + "','" + flowerOrder.getBargaining()
                    + "','" + flowerOrder.getFinalRate() + "','" + flowerOrder.getComment() + "','"+flowerOrder.getStatus()+"','"+
                    flowerOrder.getOrderBy()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int saveDecorationRequest(DecorationOrder decorationOrder) {
        try {
            String query = "INSERT INTO DECORATIONORDERS (DECORATIONNAME, DECORATIONCOST, REQUEST_DATE, BARGAINING, FINAL_RATE, COMMENT, STATUS, ORDERBY) " +
                    "VALUES ('" + decorationOrder.getDecorationName()+ "','" + decorationOrder.getDecorationCost()
                    + "','" + decorationOrder.getRequestDate() + "','" + decorationOrder.getBargaining()
                    + "','" + decorationOrder.getFinalRate() + "','" + decorationOrder.getComment() + "','"+decorationOrder.getStatus()+"','"+
                    decorationOrder.getOrderBy()+"')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<FlowerOrder> viewFlowerOrder(String username, int employeeId) {
        List<FlowerOrder> flowerOrders = new ArrayList<>();
        String query;
        try {
            if(employeeId > 0) {
                query = "SELECT * FROM FLOWERORDERS WHERE ASSIGNEDTO = '"+username+"'";
            } else {
                query = "SELECT * FROM FLOWERORDERS WHERE ORDERBY = '"+username+"'";
            }
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FlowerOrder flowerOrder = getFlowerDetails(rs);
                flowerOrders.add(flowerOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flowerOrders;
    }

    @Override
    public List<DecorationOrder> viewDecorationOrder(String username, int employeeId) {
        List<DecorationOrder> decorationOrders = new ArrayList<>();
        String query;
        try {
            if(employeeId > 0) {
                query = "SELECT * FROM DECORATIONORDERS WHERE ASSIGNEDTO = '"+username+"'";
            } else {
                query = "SELECT * FROM DECORATIONORDERS WHERE ORDERBY = '"+username+"'";
            }
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DecorationOrder decorationOrder = getDecorationDetails(rs);
                decorationOrders.add(decorationOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decorationOrders;
    }

    private DecorationOrder getDecorationDetails(ResultSet rs) throws SQLException {
        DecorationOrder decorationOrder = new DecorationOrder();
        decorationOrder.setOrderId(rs.getInt("ORDER_ID"));
        decorationOrder.setDecorationName(rs.getString("DECORATIONNAME"));
        decorationOrder.setDecorationCost(rs.getString("DECORATIONCOST"));
        decorationOrder.setRequestDate(rs.getString("REQUEST_DATE"));
        decorationOrder.setAssignedTo(rs.getString("ASSIGNEDTO"));
        decorationOrder.setBargaining(rs.getString("BARGAINING"));
        decorationOrder.setDeliveredDate(rs.getString("DELIVERED_DATE"));
        decorationOrder.setStatus(rs.getString("STATUS"));
        decorationOrder.setFinalRate(rs.getString("FINAL_RATE"));
        decorationOrder.setComment(rs.getString("COMMENT"));
        return decorationOrder;
    }


    @Override
    public List<FlowerOrder> getPendingFlowerOrderManager() {
        List<FlowerOrder> flowerOrders = new ArrayList<>();
        try {
            String query = "SELECT * FROM FLOWERORDERS WHERE STATUS IN ('Pending', 'Inprogress')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                FlowerOrder flowerOrder = getFlowerDetails(rs);
                flowerOrders.add(flowerOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flowerOrders;
    }

    private FlowerOrder getFlowerDetails(ResultSet rs) throws SQLException {
        FlowerOrder flowerOrder = new FlowerOrder();
        flowerOrder.setOrderId(rs.getInt("ORDER_ID"));
        flowerOrder.setFlowerName(rs.getString("FLOWERNAME"));
        flowerOrder.setFlowerCost(rs.getString("FLOWERCOST"));
        flowerOrder.setBargaining(rs.getString("BARGAINING"));
        flowerOrder.setRequestDate(rs.getString("REQUEST_DATE"));
        flowerOrder.setAssignedTo(rs.getString("ASSIGNEDTO"));
        flowerOrder.setDeliveredDate(rs.getString("DELIVERED_DATE"));
        flowerOrder.setFinalRate(rs.getString("FINAL_RATE"));
        flowerOrder.setStatus(rs.getString("STATUS"));
        flowerOrder.setComment(rs.getString("COMMENT"));
        return flowerOrder;
    }

    @Override
    public List<DecorationOrder> getPendingDecorationOrderManager() {
        List<DecorationOrder> decorationOrders = new ArrayList<>();
        try {
            String query = "SELECT * FROM DECORATIONORDERS WHERE STATUS IN ('Pending', 'Inprogress')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                DecorationOrder decorationOrder = getDecorationDetails(rs);
                decorationOrders.add(decorationOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return decorationOrders;
    }

    @Override
    public int modifyFlowerOrderManager(FlowerOrder flowerOrder) {
        try {
            String query = "UPDATE FLOWERORDERS SET STATUS = '"+flowerOrder.getStatus()+"', ASSIGNEDTO = '"+flowerOrder.getAssignedTo()
                    +"', FINAL_RATE = '"+flowerOrder.getFinalRate()+"', COMMENT = '"+flowerOrder.getComment()+"' WHERE ORDER_ID = '"+flowerOrder.getOrderId()+"'";
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public int modifyDecorationOrderManager(DecorationOrder decorationOrder) {
        try {
            String query = "UPDATE DECORATIONORDERS SET STATUS = '"+decorationOrder.getStatus()+"', ASSIGNEDTO = '"+decorationOrder.getAssignedTo()
                    +"', FINAL_RATE = '"+decorationOrder.getFinalRate()+"', COMMENT = '"+decorationOrder.getComment()+"' WHERE ORDER_ID = '"+decorationOrder.getOrderId()+"'";
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public FlowerOrder getFlowerOrder(int orderId) {
        try {
            String query = "SELECT * FROM FLOWERORDERS WHERE ORDER_ID = '"+orderId+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
               return getFlowerDetails(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public DecorationOrder getDecorationOrder(int orderId) {
        try {
            String query = "SELECT * FROM DECORATIONORDERS WHERE ORDER_ID = '"+orderId+"'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return getDecorationDetails(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
