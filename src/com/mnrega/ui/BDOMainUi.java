package com.mnrega.ui;

import java.time.LocalDate;
import java.util.Scanner;

public class BDOMainUi {
    public static void CreateProjectUI(Scanner sc){

        System.out.print(" Enter project name ");
        String proName = sc.next();

        System.out.print(" Enter Start Date ");
        LocalDate startDate = LocalDate.parse(sc.next());

        System.out.print(" Enter End Date ");
        LocalDate endDate = LocalDate.parse(sc.next());
    }
}
