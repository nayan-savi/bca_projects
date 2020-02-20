package college.custom.controller;

import college.custom.dao.EmployeeDao;
import college.custom.dao.EmployeeDaoImpl;
import college.custom.dao.FlowerDecorationDao;
import college.custom.dao.FlowerDecorationDaoImpl;
import college.custom.model.DecorationOrder;
import college.custom.model.Employee;
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

@WebServlet(name = "EmployeeController")
public class EmployeeController extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String anchor = request.getParameter("anchor");
        EmployeeDao employeeDao = new EmployeeDaoImpl();
        RequestDispatcher rd;
        if (anchor.equalsIgnoreCase("addEmployee")) {
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
        } else if (anchor.equalsIgnoreCase("modifyEmployee")) {
            int employeeId = Integer.parseInt(request.getParameter("EMPLOYEE_ID"));
            Employee employee = employeeDao.modifyEmployee(employeeId);
            employee.setEmployeeId(employeeId);
            request.setAttribute("employeeDetails", employee);
            rd = request.getRequestDispatcher("jsp/employee/modifyEmployee.jsp");
            rd.forward(request, response);

        } else if (anchor.equalsIgnoreCase("updateEmployee")) {
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
        } else if (anchor.equalsIgnoreCase("cancelEmployee")) {
            rd = request.getRequestDispatcher("jsp/manager/managerHome.jsp");
            rd.forward(request, response);
        }
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
        String anchor = request.getParameter("anchor");
        RequestDispatcher rd;
        HttpSession session = request.getSession();
        String username = (String) session.getAttribute("username");
        int employeeId = Integer.parseInt(session.getAttribute("employeeId").toString());
        FlowerDecorationDao flowerDecorationDao = new FlowerDecorationDaoImpl();
        if(anchor.equalsIgnoreCase("viewEmpFlowerOrder")) {
            List<FlowerOrder> flowers = flowerDecorationDao.viewFlowerOrder(username, employeeId);
            request.setAttribute("orderedFlowers", flowers);
            rd = request.getRequestDispatcher("jsp/employee/viewEmpFlowerOrder.jsp");
            rd.forward(request, response);
        } else if(anchor.equalsIgnoreCase("viewEmpDecorationOrder")) {
            List<DecorationOrder> decorations = flowerDecorationDao.viewDecorationOrder(username, employeeId);
            request.setAttribute("orderedDecorations", decorations);
            rd = request.getRequestDispatcher("jsp/employee/viewEmpDecorationOrder.jsp");
            rd.forward(request, response);
        }
    }
}
