package com.mnrega.ui;

import com.mnrega.dao.BDOint;
import com.mnrega.dao.BDOintImpl;
import com.mnrega.dto.Project;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class BDOMainUi {
    public static void CreateProjectUI(Scanner sc){

        System.out.print(" Enter project name ");
        String proName = sc.next();

        System.out.print(" Enter Start Date ");
        LocalDate startDate = LocalDate.parse(sc.next());

        System.out.print(" Enter End Date ");
        LocalDate endDate = LocalDate.parse(sc.next());

        System.out.print(" Enter wages per day ");
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
}
