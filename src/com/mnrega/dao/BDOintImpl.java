package com.mnrega.dao;

import com.mnrega.dto.GPA;
import com.mnrega.dto.Project;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BDOintImpl implements BDOint {

    @Override
    public boolean login(String username, String password) {
        return false;
    }

    @Override
    public String createProject(Project pro) throws SomethingWentWrongException, NoRecordFoundException {

        String str = "\nUnable to create project\n";
        Connection conn = null;

        try{
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("insert into project (proName, proStrDate, proEndDate, wagesParDay) VALUES (?,?,?,?)");
            ps.setString(1,pro.getProName());
            ps.setDate(2, Date.valueOf(pro.getproStartDate()));
            ps.setDate(3,Date.valueOf(pro.getProEndDate()));
            ps.setInt(4,pro.getWagesParDay());
            if(ps.executeUpdate()>0){
                str = "InProject created successfully";
            }else{
                throw new SomethingWentWrongException("\nError while creating a new project. Try again\n");
            }
        }catch ( SQLException | ClassNotFoundException ex){
            throw new SomethingWentWrongException("\nSomething went wrong.\n");
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }
        return str;
    }

    @Override
    public List<Project> showAllProject() throws SomethingWentWrongException, NoRecordFoundException {
        List<Project> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("select * from project where is_delete = false");
            ResultSet rs = ps.executeQuery();
            boolean b = false;
            while (rs.next()){
                b = true;
                list.add(new Project(rs.getInt(1), rs.getString(2), rs.getDate(3).toLocalDate(), rs.getDate(4).toLocalDate(),
                        rs.getInt(5), rs.getInt(6), rs.getInt(7)));
            }
            if(b == false){
                throw new SomethingWentWrongException("\nNo Project available\n");
            }
        }catch (ClassNotFoundException | SQLException ex){
            throw new SomethingWentWrongException("\nSomething went wrong! \n");

        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }
        return list;
    }

    @Override
    public String createGPM(GPA gpm) throws SomethingWentWrongException, NoRecordFoundException {
        String str = "\nUnable to create GPM\n";
        Connection conn = null;
        try{
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("insert into GramPanchayatMember (gpmName, gpmAadhar, gmDob, gemGender, gpmEmail, gpmPassword, gpName, district, state) VALUES(?,?,?,?,?,?,?,?,?)");
            ps.setString(1, gpm.getGpmName());
            ps.setString(2, gpm.getGpmAadhar());
            ps.setDate(3, Date.valueOf(gpm.getGmDob()));
            ps.setString(4, gpm.getGemGender());
            ps.setString(5,gpm.getGpmEmail());
            ps.setString(6,gpm.getGpmPassword());
            ps.setString(7,gpm.getGpName());
            ps.setString(8,gpm.getDistrict());
            ps.setString(9,gpm.getState());
            if(ps.executeUpdate()>0){
                str = "\nGPM created successfully\n";
            }else {
                throw new SomethingWentWrongException("\nError while creating a new GPM. Try again\n");
            }
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }
        return str;
    }

}
