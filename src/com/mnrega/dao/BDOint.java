package com.mnrega.dao;

import com.mnrega.dto.GPA;
import com.mnrega.dto.Project;
import com.mnrega.dto.Workers;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.util.List;

public interface BDOint {
    public boolean login(String username, String password);

    public String createProject(Project pro) throws SomethingWentWrongException, NoRecordFoundException;

    public List<Project> showAllProject () throws SomethingWentWrongException, NoRecordFoundException;

    public String createGPM (GPA gpm) throws SomethingWentWrongException, NoRecordFoundException;

    public List<GPA> showAl1GPM () throws SomethingWentWrongException, NoRecordFoundException;

    public String allocateProjectGPM(int proID, int gpmID) throws SomethingWentWrongException, NoRecordFoundException;

    public List<Workers> showAllWorker () throws SomethingWentWrongException, NoRecordFoundException;

//    public List<Worker> showAllWorkerByGMID(int gpmID) throws WorkerException, GPMException;

//    public List<Worker> showAllWorkerByproID (int gpmID) throws WorkerException, ProjectException;
}
