package constant;

public class Constant {

    public static String view = "<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"\n" +
            "         pageEncoding=\"ISO-8859-1\" %>\n" +
            "<%@ page import=\"java.util.List\" %>\n" +
            "<%@ page import=\"${package}\" %>\n" +
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" +
            "    <title>View Pizza</title>\n" +
            "    <script type=\"text/javascript\">\n" +
            "        function modify${className}() {\n" +
            "            var chk = document.${declare}.pizzaId;\n" +
            "            var count = 0;\n" +
            "            if (chk.length == undefined) {\n" +
            "                if (chk.checked == true) {\n" +
            "                    count++;\n" +
            "                }\n" +
            "            }\n" +
            "            for (var i = 0; i < chk.length; i++) {\n" +
            "                if (chk[i].checked == true) {\n" +
            "                    count++;\n" +
            "                }\n" +
            "            }\n" +
            "\n" +
            "            if (count == 0) {\n" +
            "                alert(\"Please selected at least one checkbox\");\n" +
            "                return false;\n" +
            "            }\n" +
            "            if (count > 1) {\n" +
            "                alert(\"Please select only one checkbox\");\n" +
            "                return false;\n" +
            "            }\n" +
            "            document.${declare}.action = \"modify${className}?anchor=modify${className}&id=\"+chk.value;\n" +
            "            document.${declare}.submit();\n" +
            "        }\n" +
            "\n" +
            "        function delete${className}() {\n" +
            "            var chk = document.${declare}.id;\n" +
            "            var count = 0;\n" +
            "            var id = 0;\n" +
            "            if (chk.length == undefined) {\n" +
            "                if (chk.checked == true) {\n" +
            "                    count++;\n" +
            "                }\n" +
            "            }\n" +
            "            for (var i = 0; i < chk.length; i++) {\n" +
            "                if (chk[i].checked == true) {\n" +
            "                \tid = chk[i].value;\n" +
            "                    count++;\n" +
            "                }\n" +
            "            }\n" +
            "\n" +
            "            if (count == 0) {\n" +
            "                alert(\"Please selected at least one checkbox\");\n" +
            "                return false;\n" +
            "            }\n" +
            "            if (count > 1) {\n" +
            "                alert(\"Please select only one checkbox\");\n" +
            "                return false;\n" +
            "            }\n" +
            "\n" +
            "            document.${declare}.action = \"delete${className}?anchor=delete${className}&id=\"+id;\n" +
            "            document.${declare}.submit();\n" +
            "        }\n" +
            "    </script>\n" +
            "</head>\n" +
            "<style>\n" +
            "    .viewHeader {\n" +
            "        font-weight: bold;\n" +
            "        background-color: lightgrey;\n" +
            "    }\n" +
            "\n" +
            "    .viewHeader>td {\n" +
            "        padding: 10px 20px;\n" +
            "    }\n" +
            "\n" +
            "    .viewData {\n" +
            "        text-align: center;\n" +
            "        font-size: 14px;\n" +
            "    }\n" +
            "\n" +
            "    .viewData>td{\n" +
            "        padding-top: 10px;\n" +
            "        padding-bottom: 10px;\n" +
            "    }\n" +
            "</style>\n" +
            "<body>\n" +
            "<%@include file=\"managerHeader.jsp\" %>\n" +
            "<div id=\"wrapper\">\n" +
            "\t<div align=\"center\">\n" +
            "        <h3 style=\"color: green\">${success}</h3>\n" +
            "        <h3 style=\"color: red\">${errmsg}</h3>\n" +
            "    </div>\n" +
            "    <div id=\"page\">\n" +
            "        <%@include file=\"../login/loginDetails.jsp\" %>\n" +
            "        <%\n" +
            "        \tList<${className}> ${declare} = (List<${className}>) request.getAttribute(\"${declare}\");\n" +
            "        %>\n" +
            "        <form action=\"\" name=\"${declare}\" method=\"post\">\n" +
            "            <div style=\"height:auto;width:auto;border:1px solid #ccc;overflow:auto;\">\n" +
            "                <table border=\"0\">\n" +
            "                    <tr class=\"viewHeader\">\n" +
            "                        ${headers}\n" +
            "                    </tr>\n" +
            "                    <%for (int i = 0; i < ${declare}.size(); i++) { %>\n" +
            "                    <tr class=\"viewData\">\n" +
            "                        ${data}\n" +
            "                    </tr>\n" +
            "                    <% } %>\n" +
            "                </table>\n" +
            "            </div>\n" +
            "            <table>\n" +
            "                <tr>\n" +
            "                    <td><input type=\"button\" value=\"Modify\" onclick=\"modify${className}()\"></td>\n" +
            "                    <td><input type=\"button\" value=\"Delete\" onclick=\"delete${className}()\"></td>\n" +
            "                </tr>\n" +
            "            </table>\n" +
            "        </form>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<%@include file=\"../footer.jsp\" %>\n" +
            "</body>\n" +
            "</html>";

