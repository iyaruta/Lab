package ui.kpi.pti.task4.db;

import ui.kpi.pti.task4.data.Course;
import ui.kpi.pti.task4.data.Score;
import ui.kpi.pti.task4.data.Student;
import ui.kpi.pti.task4.data.StudentCourse;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentCourseDb {

    public void join(Long studentId, Long courseId) {
        String sql = "INSERT INTO COURSE_TO_STUDENT(student_id, course_id) VALUES (?, ?)";
        try (Connection connection = Db.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, studentId);
            statement.setLong(2, courseId);
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad");
        }
    }

    public List<StudentCourse> findByCourse(Long courseId) {
        String sql = "select cts.*, s.name from Course_to_student cts" +
                " inner join Student s on s.id = cts.student_id where course_id = ?";
        try (Connection connection = Db.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, courseId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<StudentCourse> result = new ArrayList<>();
                while (resultSet.next()) {
                    StudentCourse sc = new StudentCourse();
                    sc.setStudentId(resultSet.getLong("student_id"));
                    sc.setCourseId(resultSet.getLong("course_id"));
                    String scoreStr = resultSet.getString("score");
                    sc.setScore(scoreStr == null ? null : Score.valueOf(scoreStr));
                    sc.setFeedback(resultSet.getString("feedback"));

                    Student student = new Student(resultSet.getLong("student_id"), resultSet.getString("name"));
                    sc.setStudent(student);

                    result.add(sc);
                }
                return result;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad");
        }
    }

    public void update(StudentCourse studentCourse) {
        String sql = "UPDATE COURSE_TO_STUDENT SET student_id=?, course_id=?, score=?, feedback=?";
        try (Connection connection = Db.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, studentCourse.getStudentId());
            statement.setLong(2, studentCourse.getCourseId());
            statement.setObject(3, studentCourse.getScore().toString());
            statement.setString(4, studentCourse.getFeedback());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad");
        }
    }
}
