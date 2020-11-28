<%-- 
    Document   : error-page
    Created on : 24-Nov-2020, 15:39:59
    Author     : Jake
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>SmartCare Error</title>
    </head>
    <body>
        <h2>An error has occurred:</h2>
        <h3><%= request.getAttribute("error") %></h3>
        <h4><a href="index.html">HomePage</a></h4>
    </body>
</html>
