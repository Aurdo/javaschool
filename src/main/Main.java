package main;

import java.io.*;
import java.sql.SQLException;
import java.util.List;
import javax.servlet.*;
import javax.servlet.http.*;

import dao.Factory;

import domain_objects.Category;

public class Main extends HttpServlet {


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,
            IOException {
        //request.setAttribute("errors", "Database error");
        try {
            List<Category> cats = Factory.getInstance().DAOCategory().getAll();
            request.setAttribute("cats", cats);
        } catch (SQLException e) {
            request.setAttribute("errors", e);
        }
        request.getRequestDispatcher("MainTemplate.jsp").forward(request, response);

    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            Category NewCat = new Category();
            NewCat.setName("TV4");
            NewCat.setDescription("TV4");
            Factory.getInstance().DAOCategory().add(NewCat);
        } catch (SQLException e) {
            request.setAttribute("errors", e);
        }
        request.getRequestDispatcher("MainTemplate.jsp").forward(request, response);
    }

}
