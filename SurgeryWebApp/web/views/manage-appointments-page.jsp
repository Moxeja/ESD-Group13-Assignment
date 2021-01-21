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
        <link rel="stylesheet" type="text/css" href="../style.css">
    </head>
    <body>
        <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="../">Homepage</a>
        <a href="../Logout">Logout</a>
        <a href="../Dashboard">Dashboard</a>
        </div>
            <div id="main">
                <header> 
                    <h1>Hello <%= session.getAttribute("username")%></h1>
             <% 
            if (request.getAttribute("msg") != null) {
                out.print("<h3>" + request.getAttribute("msg") + "</h3><br>");
            }
             %>
                </header>
                  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
                  
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
            </div>
        <script>
            function openNav() {
              document.getElementById("mySidenav").style.width = "250px";
              document.getElementById("main").style.marginLeft = "250px";
            }

            function closeNav() {
              document.getElementById("mySidenav").style.width = "0";
              document.getElementById("main").style.marginLeft= "0";
            }
            </script>           
    </body>
</html>
