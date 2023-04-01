package com.mnrega.dao;

import com.mnrega.dto.Project;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class BDOintImpl implements BDOint {

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public String createProject(Project pro) throws SomethingWentWrongException, NoRecordFoundException {
        Connection conn = null;
        String msg = "\nUnable to create project\n";

        try{
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("insert into project");


        }catch ( SQLException | ClassNotFoundException ex){

        }
        return null;
    }

}
