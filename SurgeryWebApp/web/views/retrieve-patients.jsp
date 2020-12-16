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
        <style> table {border-spacing: 10px} </style>
    </head>
    <body>
        <h4><a href="../">Homepage</a></h4>
        <h4><a href="../Logout">Logout</a></h4>
        <h4><a href="../Dashboard">Dashboard</a></h4>
        <h2>Select which type of patient to list:</h2>
        <form action="ListPatients">
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
    </body>
</html>
