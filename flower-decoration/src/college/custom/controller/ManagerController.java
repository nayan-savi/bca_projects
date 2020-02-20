package college.custom.controller;

import college.custom.dao.*;
import college.custom.model.DecorationOrder;
import college.custom.model.Employee;
import college.custom.model.FlowerOrder;
import college.custom.model.ShopDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ManagerController")
public class ManagerController extends HttpServlet {
    private RequestDispatcher rd;
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");

        ShopDetails details = new ShopDetails();
        details.setShopName(request.getParameter("shopName"));
        details.setAddress(request.getParameter("address"));
        details.setCity(request.getParameter("city"));
        details.setState(request.getParameter("state"));
        details.setCountry(request.getParameter("country"));
        details.setPincode(request.getParameter("pincode"));
        details.setStartdate(request.getParameter("startdate"));

        ShopDetailsDao detailsDao = new ShopDetailsDaoImpl();
        int row = detailsDao.save(details, anchor);
        if (row > 0) {
            rd = request.getRequestDispatcher("jsp/manager/managerHome.jsp");
            request.setAttribute("success", "Shop details saved successfully.");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("jsp/manager/addShops.jsp");
            request.setAttribute("errmsg", "Shop already exits.");
            rd.forward(request, response);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        HttpSession session = request.getSession();
        String username = (String)session.getAttribute("username");
        EmployeeDao employeeDao;
        FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
        if (anchor.equalsIgnoreCase("logoff")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/login/login.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("addEmployee")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/addEmployee.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("addFlower")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/addFlower.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("addDecoration")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/addDecoration.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("viewEmployee")) {
            employeeDao = new EmployeeDaoImpl();
            List<Employee> employees = employeeDao.viewEmployee();
            rd = request.getRequestDispatcher("jsp/employee/viewEmployee.jsp");
            request.setAttribute("employees", employees);
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("viewAssignFlower")) {
            List<FlowerOrder> flowers = flowerDecorationDao.getPendingFlowerOrderManager();
            request.setAttribute("orderedFlowers", flowers);
            rd = request.getRequestDispatcher("jsp/manager/viewAssignFlower.jsp");
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("viewAssignDecoration")) {
            List<DecorationOrder> decorations = flowerDecorationDao.getPendingDecorationOrderManager();
            request.setAttribute("orderedDecorations", decorations);
            rd = request.getRequestDispatcher("jsp/manager/viewAssignDecoration.jsp");
            rd.forward(request, response);
        }
    }
}
