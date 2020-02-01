package org.itstep.servlet;

import org.itstep.db.Post;
import org.itstep.db.PostRepository;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/replace",name = "replace")
public class ReplacePostServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("UTF-8");

        String title = req.getParameter("title");
        String titleNew = req.getParameter("titleNew");
        String subtitle = req.getParameter("subtitle");
        String author = req.getParameter("author");
        String content = req.getParameter("content");


        PostRepository.getInstance().replace(title,titleNew, subtitle ,author, content);

        resp.sendRedirect(getServletContext().getContextPath());
    }
}
