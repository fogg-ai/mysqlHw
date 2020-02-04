package org.itstep.servlet;

import org.itstep.person.Person;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebFilter;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/login")
public class LoginServlet extends HttpServlet {
    List<Person> list = new ArrayList<>();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(req, resp);
    }


    private void autoReg(){
        list.add(new Person("qwert","1223","admin")); //admin
        list.add(new Person("asdfg","1234","user")); //not admin

    }
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        boolean check = false;

        autoReg();
        session.setAttribute("reg",list);


        String login = req.getParameter("login");
        String password = req.getParameter("password");
        for (Person log : (List<Person>)session.getAttribute("reg")){
            if(log.getLogin().equals(login) && log.getPassword().equals(password) && "admin".equals(log.getStatus())) {
                session.setAttribute("log", true);
                resp.sendRedirect(getServletContext().getContextPath() + "/create");
                check = false;
                break;
            }else {
                check = true;
            }
        }

        if(check){
            resp.sendRedirect(getServletContext().getContextPath() + "/login");
        }

    }
}
