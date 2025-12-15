/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import conn.DbConnect;
import dao.UserDAO;
import entity.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ADEKANMBI
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req,HttpServletResponse resp) throws ServletException, IOException {
       String email = req.getParameter("email");
       String pass = req.getParameter("password");
       
       UserDAO dao = new UserDAO(DbConnect.getConn()); 
       User u = dao.loginUser(email);
       HttpSession session = req.getSession();
       
       if (u != null && BCrypt.checkpw(pass, u.getPassword())) {
           
           session.setAttribute("user", u);
           resp.sendRedirect("index.jsp");
           //System.out.println("User is Available..." +u);
       }
       else {
           session.setAttribute("Invalid", "Invalid email and password");
           resp.sendRedirect("login.jsp");
           //System.out.println("User is not Available" +u );
       }
    }
}
