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
        AuthUser User = (AuthUser) session.getAttribute("userInfo");
        if (User == null)
            User = new AuthUser();
        if (User.IsLogin().equals("true"))
            response.sendRedirect("/");
        else
            request.getRequestDispatcher("backend/backend-login.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String ResultPage;
        HttpSession session = request.getSession();
        AuthUser User = (AuthUser) session.getAttribute("userInfo");
        try {
            User NewUser = new User();
            NewUser.setName("TV4");
            NewUser.setIs_admin(true);
            NewUser.setPassword("1234");
            Factory.getInstance().DAOUser().add(NewUser);
        } catch (SQLException e) {
            request.setAttribute("errors", e);
        }
        if (User == null)
            User = new AuthUser();
        if (username.equals("test") && password.equals("test")) {
            User.Login(username);
            ResultPage = "/main";
            session.setAttribute("userInfo", User);
        } else {
            ResultPage = "/backend";
            User.SetError("Incorrect user name - " + username);
            session.setAttribute("userInfo", User);
        }


        response.sendRedirect(ResultPage);

    }
}
