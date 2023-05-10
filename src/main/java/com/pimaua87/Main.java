package com.pimaua87;

import java.sql.SQLException;
import java.sql.Timestamp;

public class Main {

    public static void main(String[] args) throws SQLException {
        LessonDao lessonDao = new LessonDao();

        lessonDao.addLesson("lesson5", Timestamp.valueOf("2023-05-11 09:45:12"), 5);
        lessonDao.deleteLesson(3);
        lessonDao.getAllLessons();
        lessonDao.getLessonByID(2);
    }
}
