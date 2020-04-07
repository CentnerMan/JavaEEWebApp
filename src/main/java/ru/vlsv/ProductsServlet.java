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
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 01.04.2020
 * @link https://github.com/Centnerman
 */

@WebServlet(name = "ProductsServlet", urlPatterns = "/products")
//public class ProductsServlet extends HttpServlet {
//
//    private static Logger logger = LoggerFactory.getLogger(ProductsServlet.class);
//
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        getServletContext().getRequestDispatcher("/products.jsp").include(req, resp);
//    }
//}

public class ProductsServlet extends HttpServlet {

    private static Logger logger = LoggerFactory.getLogger(ProductsServlet.class);

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();
        try {
            String url = "jdbc:mysql://localhost/javaee_test?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "6585452";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try (Connection conn = DriverManager.getConnection(url, username, password)) {
                logger.info("Connection succesful");
                writer.println("Connection to ProductDB succesfull!");
            }
        } catch (Exception ex) {
            writer.println("Connection failed...");
            writer.println(ex);
            logger.info("Connection failed. We`re get exception: " + ex);
        } finally {
            writer.close();
        }
    }
}
