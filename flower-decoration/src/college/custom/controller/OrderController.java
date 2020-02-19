package college.custom.controller;

import college.custom.dao.FlowerDecorationDao;
import college.custom.dao.FlowerDecorationDaoImpl;
import college.custom.model.Decoration;
import college.custom.model.DecorationOrder;
import college.custom.model.Flower;
import college.custom.model.FlowerOrder;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderController")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        RequestDispatcher rd;
        int row = 0;
        String data = null;
        if (anchor.equalsIgnoreCase("orderFlower")) {
            FlowerOrder flowerOrder = new FlowerOrder();
            flowerOrder.setFlowerName(request.getParameter("flowerName"));
            flowerOrder.setFlowerCost(request.getParameter("flowerCost"));
            flowerOrder.setRequestDate(request.getParameter("requestDate"));
            flowerOrder.setBargaining(request.getParameter("bargaining"));
            flowerOrder.setFinalRate(request.getParameter("finalRate"));
            flowerOrder.setComment(request.getParameter("comment"));
            flowerOrder.setStatus("Pending");
            FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
            row = flowerDecorationDao.saveFlowerRequest(flowerOrder);
            data = "Flower";
        } else if (anchor.equalsIgnoreCase("orderDecoration")) {
            DecorationOrder decorationOrder = new DecorationOrder();
            decorationOrder.setDecorationName(request.getParameter("decorationName"));
            decorationOrder.setDecorationCost(request.getParameter("decorationCost"));
            decorationOrder.setRequestDate(request.getParameter("requestDate"));
            decorationOrder.setBargaining(request.getParameter("bargaining"));
            decorationOrder.setFinalRate(request.getParameter("finalRate"));
            decorationOrder.setComment(request.getParameter("comment"));
            decorationOrder.setStatus("Pending");
            FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
            row = flowerDecorationDao.saveDecorationRequest(decorationOrder);
            data = "Decoration";
        }

        if (row > 0) {
            rd = request.getRequestDispatcher("jsp/user/userHome.jsp");
            request.setAttribute("success", data + " order saved successfully.");
            rd.forward(request, response);
        } else {
            rd = request.getRequestDispatcher("jsp/orders/" + anchor + ".jsp");
            request.setAttribute("errmsg", data + " ordered already, please check in view to check status.");
            rd.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
        if (anchor.equalsIgnoreCase("orderFlower")) {
            List<Flower> flowers = flowerDecorationDao.getAllFlowers();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/orders/orderFlower.jsp");
            request.setAttribute("flowers", flowers);
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("orderDecoration")) {
            List<Decoration> decorations = flowerDecorationDao.getAllDecorations();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/orders/orderDecoration.jsp");
            request.setAttribute("decorations", decorations);
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("viewFlowerRequest")) {
            List<FlowerOrder> flowers = flowerDecorationDao.viewFlowerOrder();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/orders/viewFlowerOrder.jsp");
            request.setAttribute("orderedFlowers", flowers);
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("viewDecorationRequest")) {
            List<DecorationOrder> decorations = flowerDecorationDao.viewDecorationOrder();
            RequestDispatcher rd = request.getRequestDispatcher("jsp/orders/viewDecorationOrder.jsp");
            request.setAttribute("orderedDecorations", decorations);
            rd.forward(request, response);
        }
    }
}
