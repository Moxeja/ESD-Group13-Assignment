<%-- 
    Document   : manage-appointments-page
    Created on : 14-Dec-2020, 16:00:29
    Author     : Tom
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Appointment Management</title>
    </head>
    
    <body>

        <h1>Hello <%= session.getAttribute("username")%></h1>
        <% 
            if (request.getAttribute("msg") != null) {
                out.print("<h3>" + request.getAttribute("msg") + "</h3><br>");
            }
        %>
        <h2>Book Appointment</h2>
        <form action="Appointments" method="post">
            Employee's name <input type="text" name="employee"><br>
            Date <input type ="date" name ="date"><br>
            Time <input type ="time" name ="time"><br>

            <input type="submit" value="Create">
        </form>
        <h2>Remove Appointment</h2>
    </body>
</html>