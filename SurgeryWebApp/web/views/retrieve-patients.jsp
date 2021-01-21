<%--
    Document   : retrieve-patients
    Created on : 14-Dec-2020, 11:32:06
    Author     : Jake
--%>

<%@page import="pojo.ClientInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Patients</title>
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
            <a href="../Logout">Logout</a>
            <a href="../Dashboard">Dashboard</a>
        </div>
        <div id="main">
            <header>
                <h2>Patients</h2>
            </header>
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
            
            <h2>Select which type of patient to list:</h2>
            <form action="ListPatients" method="post">
                NHS <input type="radio" name="ctype" value="NHS" checked>
                Private <input type="radio" name="ctype" value="private"><br>
                <input type="submit" value="List Patients">
            </form>
            <table>
                <tr>
                    <th>Client ID</th>
                    <th>Client Name</th>
                    <th>Client Address</th>
                    <th>Client Type</th>
                    <th>Client Username</th>
                </tr>
                <%
                    ArrayList<ClientInfo> patientInfo = (ArrayList<ClientInfo>) request.getAttribute("data");
                    for (ClientInfo info : patientInfo) {
                        out.println(String.format("<tr>"
                                + "<td>%s</td>"
                                + "<td>%s</td>"
                                + "<td>%s</td>"
                                + "<td>%s</td>"
                                + "<td>%s</td>"
                                + "</tr>",
                                info.cID,
                                info.cName,
                                info.cAddress,
                                info.cType,
                                info.cUname
                        ));
                    }
                %>
            </table>

            <h2>Remove Patient From Database</h2>
            <form action="ListPatients" method="post">
                Client ID: <input type="text" name="cID"><br>
                <input type="submit" value="Delete Patient">
            </form>      
        </div>     
    </body>
</html>
