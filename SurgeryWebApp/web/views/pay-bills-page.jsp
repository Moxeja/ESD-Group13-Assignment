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
        <style> table {border-spacing: 10px} </style>
    </head>
    <body>
        <h4><a href="../">Homepage</a></h4>
        <h4><a href="../Logout">Logout</a></h4>
        <h4><a href="../Dashboard">Dashboard</a></h4>
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
    </body>
</html>
