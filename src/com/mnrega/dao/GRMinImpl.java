package com.mnrega.dao;

import com.mnrega.dto.Workers;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class GRMinImpl implements GRMin{
    public static int GPMID = 1;
    @Override
    public boolean login(String email, String password) throws SomethingWentWrongException, NoRecordFoundException{
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            String query = "SELECT gpmID FROM GramPanchayatMember WHERE gpmEmail = ? AND gpmPassword = ? AND is_delete = false";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(DBUtils.isResultSetEmpty(rs)) {
                throw new NoRecordFoundException("Invalid username or password");
            }
            rs.next();
            LoggedInBDO.loggedInBDOId = rs.getInt(1);
        }catch (ClassNotFoundException | SQLException  ex){
            throw new SomethingWentWrongException("Unable to Login");
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }
        return false;
    }

    @Override
    public String createWorker(Workers worker) throws SomethingWentWrongException {
        String str = " nUnable to create worker\n";
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("select gpmName, district, state from GramPanchayatMember where gpmID = ? and is_delete = false");
            ps.setInt(1, GPMID);
            ResultSet rs = ps.executeQuery();
            String gpName = null;
            String district = null;
            String state = null;
            while (rs.next()){
                gpName = rs.getString(1);
                district = rs.getString(2);
                state = rs.getString(3);
            }

            PreparedStatement prs = conn.prepareStatement("insert into workers (wName, WAadhar, wDob, Wender, gpName, gpmID, district, state) VALUES (?,?,?,?,?,?,?,?)");
            prs.setString(1,worker.getwName());
            prs.setString(2,worker.getWAadhar());
            prs.setDate(3, Date.valueOf(worker.getwDob()));
            prs.setString(4,worker.getWGender());
            prs.setString(5, gpName);
            prs.setInt(6, GPMID);
            prs.setString(7, district);
            prs.setString(8, state);
            if(prs.executeUpdate()>0){
                str = "\nworker created successfully\n";
            }else {
                throw new SomethingWentWrongException("\nError while creating new worker. Try again\n");
            }
        }catch ( SQLException | ClassNotFoundException ex){
            throw new SomethingWentWrongException("\nSomething went wrong!\n");
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }
        return str;
    }

    @Override
    public List<Workers> showAllWorkerGPM() throws SomethingWentWrongException {
        List<Workers> list = new ArrayList<>();
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("select * from workers where is_delete = false");
//            ps.setInt(1,GPMID);
            ResultSet rs = ps.executeQuery();
            boolean bolen = false;
            while (rs.next()){
                bolen = true;
                list.add(new Workers(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9),rs.getString(10)));
            }
            if(bolen == false){
                throw new SomethingWentWrongException(" \nNo worker available in this GPM\n" );
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
    public Workers SearchAadharDetails(String aadhar) throws SomethingWentWrongException {
        Workers worker = null;
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("select * from workers where WAadhar = ? and is_delete = false");
            ps.setString(1,aadhar);
            ResultSet rs = ps.executeQuery();
            boolean bol = false;
            while (rs.next()){
                bol = true;
                worker = new Workers(rs.getInt(1), rs.getString(2),rs.getString(3),rs.getDate(4).toLocalDate(), rs.getString(5),
                        rs.getString(6), rs.getInt(7), rs.getInt(8),
                        rs.getString(9),rs.getString(10));
            }
            if(bol == false){
                throw new SomethingWentWrongException("\nNo worker available with aadhar " + aadhar +"\n");
            }
        }catch (ClassNotFoundException | SQLException ex){
            throw new SomethingWentWrongException("\nSomething went wrong! \n");
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }
        return worker;
    }

    @Override
    public void logout() {
        LoggedInBDO.loggedInBDOId = 0;
    }
}
