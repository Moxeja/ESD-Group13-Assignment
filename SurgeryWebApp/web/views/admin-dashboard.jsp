<%-- 
    Document   : admin-dashboard
    Created on : 24-Nov-2020, 14:52:55
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Dashboard</title>
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
                    <h1>Admin Dashboard</h1>
                </header>
                 <div class="btn-group" style="width:100%">
                        <button style="width:20%"><a href="./Admin/AddStaff">Add Doctor or Nurse</a></button>
                        <button style="width:20%"><a href="./Admin/ListPatients">List current patients</a></button>
                        <button style="width:20%"><a href="./Admin/ListPatientsDate">List current patients by surgery dates</a></button>
                        <button style="width:20%"><a href="./Admin/ChangeConsultation">Change consultation settings</a></button>
                        <button style="width:20%"><a href="./Admin/remove-surgery">Remove patient from schedule</a></button>   
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
    </body>
</html>
