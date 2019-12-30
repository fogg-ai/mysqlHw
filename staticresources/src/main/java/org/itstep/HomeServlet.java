package org.itstep;

import org.itstep.dao.UserDao;
import org.itstep.domain.User;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

public class HomeServlet extends HttpServlet {

    private UserDao userDao;

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        String user = getServletContext().getInitParameter("db.username");
        String pass = getServletContext().getInitParameter("db.password");
        String url = getServletContext().getInitParameter("db.url");
        try {
            userDao = new UserDao(url, user, pass);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("request");
        resp.setContentType ("text/html; charset=UTF-8");
        String login = req.getParameter("login");
        String password = req.getParameter("password");
        PrintWriter writer = resp.getWriter();
        writer.append("<head><link href=\"static/css/style.css\" rel=\"stylesheet\"/></head>");
        writer.append("<span>Успешная регистрация.</span>");
        User user = new User(login, password);

        if(userDao != null) {
             userDao.save(user);
        }
        System.out.println(userDao.findAll());

    }
}
