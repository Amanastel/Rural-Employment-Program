package com.mnrega.ui;

import com.mnrega.dao.BDOLogin;
import com.mnrega.dao.BDOLoginImpl;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.util.Scanner;

import static com.mnrega.ui.UIMain.displayGEMMenu;

public class BDOUi {
    static boolean login(Scanner sc) {
        System.out.println("Enter email");
        String email = sc.next();

        System.out.print("Enter password ");
        String password = sc.next();

        BDOLogin bdoLogin = new BDOLoginImpl();
        try {
            bdoLogin.login(email,password);
            displayGEMMenu();
        }catch (SomethingWentWrongException | NoRecordFoundException ex){
            System.out.println(ex);
            return false;
        }
        return true;
    }
    static void logOut(){
        BDOLogin bdoLogin = new BDOLoginImpl();
        bdoLogin.logout();
    }
}
