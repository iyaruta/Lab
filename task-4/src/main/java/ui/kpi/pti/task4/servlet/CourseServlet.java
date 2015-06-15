package ui.kpi.pti.task4.servlet;

import ui.kpi.pti.task4.data.Course;
import ui.kpi.pti.task4.data.Student;
import ui.kpi.pti.task4.data.Teacher;

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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            List<Course> courses = testCourses();
            req.setAttribute("courses", courses);
        } catch (ParseException e) {
            throw new IllegalStateException(e);
        }

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/course.jsp");
        requestDispatcher.forward(req, resp);
    }

    public List<Course> testCourses() throws ParseException {
        List<Course> courses = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            Course course = new Course();
            course.setId((long) i);
            course.setName("Курс " + i);
            course.setDescription("Description " + i);
            course.setStart(DATE_FORMAT.parse("20/06/2015"));
            course.setEnd(DATE_FORMAT.parse("25/06/2015"));

            Teacher teacher = new Teacher();
            teacher.setName("John Smith");
            course.setTeacher(teacher);
            course.setStudents(new ArrayList<Student>());
            courses.add(course);
        }

        return courses;
    }
}
