<%-- 
    Document   : turnover-page
    Created on : 21-Jan-2021, 12:58:06
    Author     : Jake
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Turnover</title>
        <link rel="stylesheet" type="text/css" href="../style.css">

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
            <a href="../">Homepage</a>
            <a href="../Dashboard">Dashboard</a>
            <a href="../Logout">Logout</a>
        </div>
        <div id="main">
            <header>
                <h1>Turnover Viewer</h1>
            </header>
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
            <h2>Select which dates you wish to view:</h2>
            <form action="Turnover" method="post">
                Start Date: <input type="date" name="startDate"><br>
                End Date: <input type="date" name="endDate"><br>
                <input type="submit" value="Show turnover">
            </form>

            <%
                if (request.getAttribute("turnover") != null) {
                    float turnover = (Float) request.getAttribute("turnover");
                    out.println(String.format("<h2>Calculated Turnover: %s</h2>", new DecimalFormat("£#.##").format(turnover)));
                }
            %>
        </div>
    </body>
</html>
