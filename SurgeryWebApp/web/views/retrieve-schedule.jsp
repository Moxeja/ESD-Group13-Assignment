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
        <style> table {border-spacing: 10px} </style>
    </head>
    <body>
        <h4><a href="../">Homepage</a></h4>
        <h4><a href="../Logout">Logout</a></h4>
        <h4><a href="../Dashboard">Dashboard</a></h4
        <h1>Operation schedule</h1>
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
    </body>
</html>
