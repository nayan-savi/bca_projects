package college.custom.controller;

import college.custom.dao.PizzaDao;
import college.custom.dao.PizzaDaoImpl;
import college.custom.model.Pizza;
import college.custom.model.PizzaOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderController")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        String orderId = request.getParameter("id");
        HttpSession session = request.getSession();
        PizzaDao pizzaDao = new PizzaDaoImpl();
        RequestDispatcher rd;
        int row = -1;
        String data = null;
        String username = (String) session.getAttribute("username");
        if (anchor.equalsIgnoreCase("orderPizza")) {
            PizzaOrder pizzaOrder = getPizzaOrder(request, username);
            row = pizzaDao.savePizzaRequest(pizzaOrder);
            data = "Pizza";
        } else if (anchor.equalsIgnoreCase("deleteFlowerRequest")) {
            String orderIdQuery = request.getParameter("orderId");
            row = pizzaDao.deletePizzaOrderById(orderIdQuery);
            if(row > 0) {
                sendResponse(request, response, orderId);
                return;
            }
        } 

        if (row > 0) {
            rd = request.getRequestDispatcher("jsp/user/userHome.jsp");
            request.setAttribute("success", data+ " order saved successfully.");
            rd.forward(request, response);
        } else if(row == 0) {
            rd = request.getRequestDispatcher("jsp/orders/" + anchor + ".jsp");
            request.setAttribute("errmsg", data +" ordered already, please check in view to check status.");
            rd.forward(request, response);
        }
    }

    private void sendResponse(HttpServletRequest request, HttpServletResponse response, String orderId) throws ServletException, IOException {
        RequestDispatcher rd;
        request.setAttribute("success", "Order Id: " + orderId + " has been deleted.");
        rd = request.getRequestDispatcher("jsp/user/userHome.jsp");
        rd.forward(request, response);
    }

    private PizzaOrder getPizzaOrder(HttpServletRequest request, String username) {
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setPizzaName(request.getParameter("pizzaName"));
        pizzaOrder.setPizzaCost(request.getParameter("pizzaCost"));
        pizzaOrder.setRequestDate(request.getParameter("requestDate"));
        pizzaOrder.setBargaining(request.getParameter("bargaining"));
        pizzaOrder.setFinalRate(request.getParameter("finalRate") == null ? "" : request.getParameter("finalRate"));
        pizzaOrder.setComment(request.getParameter("comment"));
        pizzaOrder.setOrderBy(username);
        pizzaOrder.setStatus("Pending");
        return pizzaOrder;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String anchor = request.getParameter("anchor");
        PizzaDao flowerDecorationDao = new PizzaDaoImpl();
        RequestDispatcher rd;
        String username = (String) session.getAttribute("username");
        if (anchor.equalsIgnoreCase("orderPizza")) {
            List<Pizza> pizza = flowerDecorationDao.getActivePizza();
            rd = request.getRequestDispatcher("jsp/orders/orderPizza.jsp");
            request.setAttribute("pizza", pizza);
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("viewPizzaRequest")) {
            List<PizzaOrder> pizza = flowerDecorationDao.viewPizzaOrder(username, 0);
            request.setAttribute("orderedPizza", pizza);
            rd = request.getRequestDispatcher("jsp/orders/viewPizzaOrder.jsp");
            rd.forward(request, response);
        } 
    }
}
