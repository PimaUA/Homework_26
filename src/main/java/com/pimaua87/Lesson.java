package com.pimaua87;

public class Lesson {
    private int id;
    private String name;
    private final Homework homework;

    public Lesson(int id, String name, Homework homework) {
        this.id = id;
        this.name = name;
        this.homework = homework;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", homework=" + homework +
                '}';
    }
}
