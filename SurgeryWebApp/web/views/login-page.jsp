<%-- 
    Document   : login-page
    Created on : 24-Nov-2020, 15:07:44
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login!</h1>
        <h4><a href="./">Homepage</a></h4>
        <% 
            if (request.getAttribute("msg") != null) {
                out.print("<h3>" + request.getAttribute("msg") + "</h3><br>");
            }
        %>
        <form action="Login" method="post">
            Username: <input type="text" name="username"><br>
            Password: <input type="password" name="password"><br>
            <input type="submit" value="Login">
        </form>
    </body>
</html>
