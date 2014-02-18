package main.backend;

import util.User;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class Auth extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        User User = (User) session.getAttribute("userInfo");
        if (User == null)
            User = new User();
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
        User User = (User) session.getAttribute("userInfo");

        if (User == null)
            User = new User();
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
