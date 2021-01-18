<%-- 
    Document   : consultation-page
    Created on : 18-Jan-2021, 00:16:20
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Change consultation details</title>
    </head>
    <body>
        <h1>Edit consultation details</h1>
        <h4><a href="../">Homepage</a></h4>
        <h4><a href="../Logout">Logout</a></h4>
        <form action="ChangeConsultation" method="post">
            Duration in minutes: <input type="text" name="duration" value="<% out.print(request.getAttribute("duration")); %>"><br>
            Price: <input type="text" name="price" value="<% out.print(request.getAttribute("price")); %>"><br>
            <input type="submit" value="Update details">
        </form>
    </body>
</html>
