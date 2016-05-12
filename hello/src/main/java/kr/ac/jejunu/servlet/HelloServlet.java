package kr.ac.jejunu.servlet;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.GenericServlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

/**
 * Created by jhkang on 5/13/16.
 */
public class HelloServlet extends GenericServlet {
    private final static Logger logger = LoggerFactory.getLogger(HelloServlet.class);

    @Override
    public void init() throws ServletException {
        logger.info("**********  init  **********");
        super.init();
    }

    @Override
    public void destroy() {
        logger.info("**********  destroy  **********");
        super.destroy();
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        logger.info("**********  service  **********");
        res.getWriter().println("<h1>Hello!!</h1>");
    }
}
