package com.saurabhjadhav.smartcampus.Gatepass;

public class GatepassModel {

    private String fullnname;
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
    private String leaveTime;
    private String returnDate;
    private String returnTime;

    public GatepassModel() {

    }

    public GatepassModel(String fullnname, String hostelName, String branch, String year, String floorNo, String roomNo, String contactNo, String parentContactNo, String reason, String placeOfVisit, String leaveDate, String leaveTime, String returnDate, String returnTime) {
        this.fullnname = fullnname;
        this.hostelName = hostelName;
        this.branch = branch;
        this.year = year;
        this.floorNo = floorNo;
        this.roomNo = roomNo;
        this.contactNo = contactNo;
        this.parentContactNo = parentContactNo;
        this.reason = reason;
        this.placeOfVisit = placeOfVisit;
        this.leaveDate = leaveDate;
        this.leaveTime = leaveTime;
        this.returnDate = returnDate;
        this.returnTime = returnTime;
    }

    public String getFullnname() {
        return fullnname;
    }

    public void setFullnname(String fullnname) {
        this.fullnname = fullnname;
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

    public String getLeaveTime() {
        return leaveTime;
    }

    public void setLeaveTime(String leaveTime) {
        this.leaveTime = leaveTime;
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