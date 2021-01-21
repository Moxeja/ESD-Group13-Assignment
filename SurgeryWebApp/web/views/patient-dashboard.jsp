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
        <link rel="stylesheet" type="text/css" href="style.css">
    </head>
    <body>
         <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="./">Homepage</a>
        <a href="./Logout">Logout</a>
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
                
                    <div class="btn-group" style="width:100%">
                        <button style="width:25%"><a href="./Patient/Appointments">Create Appointment</a></button>
                        <button style="width:25%"><a href="./Patient/DestroyAppointments">Manage Appointments</a></button>
                         <button style="width:25%"><a href="./Patient/RepeatPrescription">Order Repeat Prescription</a></button>
                        <button style="width:25%"><a href="./Patient/PayBills">Pay Outstanding Bills</a></button>
                       
                    </div>
                    <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>

        <form action="./Patient/Appointments" method="post">
          
        </form>
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
