package com.saurabhjadhav.smartcampus.Teacher.Notice;

public class NoticeModel {

    private String noticeimageUrl;
    private String noticedescriptionUrl;

    public NoticeModel() {

    }

    public NoticeModel(String noticeimageUrl, String noticedescriptionUrl) {
        this.noticeimageUrl = noticeimageUrl;
        this.noticedescriptionUrl = noticedescriptionUrl;
    }

    public String getNoticeimageUrl() {
        return noticeimageUrl;
    }

    public void setNoticeimageUrl(String noticeimageUrl) {
        this.noticeimageUrl = noticeimageUrl;
    }

    public String getNoticedescriptionUrl() {
        return noticedescriptionUrl;
    }

    public void setNoticedescriptionUrl(String noticedescriptionUrl) {
        this.noticedescriptionUrl = noticedescriptionUrl;
    }
}
