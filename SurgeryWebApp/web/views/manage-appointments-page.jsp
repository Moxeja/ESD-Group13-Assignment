<%-- 
    Document   : manage-appointments-page.jsp
    Created on : 14-Dec-2020, 16:10:01
    Author     : Tom
--%>

<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Appointments</title>
        <style> table {border-spacing: 10px} </style>
    </head>
    <body>
        <h1>Current Appointments</h1>
        <table>
            <tr>
                <th>Appointment ID</th>
                <th>Employee</th>
                <th>Client</th>
                <th>Date</th>
                <th>Time</th>
            </tr>
            
                <%  
                    List<ArrayList<String>> appointments = (List<ArrayList<String>>)request.getAttribute("appointments");
                    for(ArrayList<String> appointment:appointments){
                       out.println(String.format("<form action= \"DestroyAppointments\" method = \"post\">"
                               + "<tr><td>%s</td>"
                               + "<td>%s</td>"
                               + "<td>%s</td>"
                               + "<td>%s</td>"
                               + "<td>%s</td>"
                               + "<td><button name =\"delete\" type=\"submit\" value=\"%s\">Delete</button></td>"
                               + "</tr>"
                               + "</form>",
                               appointment.get(0),
                               appointment.get(1),
                               appointment.get(2),
                               appointment.get(3),
                               appointment.get(4),
                               appointment.get(0))
                       );
                    }
                %>
            
        </table>
    </body>
</html>
