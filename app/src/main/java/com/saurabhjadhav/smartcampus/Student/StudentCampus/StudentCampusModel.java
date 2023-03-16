package com.saurabhjadhav.smartcampus.Student.StudentCampus;

public class StudentCampusModel {

    private String campusimageUrl;
    private String campusdescriptionUrl;
    private String hostelimageUrl;
    private String hosteldescriptionUrl;

    public StudentCampusModel() {
    }

    public StudentCampusModel(String campusimageUrl, String campusdescriptionUrl, String hostelimageUrl, String hosteldescriptionUrl) {
        this.campusimageUrl = campusimageUrl;
        this.campusdescriptionUrl = campusdescriptionUrl;
        this.hostelimageUrl = hostelimageUrl;
        this.hosteldescriptionUrl = hosteldescriptionUrl;
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

    public String getHostelimageUrl() {
        return hostelimageUrl;
    }

    public void setHostelimageUrl(String hostelimageUrl) {
        this.hostelimageUrl = hostelimageUrl;
    }

    public String getHosteldescriptionUrl() {
        return hosteldescriptionUrl;
    }

    public void setHosteldescriptionUrl(String hosteldescriptionUrl) {
        this.hosteldescriptionUrl = hosteldescriptionUrl;
    }
}
