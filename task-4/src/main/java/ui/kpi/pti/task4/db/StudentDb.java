package ui.kpi.pti.task4.db;

import ui.kpi.pti.task4.data.Student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class StudentDb {

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


}
