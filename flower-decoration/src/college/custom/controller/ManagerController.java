package college.custom.controller;

import college.custom.dao.ShopDetailsDao;
import college.custom.dao.ShopDetailsDaoImpl;
import college.custom.model.ShopDetails;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ManagerController")
public class ManagerController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        RequestDispatcher rd;
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

        if (anchor.equalsIgnoreCase("logoff")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/login/login.jsp");
            rd.forward(request, response);
        } else if (anchor.equalsIgnoreCase("addShops")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/addShops.jsp");
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("addEmployee")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/addEmployee.jsp");
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("addFlower")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/addFlower.jsp");
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("addDecoration")) {
            RequestDispatcher rd = request.getRequestDispatcher("jsp/manager/addDecoration.jsp");
            rd.forward(request, response);
        }
    }
}
