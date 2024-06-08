package org.example.questexample.Controller;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.TimeUnit;

@WebServlet(name = "errorRegistration", value = "/error-registration")
public class ErrorRegistration extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Error</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Ошибка!</h1>");
        out.println("<h3>Были введены не валидные данные для регистрации!</h3>");
        out.println("<p>Через 5 секунд вы будете перенаправлены для повторной попытки регистрации<p>");
        out.println("<meta http-equiv=\"Refresh\" content=\"5;url=/start\">");
        out.println("</body>");
        out.println("</html>");
        out.close();
    }



}
