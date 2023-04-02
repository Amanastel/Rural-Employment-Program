package com.mnrega.dto;

import java.time.LocalDate;

public class Workers {
    private int wID;
    private String wName;
    private String WAadhar;
    private LocalDate wDob;
    private String WGender;
    private String gpName;
    private int gpmID;
    private int proID;
    private LocalDate workStrDate;
    private String district;
    private String state;

    public Workers(int wID, String wName, String WAadhar, LocalDate wDob, String WGender, String gpName, int gpmID, int proID, LocalDate workStrDate, String district, String state) {
        super();
        this.wID = wID;
        this.wName = wName;
        this.WAadhar = WAadhar;
        this.wDob = wDob;
        this.WGender = WGender;
        this.gpName = gpName;
        this.gpmID = gpmID;
        this.proID = proID;
        this.workStrDate = workStrDate;
        this.district = district;
        this.state = state;
    }
    public Workers(int wID, String wName, String WAadhar, LocalDate wDob, String WGender, String gpName, int gpmID, int proID, String district, String state) {
        super();
        this.wID = wID;
        this.wName = wName;
        this.WAadhar = WAadhar;
        this.wDob = wDob;
        this.WGender = WGender;
        this.gpName = gpName;
        this.gpmID = gpmID;
        this.proID = proID;
//        this.workStrDate = workStrDate;
        this.district = district;
        this.state = state;
    }
    public Workers(String wName, String WAadhar, LocalDate wDob, String WGender){
        super();
        this.wName = wName;
        this.WAadhar = WAadhar;
        this.wDob = wDob;
        this.WGender = WGender;
    }

    public int getwID() {
        return wID;
    }

    public void setwID(int wID) {
        this.wID = wID;
    }

    public String getwName() {
        return wName;
    }

    public void setwName(String wName) {
        this.wName = wName;
    }

    public String getWAadhar() {
        return WAadhar;
    }

    public void setWAadhar(String WAadhar) {
        this.WAadhar = WAadhar;
    }

    public LocalDate getwDob() {
        return wDob;
    }

    public void setwDob(LocalDate wDob) {
        this.wDob = wDob;
    }

    public String getWGender() {
        return WGender;
    }

    public void setWGender(String WGender) {
        this.WGender = WGender;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
    }

    public int getGpmID() {
        return gpmID;
    }

    public void setGpmID(int gpmID) {
        this.gpmID = gpmID;
    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public LocalDate getWorkStrDate() {
        return workStrDate;
    }

    public void setWorkStrDate(LocalDate workStrDate) {
        this.workStrDate = workStrDate;
    }

    public String getDistrict() {
        return district;
    }

    public void setDistrict(String district) {
        this.district = district;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Workers{" +
                "wID=" + wID +
                ", wName='" + wName + '\'' +
                ", WAadhar='" + WAadhar + '\'' +
                ", wDob=" + wDob +
                ", WGender='" + WGender + '\'' +
                ", gpName='" + gpName + '\'' +
                ", gpmID=" + gpmID +
                ", proID=" + proID +
                ", workStrDate=" + workStrDate +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
