<%--
  Created by IntelliJ IDEA.
  User: NAYAN
  Date: 2/23/20
  Time: 7:21 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv=[COLOR=red]"cache-control"[/COLOR] content=[COLOR=red]"max-age=0, must-revalidate, no-cache, no-store, private" [/COLOR]>
    <meta http-equiv=[COLOR=red]"expires"[/COLOR] content=[COLOR=red]"-1"[/COLOR]>
    <meta http-equiv=[COLOR=red]"pragma"[/COLOR] content=[COLOR=red]"no-cache"[/COLOR]>
    <title>Title</title>
</head>
<body>
<%
    response.setHeader("Cache-Control","no-cache");
    response.setHeader("Cache-Control","no-store");
    response.setHeader("Pragma","no-cache");
    response.setDateHeader ("Expires", 0);

    if(session.getAttribute("some_token")==null)
        response.sendRedirect(request.getContextPath());

%>

</body>
</html>
