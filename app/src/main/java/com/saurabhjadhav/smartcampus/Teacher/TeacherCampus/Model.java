package com.saurabhjadhav.smartcampus.Teacher.TeacherCampus;

public class Model {

    private String campusimageUrl;
    private String campusdescriptionUrl;

    public Model() {

    }

    public Model(String campusimageUrl, String campusdescriptionUrl) {
        this.campusimageUrl = campusimageUrl;
        this.campusdescriptionUrl = campusdescriptionUrl;
    }

    public String getCampusimageUrl() {
        return campusimageUrl;
    }

    public void setCampusimageUrl(String campusimageUrl) {
        this.campusimageUrl = campusimageUrl;
    }

    public String getCampusdescriptionUrl() {
        return campusdescriptionUrl;
    }

    public void setCampusdescriptionUrl(String campusdescriptionUrl) {
        this.campusdescriptionUrl = campusdescriptionUrl;
    }
}
