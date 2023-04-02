package com.mnrega.dto;

import java.time.LocalDate;

public class GPA {
    private int gpmID;
    private String gpmName;
    private int gpmAadhar;
    private LocalDate gmDob;
    private String gemGender;
    private String gpmEmail;
    private String gpmPassword;
    private String gpName;
    private String district;
    private String state;

    public GPA(int gpmID, String gpmName, int gpmAadhar, LocalDate gmDob, String gemGender, String gpmEmail, String gpmPassword, String gpName, String district, String state) {
        this.gpmID = gpmID;
        this.gpmName = gpmName;
        this.gpmAadhar = gpmAadhar;
        this.gmDob = gmDob;
        this.gemGender = gemGender;
        this.gpmEmail = gpmEmail;
        this.gpmPassword = gpmPassword;
        this.gpName = gpName;
        this.district = district;
        this.state = state;
    }

    public int getGpmID() {
        return gpmID;
    }

    public void setGpmID(int gpmID) {
        this.gpmID = gpmID;
    }

    public String getGpmName() {
        return gpmName;
    }

    public void setGpmName(String gpmName) {
        this.gpmName = gpmName;
    }

    public int getGpmAadhar() {
        return gpmAadhar;
    }

    public void setGpmAadhar(int gpmAadhar) {
        this.gpmAadhar = gpmAadhar;
    }

    public LocalDate getGmDob() {
        return gmDob;
    }

    public void setGmDob(LocalDate gmDob) {
        this.gmDob = gmDob;
    }

    public String getGemGender() {
        return gemGender;
    }

    public void setGemGender(String gemGender) {
        this.gemGender = gemGender;
    }

    public String getGpmEmail() {
        return gpmEmail;
    }

    public void setGpmEmail(String gpmEmail) {
        this.gpmEmail = gpmEmail;
    }

    public String getGpmPassword() {
        return gpmPassword;
    }

    public void setGpmPassword(String gpmPassword) {
        this.gpmPassword = gpmPassword;
    }

    public String getGpName() {
        return gpName;
    }

    public void setGpName(String gpName) {
        this.gpName = gpName;
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
        return "GPA{" +
                "gpmID=" + gpmID +
                ", gpmName='" + gpmName + '\'' +
                ", gpmAadhar=" + gpmAadhar +
                ", gmDob=" + gmDob +
                ", gemGender='" + gemGender + '\'' +
                ", gpmEmail='" + gpmEmail + '\'' +
                ", gpmPassword='" + gpmPassword + '\'' +
                ", gpName='" + gpName + '\'' +
                ", district='" + district + '\'' +
                ", state='" + state + '\'' +
                '}';
    }
}
