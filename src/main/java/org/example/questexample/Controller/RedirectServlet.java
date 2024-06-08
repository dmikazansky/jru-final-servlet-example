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

@WebServlet(name="redirectServlet", value = "/redirect")
public class RedirectServlet extends HttpServlet {
    List<User> db = UserDB.createUsers();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        session.invalidate();
        getServletContext().getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        StatusEnum status = (StatusEnum) session.getAttribute("status");
        String text = req.getParameter("text");
        if (status == StatusEnum.START) {
            session.setAttribute("status", StatusEnum.CALL);
            getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
        }
        else if (status == StatusEnum.CALL) {
            if(Objects.equals("bridge", text)) {
                session.setAttribute("status", StatusEnum.BRIDGE);
                getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
            } else {
                session.setAttribute("status", StatusEnum.REJECT);
                getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
            }
        }
        else if (status == StatusEnum.BRIDGE) {
            if(Objects.equals("victory", text)) {
                session.setAttribute("status", StatusEnum.VICTORY);
                getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
            } else {
                session.setAttribute("status", StatusEnum.REJECT);
                getServletContext().getRequestDispatcher("/game.jsp").forward(req, resp);
            }
        }
    }

}
