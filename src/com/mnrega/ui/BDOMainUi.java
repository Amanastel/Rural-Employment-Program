package com.mnrega.ui;

import com.mnrega.dao.BDOint;
import com.mnrega.dao.BDOintImpl;
import com.mnrega.dto.GPA;
import com.mnrega.dto.Project;
import com.mnrega.dto.Workers;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.time.LocalDate;
import java.util.Date;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BDOMainUi {
    public static void CreateProjectUI(Scanner sc){

        System.out.print("Enter project name ");
        String proName = sc.next();

        System.out.print("Enter Start Date ");
        LocalDate startDate = LocalDate.parse(sc.next());

        System.out.print("Enter End Date ");
        LocalDate endDate = LocalDate.parse(sc.next());

        System.out.print("Enter wages per day ");
        int wage = sc.nextInt();

        Project pro = new Project(proName,startDate,endDate,wage);
        BDOint bdo = new BDOintImpl();
        try {
            String str = bdo.createProject(pro);
            System.out.println(str);
        }catch (InputMismatchException | NoRecordFoundException | SomethingWentWrongException ex){
            System.out.println(ex);
        }
    }
    public static void showAllProject() {
        BDOint bdo = new BDOintImpl();
        try {
            List<Project> pr = bdo.showAllProject();
            pr.forEach(System.out::println);
        }catch (NoRecordFoundException | SomethingWentWrongException ex){
            System.out.println(ex);
        }
    }

    public static void createGPM(Scanner sc){
        System.out.print("Enter GPM name ");
        String GpmName = sc.next();

        System.out.print("Enter Aadhar Number ");
        String gpmAadhar = sc.next();
        if(gpmAadhar.length()<12){
            System.out.println("wrong Aadhar card");
            sc.close();
        }

        System.out.print("Enter GMP dob ");
        LocalDate endDate = LocalDate.parse(sc.next());

        System.out.print("Enter GRM Gender ");
        String gemGender = sc.next();

        System.out.print("Enter GRM Email ");
        String gpmEmail = sc.next();

        System.out.print("Enter GRM Password ");
        String gpmPassword = sc.next();

        System.out.print("Enter GP Name ");
        String gpName = sc.next();

        System.out.print("Enter GP district ");
        String district = sc.next();

        System.out.print("Enter GP state ");
        String state = sc.next();

        GPA gpa = new GPA(GpmName,gpmAadhar,endDate,gemGender,gpmEmail,gpmPassword,gpName,district,state);
        BDOint bdo = new BDOintImpl();
        try {
            bdo.createGPM(gpa);
            System.out.println("Create GPM successfully");
        }catch (InputMismatchException | NoRecordFoundException | SomethingWentWrongException ex){
            System.out.println(ex);
        }
    }
    public static void showAl1GPM(){
        BDOint bdo = new BDOintImpl();
        try {
            List<GPA> gpm = bdo.showAl1GPM();
            gpm.forEach(System.out::println);
        }catch (NoRecordFoundException | SomethingWentWrongException ex){
            System.out.println(ex);
        }
    }
    public static void allocateProjectGPM(Scanner sc){
        System.out.print("Enter Project ID ");
        int proID = sc.nextInt();

        System.out.print("Enter GPM ID ");
        int gpmID = sc.nextInt();

        BDOint bdo = new BDOintImpl();
        try {
            bdo.allocateProjectGPM(proID,gpmID);
            System.out.println("Allocate Project successfully");
        }catch (InputMismatchException | NoRecordFoundException | SomethingWentWrongException ex){
            System.out.println(ex);
        }
    }
    public static void showAllWorker(){
        BDOint bdo = new BDOintImpl();
        try {
            List<Workers> list = bdo.showAllWorker();
            list.forEach(System.out::println);
        }catch (NoRecordFoundException | SomethingWentWrongException ex){
            System.out.println(ex);
        }
    }
}
