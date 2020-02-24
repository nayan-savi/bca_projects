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
        FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
        int row = 0;
        String data = "";
        if(anchor.equalsIgnoreCase("updateFlower")) {
            Flower flower = getFlower(request);
            row = flowerDecorationDao.updateFlower(flower, request.getParameter("flowerId"));
            data = "Flower";
        } else if(anchor.equalsIgnoreCase("updateDecoration")) {
            Decoration decoration = getDecoration(request);
            row = flowerDecorationDao.updateDecoration(decoration, request.getParameter("decorationId"));
            data = "Decoration";
        } else if(anchor.equalsIgnoreCase("modifyFlower")) {
            Flower flower = flowerDecorationDao.getFlowerById(request.getParameter("flowerId"));
            request.setAttribute("flower", flower);
            rd = request.getRequestDispatcher("jsp/manager/modifyFlower.jsp");
            rd.forward(request, response);
            data = "Flower";
        } else if(anchor.equalsIgnoreCase("modifyDecoration")) {
            Decoration decoration = flowerDecorationDao.getDecorationById(request.getParameter("decorationId"));
            request.setAttribute("decoration", decoration);
            rd = request.getRequestDispatcher("jsp/manager/modifyDecoration.jsp");
            rd.forward(request, response);
            data = "Decoration";
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

    private Decoration getDecoration(HttpServletRequest request) {
        Decoration decoration = new Decoration();
        decoration.setDecorationName(request.getParameter("decorationName"));
        decoration.setDecorationCost(request.getParameter("decorationCost"));
        decoration.setStatus(request.getParameter("status"));
        decoration.setComment(request.getParameter("comment"));
        return decoration;
    }

    private Flower getFlower(HttpServletRequest request) {
        Flower flower = new Flower();
        flower.setFlowerName(request.getParameter("flowerName"));
        flower.setFlowerCost(request.getParameter("flowerCost"));
        flower.setStatus(request.getParameter("status"));
        flower.setComment(request.getParameter("comment"));
        return flower;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        HttpSession session = request.getSession();
        EmployeeDao employeeDao;
        FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
        if (anchor.equalsIgnoreCase("logoff")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/logout.jsp");
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
        } else if(anchor.equalsIgnoreCase("viewFlower")) {
            List<Flower> flowers = flowerDecorationDao.getAllFlowers();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/viewFlower.jsp");
            request.setAttribute("flowers", flowers);
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("viewDecoration")) {
            List<Decoration> decorations = flowerDecorationDao.getAllDecorations();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/viewDecoration.jsp");
            request.setAttribute("decorations", decorations);
            rd.forward(request, response);
        }
    }
}
