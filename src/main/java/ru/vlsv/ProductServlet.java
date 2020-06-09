package ru.vlsv;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.examples.BasicServlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 05.06.2020
 * @link https://github.com/Centnerman
 */

@WebServlet(name = "ProductServlet", urlPatterns = "/product")
public class ProductServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(BasicServlet.class);

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setHeader("Content-type", "text/html; charset=utf-8");
//        getServletContext().getRequestDispatcher("/header.html").include(req, resp);
        resp.getWriter().println("<h1>Product</h1>");
        resp.getWriter().write("One Product");
//        getServletContext().getRequestDispatcher("/products.jsp").include(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
