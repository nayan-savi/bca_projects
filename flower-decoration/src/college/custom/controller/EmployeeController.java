package college.custom.controller;

import college.custom.dao.EmployeeDao;
import college.custom.dao.EmployeeDaoImpl;
import college.custom.model.Employee;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "EmployeeController")
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        RequestDispatcher rd = null;
        if(anchor.equalsIgnoreCase("addEmployee")) {
            Employee employee = getEmployee(request);

            int row = employeeDao.saveEmployee(employee);
            if (row > 0) {
                rd = request.getRequestDispatcher("jsp/manager/managerHome.jsp");
                request.setAttribute("success", "Employee details saved successfully.");
                rd.forward(request, response);
            } else {
                rd = request.getRequestDispatcher("jsp/manager/addEmployee.jsp");
                request.setAttribute("errmsg", "Employee already exits.");
                rd.forward(request, response);
            }
        } else if(anchor.equalsIgnoreCase("modifyEmployee")) {
            int employeeId = Integer.parseInt(request.getParameter("EMPLOYEE_ID"));
            Employee employee = employeeDao.modifyEmployee(employeeId);
            employee.setEmployeeId(employeeId);
            request.setAttribute("employeeDetails", employee);
            rd = request.getRequestDispatcher("jsp/employee/modifyEmployee.jsp");
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("updateEmployee")) {
            Employee employee = getEmployee(request);
            employee.setEmployeeId(Integer.parseInt(request.getParameter("employeeId")));
            int row = employeeDao.updateEmployee(employee);
            if (row > 0) {
                rd = request.getRequestDispatcher("jsp/manager/managerHome.jsp");
                request.setAttribute("success", "Employee details updated successfully.");
                rd.forward(request, response);
            } else {
                rd = request.getRequestDispatcher("jsp/employee/modifyEmployee.jsp");
                request.setAttribute("errmsg", "Employee details update failed.");
                rd.forward(request, response);
            }
        }

        /*
        HttpSession sess = request.getSession(true);
        if (anchor.equalsIgnoreCase("viewSupportRequest")) {
            EmployeeDao employee = new EmployeeDaoImpl();
            request.setAttribute("supportList", employee.getSupports());
            RequestDispatcher rd = request.getRequestDispatcher("jsp/Employee/viewSupportRequest.jsp");
            rd.forward(request, response);
        }*/

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

    private Employee getEmployee(HttpServletRequest request) {
        Employee employee = new Employee();
        employee.setEmployeeName(request.getParameter("employeeName"));
        employee.setDateOfJoin(request.getParameter("dateOfJoin"));
        employee.setQualification(request.getParameter("qualification"));
        employee.setEmailId(request.getParameter("emailId"));
        employee.setContactNo(request.getParameter("contactNo"));
        employee.setFatherName(request.getParameter("fatherName"));
        employee.setMotherName(request.getParameter("motherName"));
        employee.setAddress(request.getParameter("address"));
        employee.setDob(request.getParameter("dob"));
        employee.setUsername(request.getParameter("username"));
        employee.setPassword(request.getParameter("password"));
        employee.setDesignation(request.getParameter("designation"));
        employee.setRelievingDate(request.getParameter("relievingDate"));
        employee.setLevel(Integer.parseInt(request.getParameter("level")));
        employee.setActive(request.getParameter("active"));
        return employee;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
