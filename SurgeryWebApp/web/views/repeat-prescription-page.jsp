<%--
    Document   : repeat-perscription-page
    Created on : 21-Jan-2021, 03:20:28
    Author     : Jake
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="pojo.MedicinesInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Repeat Prescription</title>
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
                <h1>Order a Repeat Prescription</h1>
            </header>
            <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>

            <h1>Current Prescriptions</h1>
            <%
                if (request.getAttribute("msg") != null) {
                    out.println(String.format("<h2>%s</h2>", (String) request.getAttribute("msg")));
                }
            %>
            <table>
                <tr>
                    <th>Medication ID</th>
                    <th>Medication Name</th>
                    <th>Medication Type</th>
                    <th>Medication Cost</th>
                </tr>
                <%
                    ArrayList<MedicinesInfo> prescriptions = (ArrayList<MedicinesInfo>) request.getAttribute("prescriptions");
                    for (MedicinesInfo prescription : prescriptions) {
                        out.println(String.format(
                                "<tr><td>%d</td>"
                                + "<td>%s</td>"
                                + "<td>%s</td>"
                                + "<td>%s</td></tr>",
                                prescription.mID,
                                prescription.mName,
                                prescription.mType,
                                new DecimalFormat("£#.##").format(prescription.mCost)
                        ));
                    }
                %>
            </table>

            <br>
            <form action="RepeatPrescription" method="post">
                Medication ID: <input type="text" name="medication">
                <input type="submit" value="Request Medication">
            </form>
        </div>
    </body>
</html>
