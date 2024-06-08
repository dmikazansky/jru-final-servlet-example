package org.example.questexample.Controller;

import org.example.questexample.Entity.StatusEnum;
import org.example.questexample.Entity.User;
import org.example.questexample.db.UserDB;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet(name = "initServlet", value = "/start")
public class InitServlet extends HttpServlet {

    private List<User> users = UserDB.createUsers();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user1 = (User) session.getAttribute("user");
        StatusEnum status = (StatusEnum) session.getAttribute("status");
        if(!UserDB.validateUser(user1)) {
            registration(req, resp);
        }
    }
    private void registration (HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String emailinput = req.getParameter("emailinput");
        String passwordinput = req.getParameter("passwordinput");
        String nicknameinput =  req.getParameter("nickinput");
        User user = User.register(nicknameinput, emailinput, passwordinput);
        if(Objects.nonNull(user)) {
            users.add(user);
            session.setAttribute("user", user);
            session.setAttribute("nickname", user.getNickname());
            session.setAttribute("email", user.getEmail());
            session.setAttribute("password", user.getPassword());
            session.setAttribute("status", StatusEnum.START);
           resp.sendRedirect(req.getContextPath() + "/game.jsp");
        } else {
            getServletContext().getRequestDispatcher("/error-registration").forward(req, resp);
        }
    }

}
