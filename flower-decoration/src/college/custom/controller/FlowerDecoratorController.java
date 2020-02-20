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
import java.util.List;

@WebServlet(name = "FlowerDecoratorController")
public class FlowerDecoratorController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        RequestDispatcher rd;
        FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        int row = 0;
        String data = null;
        if(anchor.equals("addFlower")) {
            Flower flower = new Flower();
            flower.setFlowerName(request.getParameter("flowerName"));
            flower.setFlowerCost(request.getParameter("flowerCost"));
            flower.setStatus(request.getParameter("status"));
            flower.setComment(request.getParameter("comment"));
            flowerDecorationDao = new FlowerDecorationDaoImpl();
            row = flowerDecorationDao.save(flower);
            data = "Flower";
        } else if(anchor.equals("addDecoration")) {
            Decoration decoration = new Decoration();
            decoration.setDecorationName(request.getParameter("decorationName"));
            decoration.setDecorationCost(request.getParameter("decorationCost"));
            decoration.setStatus(request.getParameter("status"));
            decoration.setComment(request.getParameter("comment"));
            DecoratorDao decoratorDao = new DecoratorDaoImpl();
            row = decoratorDao.save(decoration);
            data = "Decoration";
        } else if(anchor.equals("modifyFlowerManager")) {
            List<Employee> employees = employeeDao.viewEmployee();
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            FlowerOrder flowerOrder = flowerDecorationDao.getFlowerOrder(orderId);
            request.setAttribute("flowerDetails", flowerOrder);
            request.setAttribute("employees", employees);
            rd = request.getRequestDispatcher("jsp/manager/modifyAssignFlower.jsp");
            rd.forward(request, response);
        } else if(anchor.equals("modifyDecorationManager")) {
            List<Employee> employees = employeeDao.viewEmployee();
            int orderId = Integer.parseInt(request.getParameter("orderId"));
            DecorationOrder decorationOrder = flowerDecorationDao.getDecorationOrder(orderId);
            request.setAttribute("decorationDetails", decorationOrder);
            request.setAttribute("employees", employees);
            rd = request.getRequestDispatcher("jsp/manager/modifyAssignDecoration.jsp");
            rd.forward(request, response);
        } else if(anchor.equals("updateFlowerOrder")) {
            FlowerOrder flowerOrder = getFlowerUpdatedOrder(request);
            row = flowerDecorationDao.modifyFlowerOrderManager(flowerOrder);
            data = "Flower";
        } else if(anchor.equals("updateDecorationOrder")) {
            DecorationOrder decorationUpdateOrder = getDecorationUpdateOrder(request);
            row = flowerDecorationDao.modifyDecorationOrderManager(decorationUpdateOrder);
            data = "Decoration";
        }

        if (row > 0) {
            rd = request.getRequestDispatcher("jsp/manager/managerHome.jsp");
            request.setAttribute("success", data + " details saved successfully.");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("jsp/manager/"+anchor+".jsp");
            request.setAttribute("errmsg", data +" already exits.");
            rd.forward(request, response);
        }
    }

    private FlowerOrder getFlowerUpdatedOrder(HttpServletRequest request) {
        FlowerOrder flowerOrder = new FlowerOrder();
        flowerOrder.setOrderId(Integer.parseInt(request.getParameter("orderId")));
        flowerOrder.setFlowerName(request.getParameter("flowerName"));
        flowerOrder.setFlowerCost(request.getParameter("flowerCost"));
        flowerOrder.setRequestDate(request.getParameter("requestDate"));
        flowerOrder.setBargaining(request.getParameter("bargaining"));
        flowerOrder.setFinalRate(request.getParameter("finalRate"));
        flowerOrder.setComment(request.getParameter("comment"));
        flowerOrder.setStatus(request.getParameter("status"));
        flowerOrder.setAssignedTo(request.getParameter("assignedTo"));
        return flowerOrder;
    }

    private DecorationOrder getDecorationUpdateOrder(HttpServletRequest request) {
        DecorationOrder decorationOrder = new DecorationOrder();
        decorationOrder.setOrderId(Integer.parseInt(request.getParameter("orderId")));
        decorationOrder.setDecorationName(request.getParameter("decorationName"));
        decorationOrder.setDecorationCost(request.getParameter("decorationCost"));
        decorationOrder.setRequestDate(request.getParameter("requestDate"));
        decorationOrder.setBargaining(request.getParameter("bargaining"));
        decorationOrder.setFinalRate(request.getParameter("finalRate"));
        decorationOrder.setComment(request.getParameter("comment"));
        decorationOrder.setStatus(request.getParameter("status"));
        decorationOrder.setAssignedTo(request.getParameter("assignedTo"));
        return decorationOrder;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
