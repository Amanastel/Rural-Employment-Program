package com.mnrega.dao;

import com.mnrega.dto.GPA;
import com.mnrega.dto.Workers;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.util.List;

public interface GRMin {
    public boolean login (String email, String password) throws SomethingWentWrongException, NoRecordFoundException;
    public String createWorker(Workers worker, LoggedInBDO gpmID) throws SomethingWentWrongException;

    public List<Workers> showAllWorkerGPM() throws SomethingWentWrongException;

    public Workers SearchAadharDetails(String aadhar) throws SomethingWentWrongException;

    public String assignProWorker(int proID, int wID) throws SomethingWentWrongException, NoRecordFoundException;

    public void showWorkerWorkingDay(LoggedInBDO gpmID) throws SomethingWentWrongException;

//    public void ShowWorkerAndWages () throws SomethingWentWrongException;

    public String deleteWorker(int wID,LoggedInBDO gpmID) throws SomethingWentWrongException;

    public void countOfWorker (LoggedInBDO gpmID) ;


    public void logout();
}
