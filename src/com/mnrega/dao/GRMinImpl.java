package com.mnrega.dao;

import com.mnrega.dto.Workers;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;
import com.mysql.cj.xdevapi.WarningImpl;

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
    public String assignProWorker(int proID, int wID) throws SomethingWentWrongException, NoRecordFoundException {
        String str = "\nUnable to assign project\n";
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("select * from project where proID = ? and is_delete = false");
            ps.setInt(1,proID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                PreparedStatement prs = conn.prepareStatement("select * from workers where wID = ? and is_delete = false");
                prs.setInt(1,wID);
                ResultSet rsd = prs.executeQuery();
                if(rsd.next()){
                    PreparedStatement prs2 = conn.prepareStatement("update workers set proID = ?, workStrDate = now() where wID = ?");
                    prs2.setInt(1,proID);
                    prs2.setInt(2,wID);

                    if(prs2.executeUpdate()>0){
                        str = "Project with ID: " + proID + " assigned to a worker with ID: " + wID;
                    }
                }else {
                    throw new SomethingWentWrongException(" \nworker ID " + wID + " doesn't exist! \n");
                }
            }

        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }
        return str;
    }

    @Override
    public void showWorkerWorkingDay() throws SomethingWentWrongException {
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("select wName, datediff(now(), workStrDate) from workers where gpmID = ? and is_delete = false");
            ps.setInt(1,GPMID);
            ResultSet rs = ps.executeQuery();
            boolean bolF1 = false;
            while(rs.next()){
                bolF1 = true;
                System.out.println(rs.getString(1));
            }
            if( bolF1 == false){
                throw new SomethingWentWrongException(" \nNo Worker Working Day available\n");
            }

        }catch (ClassNotFoundException | SQLException ex){
            System.out.println(ex);
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }
    }

    @Override
    public String deleteWorker(int wID) throws SomethingWentWrongException {
        String str = "\nUnable to delete worker\n";
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("update workers set is_delete = true where wID = ? and is_delete = false");
            ps.setInt(1,wID);

            if(ps.executeUpdate()>0){
                str = "Inworker ID no " + wID + " deleted\n";
                countOfWorker();
            }else {
                throw new SomethingWentWrongException("\nWorker ID " + wID + " doesn't exist! \n");
            }

        }catch (ClassNotFoundException | SQLException ex){
            throw new SomethingWentWrongException("\nSomething went wrong! \n");
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }
        return str;
    }

    @Override
    public void countOfWorker() {
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            PreparedStatement ps = conn.prepareStatement("select proID from project where gpmID = ? and is_delete = false");
            ps.setInt(1,GPMID);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                int proId = rs.getInt(1);
                PreparedStatement prs = conn.prepareStatement("select count(*) from workers where gpmID = ? and proID = ? and is_delete = false");
                prs.setInt(1,GPMID);
                prs.setInt(2,proId);
                ResultSet rs2 = prs.executeQuery();
                if(rs2.next()){
                    int count = rs2.getInt(1);
                    PreparedStatement ps2 = conn.prepareStatement("update project set nOfWorkes = ? where proID = ?");
                    ps2.setInt(1,count);
                    ps2.setInt(2,proId);
                }
            }
        }catch (ClassNotFoundException | SQLException ex){
            System.out.println("worker is not working");
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }
    }


    @Override
    public void logout() {
        LoggedInBDO.loggedInBDOId = 0;
    }
}
