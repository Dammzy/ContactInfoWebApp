/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import conn.DbConnect;
import dao.ContactDAO;
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
@WebServlet("/delete")
public class DeleteContact extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       int cid = Integer.parseInt(req.getParameter("cid"));
       
       ContactDAO dao = new ContactDAO(DbConnect.getConn());
       
       boolean f = dao.deletContactById(cid);
        HttpSession session = req.getSession();
        
        if(f){
            session.setAttribute("succMsg", "Contact Deleted Successfully");
            resp.sendRedirect("viewContact.jsp");
        } else {
            session.setAttribute("failedMsg", "Something went wrong");
            resp.sendRedirect("editContact.jsp?cid="+cid);
        }
       
    }
    
}
