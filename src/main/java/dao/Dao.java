package dao;

import models.Lesson;

import java.sql.SQLException;
import java.sql.Timestamp;

public interface Dao<T> {

    void addLesson(String name, Timestamp updatedAt, T hw_id) throws SQLException;

    void deleteLesson(T t) throws SQLException;

    Lesson getLessonByID(T t) throws SQLException;
}
