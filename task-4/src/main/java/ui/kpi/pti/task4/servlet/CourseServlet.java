package ui.kpi.pti.task4.servlet;

import ui.kpi.pti.task4.data.Course;
import ui.kpi.pti.task4.data.Student;
import ui.kpi.pti.task4.data.Teacher;
import ui.kpi.pti.task4.db.CourseDb;
import ui.kpi.pti.task4.db.StudentDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@WebServlet("/course")
public class CourseServlet extends HttpServlet {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("dd/MM/yyyy");

    private CourseDb courseDb = new CourseDb();
    private StudentDb studentDb = new StudentDb();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        Student student = null;
        if (session != null && Objects.equals(session.getAttribute("type"), "student")) {
            student = (Student) session.getAttribute("me");
        }

        List<Course> courses = courseDb.findAll();
        for (Course course : courses) {
            List<Student> students = studentDb.findByCourse(course.getId());
            if (students.contains(student)) {
                course.setAvailable(false);
            }
            course.setStudents(students);
        }
        req.setAttribute("courses", courses);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/course.jsp");
        requestDispatcher.forward(req, resp);
    }
}
