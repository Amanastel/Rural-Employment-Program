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
            String query = "SELECT id FROM user WHERE username = ? AND password = ? AND is_delete = 0";
            PreparedStatement ps = conn.prepareStatement(query);
            ps.setString(1, username);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if(DBUtils.isResultSetEmpty(rs)){
                throw new NoRecordFoundException("Invalid username or password");
            }
            rs.next();
            LoggedInUser.loggedInUserId = rs.getInt(1);
        }catch (ClassNotFoundException | SQLException ex){
            throw new SomethingWentWrongException("Unable to add category");
        }finally {
            try {
                DBUtils.closeConnection(conn);
            }catch(SQLException ex) {

            }
        }

    }

    @Override
    public void logout() {
        LoggedInUser.loggedInUserId = 0;
    }
}
