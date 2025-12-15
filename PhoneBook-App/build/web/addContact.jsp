<%-- 
    Document   : addContact
    Created on : Oct 17, 2025, 11:19:05 PM
    Author     : ADEKANMBI
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>ADD CONTACTS</title>
        <%@include file="component/allCss.jsp" %>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        
        <%
            if(user == null) {
            session.setAttribute("Invalid", "Login Please...");
            response.sendRedirect("login.jsp");
            }
        %>
        <div class="container-fluid"> 
            <div class="row p-2">
                <div class="col-md-4 offset-md-4">
                    <div class="card">
                     <div class="card-body">
            <h4 class="text-center text-danger">Fill Your Contact Details</h4>
            
            <% 
            String succMsg = (String) session.getAttribute("succMsg");
            String failedMsg = (String) session.getAttribute("failedMsg");
            if(succMsg != null) {
            %>
            <p class="text-success text-center"><%=succMsg%> </p>
            <%
            }
            if(failedMsg != null) {
            %>
            <p class="text-danger text-center"><%=failedMsg%> </p>
            <%
            }
            %>
            
            <form action="AddContact" method="post">
                <%
                    if(user!=null)
                    {%>
                    <input type="hidden" value="<%=user.getId()%>" name="userID">
                    
                <%}
                %>    
                <div class="form-group">
    <label for="exampleInputEmail1">Name of Person</label>
    <input name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
                
  <div class="form-group">
    <label for="exampleInputEmail1">Phone Number</label>
    <input name="phone" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
    <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
    
  </div>
  <div class="form-group">
      <textarea class="form-control" name="about" placeholder="Enter Details About the person">About</textarea>
    
  </div>
  
 
                <div class="text-center mt-3">
                    <button type="submit" class="btn btn-primary">Add Contact</button>
                </div>
</form>
        
        </div>
        </div>
        </div>
        </div>
        </div>
           
        
        
         <div style="margin-top: 11%">   
     <%@include file="component/footer.jsp" %>  
        </div>
    </body>
</html>