    public static String add = "<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"\n" +
            "         pageEncoding=\"ISO-8859-1\"%>\n" +
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" +
            "    <title>Insert title here</title>\n" +
            "    <script type=\"text/javascript\">\n" +
            "\n" +
            "        function addValue() {\n" +
            "\n" +
            "\t\t\t${javascriptValidation}\n" +
            "\n" +
            "            document.${name}.action=\"pizza?anchor=${name}\";\n" +
            "            document.${name}.submit();\n" +
            "        }\n" +
            "\n" +
            "    </script>\n" +
            "</head>\n" +
            "<body>\n" +
            "\t<%@include file=\"managerHeader.jsp\" %>\n" +
            "\t<div id=\"wrapper\">\n" +
            "\t\t<div id=\"page\">\n" +
            "\t\t\t<%@include file=\"../login/loginDetails.jsp\" %>\n" +
            "\t\t\t<div align=\"center\">\n" +
            "\t\t\t\t<h3 style=\"color: green\">${success}</h3>\n" +
            "\t\t\t\t<h3 style=\"color: red\">${errmsg}</h3>\n" +
            "\t\t\t</div>\n" +
            "\t\t\t<form action=\"\" name=\"${name}\" method=\"post\" style=\"padding-left: 40px;\">\n" +
            "\t\t\t\t<h1></h1>\n" +
            "\t\t\t\t<table>\n" +
            "\t\t\t\t\t${trData}\n" +
            "\t\t\t\t\t<tr ><td colspan=\"3\" align=\"center\"><input type=\"button\" value=\"Save\" onclick=\"addValue()\"></td></tr>\n" +
            "\t\t\t\t</table>\n" +
            "\t\t\t</form>\n" +
            "\n" +
            "\t\t</div>\n" +
            "\t</div>\n" +
            "\t<%@include file=\"../footer.jsp\" %>\n" +
            "</body>\n" +
            "</html>";

