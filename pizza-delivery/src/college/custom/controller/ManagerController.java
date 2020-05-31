package college.custom.controller;

import college.custom.dao.*;
import college.custom.model.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "ManagerController")
public class ManagerController extends HttpServlet {
    private RequestDispatcher rd;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        PizzaDao pizzaDao = new PizzaDaoImpl();
        int row = 0;
        String data = "";
        if(anchor.equalsIgnoreCase("updatePizza")) {
            Pizza pizza = getPizza(request);
            row = pizzaDao.updatePizza(pizza, request.getParameter("pizzaId"));
            data = "Pizza";
        } else if(anchor.equalsIgnoreCase("modifyPizza")) {
            Pizza pizza = pizzaDao.getPizzaById(request.getParameter("pizzaId"));
            request.setAttribute("pizza", pizza);
            rd = request.getRequestDispatcher("jsp/manager/modifyPizza.jsp");
            rd.forward(request, response);
            data = "Pizza";
        } 

        if (row > 0) {
            rd = request.getRequestDispatcher("jsp/manager/managerHome.jsp");
            request.setAttribute("success", data +" details saved successfully.");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("jsp/manager/managerHome.jsp");
            request.setAttribute("errmsg", data+ " already exits.");
            rd.forward(request, response);
        }

    }

    private Pizza getPizza(HttpServletRequest request) {
        Pizza pizza = new Pizza();
        pizza.setPizzaName(request.getParameter("pizzaName"));
        pizza.setPizzaCost(request.getParameter("pizzaCost"));
        pizza.setStatus(request.getParameter("status"));
        pizza.setComment(request.getParameter("comment"));
        return pizza;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        HttpSession session = request.getSession();
        EmployeeDao employeeDao;
        PizzaDao pizzaDao = new PizzaDaoImpl();
        if (anchor.equalsIgnoreCase("logoff")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/logout.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("addEmployee")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/addEmployee.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("addPizza")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/addPizza.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("viewEmployee")) {
            employeeDao = new EmployeeDaoImpl();
            List<Employee> employees = employeeDao.viewEmployee();
            rd = request.getRequestDispatcher("jsp/employee/viewEmployee.jsp");
            request.setAttribute("employees", employees);
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("viewAssignPizza")) {
            List<PizzaOrder> pizza = pizzaDao.getPendingPizzaOrderManager();
            request.setAttribute("orderedPizza", pizza);
            rd = request.getRequestDispatcher("jsp/manager/viewAssignPizza.jsp");
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("viewPizza")) {
            List<Pizza> pizza = pizzaDao.getAllPizza();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/viewPizza.jsp");
            request.setAttribute("pizza", pizza);
            rd.forward(request, response);
        } 
    }
}
