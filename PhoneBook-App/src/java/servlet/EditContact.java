/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import conn.DbConnect;
import dao.ContactDAO;
import entity.Contact;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;

/**
 *
 * @author ADEKANMBI
 */
@WebServlet("/Update")
public class EditContact extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        int cid = Integer.parseInt(req.getParameter("cid"));
        String name = req.getParameter("name");
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String about = req.getParameter("about");
        
        Contact c = new Contact();
        c.setId(cid);
        c.setName(name);
        c.setPhone(phone);
        c.setEmail(email);
        c.setAbout(about);
        
        
        ContactDAO dao = new ContactDAO(DbConnect.getConn());
         HttpSession session = req.getSession();
        boolean f = dao.updateContact(c);
        if(f){
            session.setAttribute("succMsg", "Your Contact is Updated ");
            resp.sendRedirect("viewContact.jsp");
        } else {
            session.setAttribute("failedMsg", "Something went wrong");
            resp.sendRedirect("editContact.jsp?cid="+cid);
        }
        
        
    }
    
}
