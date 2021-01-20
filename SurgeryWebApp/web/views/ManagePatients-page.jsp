<%-- 
    Document   : ManagePatients
    Created on : 20-Jan-2021, 09:27:30
    Author     : Tom
--%>

<%@page import="pojo.EmployeeInfo"%>
<%@page import="pojo.ClientInfo"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Patients</title>
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
                    <h1>Hello </h1>
                </header>
                  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>

        <h2>Current Patients</h2>
        <table>
            <tr>
                <th>Client ID</th>
                <th>Client</th>
                <th>Client Address</th>
                <th>Client Type</th>

            </tr>
                <%  
                    ArrayList<ClientInfo> patientInfo = (ArrayList<ClientInfo>)request.getAttribute("data");
                    for(ClientInfo info : patientInfo) {
                       out.println(String.format("<form action= \"ForwardPatient\" method = \"post\">"
                            +"<tr><td>%s</td>"
                            + "<td>%s</td>"
                            + "<td>%s</td>"
                            + "<td>%s</td>"
                            + "</tr>"
                            + "</form>",
                            info.cID,
                            info.cName,
                            info.cAddress,
                            info.cType

                       ));
                    }
                %>
        </table>
        <h3>Transfer Form</h2>
        <form action="./ManagePatients" method="post">

            Client Name<input type ="cName" name ="cName"><br>
            Reason For Transfer <input type ="reason" name ="reason"><br>
            Location of Transfer <input type ="location" name ="location"><br>
            Specialist Wanted <input type ="specialist" name ="specialist"<br>
            <input type="submit" value="Transfer">

        </form>
        <% String formalrequest = "";
        formalrequest = (String)request.getAttribute("request");
        %>
        <textarea name='test' id='test'><%=formalrequest %> </textarea>

        
        
        
        
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
