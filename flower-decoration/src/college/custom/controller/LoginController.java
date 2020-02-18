package college.custom.controller;

import college.custom.dao.LoginDao;
import college.custom.dao.LoginDaoImpl;
import college.custom.model.Login;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginController")
public class LoginController extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession(true);
        RequestDispatcher rd = null;
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String type = request.getParameter("type");

        LoginDao loginDao = new LoginDaoImpl();
        Login login = loginDao.login(username, password, type);
        int level = login.getLevel();
        if (level != 0) {
            if (level == 1) {
                rd = request.getRequestDispatcher("jsp/manager/managerHome.jsp");
            } else if (level == 2) {
                session.setAttribute("employeeId", login.getEmployeeId());
                session.setAttribute("active", login.getActive());
                rd = request.getRequestDispatcher("jsp/employee/employeeHome.jsp");
            } else if (level == 3) {
                rd = request.getRequestDispatcher("jsp/user/userHome.jsp");
            }
        } else {
            rd = request.getRequestDispatcher("jsp/login/login.jsp");
            request.setAttribute("msg", "Invalid username and password ");
        }
        rd.forward(request, response);
    }

}
