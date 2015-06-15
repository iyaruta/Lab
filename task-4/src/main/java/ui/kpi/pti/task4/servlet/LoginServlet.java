package ui.kpi.pti.task4.servlet;

import ui.kpi.pti.task4.data.Course;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Objects;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String type = req.getParameter("type");
        if (Objects.equals(type, "teacher") || Objects.equals(type, "student")) {
            req.setAttribute("type", type);
        } else {
            throw new IllegalArgumentException("Type not supported");
        }

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/login.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        if (Objects.equals(type, "teacher")) {
            //TODO: login teacher

        } else if (Objects.equals(type, "student")) {
            //TODO: login student
            HttpSession session = req.getSession();
            session.setAttribute("type", type);
            session.setAttribute("name", name);
        } else {
            throw new IllegalArgumentException("Type not supported");
        }

        resp.sendRedirect("/task-4/course");
    }
}
