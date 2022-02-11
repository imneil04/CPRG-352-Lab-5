<%-- 
    Document   : register
    Created on : Feb. 9, 2022, 2:04:18 p.m.
    Author     : neild
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Shopping List</h1>
        
        <form action="ShoppingList" method="post">
            <label for ="name"></label>
            <input type ="text" name="name" id="name" required>
            
            <button type="submit">Register name</button>
            <p>${message}</p>    
        </form>
    </body>
</html>
