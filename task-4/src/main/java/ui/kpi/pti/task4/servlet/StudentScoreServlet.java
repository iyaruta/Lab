package ui.kpi.pti.task4.servlet;

import ui.kpi.pti.task4.data.Score;
import ui.kpi.pti.task4.data.Student;
import ui.kpi.pti.task4.data.StudentCourse;
import ui.kpi.pti.task4.db.StudentCourseDb;
import ui.kpi.pti.task4.db.StudentDb;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/course/student")
public class StudentScoreServlet extends HttpServlet {

    private StudentDb studentDb = new StudentDb();
    private StudentCourseDb studentCourseDb = new StudentCourseDb();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long studentId = Long.valueOf(req.getParameter("student"));
        Long courseId = Long.valueOf(req.getParameter("course"));
        Student student = studentDb.get(studentId);
        req.setAttribute("student", student);
        req.setAttribute("courseId", courseId);


        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/jsp/studentScore.jsp");
        requestDispatcher.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Long courseId = Long.valueOf(req.getParameter("courseId"));
        Long studentId = Long.valueOf(req.getParameter("studentId"));
        String scoreStr = req.getParameter("score");
        String feedback = req.getParameter("feedback");

        StudentCourse studentCourse = new StudentCourse(studentId, courseId, Score.valueOf(scoreStr), feedback);
        studentCourseDb.update(studentCourse);

        resp.sendRedirect("/task-4/teacher/course?id=" + courseId);
    }
}
