package com.saurabhjadhav.smartcampus.Student.NoticeBoard;

public class DisplayNoticeModel {

    private String noticeimageUrl;
    private String campusdescriptionUrl;

    public DisplayNoticeModel() {

    }

    public DisplayNoticeModel(String noticeimageUrl, String campusdescriptionUrl) {
        this.noticeimageUrl = noticeimageUrl;
        this.campusdescriptionUrl = campusdescriptionUrl;
    }

    public String getNoticeimageUrl() {
        return noticeimageUrl;
    }

    public void setNoticeimageUrl(String noticeimageUrl) {
        this.noticeimageUrl = noticeimageUrl;
    }

    public String getCampusdescriptionUrl() {
        return campusdescriptionUrl;
    }

    public void setCampusdescriptionUrl(String campusdescriptionUrl) {
        this.campusdescriptionUrl = campusdescriptionUrl;
    }
}
