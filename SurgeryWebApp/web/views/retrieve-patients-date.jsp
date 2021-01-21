<%-- 
    Document   : retrieve-patients-date
    Created on : 20-Jan-2021, 14:06:32
    Author     : Jamie Warner
--%>

<%@page import="pojo.ClientInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of Patients from dates specified</title>
<!--        <style> table {border-spacing: 10px} </style>-->
        <link rel="stylesheet" type="text/css" href="../style.css">
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
                    <h1>Patients by date</h1>
                </header>
                <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
      
                <h2>Select which dates you wish to view:</h2>
                <form action="../Admin/ListPatientsDate" method="post">
                    Date <input type ="date" name ="startDate"><br>
                    Date <input type ="date" name ="endDate"><br>
                    <input type="submit" value="List Patients Date">
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
                                ArrayList<ClientInfo> patientInfo = (ArrayList<ClientInfo>)request.getAttribute("data");
                                for(ClientInfo info : patientInfo) {
                                   out.println(String.format("<tr>"
                                           +"<td>%s</td>"
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
