package college.custom.dao;

import college.custom.model.Pizza;
import college.custom.model.PizzaOrder;

import java.util.List;

public interface PizzaDao {
	
    int save(Pizza pizza);
    int savePizzaRequest(PizzaOrder pizzaOrder);
    List<Pizza> getActivePizza();
    List<PizzaOrder> viewPizzaOrder(String username, int employeeId);
    List<PizzaOrder> getPendingPizzaOrderManager();
    int modifyPizzaOrderEmployee(PizzaOrder pizzaOrder);
    PizzaOrder getPizzaOrder(int orderId);
    int deletePizzaOrderById(String orderId);
    List<PizzaOrder> viewDonePizzaOrder(String username, int employeeId);
    List<Pizza> getAllPizza();
    int updatePizza(Pizza pizza, String id);
    Pizza getPizzaById(String pizzaId);
    int deletePizzaById(int pizzaId);

}
