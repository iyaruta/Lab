package ui.kpi.pti.task4.servlet;

import ui.kpi.pti.task4.data.Course;
import ui.kpi.pti.task4.data.Student;
import ui.kpi.pti.task4.data.StudentCourse;
import ui.kpi.pti.task4.db.CourseDb;
import ui.kpi.pti.task4.db.StudentCourseDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/teacher/course")
public class CourseInfoServlet extends HttpServlet {

    private CourseDb courseDb = new CourseDb();
    private StudentCourseDb studentCourseDb = new StudentCourseDb();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !Objects.equals(session.getAttribute("type"), "teacher")) {
            resp.sendRedirect("/task-4/login?type=teacher");
            return;
        }

        Long id = Long.valueOf(req.getParameter("id"));
        Course course = courseDb.get(id);
        List<StudentCourse> students = studentCourseDb.findByCourse(id);

        req.setAttribute("course", course);
        req.setAttribute("students", students);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/courseInfo.jsp");
        requestDispatcher.forward(req, resp);
    }
}
