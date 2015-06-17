package ui.kpi.pti.task4.servlet;

import ui.kpi.pti.task4.data.Course;
import ui.kpi.pti.task4.data.Student;
import ui.kpi.pti.task4.data.Teacher;
import ui.kpi.pti.task4.db.StudentDb;
import ui.kpi.pti.task4.db.TeacherDb;

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

    private TeacherDb teacherDb = new TeacherDb();
    private StudentDb studentDb = new StudentDb();

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
            Teacher teacher = teacherDb.get(name);
            if (teacher != null) {
                HttpSession session = req.getSession();
                session.setAttribute("type", type);
                session.setAttribute("me", teacher);
                resp.sendRedirect("/task-4/teacher");
            }
        } else if (Objects.equals(type, "student")) {
            Student student = studentDb.get(name);
            if (student != null) {
                HttpSession session = req.getSession();
                session.setAttribute("type", type);
                session.setAttribute("me", student);
                resp.sendRedirect("/task-4/course");
            }
        } else {
            throw new IllegalArgumentException("Type not supported");
        }

    }
}
