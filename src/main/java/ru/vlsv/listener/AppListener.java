package ru.vlsv.listener;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.vlsv.entity.Product;
import ru.vlsv.examples.BasicServlet;
import ru.vlsv.repositories.ProductRepository;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 01.04.2020
 * @link https://github.com/Centnerman
 */

@WebListener
public class AppListener implements ServletContextListener {

    private static Logger logger = LoggerFactory.getLogger(AppListener.class);

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        ServletContext ctx = sce.getServletContext();
        String jdbcConnectionString = ctx.getInitParameter("jdbcConnectionString");
        String dbUsername = ctx.getInitParameter("dbUsername");
        String dbPassword = ctx.getInitParameter("dbPassword");

        Connection connection = null;
        try {
            connection = DriverManager.getConnection(jdbcConnectionString, dbUsername, dbPassword);
            ProductRepository repository = new ProductRepository(connection);
            ctx.setAttribute("connection", connection);
            ctx.setAttribute("productRepository", repository);

            if (repository.findAll().size() == 0) {
                repository.insert(new Product(-1L, "Product1", "Desc1", new BigDecimal(100)));
                repository.insert(new Product(-1L, "Product2", "Desc2", new BigDecimal(200)));
                repository.insert(new Product(-1L, "Product3", "Desc3", new BigDecimal(300)));
            }

        } catch (SQLException e) {
            logger.error("", e);
        }

    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {

    }
}
