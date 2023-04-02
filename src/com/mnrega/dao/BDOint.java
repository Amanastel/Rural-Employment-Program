package com.mnrega.dao;

import com.mnrega.dto.GPA;
import com.mnrega.dto.Project;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.util.List;

public interface BDOint {
    public boolean login(String username, String password);

    public String createProject(Project pro) throws SomethingWentWrongException, NoRecordFoundException;

    public List<Project> showAllProject () throws SomethingWentWrongException, NoRecordFoundException;

    public String createGPM (GPA gpm) throws SomethingWentWrongException, NoRecordFoundException;

//    public List<GPM> showAl1GPM () throws GPMException, NoRecordFound;

//    public String assignProToGPM(int proID, int gpmID) throws ProjectException, GPMException;

//    public List<Worker> showAllWorker () throws WorkerException, NoRecordFound;

//    public List<Worker> showAllWorkerByGMID(int gpmID) throws WorkerException, GPMException;

//    public List<Worker> showAllWorkerByproID (int gpmID) throws WorkerException, ProjectException;
}
