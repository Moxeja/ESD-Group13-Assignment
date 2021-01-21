<%--
    Document   : doctor-dashboard
    Created on : 24-Nov-2020, 14:53:11
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Medical Staff Dashboard</title>
        <link rel="stylesheet" type="text/css" href="style.css">

        <script>
            function openNav() {
                document.getElementById("mySidenav").style.width = "250px";
                document.getElementById("main").style.marginLeft = "250px";
            }

            function closeNav() {
                document.getElementById("mySidenav").style.width = "0";
                document.getElementById("main").style.marginLeft = "0";
            }
        </script>
    </head>
    <body>
        <div id="mySidenav" class="sidenav">
            <a href="javascript:void(0)" class="closebtn" onclick="closeNav()">&times;</a>
            <a href="./">Homepage</a>
            <a href="./Logout">Logout</a>
        </div>
        <div id="main">
            <header>
                <h1>Medical Staff Dashboard</h1>
            </header>
            <div class="btn-group" style="width:100%">
                <button style="width:33.3%"><a href="./Staff/ManagePatients">Forward Patients</a></button>
                <button style="width:33.3%"><a href="./Staff/IssuePrescriptions">Issue Prescriptions</a></button>
                <button style="width:33.3%"><a href="./Staff/retrieve-schedule">View Schedule</a></button>
            </div>
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
        </div>
    </body>
</html>
