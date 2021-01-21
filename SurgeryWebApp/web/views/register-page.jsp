<%-- 
    Document   : register-page
    Created on : 24-Nov-2020, 15:07:44
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Register</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
    <body>
         <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="./">Homepage</a>
        <a href="./Login">Login</a>
        <a href="./Logout">Logout</a>
        </div>
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
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
        
        <div class="loginbox">
        <img src="avatar.png" class="avatar">
             <h1>Register Here</h1>
             <form action="Register" method="post">
                Username: <input type="text" name="username"><br>
                Password: <input type="password" name="password"><br><br>
                Full Name: <input type="text" name="name"><br>
                Address: <input type="text" name="address"><br>
                Client Type: NHS <input type="radio" name="ctype" value="NHS" checked>
                Private <input type="radio" name="ctype" value="private"><br>
                <input type="submit" value="Register">
             </form>
        </div>
    </body>
          
</html>
