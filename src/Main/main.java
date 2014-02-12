package Main;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import DAO.Factory;

import logic.Category;

public class main extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        request.setAttribute("errors", "Ошибка базы данных");
        try {
            List<Category> cats = Factory.getInstance().CategoryDAO().getAll();
            request.setAttribute("cats", cats);
            int size = cats.size();
            request.setAttribute("size", size);
        } catch (SQLException e) {
            request.setAttribute("errors", e);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Category NewCat = new Category();
            NewCat.setName("TV");
            NewCat.setDescription("TV");
            Factory.getInstance().CategoryDAO().add(NewCat);
        } catch (SQLException e) {
            request.setAttribute("errors", e);
        }
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }

}
