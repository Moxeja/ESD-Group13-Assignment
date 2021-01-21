<%-- 
    Document   : pay-bills-page
    Created on : 18-Jan-2021, 17:31:28
    Author     : Jake
--%>

<%@page import="java.text.DecimalFormat"%>
<%@page import="pojo.InvoiceInfo"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pay Bills</title>
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
                    <h1>Hello <%= session.getAttribute("username")%></h1>
             <% 
            if (request.getAttribute("msg") != null) {
                out.print("<h3>" + request.getAttribute("msg") + "</h3><br>");
            }
             %>
                </header>
                  <span style="font-size:30px;cursor:pointer" onclick="openNav()">&#9776; MENU</span>
                  
                  
        <h1>Current Bills</h1>
        <table>
            <tr>
                <th>Invoice ID</th>
                <th>Paid For</th>
                <th>Cost</th>
            </tr>
                <%  
                    ArrayList<InvoiceInfo> data = (ArrayList<InvoiceInfo>) request.getAttribute("data");
                    for (InvoiceInfo invoice : data) {
                       out.println(String.format(
                               "<tr><td>%d</td>"
                               + "<td>%b</td>"
                               + "<td>%s</td></tr>",
                               invoice.iID,
                               invoice.iPaid,
                               new DecimalFormat("£#.##").format(invoice.charge)
                       ));
                    }
                %>
        </table><br>
        <form action="PayBills" method="post">
            Invoice ID: <input type="text" name="iID" required><br>
            Credit Card Number: <input type="text" name="card" required><br>
            Expiry Date: <input type="date" name="expiry" required><br>
            Name on Card: <input type="text" name="cardname" required><br>
            CSC (Number on back): <input type="text" name="csc" required><br>
            <input type="submit" value="Pay Bill">
        </form>
        
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
