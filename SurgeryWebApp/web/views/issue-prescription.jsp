<%-- 
    Document   : issueprescription
    Created on : 20-Jan-2021, 16:14:58
    Author     : Delaylal-PC
--%>

<%@page import="pojo.MedicinesInfo"%>
<%@page import="pojo.ClientInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Issue Prescription</title>
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
                    <h1>Prescriptions</h1>
                </header>
                  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>

        <h2>Current Patients</h2>
            <table>
                   <tr>
                       <th>Patient ID</th>
                       <th>Name</th>
                       <th>Patient Address</th>
                       <th>Type</th>
                   </tr>
                       <%  
                           ArrayList<ClientInfo> patientInfo = (ArrayList<ClientInfo>)request.getAttribute("data");
                           for(ClientInfo info : patientInfo) {
                              out.println(String.format(
                                      "<tr><td>%s</td>"
                                      + "<td>%s</td>"
                                      + "<td>%s</td>"
                                      + "<td>%s</td>"     
                                      + "</tr>",
                                      info.cID,
                                      info.cName,
                                      info.cAddress,
                                      info.cType
                              ));
                           }
                       %>
               </table>
        
                <h2>Medicines</h2>
                <form action="IssuePrescriptions" method="post">
                    Patient ID: <input type="text" name="cID"><br><br>
                    <select name="medicines">
                        <%
                            
                            //make it array first
                             ArrayList<MedicinesInfo> medicines = ( ArrayList<MedicinesInfo>)request.getAttribute("medicines");
                                for(MedicinesInfo medicine:medicines)
                            {       
                              out.println(String.format("<option value=\"%d\">%s</option>",medicine.mID , medicine.mName));  
                            }
                        %>    
                    </select>   
                    <input type="submit" value="Confirm">
                </form>
                

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
