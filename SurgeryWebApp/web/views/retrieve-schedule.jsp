<%-- 
    Document   : retrieve-schedule
    Created on : 17-Jan-2021
    Author     : Nicola
--%>

<%@page import="pojo.ScheduleInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Operation schedule</title>
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
                <h1>Operation schedule</h1>
                </header>
                
                <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
                        <table>
                            <tr>
                                <th>Operation Id</th>
                                <th>Employee Id</th>
                                <th>Client Id</th>
                                <th>Date</th>
                                <th>Slot</th>
                                <th>Time</th>
                                <th>Charge</th>
                            </tr>
                                <%  
                                    ArrayList<ScheduleInfo> scheduleInfo = (ArrayList<ScheduleInfo>)request.getAttribute("data");
                                    for(ScheduleInfo info : scheduleInfo) {
                                       out.println(String.format("<tr>"
                                               +"<td>%s</td>"
                                               + "<td>%s</td>"
                                               + "<td>%s</td>"
                                               + "<td>%s</td>"
                                               + "<td>%s</td>"
                                               + "<td>%s</td>"
                                               + "<td>%s</td>"
                                               + "</tr>",
                                               info.oID,
                                               info.eID,
                                               info.cID,
                                               info.oDate,
                                               info.nSlot,
                                               info.oTime,
                                               info.charge
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
