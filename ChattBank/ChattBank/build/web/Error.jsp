<%-- 
    Document   : Lab 5
    Created on : Oct 11, 2019, 4:38:07 PM
    Author     : Chelsea Piccirilli
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.customer" %>
<!DOCTYPE html>
<html>
    <head>
        <title>ChattBank - LOGIN ERRORR!!!!!</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <%        
        customer c1;
        c1 = (customer)session.getAttribute("customer");
        System.out.println("Got Session");
        c1.display();
        String id = c1.getCustId();
        %>
       
        <header>
            <h1>ChattBank</h1>
        </header>
        <nav>
            <a href="index.html">Home</a> <a href="login.html">Login</a>
        </nav> 
        <div>
            <h2>Login Error!</h2>
            <p>Error Logging in for User with ID: <%= id %></p>
        </div>
        <footer>
            <h5>A list of our corporate sponsors:</h5>
            No one.                
        </footer>
    </body>
</html>
1