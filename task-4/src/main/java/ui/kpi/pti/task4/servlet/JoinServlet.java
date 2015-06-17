package ui.kpi.pti.task4.servlet;

import ui.kpi.pti.task4.data.Student;
import ui.kpi.pti.task4.db.StudentCourseDb;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Objects;

@WebServlet("/join")
public class JoinServlet extends HttpServlet {

    StudentCourseDb studentCourseDb = new StudentCourseDb();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !Objects.equals(session.getAttribute("type"), "student")) {
            resp.sendRedirect("/task-4/login?type=student");
            return;
        }

        Student me = (Student)session.getAttribute("me");
        Long courseId = Long.valueOf(req.getParameter("course"));
        studentCourseDb.join(me.getId(), courseId);
        resp.sendRedirect("/task-4/course");
    }
}
