package college.custom.controller;

import college.custom.dao.DecoratorDao;
import college.custom.dao.DecoratorDaoImpl;
import college.custom.dao.FlowerDecorationDao;
import college.custom.dao.FlowerDecorationDaoImpl;
import college.custom.model.Decoration;
import college.custom.model.Flower;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "FlowerDecoratorController")
public class FlowerDecoratorController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        RequestDispatcher rd;
        int row = 0;
        String data = null;
        if(anchor.equals("addFlower")) {
            Flower flower = new Flower();
            flower.setFlowerName(request.getParameter("flowerName"));
            flower.setFlowerCost(request.getParameter("flowerCost"));
            flower.setStatus(request.getParameter("status"));
            flower.setComment(request.getParameter("comment"));
            FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
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

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
