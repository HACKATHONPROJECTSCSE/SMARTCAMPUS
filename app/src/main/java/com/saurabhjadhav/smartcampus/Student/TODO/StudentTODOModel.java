package com.saurabhjadhav.smartcampus.Student.TODO;

public class StudentTODOModel {

    private String title;
    private String description;
    private int priority;

    public StudentTODOModel() {

    }

    public StudentTODOModel(String title, String description, int priority) {
        this.title = title;
        this.description = description;
        this.priority = priority;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }
}
