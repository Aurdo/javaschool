package main.backend.categories;

import dao.Factory;
import domain_objects.Category;
import domain_objects.User;
import util.AuthUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Shichirin
 * Date: 25.02.14
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class Edit extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AuthUser User_Auth = (AuthUser) session.getAttribute("userInfo");
        if (User_Auth == null)
            User_Auth = new AuthUser();
        if (User_Auth.IsLogin().equals("true")) {
            try {
                String url = request.getRequestURI().replace("/backend/category/edit/", "");
                Category cat = Factory.getInstance().DAOCategory().getById(Integer.parseInt(url));
                request.setAttribute("cat", cat);
            } catch (SQLException e) {
                request.setAttribute("errors", e);
            }
            request.getRequestDispatcher("/backend/category-edit.jsp").forward(request, response);
        } else
            response.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
