package ui.kpi.pti.task4.db;

import ui.kpi.pti.task4.data.Course;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CourseDb {

    public List<Course> findAll() {
        String sql = "select * from Course";
        try (Connection connection = Db.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Course> result = new ArrayList<>();
                while (resultSet.next()) {
                    Course course = toCourse(resultSet);
                    result.add(course);
                }
                return result;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad");
        }
    }

    public List<Course> findByTeacher(final Long teacherId) {
        String sql = "select * from Course where teacher_id = ?";
        try (Connection connection = Db.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setLong(1, teacherId);
            try (ResultSet resultSet = statement.executeQuery()) {
                List<Course> result = new ArrayList<>();
                while (resultSet.next()) {
                    Course course = toCourse(resultSet);
                    result.add(course);
                }
                return result;
            }
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad");
        }
    }

    private Course toCourse(ResultSet resultSet) throws SQLException {
        long id = resultSet.getLong("id");
        String name = resultSet.getString("name");
        String description = resultSet.getString("description");
        Date start = resultSet.getDate("start_time");
        Date end = resultSet.getDate("end_time");

        return new Course(id, name, description, start, end);
    }

    public void save(Course course) {
        String sql = "INSERT INTO COURSE(name, description, start_time, end_time, teacher_id) VALUES (?, ?, ?, ?, ?)";
        try (Connection connection = Db.connect();
             PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, course.getName());
            statement.setString(2, course.getDescription());
            statement.setDate(3, new Date(course.getStart().getTime()));
            statement.setDate(4, new Date(course.getEnd().getTime()));
            statement.setLong(5, course.getTeacher().getId());
            statement.executeUpdate();
        } catch (SQLException e) {
            throw new IllegalArgumentException("Bad");
        }
    }
}
