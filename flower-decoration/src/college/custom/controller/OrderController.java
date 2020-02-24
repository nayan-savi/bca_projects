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
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "OrderController")
public class OrderController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        String orderId = request.getParameter("id");
        HttpSession session = request.getSession();
        FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
        RequestDispatcher rd;
        int row = 0;
        String data = null;
        String username = (String) session.getAttribute("username");
        if (anchor.equalsIgnoreCase("orderFlower")) {
            FlowerOrder flowerOrder = getFlowerOrder(request, username);
            row = flowerDecorationDao.saveFlowerRequest(flowerOrder);
            data = "Flower";
        } else if (anchor.equalsIgnoreCase("orderDecoration")) {
            DecorationOrder decorationOrder = getDecorationOrder(request, username);
            row = flowerDecorationDao.saveDecorationRequest(decorationOrder);
            data = "Decoration";
        } else if (anchor.equalsIgnoreCase("deleteFlowerRequest")) {
            String orderIdQuery = request.getParameter("orderId");
            row = flowerDecorationDao.deleteFlowerOrderById(orderIdQuery);
            if(row > 0) {
                sendResponse(request, response, orderId);
                return;
            }
        } else if (anchor.equalsIgnoreCase("deleteDecorationRequest")) {
            String orderIdQuery = request.getParameter("orderId");
            row = flowerDecorationDao.deleteDecorationOrderById(orderIdQuery);
            if(row > 0) {
                sendResponse(request, response, orderId);
                return;
            }
        }

        if (row > 0) {
            rd = request.getRequestDispatcher("jsp/user/userHome.jsp");
            request.setAttribute("success", data+ " order saved successfully.");
            rd.forward(request, response);
        } else {
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

    private DecorationOrder getDecorationOrder(HttpServletRequest request, String username) {
        DecorationOrder decorationOrder = new DecorationOrder();
        decorationOrder.setDecorationName(request.getParameter("decorationName"));
        decorationOrder.setDecorationCost(request.getParameter("decorationCost"));
        decorationOrder.setRequestDate(request.getParameter("requestDate"));
        decorationOrder.setBargaining(request.getParameter("bargaining"));
        decorationOrder.setFinalRate(request.getParameter("finalRate"));
        decorationOrder.setComment(request.getParameter("comment"));
        decorationOrder.setStatus("Pending");
        decorationOrder.setOrderBy(username);
        return decorationOrder;
    }

    private FlowerOrder getFlowerOrder(HttpServletRequest request, String username) {
        FlowerOrder flowerOrder = new FlowerOrder();
        flowerOrder.setFlowerName(request.getParameter("flowerName"));
        flowerOrder.setFlowerCost(request.getParameter("flowerCost"));
        flowerOrder.setRequestDate(request.getParameter("requestDate"));
        flowerOrder.setBargaining(request.getParameter("bargaining"));
        flowerOrder.setFinalRate(request.getParameter("finalRate") == null ? "" : request.getParameter("finalRate"));
        flowerOrder.setComment(request.getParameter("comment"));
        flowerOrder.setOrderBy(username);
        flowerOrder.setStatus("Pending");
        return flowerOrder;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        String anchor = request.getParameter("anchor");
        FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
        RequestDispatcher rd;
        String username = (String) session.getAttribute("username");
        if (anchor.equalsIgnoreCase("orderFlower")) {
            List<Flower> flowers = flowerDecorationDao.getActiveFlowers();
            rd = request.getRequestDispatcher("jsp/orders/orderFlower.jsp");
            request.setAttribute("flowers", flowers);
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("orderDecoration")) {
            List<Decoration> decorations = flowerDecorationDao.getActiveDecorations();
            rd = request.getRequestDispatcher("jsp/orders/orderDecoration.jsp");
            request.setAttribute("decorations", decorations);
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("viewFlowerRequest")) {
            List<FlowerOrder> flowers = flowerDecorationDao.viewFlowerOrder(username, 0);
            rd = request.getRequestDispatcher("jsp/orders/viewFlowerOrder.jsp");
            request.setAttribute("orderedFlowers", flowers);
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("viewDecorationRequest")) {
            List<DecorationOrder> decorations = flowerDecorationDao.viewDecorationOrder(username, 0);
            rd = request.getRequestDispatcher("jsp/orders/viewDecorationOrder.jsp");
            request.setAttribute("orderedDecorations", decorations);
            rd.forward(request, response);
        }
    }
}
