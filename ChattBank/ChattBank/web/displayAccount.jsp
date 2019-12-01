<%-- 
    Document   : displayAccount.jsp
    Created on : Oct 15, 2019, 9:35:02 PM
    Author     : Chelsea
--%>

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
        <jsp:useBean id="a1" class="business.account" scope="session"/>
           

        <header>
            <h1>ChattBank</h1>
        </header>
        <nav>
            <a href="index.html">Home</a> <a href="login.html">Login</a>
        </nav> 
        <div>
            <h2> DISPLAY ACCT</h2>
            <form method="post" action="http://localhost:8080/ChattBank/accountLookupServlet">
            <table>
                <tr>
                    <td>Account #:</td><td><input type="text" name="acct" value="<jsp:getProperty property="acctNo" name="a1" />"></td>                    
                </tr>
                <tr>
                    <td>Customer Id:</td><td><input type="text" name="custid" value="<jsp:getProperty property="custId" name="a1" />"></td>
                </tr>
                <tr>
                    <td>Acc. Type:</td><td><input type="text" name="accttype" value="<jsp:getProperty property="type" name="a1" />"></td>
                    
                </tr>
                <tr>
                    <td>Balance:</td><td><input type="text" name="balance" value="<jsp:getProperty property="balance" name="a1" />"></td>
                </tr>
                <tr>
                        <td></td>
                        <td><input type="submit" name="submitbtn" value="Look Up..." /> 
                        <input type="reset" value="clear" /></td>
                </tr>
            </table>
            </form>
            
        </div>
        
        <footer>
            <h5>A list of our corporate sponsors:</h5>
            No one.                
        </footer>
    </body>
</html>
