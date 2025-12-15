<%-- 
    Document   : register
    Created on : Oct 17, 2025, 11:18:48 PM
    Author     : ADEKANMBI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <%@include file="component/allCss.jsp" %>
    </head>
    <body style="background-color: #d5dbd6">
        <%@include file="component/navbar.jsp" %>
        <div class="container-fluid"> 
            <div class="row p-2">
                <div class="col-md-6 offset-md-3">
                    <div class="card">
                     <div class="card-body">
            <h4 class="text-center text-danger">Registration Page</h4>
            
            <% 
            String successMsg = (String) session.getAttribute("successMsg");
            String ErrorMsg = (String) session.getAttribute("ErrorMsg");
            if(successMsg != null) {
            %>
            <p class="text-success text-center"><%=successMsg%> </p>
            <%
            }
            if(ErrorMsg != null) {
            %>
            <p class="text-danger text-center"><%=ErrorMsg%> </p>
            <%
            }
            %>
            
            <form action="register" method="post">
                <div class="form-group">
    <label for="exampleInputEmail1">Enter Name</label>
    <input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
                
  <div class="form-group">
    <label for="exampleInputEmail1">Email address</label>
    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
  <div class="form-group">
    <label for="exampleInputPassword1">Password</label>
    <input name="password" type="password" class="form-control" id="exampleInputPassword1">
  </div>
  
 
                <div class="text-center mt-3">
                    <button type="submit" class="btn btn-primary">Register</button>
                </div>
</form>
        
        </div>
        </div>
        </div>
        </div>
        </div>
           
        
        
         <div style="margin-top: 15%">   
     <%@include file="component/footer.jsp" %>  
        </div>
    </body>
    
</html>
