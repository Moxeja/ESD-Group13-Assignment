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
        <title>Register Employee</title>
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
                 <h1>Register a new Doctor or Nurse</h1>
                </header>  
       
        <% 
            if (request.getAttribute("msg") != null) {
                out.print("<h3>" + request.getAttribute("msg") + "</h3><br>");
            }
        %>
        
        
        <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
        
            <div>
            <form action="AddStaff" method="post">
                Username: <input type="text" name="username"><br>
                Password: <input type="text" name="password"><br><br>
                Full Name: <input type="text" name="name"><br>
                Address: <input type="text" name="address"><br>
                User Type: Doctor<input type="radio" name="type" value="doctor" checked>
                Nurse<input type="radio" name="type" value="nurse"><br><br>
                <input type="submit" value="Register">
            
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
