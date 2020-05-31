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
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	RequestDispatcher rd;
        String anchor = request.getParameter("anchor");
        String pizzaId = request.getParameter("id");
        PizzaDao pizzaDao = new PizzaDaoImpl();
        int row = -1;
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
        } else if (anchor.equalsIgnoreCase("deletePizza")) {
	       	row = pizzaDao.deletePizzaById(Integer.parseInt(pizzaId));
            data = "delete";
        } else if(anchor.equalsIgnoreCase("cancelPizza")) {
        	rd = request.getRequestDispatcher("jsp/manager/viewPizza.jsp");
            response.sendRedirect(request.getContextPath()+"/viewPizza?anchor=viewPizza");
        } else if(anchor.equalsIgnoreCase("cancelManager")) {
        	rd = request.getRequestDispatcher("jsp/manager/viewAssignPizza.jsp");
            response.sendRedirect(request.getContextPath()+"/viewAssignPizza?anchor=viewAssignPizza");
        } 

        if (row > 0) {
        	if(data.equalsIgnoreCase("delete")) {
        		rd = request.getRequestDispatcher("jsp/manager/viewPizza.jsp");
	            response.sendRedirect(request.getContextPath()+"/viewPizza?anchor=viewPizza");
        	} else {
	            rd = request.getRequestDispatcher("jsp/manager/viewPizza.jsp");
	            request.setAttribute("success", data +" details saved successfully.");
	            response.sendRedirect(request.getContextPath()+"/viewPizza?anchor=viewPizza");
        	}
        } else if(row == 0)  {
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
    	RequestDispatcher rd;
        String anchor = request.getParameter("anchor");
        HttpSession session = request.getSession();
        EmployeeDao employeeDao;
        PizzaDao pizzaDao = new PizzaDaoImpl();
        if (anchor.equalsIgnoreCase("logoff")) {
            rd = request.getRequestDispatcher("jsp/logout.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("addEmployee")) {
            rd = request.getRequestDispatcher("jsp/manager/addEmployee.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("addPizza")) {
            rd = request.getRequestDispatcher("jsp/manager/addPizza.jsp");
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
            rd = request.getRequestDispatcher("jsp/manager/viewPizza.jsp");
            request.setAttribute("pizza", pizza);
            rd.forward(request, response);
        } 
    }
}
