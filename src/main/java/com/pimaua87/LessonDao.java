package com.pimaua87;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class LessonDao implements Dao {
    private static final String SQL_ADD_LESSON = "INSERT INTO Lesson (name,updatedAt,homework_id) " +
            "VALUES(?,?,?);";
    private static final String SQL_DELETE_LESSON = "DELETE FROM lesson WHERE id=?;";
    private static final String SQL_SELECT_ALL_LESSONS = "SELECT * FROM lesson;";
    private static final String SQL_SELECT_LESSON_BY_ID = "SELECT * FROM lesson WHERE id=?;";

    private static final String SQL_SELECT_HOMEWORK_BY_ID = "SELECT homework.* FROM homework\n" +
            "JOIN lesson ON homework.id=lesson.id\n" +
            "AND homework.id=?;";
    DataBaseConnection dataBaseConnection;
    Lesson lesson;
    Homework homework;

    @Override
    public void addLesson(String name, Timestamp updatedAt, int homework_id) throws SQLException {
        dataBaseConnection = new DataBaseConnection();
        Connection newConnection = dataBaseConnection.getConnection();
        PreparedStatement preparedStatement = newConnection.prepareStatement(SQL_ADD_LESSON);
        preparedStatement.setString(1, name);
        preparedStatement.setTimestamp(2, updatedAt);
        preparedStatement.setInt(3, homework_id);
        preparedStatement.executeUpdate();
        dataBaseConnection.close(newConnection);
    }

    @Override
    public void deleteLesson(int id) throws SQLException {
        dataBaseConnection = new DataBaseConnection();
        Connection newCon = dataBaseConnection.getConnection();
        PreparedStatement preparedStatement = newCon.prepareStatement(SQL_DELETE_LESSON);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
        dataBaseConnection.close(newCon);
    }

    @Override
    public List<Lesson> getAllLessons() throws SQLException {
        dataBaseConnection = new DataBaseConnection();
        Connection newConnection = dataBaseConnection.getConnection();
        Statement statement = newConnection.createStatement();
        ResultSet resultSet = statement.executeQuery(SQL_SELECT_ALL_LESSONS);
        List<Lesson> lessons = new ArrayList<>();
        while (resultSet.next()) {
            lesson = new Lesson(resultSet.getInt(1), resultSet.getString(2),
                    getHomeworkByID(resultSet.getInt(1)));
            lessons.add(lesson);
        }
        dataBaseConnection.close(newConnection);
        return lessons;
    }

    @Override
    public Lesson getLessonByID(int id) throws SQLException {
        dataBaseConnection = new DataBaseConnection();
        Connection newConnection = dataBaseConnection.getConnection();
        PreparedStatement preparedStatement = newConnection.prepareStatement(SQL_SELECT_LESSON_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            lesson = new Lesson(resultSet.getInt(1), resultSet.getString(2), getHomeworkByID(id));
        }
        dataBaseConnection.close(newConnection);
        return lesson;
    }

    public Homework getHomeworkByID(int id) throws SQLException {
        dataBaseConnection = new DataBaseConnection();
        Connection newConnection = dataBaseConnection.getConnection();
        PreparedStatement preparedStatement = newConnection.prepareStatement(SQL_SELECT_HOMEWORK_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet resultSet = preparedStatement.executeQuery();
        if (resultSet.next()) {
            homework = new Homework(resultSet.getInt(1), resultSet.getString(2),
                    resultSet.getString(3));
        }
        dataBaseConnection.close(newConnection);
        return homework;
    }
}
