package ui.kpi.pti.task4.db;

import java.sql.*;

public class Db<T> {

    private static final String url = "jdbc:postgresql://localhost:5432/postgres?schema=public";
    private static final String name = "postgres";
    private static final String password = "postgres";

    static {
        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            throw new IllegalStateException("No driver");
        }
    }

    public static Connection connect() {
        try {
            return DriverManager.getConnection(url, name, password);
        } catch (SQLException e) {
            throw new IllegalArgumentException("No connection");
        }
    }

}