package com.example.nguyenhuythuat_nsc.servlet;

import com.example.nguyenhuythuat_nsc.dao.UserDao;
import com.example.nguyenhuythuat_nsc.model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = {"/login"})
public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        UserDao dao = new UserDao();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        User user = dao.getUser(username, password); //'' or 1=1--
        if (user != null) {
            response.sendRedirect("index.jsp");
        }else {
            request.getRequestDispatcher("login.jsp").forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("login.jsp").forward(request, response);
    }
}
