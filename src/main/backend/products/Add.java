package main.backend.products;

import dao.Factory;
import domain_objects.Category;
import domain_objects.Product;
import org.hibernate.Session;
import util.AuthUser;
import util.HibernateUtil;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.MathContext;
import java.sql.SQLException;
import java.util.HashSet;
import java.util.Set;

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
        String[] categories = request.getParameterValues("categories");
        /*final int[] categoris_ints = new int[categoris.length];
        for (int i=0; i < categoris.length; i++) {
            categoris_ints[i] = Integer.parseInt(categoris[i]);
        }*/

        BigDecimal price = new BigDecimal(request.getParameter("price"), new MathContext(2));
        try {
            Product prod = new Product();
            prod.setName(name);
            prod.setDescription(desc);
            prod.setPrice(price);
            Set cat = Factory.getInstance().DAOCategory().getForProductCreate(categories);
            prod.setCategories(cat);
            Factory.getInstance().DAOProduct().add(prod);
            response.sendRedirect("/backend/products");
        } catch (SQLException e) {
            request.setAttribute("errors", e);
        }
        //response.sendRedirect("/backend/products");
    }
}
