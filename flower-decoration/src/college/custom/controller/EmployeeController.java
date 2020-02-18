package college.custom.controller;

import college.custom.dao.EmployeeDao;
import college.custom.dao.EmployeeDaoImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "EmployeeController")
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        HttpSession sess = request.getSession(true);
        if (anchor.equalsIgnoreCase("viewSupportRequest")) {
            EmployeeDao employee = new EmployeeDaoImpl();
            request.setAttribute("supportList", employee.getSupports());
            RequestDispatcher rd = request.getRequestDispatcher("jsp/Employee/viewSupportRequest.jsp");
            rd.forward(request, response);
        }

        /*if (anchor.equalsIgnoreCase("resolveSupportRequest")) {
            DaoEmployee du = new DaoEmployeeImpl();
            request.setAttribute("supportList", du.getResolveSupportList(Integer.parseInt(sess.getAttribute("PKEMPLOYEE_ID").toString())));
            RequestDispatcher rd = request.getRequestDispatcher("jsp/Employee/resolveSupportRequest.jsp");
            rd.forward(request, response);
        }

        if (anchor.equalsIgnoreCase("startSupportRequest")) {
            DaoEmployee du = new DaoEmployeeImpl();
            du.startSupportRequest(Integer.parseInt(sess.getAttribute("PKEMPLOYEE_ID").toString()), Integer.parseInt(request.getParameter("PK_USER_SUPPORT_ID")));
            request.setAttribute("supportList", du.getSupportList());
            RequestDispatcher rd = request.getRequestDispatcher("jsp/Employee/viewSupportRequest.jsp");
            rd.forward(request, response);
        }

        if (anchor.equalsIgnoreCase("modifySupportRequest")) {
            DaoEmployee du = new DaoEmployeeImpl();
            User user = du.modifySupportRequest(Integer.parseInt(request.getParameter("PK_USER_SUPPORT_ID")));
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/Employee/UpdateSupportRequest.jsp");
            rd.forward(request, response);
        }

        if (anchor.equalsIgnoreCase("updateSupportRequest")) {
            DaoEmployee du = new DaoEmployeeImpl();
            int supportid = Integer.parseInt(request.getParameter("PK_USER_SUPPORT_ID"));
            if (du.updateSupportRequest(supportid, request.getParameter("reply")) == 1) {
                request.setAttribute("success", "Resolve");
            } else {
                request.setAttribute("success", "Resolve failed");
            }
            User user = du.modifySupportRequest(supportid);
            request.setAttribute("user", user);
            RequestDispatcher rd = request.getRequestDispatcher("jsp/Employee/UpdateSupportRequest.jsp");
            rd.forward(request, response);
        }

        if (anchor.equalsIgnoreCase("managerreply")) {
            DaoEmployee du = new DaoEmployeeImpl();
            request.setAttribute("replyList", du.getReplyList(Integer.parseInt(sess.getAttribute("PKEMPLOYEE_ID").toString())));
            RequestDispatcher rd = request.getRequestDispatcher("jsp/Employee/viewManagerReply.jsp");
            rd.forward(request, response);
        }*/

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
