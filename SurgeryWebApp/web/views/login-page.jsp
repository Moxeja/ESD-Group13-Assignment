<%-- 
    Document   : login-page
    Created on : 24-Nov-2020, 15:07:44
    Edited on  : 18-Jan-2020
    Author     : Jake
    Edit/Style : Dominika
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
    <body> 
        <div id="mySidenav" class="sidenav">
        <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
        <a href="./">Homepage</a>
        <a href="./Register">Register</a>
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
             <h1>Login Here</h1>
             <form action="Login" method="post">
                   Username: <input type="text" name="username" placeholder="Enter Username"><br>
                   Password: <input type="password" name="password"placeholder="Enter Password"><br>
                   <input type="submit" value="Login">
                   <a href="./Register">Don't have an account? CLICK TO REGISTER</a>
             </form>
        </div>
    </body>
</html>
