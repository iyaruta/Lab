package ui.kpi.pti.task4.servlet;

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
import java.io.IOException;
import java.util.Objects;

@WebServlet("/signup")
public class SignupServlet extends HttpServlet {

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

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("name");
        String password = req.getParameter("password");
        String type = req.getParameter("type");
        if (Objects.equals(type, "teacher")) {
            Teacher teacher = new Teacher(null, name);
            teacherDb.save(teacher);
        } else if (Objects.equals(type, "student")) {
            Student student = new Student(null, name);
            studentDb.save(student);
        } else {
            throw new IllegalArgumentException("Type not supported");
        }

        RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/login");
        dispatcher.forward(req, resp);
    }
}
