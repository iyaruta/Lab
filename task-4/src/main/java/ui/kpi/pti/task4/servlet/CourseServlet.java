package ui.kpi.pti.task4.servlet;

import ui.kpi.pti.task4.data.Course;
import ui.kpi.pti.task4.data.Student;
import ui.kpi.pti.task4.data.Teacher;
import ui.kpi.pti.task4.db.CourseDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private CourseDb courseDb = new CourseDb();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        List<Course> courses = courseDb.findAll();
        req.setAttribute("courses", courses);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/course.jsp");
        requestDispatcher.forward(req, resp);
    }
}
