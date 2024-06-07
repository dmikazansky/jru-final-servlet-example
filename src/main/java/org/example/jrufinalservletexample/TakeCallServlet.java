package org.example.jrufinalservletexample;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet (name="takeServlet", value = "/take-servlet")
public class TakeCallServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();
        out.println("<html>");
        out.println("<head>");
        out.println("<title>Take Servlet</title>");
        out.println("<link href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css\" rel=\"stylesheet\" integrity=\"sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH\" crossorigin=\"anonymous\">\n");
        out.println("<script src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js\" integrity=\"sha384-YvpcrYf0tY3lHB60NNkmXc5s9fDVZLESaAA55NDzOxhy9GkcIdslK1eN7N6jIeHz\" crossorigin=\"anonymous\"></script>\n");
        out.println("</head>");
        out.println("<body>");
        out.println("<div class=\"container\">\n");
        out.println("<h1>Ты потерял память." + "<br>" + "Принять вызов НЛО?</h1>");
        out.println("<div class=\"btn-group\" role=\"group\" aria-label=\"Basic example\">");
        out.println("<a class=\"btn btn-primary\" href= \"/accept-servlet\" role=\"button\">Принять вызов</a>");
        out.println("<a class=\"btn btn-primary\" href= \"/done-servlet\" role=\"button\">Отклонить вызов</a>");
        out.println("</div>");
        out.println("</div>");
        out.println("</body>");
        out.println("</html>");
    }
}
