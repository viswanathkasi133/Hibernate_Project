package com.tap.servlets;

import java.io.IOException;

import com.tap.HibernateUtil;
import com.tap.dao.UserDAO;
import com.tap.entity.User;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/register")
public class Main extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String department = req.getParameter("department");
        String salary = req.getParameter("salary");
        String email = req.getParameter("email");
        String password = req.getParameter("password");
        
        User u = new User(name, department, salary, email, password);
        System.out.println(u);
        
        try {
            UserDAO dao = new UserDAO(HibernateUtil.getSessionFactory());
            boolean success = dao.saveUser(u);
            HttpSession session = req.getSession();
            if (success) {
                session.setAttribute("msg", "User registered successfully");
                System.out.println("User registered successfully");
            } else {
                session.setAttribute("msg", "Something went wrong on the server..");
                System.out.println("Something went wrong...");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
            // Log the error or handle it gracefully
            e.printStackTrace();
        } finally {
            // No need to close the session factory here
        }
        resp.sendRedirect("index.jsp");
    }
}
