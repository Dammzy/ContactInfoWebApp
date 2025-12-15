/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package servlet;

import conn.DbConnect;
import dao.UserDAO;
import entity.User;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.mindrot.jbcrypt.BCrypt;

/**
 *
 * @author ADEKANMBI
 */
@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    
    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response){
        String name = request.getParameter("name");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        
        String hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt());
        
        User u = new User(name, email, hashedPassword);
        
        u.setName(name);
        u.setEmail(email);
        u.setPassword(hashedPassword);
        
        UserDAO dao=new UserDAO(DbConnect.getConn());
        
        boolean f=dao.userRegister(u);
        
        HttpSession session = request.getSession();
        
        if(f)
        {
            try {
                session.setAttribute("successMsg", "User Registered Successfully...");
                response.sendRedirect("register.jsp");
                //System.out.println("User Registered Successfully...");
            } catch (IOException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        else {
            try {
                session.setAttribute("ErrorMsg", "Something wrong on Server...");
                response.sendRedirect("register.jsp");
                //System.out.println("User Registered Successfully...");
            } catch (IOException ex) {
                Logger.getLogger(RegisterServlet.class.getName()).log(Level.SEVERE, null, ex);
            }
             //System.out.println("Something wrong on Server...");
        }
    }
}
