package college.custom.dao;

import college.custom.model.Pizza;
import college.custom.model.PizzaOrder;
import college.custom.util.ConnectionDb;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class PizzaDaoImpl implements PizzaDao {
    private Statement stmt;

    public PizzaDaoImpl() {
        try {
            stmt = ConnectionDb.getConnection().createStatement();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public int save(Pizza pizza) {
        try {
            String query = "INSERT INTO PIZZA (PIZZANAME, PIZZACOST, STATUS, COMMENT) " +
                    "VALUES ('" + pizza.getPizzaName() + "','" + pizza.getPizzaCost() + "','" + pizza.getStatus() + "','" + pizza.getComment() + "')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<Pizza> getActivePizza() {
        List<Pizza> pizzas = new ArrayList<>();
        try {
            String query = "SELECT * FROM PIZZA WHERE STATUS = 'YES'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pizza pizza = new Pizza();
                pizza.setPizzaName(rs.getString("PIZZANAME"));
                pizza.setPizzaCost(rs.getString("PIZZACOST"));
                pizza.setComment(rs.getString("comment"));
                pizzas.add(pizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzas;
    }

    
    @Override
    public int savePizzaRequest(PizzaOrder pizzaOrder) {
        try {
            String query = "INSERT INTO PIZZAORDERS (PIZZANAME, PIZZACOST, REQUEST_DATE, BARGAINING, FINAL_RATE, COMMENT, STATUS, BYCUSTOMER) " +
                    "VALUES ('" + pizzaOrder.getPizzaName() + "','" + pizzaOrder.getPizzaCost()
                    + "','" + pizzaOrder.getRequestDate() + "','" + pizzaOrder.getBargaining()
                    + "','" + pizzaOrder.getFinalRate() + "','" + pizzaOrder.getComment() + "','" + pizzaOrder.getStatus() + "','" +
                    pizzaOrder.getOrderBy() + "')";
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    
    @Override
    public List<PizzaOrder> viewPizzaOrder(String username, int employeeId) {
        List<PizzaOrder> pizzaOrders = new ArrayList<>();
        String query;
        try {
            if (employeeId > 0) {
                query = "SELECT * FROM PIZZAORDERS WHERE ASSIGNEDTO = '" + username + "' AND STATUS NOT IN ('Done')";
            } else {
                query = "SELECT * FROM PIZZAORDERS WHERE BYCUSTOMER = '" + username + "'";
            }
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PizzaOrder pizzaOrder = getPizzaDetails(rs);
                pizzaOrders.add(pizzaOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pizzaOrders;
    }

    @Override
    public List<PizzaOrder> getPendingPizzaOrderManager() {
        List<PizzaOrder> pizzaOrders = new ArrayList<>();
        try {
            String query = "SELECT * FROM PIZZAORDERS WHERE STATUS IN ('Pending', 'Inprogress')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PizzaOrder pizzaOrder = getPizzaDetails(rs);
                pizzaOrders.add(pizzaOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pizzaOrders;
    }

    private PizzaOrder getPizzaDetails(ResultSet rs) throws SQLException {
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setOrderId(rs.getInt("ORDER_ID"));
        pizzaOrder.setPizzaName(rs.getString("PIZZANAME"));
        pizzaOrder.setPizzaCost(rs.getString("PIZZACOST"));
        pizzaOrder.setBargaining(rs.getString("BARGAINING"));
        pizzaOrder.setRequestDate(rs.getString("REQUEST_DATE"));
        pizzaOrder.setAssignedTo(rs.getString("ASSIGNEDTO"));
        pizzaOrder.setDeliveredDate(rs.getString("DELIVERED_DATE"));
        pizzaOrder.setFinalRate(rs.getString("FINAL_RATE"));
        pizzaOrder.setStatus(rs.getString("STATUS"));
        pizzaOrder.setComment(rs.getString("COMMENT"));
        return pizzaOrder;
    }

    @Override
    public int modifyPizzaOrderEmployee(PizzaOrder pizzaOrder) {
        try {
            String query = "UPDATE PIZZAORDERS SET STATUS = '" + pizzaOrder.getStatus() + "', ASSIGNEDTO = '" + pizzaOrder.getAssignedTo()
                    + "', FINAL_RATE = '" + pizzaOrder.getFinalRate() + "', COMMENT = '" + pizzaOrder.getComment() + "', DELIVERED_DATE = '" + pizzaOrder.getDeliveredDate()
                    + "' WHERE ORDER_ID = '" + pizzaOrder.getOrderId() + "'";
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public PizzaOrder getPizzaOrder(int orderId) {
        try {
            String query = "SELECT * FROM PIZZAORDERS WHERE ORDER_ID = '" + orderId + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return getPizzaDetails(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    public int deletePizzaOrderById(String orderId) {
        try {
            String query = "DELETE FROM PIZZAORDERS WHERE ORDER_ID = " + Integer.parseInt(orderId);
            return stmt.executeUpdate(query);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }

    @Override
    public List<PizzaOrder> viewDonePizzaOrder(String username, int employeeId) {
        List<PizzaOrder> pizzaOrders = new ArrayList<>();
        String query;
        try {
            query = "SELECT * FROM PIZZAORDERS WHERE ASSIGNEDTO = '" + username + "' AND STATUS IN ('Done')";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                PizzaOrder pizzaOrder = getPizzaDetails(rs);
                pizzaOrders.add(pizzaOrder);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pizzaOrders;
    }

    
    @Override
    public List<Pizza> getAllPizza() {
        List<Pizza> pizzas = new ArrayList<>();
        try {
            String query = "SELECT * FROM PIZZA";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Pizza pizza = getPizza(rs);
                pizzas.add(pizza);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return pizzas;
    }

    private Pizza getPizza(ResultSet rs) throws SQLException {
        Pizza pizza = new Pizza();
        pizza.setPizzaId(rs.getInt("PIZZAID"));
        pizza.setPizzaName(rs.getString("PIZZANAME"));
        pizza.setPizzaCost(rs.getString("PIZZACOST"));
        pizza.setStatus(rs.getString("STATUS"));
        pizza.setComment(rs.getString("COMMENT"));
        return pizza;
    }

    @Override
    public int updatePizza(Pizza pizza, String id) {
        try {
            String query = "UPDATE PIZZA SET PIZZACOST = '"+pizza.getPizzaCost()+"', STATUS ='"+pizza.getStatus()+"', COMMENT = '"+pizza.getComment()+"' WHERE PIZZAID = "+id;
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

   
    @Override
    public Pizza getPizzaById(String pizzaId) {
        try {
            String query = "SELECT * FROM PIZZA WHERE pizzaid = '" + Integer.parseInt(pizzaId) + "'";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                return getPizza(rs);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

	@Override
	public int deletePizzaById(int pizzaId) {
		try {
            String query = "DELETE FROM PIZZA WHERE PIZZAID = "+pizzaId;
            return stmt.executeUpdate(query);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
	}



}
