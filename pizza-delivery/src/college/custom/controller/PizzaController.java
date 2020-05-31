package college.custom.controller;

import college.custom.dao.*;
import college.custom.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet(name = "PizzaController")
public class PizzaController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        RequestDispatcher rd;
        PizzaDao pizzaDao = new PizzaDaoImpl();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        String pattern = "dd-mm-yyyy";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
        String date = simpleDateFormat.format(new Date());
        int row = -1;
        String data = null;
        String fromData = "";
        if(anchor.equals("addPizza")) {
            Pizza pizza = new Pizza();
            pizza.setPizzaName(request.getParameter("pizzaName"));
            pizza.setPizzaCost(request.getParameter("pizzaCost"));
            pizza.setStatus(request.getParameter("status"));
            pizza.setComment(request.getParameter("comment"));
            row = pizzaDao.save(pizza);
            data = "Pizza";
        } else if(anchor.equals("modifyPizzaManager")) {
            List<Employee> employees = employeeDao.viewEmployee();
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            PizzaOrder pizzaOrder = pizzaDao.getPizzaOrder(orderId);
            request.setAttribute("pizzaDetails", pizzaOrder);
            request.setAttribute("employees", employees);
            rd = request.getRequestDispatcher("jsp/manager/modifyAssignPizza.jsp");
            rd.forward(request, response);
        } else if(anchor.equals("updatePizzaOrder")) {
            PizzaOrder pizzaOrder = getPizzaUpdatedOrder(request);
            pizzaOrder.setDeliveredDate(date);
            row = pizzaDao.modifyPizzaOrderEmployee(pizzaOrder);
            data = "Pizza";
        } else if (anchor.equalsIgnoreCase("modifyEmpPizzaOrder")) {
            PizzaOrder pizzaOrder = pizzaDao.getPizzaOrder(Integer.parseInt(request.getParameter("orderId")));
            rd = request.getRequestDispatcher("jsp/employee/modifyEmpPizzaOrder.jsp");
            request.setAttribute("pizzaDetails", pizzaOrder);
            rd.forward(request, response);
            data = "Pizza";
        } else if(anchor.equals("updateEmpPizzaOrder")) {
            PizzaOrder pizzaOrder = getPizzaUpdatedOrder(request);
            pizzaOrder.setDeliveredDate(date);
            row = pizzaDao.modifyPizzaOrderEmployee(pizzaOrder);
            data = "Pizza";
            fromData = "empData";
        } else if (anchor.equalsIgnoreCase("updateEmpPizzaOrder")) {
            PizzaOrder pizzaOrder = getPizzaUpdatedOrder(request);
            row = pizzaDao.modifyPizzaOrderEmployee(pizzaOrder);
            fromData = "empData";
            data = "Pizza";
        }

        if (row > 0) {
            if(fromData.equals("empData")) {
                rd = request.getRequestDispatcher("jsp/employee/employeeHome.jsp");
                request.setAttribute("success", data + " details saved successfully.");
                rd.forward(request, response);
            } else {
                rd = request.getRequestDispatcher("jsp/manager/viewAssignPizza.jsp");
                response.sendRedirect(request.getContextPath()+"/viewAssignPizza?anchor=viewAssignPizza");
            }
        } else if(row == 0){
            rd = request.getRequestDispatcher("jsp/manager/"+anchor+".jsp");
            request.setAttribute("errmsg", data +" already exits.");
            rd.forward(request, response);
        }
    }

    private PizzaOrder getPizzaUpdatedOrder(HttpServletRequest request) {
        PizzaOrder pizzaOrder = new PizzaOrder();
        pizzaOrder.setOrderId(Integer.parseInt(request.getParameter("orderId")));
        pizzaOrder.setPizzaName(request.getParameter("pizzaName"));
        pizzaOrder.setPizzaCost(request.getParameter("pizzaCost"));
        pizzaOrder.setRequestDate(request.getParameter("requestDate"));
        pizzaOrder.setBargaining(request.getParameter("bargaining"));
        pizzaOrder.setFinalRate(request.getParameter("finalRate"));
        pizzaOrder.setComment(request.getParameter("comment"));
        pizzaOrder.setStatus(request.getParameter("status"));
        pizzaOrder.setAssignedTo(request.getParameter("assignedTo"));
        return pizzaOrder;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
