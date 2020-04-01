package ru.vlsv.filters;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import java.io.IOException;

/**
 * GeekBrains Java, JavaEEWebApp.
 *
 * @author Anatoly Lebedev
 * @version 1.0.0 25.03.2020
 * @link https://github.com/Centnerman
 */

@WebFilter(filterName = "HeaderFooter", urlPatterns = "/*")
public class HTTPFilter implements Filter {

    private FilterConfig filterConfig;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        this.filterConfig = filterConfig;

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        servletResponse.setCharacterEncoding("UTF-8");
        servletResponse.setContentType("text/html");
//        servletResponse.setContentType("text/html; charset=UTF-8");
        servletResponse.getWriter().print("");
        filterConfig.getServletContext().getRequestDispatcher("/header.html").include(servletRequest, servletResponse);

        filterChain.doFilter(servletRequest, servletResponse);

        filterConfig.getServletContext().getRequestDispatcher("/footer.html").include(servletRequest, servletResponse);
//        servletResponse.getWriter().println("<h2>Footer from filter</h2>");

    }

    @Override
    public void destroy() {

    }
}
