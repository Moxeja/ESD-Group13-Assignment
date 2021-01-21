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
                  
                  <div>    
                    <h2>Book Appointment</h2>
                    <form action="Appointments" method="post">
                        Employee's name <input type="text" name="employee"><br>
                        Date <input type ="date" name ="date"><br>
                        Time <input type ="time" name ="time"><br>

                        <input type="submit" value="Create">
                    </form>
                    
                </div>
                  
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