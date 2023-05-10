package com.pimaua87;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

public interface Dao {

    void addLesson(String name, Timestamp updatedAt, int hw_id) throws SQLException;

    void deleteLesson(int id) throws SQLException;

    List<Lesson> getAllLessons() throws SQLException;

    Lesson getLessonByID(int id) throws SQLException;
}
