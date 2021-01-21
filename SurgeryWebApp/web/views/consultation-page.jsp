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
                <h1>Edit consultation details</h1>    
                </header>    
                <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
                    <div id="consultationForm">       
                    <form action="ChangeConsultation" method="post">
                        Duration in minutes: <input type="text" name="duration" value="<% out.print(request.getAttribute("duration")); %>"><br>
                        Price: <input type="text" name="price" value="<% out.print(request.getAttribute("price")); %>"><br>
                        <input type="submit" value="Update details">
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
