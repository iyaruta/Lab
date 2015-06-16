package ui.kpi.pti.task4.servlet;

import ui.kpi.pti.task4.data.Course;
import ui.kpi.pti.task4.data.Teacher;
import ui.kpi.pti.task4.db.CourseDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Objects;

@WebServlet("/addCourse")
public class AddCourseServlet extends HttpServlet {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private CourseDb courseDb = new CourseDb();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !Objects.equals(session.getAttribute("type"), "teacher")) {
            resp.sendRedirect("/task-4/login?type=teacher");
            return;
        }

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/addCourse.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        if (session == null || !Objects.equals(session.getAttribute("type"), "teacher")) {
            resp.sendRedirect("/task-4/login?type=teacher");
            return;
        }

        Teacher me = (Teacher) session.getAttribute("me");

        String name = req.getParameter("name");
        String description = req.getParameter("description");
        Date start = toDate(req.getParameter("start"));
        Date end = toDate(req.getParameter("end"));
        Course course = new Course(null, name, description, start, end);
        course.setTeacher(me);

        courseDb.save(course);
        resp.sendRedirect("/task-4/teacher");
    }

    private Date toDate(String str) {
        try {
            return DATE_FORMAT.parse(str);
        } catch (ParseException e) {
            throw new IllegalArgumentException("Invalid date format: dd/MM/yyyy");
        }
    }

}
