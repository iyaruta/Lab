package ui.kpi.pti.task4.db;

import ui.kpi.pti.task4.data.Course;
import ui.kpi.pti.task4.data.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentDb {

    public Student get(Long id) {
        String sql = "select * from Student where id = ?";
        try (Connection connection = Db.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? new Student(resultSet.getLong("id"), resultSet.getString("name")) : null;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad SQL");
        }
    }


    public Student get(String name) {
        String sql = "select * from Student where name = ?";
        try (Connection connection = Db.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, name);
            try (ResultSet resultSet = statement.executeQuery()) {
                return resultSet.next() ? new Student(resultSet.getLong("id"), resultSet.getString("name")) : null;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad SQL");
        }
    }

    public List<Student> findByCourse(Long courseId) {
        String sql = "select * from Course_to_student cts" +
                " inner join Student s on s.id = cts.student_id where course_id = ?";
        try (Connection connection = Db.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, courseId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Student> result = new ArrayList<>();
                while (resultSet.next()) {
                    result.add(new Student(resultSet.getLong("id"), resultSet.getString("name")));
                }
                return result;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad");
        }
    }


}
