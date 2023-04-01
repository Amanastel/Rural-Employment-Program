package com.mnrega.dao;

import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

public interface BDOLogin {
    public void login(String username, String password)
            throws SomethingWentWrongException, NoRecordFoundException;

    public void logout();
}
