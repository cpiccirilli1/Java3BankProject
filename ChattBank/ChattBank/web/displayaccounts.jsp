<%-- 
    Document   : displayaccounts
    Created on : Oct 21, 2019, 9:10:09 AM
    Author     : Chelsea
--%>

<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="business.*"  %>
<!DOCTYPE html>
<html>
    <head>
        <title>ChattBank - One stop shop for a blank login.</title>
        <meta charset="UTF-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1.0" />
        <link rel="stylesheet" type="text/css" href="style.css" />
    </head>
    <body>
        <header>
            <h1>ChattBank</h1>
        </header>
        <nav>
            <a href="index.html">Home</a> <a href="login.html">Login</a>
        </nav> 
        <div>
            <h2>Displaying all accounts!</h2>
            <br/>
            
            <% 
                customer c1; //Create empty class
                c1 = (customer)session.getAttribute("c1"); //fill with session class
                AccountList alist = new AccountList(); 
                alist = c1.alist; //get the AccountList class
                ArrayList<account> a = new ArrayList<>(); //Create a new arraylist object
                a = alist.arr; //fill it with the account arraylist in the customer object
                System.out.println("display accountSSSS!");
                c1.display();
              %>
            
        </div>
        <footer>
            <h5>A list of our corporate sponsors:</h5>
            No one.                
        </footer>
    </body>
</html>
