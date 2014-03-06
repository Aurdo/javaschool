package main.backend.products;

import dao.Factory;
import domain_objects.Category;
import domain_objects.Product;
import util.AuthUser;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.lang.reflect.Array;
import java.sql.SQLException;

/**
 * Created with IntelliJ IDEA.
 * User: Shichirin
 * Date: 25.02.14
 * Time: 12:02
 * To change this template use File | Settings | File Templates.
 */
public class Add extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        AuthUser User_Auth = (AuthUser) session.getAttribute("userInfo");

        if (User_Auth == null)
            User_Auth = new AuthUser();
        if (User_Auth.IsLogin().equals("true")) {
            try {
                java.util.List<Category> cats = Factory.getInstance().DAOCategory().getAll();
                request.setAttribute("cats", cats);
            }catch (SQLException e){
                request.setAttribute("errors", e);
            }
            request.getRequestDispatcher("/backend/products-add.jsp").forward(request, response);
        } else
            response.sendRedirect("/");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String name = request.getParameter("name");
        String desc = request.getParameter("description");
        Integer price = Integer.parseInt(request.getParameter("price"));
        //Array cats = request.getParameter("description");
        try {
            Product product = new Product();
            product.setName(name);
            product.setDescription(desc);
            product.setPrice(price);

            Factory.getInstance().DAOProduct().add(product);
            response.sendRedirect("/backend/products");
        } catch (SQLException e) {
            request.setAttribute("errors", e);
        }

    }
}
