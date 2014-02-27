package main.backend;

import dao.Factory;
import domain_objects.User;
import util.AuthUser;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

public class Auth extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AuthUser User_Auth = (AuthUser) session.getAttribute("userInfo");
        try {
            User User_Info = Factory.getInstance().DAOUser().getByName("admin");
            request.setAttribute("User", User_Info.getId());
        } catch (SQLException e) {
            request.setAttribute("errors", e);
        }
        if (User_Auth == null)
            User_Auth = new AuthUser();
        if (User_Auth.IsLogin().equals("true"))
            response.sendRedirect("/backend/category");
        else
            request.getRequestDispatcher("backend/backend-login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ResultPage;
        HttpSession session = request.getSession();
        AuthUser User_Auth = (AuthUser) session.getAttribute("userInfo");
        if (User_Auth == null)
            User_Auth = new AuthUser();
        if (username.equals("test") && password.equals("test")) {
            User_Auth.Login(username);
            ResultPage = "/backend/category";
            session.setAttribute("userInfo", User_Auth);
        } else {
            ResultPage = "/backend";
            User_Auth.SetError("Incorrect user name - " + username);
            session.setAttribute("userInfo", User_Auth);
        }


        response.sendRedirect(ResultPage);

    }
}
