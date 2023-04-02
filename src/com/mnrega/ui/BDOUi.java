package com.mnrega.ui;

import com.mnrega.dao.BDOLogin;
import com.mnrega.dao.BDOLoginImpl;
import com.mnrega.dao.GRMin;
import com.mnrega.dao.GRMinImpl;
import com.mnrega.dto.Workers;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

import static com.mnrega.ui.UIMain.displayGEMMenu;

public class BDOUi {
    static boolean login(Scanner sc) {
        System.out.print("Enter email ");
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

    static void createWorker(Scanner sc){

        System.out.print("Enter Worker Name ");
        String wName = sc.next();

        System.out.print("Enter Worker Aadhar details ");
        String wAadhar = sc.next();

        System.out.print("Enter Worker DOB ");
        LocalDate wDob = LocalDate.parse(sc.next());

        System.out.print("Enter Gender ");
        String wGander = sc.next();

        Workers workers = new Workers(wName,wAadhar,wDob,wGander);

        GRMin grMin = new GRMinImpl();
        try {
            grMin.createWorker(workers);
            System.out.println("Worker Added successfully");
        }catch (InputMismatchException | SomethingWentWrongException ex){
            System.out.println(ex);
        }
    }
}
