package com.mnrega.dao;

import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GRMinImpl implements GRMin{
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
    public void logout() {
        LoggedInBDO.loggedInBDOId = 0;
    }
}
