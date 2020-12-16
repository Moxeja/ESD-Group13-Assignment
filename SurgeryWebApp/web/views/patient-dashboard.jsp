<%-- 
    Document   : patient-dashboard
    Created on : 24-Nov-2020, 14:52:33
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Patient Dashboard</title>
    </head>
    <body>
        <h4><a href="./">Homepage</a></h4>
        <h4><a href="./Logout">Logout</a></h4>
        <h1>Hello <%= session.getAttribute("username")%></h1>
        <% 
            if (request.getAttribute("msg") != null) {
                out.print("<h3>" + request.getAttribute("msg") + "</h3><br>");
            }
        %>
        <h2>Book Appointment</h2>
        <form action="./Patient/Appointments" method="post">
            <h4><a href="./Patient/Appointments">Create Appointment</a></h4>
            <h4><a href="./Patient/DestroyAppointments">Manage Appointments</a></h4>
        </form>
    </body>
</html>
