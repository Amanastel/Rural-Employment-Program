package com.mnrega.dao;

import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class BDOLoginImpl implements BDOLogin {
    @Override
    public void login(String username, String password) throws SomethingWentWrongException, NoRecordFoundException {
        Connection conn = null;
        try {
            conn = DBUtils.getConnectionToDatabase();
            String query = "SELECT gpmID FROM GramPanchayatMember WHERE gpmEmail = ? AND gpmPassword = ? AND is_delete = false";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(DBUtils.isResultSetEmpty(rs)){
                throw new NoRecordFoundException("Invalid username or password");
            }
            while (rs.next()){
                LoggedInBDO.loggedInBDOId = rs.getInt(1);
            }
        }catch (ClassNotFoundException | SQLException ex){
            throw new SomethingWentWrongException("Unable to login");
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {
                System.out.println(ex);
            }
        }
    }

    @Override
    public void logout() {
        LoggedInBDO.loggedInBDOId = 0;
    }
}
