package com.mnrega.dto;

import java.time.LocalDate;

public class Project {
    private int proID;
    private String proName;
    private LocalDate proStartDate;
    private LocalDate proEndDate;
    private int gpmID;
    private int noOfWorker;
    private int wagesParDay;
    public Project () {}
    public Project (int proID, String proName, LocalDate proStartDate, LocalDate proEndDate, int gpmID, int noOfWorker, int wagesParDay){
        super();
        this.proID = proID;
        this.proName = proName;
        this.proStartDate = proStartDate;
        this.proEndDate = proEndDate;
        this.gpmID = gpmID;
        this.noOfWorker = noOfWorker;
        this.wagesParDay = wagesParDay;
    }

    public Project (String proName, LocalDate proStrate, LocalDate proEndDate, int wagesParDay){
        super();
        this.proName = proName;
        this.proStartDate = proStrate;
        this.proEndDate = proEndDate;
        this.wagesParDay = wagesParDay;

    }

    public int getProID() {
        return proID;
    }

    public void setProID(int proID) {
        this.proID = proID;
    }

    public String getProName() {
        return proName;
    }

    public void setProName(String proName) {
        this.proName = proName;
    }

    public LocalDate getproStartDate() {
        return proStartDate;
    }

    public void setProStartDate(LocalDate proStrate) {
        this.proStartDate = proStrate;
    }

    public LocalDate getProEndDate() {
        return proEndDate;
    }

    public void setProEndDate(LocalDate proEndDate) {
        this.proEndDate = proEndDate;
    }

    public int getGpmID() {
        return gpmID;
    }

    public void setGpmID(int gpmID) {
        this.gpmID = gpmID;
    }

    public int getNoOfWorker() {
        return noOfWorker;
    }

    public void setNoOfWorker(int noOfWorker) {
        this.noOfWorker = noOfWorker;
    }

    public int getWagesParDay() {
        return wagesParDay;
    }

    public void setWagesParDay(int wagesParDay) {
        this.wagesParDay = wagesParDay;
    }

    @Override
    public String toString() {
        return "Project{" +
                "proID=" + proID +
                ", proName='" + proName + '\'' +
                ", proStartDate=" + proStartDate +
                ", proEndDate=" + proEndDate +
                ", gpmID=" + gpmID +
                ", noOfWorker=" + noOfWorker +
                ", wagesParDay=" + wagesParDay +
                '}';
    }
}

