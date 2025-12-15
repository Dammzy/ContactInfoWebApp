<%-- 
   Document   : viewContact
   Created on : Oct 17, 2025, 11:19:20 PM
   Author     : ADEKANMBI
--%>

<%@page import="java.util.List"%>
<%@page import="entity.Contact"%>
<%@page import="dao.ContactDAO"%>
<%@page import="conn.DbConnect"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Your contacts</title>
        <%@include file="component/allCss.jsp" %>
        <style type="text/css">
            .crd-ho:hover{
                background-color: #f7f7f7;
            }
            
            
            
            
        </style>
    </head>
    <body>
        <%@include file="component/navbar.jsp" %>
        
        
        <%
            if(user == null) {
            session.setAttribute("Invalid", "Login Please..."); 
            response.sendRedirect("login.jsp");
            }
        %>
        
        <%
        String succMsg =(String)session.getAttribute("succMsg");
        String failedMsg = (String) session.getAttribute("failedMsg");
        if (succMsg!=null)
        {%>
        <div class="alert alert-success" role="alert"><%=succMsg%></div>
        <%
        session.removeAttribute("succMsg");
            }

            if(failedMsg != null) {
            %>
            <p class="text-danger text-center"><%=failedMsg%> </p>
            <%
                session.removeAttribute("failedMsg");
            }
            %>
        
        
        
        
        <div class="container">
            <div class="row p-4">
                 
                    
                    <%
                        
                        if(user!=null)
                        {
                        
                        ContactDAO dao = new ContactDAO(DbConnect.getConn());
                        List<Contact> contact = dao.getAllContact(user.getId());
                        

                        for(Contact c:contact)
                        {%>
                        <div class="col-md-3">
                        <div class="card crd-ho">
                        <div class="card-body">
                            <h5>Name: <%=c.getName()%> </h5>
                            <p>Ph no: <%=c.getPhone()%> </p>
                            <p>Email:<%=c.getEmail()%></p>
                            <p>About:<%=c.getAbout()%></p>
                            <div class="text-center">
                                <a href="editContact.jsp?cid=<%=c.getId()%>" class="btn btn-success btn-sm text-white">Edit</a>
                                <a href="delete?cid=<%=c.getId()%>" class="btn btn-danger btn-sm text-white">Delete</a>
                            </div>
                        </div>
                    </div>
                </div>            
                        <%}
                          }
                        %>
                    
                    
                </div>
                
            </div>
        </div>
    </body>
</html>
