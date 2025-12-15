<%-- 
    Document   : index
    Created on : Oct 17, 2025, 11:16:15 PM
    Author     : ADEKANMBI
--%>

<%@page import="entity.User"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Phonebook</title>
        <%@include file="component/allCss.jsp" %>
        
        
        <style type="text/css">
            .back-img{
                background: url("img/phone.png");
                width: 100%;
                height: 80vh;
                background-repeat: no-repeat;
                background-size: cover;
            }
        </style>
        
        
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        
        <div class="container-fluid back-img text-center text-danger mt-3  ">
            <h1>Welcome to your Phonebook Application</h1>
        </div>
        
        
        <%@include file="component/footer.jsp" %>   
    </body>
</html>
