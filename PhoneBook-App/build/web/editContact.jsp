<%-- 
    Document   : editContact
    Created on : Nov 20, 2025, 10:20:14 AM
    Author     : ADEKANMBI
--%>

<%@page import="entity.Contact"%>
<%@page import="dao.ContactDAO"%>
<%@page import="conn.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
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
            
            String failedMsg = (String) session.getAttribute("failedMsg");
            
            if(failedMsg != null) {
            %>
            <p class="text-danger text-center"><%=failedMsg%> </p>
            <%
                session.removeAttribute("failedMsg");
            }
            %>
            
            <form action="Update" method="post">
                <%
                    int cid = Integer.parseInt(request.getParameter("cid"));
                    ContactDAO dao = new ContactDAO(DbConnect.getConn());
                    Contact c = dao.getContactByID(cid);
                %>    
                
                <input type="hidden" value="<%=cid%>" name="cid">
                
                <div class="form-group">
    <label for="exampleInputEmail1">Name of Person</label>
    <input value="<%=c.getName()%>" name="name" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
                
  <div class="form-group">
    <label for="exampleInputEmail1">Phone Number</label>
    <input value="<%=c.getPhone()%>" name="phone" type="text" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
    <div class="form-group">
    <label for="exampleInputEmail1">Email</label>
    <input value="<%=c.getEmail()%>" name="email" type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
    
  </div>
    
  </div>
  <div class="form-group">
      <textarea  class="form-control" name="about" placeholder="Enter Details About the person"><%=c.getAbout()%></textarea>
    
  </div>
  
 
                <div class="text-center mt-2">
                    <button type="submit" class="btn btn-primary">Update Contact</button>
                </div>
</form>
        
        </div>
        </div>
        </div>
        </div>
        </div>
           
        
        
         <div style="margin-top: 11%">   
     <%@include file="component/footer.jsp" %>
        
    </body>
</html>
