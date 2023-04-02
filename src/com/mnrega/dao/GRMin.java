package com.mnrega.dao;

import com.mnrega.dto.Workers;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

public interface GRMin {
    public boolean login (String email, String password) throws SomethingWentWrongException, NoRecordFoundException;
    public String createWorker(Workers worker) throws SomethingWentWrongException;

    public void logout();
}