    public static String modify = "<%@ page language=\"java\" contentType=\"text/html; charset=ISO-8859-1\"\n" +
            "         pageEncoding=\"ISO-8859-1\" %>\n" +
            "<%@ page import=\"java.util.List\" %>\n" +
            "<%@ page import=\"${package}\" %>\n" +
            "<!DOCTYPE html PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\" \"http://www.w3.org/TR/html4/loose.dtd\">\n" +
            "<html>\n" +
            "<head>\n" +
            "    <meta http-equiv=\"Content-Type\" content=\"text/html; charset=ISO-8859-1\">\n" +
            "    <title>View Flower</title>\n" +
            "    <script type=\"text/javascript\">\n" +
            "        function cancel${className}() {\n" +
            "            document.${declare}.action=\"cancel${className}?anchor=cancel${className}\";\n" +
            "            document.${declare}.submit();\n" +
            "        }\n" +
            "    </script>\n" +
            "</head>\n" +
            "<style>\n" +
            "    .viewHeader>td {\n" +
            "        padding: 10px 20px;\n" +
            "    }\n" +
            "\n" +
            "    .viewData>td{\n" +
            "        padding-top: 10px;\n" +
            "        padding-bottom: 10px;\n" +
            "    }\n" +
            "</style>\n" +
            "<body>\n" +
            "<%@include file=\"managerHeader.jsp\" %>\n" +
            "<div id=\"wrapper\">\n" +
            "\n" +
            "    <div id=\"page\">\n" +
            "        <%@include file=\"../login/loginDetails.jsp\" %>\n" +
            "        <%\n" +
            "        \t${className} ${declare} = (${className}) request.getAttribute(\"${declare}\");\n" +
            "        %>\n" +
            "        <form action=\"update${className}?anchor=update${className}\" name=\"${declare}\" method=\"post\">\n" +
            "            <div style=\"height:auto;width:auto;border:1px solid #ccc;overflow:auto;\">\n" +
            "                <table border=\"0\">\n" +
            "                    ${rowData}\n" +
            "\n" +
            "                </table>\n" +
            "            </div>\n" +
            "            <table>\n" +
            "                <tr>\n" +
            "                    <td><input type=\"submit\" value=\"Update\"></td>\n" +
            "                    <td><input type=\"button\" value=\"Cancel\" onclick=\"cancel${className}()\"></td>\n" +
            "                </tr>\n" +
            "            </table>\n" +
            "        </form>\n" +
            "    </div>\n" +
            "</div>\n" +
            "<%@include file=\"../footer.jsp\" %>\n" +
            "</body>\n" +
            "</html>";

    public final static String controller = "import java.io.IOException;\n" +
            "\n" +
            "import javax.servlet.RequestDispatcher;\n" +
            "import javax.servlet.ServletException;\n" +
            "import javax.servlet.annotation.WebServlet;\n" +
            "import javax.servlet.http.HttpServlet;\n" +
            "import javax.servlet.http.HttpServletRequest;\n" +
            "import javax.servlet.http.HttpServletResponse;\n" +
            "\n" +
            "@WebServlet(name = \"${className}Controller\")\n" +
            "public class ${className}Controller extends HttpServlet {\n" +
            "\n" +
            "\t@Override\n" +
            "\tprotected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {\n" +
            "\t\tString anchor = request.getParameter(\"anchor\");\n" +
            "\t\tString data = \"\";\n" +
            "\t\tint row = -1;\n" +
            "\t\t${className}Dao ${declareName}Dao = new ${className}DaoImpl();\n" +
            "\t\tif (anchor.equals(\"add${className}\")) {\n" +
            "\t\t\t${className} ${declareName} = new ${className}();\n" +
            "\t\t\t${setData}\n" +
            "\t\t\trow = ${declareName}Dao.save(${declareName});\n" +
            "\t\t\tdata = \"${className}\";\n" +
            "\t\t}\n" +
            "\n" +
            "\t\tif (row > 0) {\n" +
            "\t\t\tRequestDispatcher rd = request.getRequestDispatcher(\"\");\n" +
            "\t\t\tresponse.sendRedirect(request.getContextPath() + \"\");\n" +
            "\t\t} else if (row == 0) {\n" +
            "\t\t\tRequestDispatcher rd = request.getRequestDispatcher(\"\");\n" +
            "\t\t\trequest.setAttribute(\"errmsg\", data + \" already exits.\");\n" +
            "\t\t\trd.forward(request, response);\n" +
            "\t\t}\n" +
            "\t}\n" +
            "\n" +
            "\t@Override\n" +
            "    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {\n" +
            "        String anchor = request.getParameter(\"anchor\");\n" +
            "        if (anchor.equals(\"add${className}\")) {\n" +
            "            RequestDispatcher rd = request.getRequestDispatcher(\"jsp/employee/add${className}.jsp\");\n" +
            "            rd.forward(request, response);\n" +
            "        } else if(anchor.equals(\"view${className}\")) {\n" +
            "            RequestDispatcher rd = request.getRequestDispatcher(\"jsp/employee/view${className}.jsp\");\n" +
            "            request.setAttribute(\"${declareName}\", new ArrayList<>());\n" +
            "            rd.forward(request, response);\n" +
            "        }\n" +
            "    }\n" +
            "}\n";
}
