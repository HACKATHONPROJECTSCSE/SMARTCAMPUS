package com.saurabhjadhav.smartcampus.Student.GatePassFinal;

public class UserGatepass {

    private String leaveTime;
    private String userId;
    private String fullName;
    private String hostelName;
    private String branch;
    private String year;
    private String floorNo;
    private String roomNo;
    private String contactNo;
    private String parentContactNo;
    private String reason;
    private String placeOfVisit;
    private String leaveDate;
    private String returnDate;
    private String returnTime;

    public UserGatepass() {
    }


    public UserGatepass(String userId, String mFullNAme, String mhostelName, String mbranch, String myear, String mfloorNo, String mroomNo, String mcontactNo, String mparentContactNo, String mreason, String mplaceOfVisit, String mleaveDate, String mleaveTime, String mreturnDate, String mreturnTime) {
        this.userId = userId;
        this.fullName = mFullNAme;
        this.hostelName = mhostelName;
        this.branch = mbranch;
        this.year = myear;
        this.floorNo = mfloorNo;
        this.roomNo = mroomNo;
        this.contactNo = mcontactNo;
        this.parentContactNo = mparentContactNo;
        this.reason = mreason;
        this.placeOfVisit = mplaceOfVisit;
        this.leaveDate = mleaveDate;
        this.leaveTime = mleaveTime;
        this.returnDate = mreturnDate;
        this.returnTime = mreturnTime;
    }

    public String getuIdGatepass() {
        return userId;
    }


    public String getuId() {
        return userId;
    }

    public void setuId(String uId) {
        this.userId = uId;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getHostelName() {
        return hostelName;
    }

    public void setHostelName(String hostelName) {
        this.hostelName = hostelName;
    }

    public String getBranch() {
        return branch;
    }

    public void setBranch(String branch) {
        this.branch = branch;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFloorNo() {
        return floorNo;
    }

    public void setFloorNo(String floorNo) {
        this.floorNo = floorNo;
    }

    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }

    public String getParentContactNo() {
        return parentContactNo;
    }

    public void setParentContactNo(String parentContactNo) {
        this.parentContactNo = parentContactNo;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getPlaceOfVisit() {
        return placeOfVisit;
    }

    public void setPlaceOfVisit(String placeOfVisit) {
        this.placeOfVisit = placeOfVisit;
    }

    public String getLeaveDate() {
        return leaveDate;
    }

    public void setLeaveDate(String leaveDate) {
        this.leaveDate = leaveDate;
    }

    public String getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(String returnDate) {
        this.returnDate = returnDate;
    }

    public String getReturnTime() {
        return returnTime;
    }

    public void setReturnTime(String returnTime) {
        this.returnTime = returnTime;
    }

}
