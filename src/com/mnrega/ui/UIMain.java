package com.mnrega.ui;

import com.mnrega.dao.BDOLogin;
import com.mnrega.dao.BDOLoginImpl;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;
import custom.ConsoleColors;

import java.util.Scanner;

import static com.mnrega.ui.BDOMainUi.*;
import static com.mnrega.ui.BDOUi.*;

public class UIMain {
    static void displayBDOMenu() {
//        System.out.println("1. Create Project ");
//        System.out.println("2. View List of Project ");
//        System.out.println("3. Create GPM ");
//        System.out.println("4. View all GPM ");
//        System.out.println("5. Allocate Project to GPM ");
//        System.out.println("6. View all worker ");
//        System.out.println("0. Log out ");


        System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to BDO Home Window : "+ ConsoleColors.RESET);
        System.out.println("Press 1 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +"  Create Project " + ConsoleColors.RESET);
        System.out.println("Press 2 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +"  View List of Project " + ConsoleColors.RESET);
        System.out.println("Press 3 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +"  Create GPM " + ConsoleColors.RESET);
        System.out.println("Press 4 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +"  View all GPM " + ConsoleColors.RESET);
        System.out.println("Press 5 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +"  Allocate GPM to a Project." + ConsoleColors.RESET);
        System.out.println("Press 6 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +"  View all worker " + ConsoleColors.RESET);
        System.out.println("Press 0 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +"  LOGOUT AND RETURN TO HOMEPAGE" + ConsoleColors.RESET);
    }

    static void BDOMenu(Scanner sc) {
        int choice = 0;
        do {
            displayBDOMenu();
            System.out.print("Enter selection ");
            choice = sc.nextInt();
            switch(choice) {
                case 0:
                    System.out.println("Bye Bye admin");
                    break;
                case 1:
                    CreateProjectUI(sc);
                    break;
                case 2:
                    showAllProject();
                    break;
                case 3:
                    createGPM(sc);
                    break;
                case 4:
                    showAl1GPM();
                    break;
                case 5:
                    allocateProjectGPM(sc);
                    break;
                case 6:
                    showAllWorker();
                    break;
                default:
                    System.out.println("Invalid Selection, try again");
            }
        }while(choice != 0);
        sc.close();
    }

    static void BDOLogin(Scanner sc) {
        System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT +" Enter username  " + ConsoleColors.RESET);
//        System.out.print("Enter username ");
        String username = sc.next();
        System.out.print(ConsoleColors.PURPLE_BOLD_BRIGHT +" Enter password " + ConsoleColors.RESET);
//        System.out.print("Enter password ");
        String password = sc.next();

        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            BDOMenu(sc);
        }else {
            System.out.println("Invalid Username and Password");
        }
    }


    static void displayGEMMenu() {
//        System.out.println("1. Create worker ");
//        System.out.println("2. View GP worker ");
//        System.out.println("3. Search worker by Aadhar ");
//        System.out.println("4. Assign project to worker ");
//        System.out.println("5. View worker and working day ");
//        System.out.println("6. Delete the worker ");
//        System.out.println("7. View all worker ");
//        System.out.println("0. Logout");

        System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to Gram Panchayat Member Home Window : "+ ConsoleColors.RESET);
        System.out.println("Press 1 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Create worker " + ConsoleColors.RESET);
        System.out.println("Press 2 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View GP worker " + ConsoleColors.RESET);
        System.out.println("Press 3 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Search worker by Aadhar " + ConsoleColors.RESET);
        System.out.println("Press 4 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Assign project to worker " + ConsoleColors.RESET);
        System.out.println("Press 5 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View worker and working day " + ConsoleColors.RESET);
        System.out.println("Press 6 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" Delete the worker " + ConsoleColors.RESET);
        System.out.println("Press 7 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" View all worker " + ConsoleColors.RESET);
        System.out.println("Press 0 to"+ConsoleColors.PURPLE_BOLD_BRIGHT +" LOGOUT " + ConsoleColors.RESET);
    }
    public static void GPMLogin(Scanner sc){
//        Gram Panchayat Member login
        if(BDOUi.login(sc)) {

            int choice = 0;
            do {
                displayGEMMenu();
                System.out.print("Enter selection ");
                choice = sc.nextInt();
                switch (choice) {
                    case 1:
                        createWorker(sc);
                        break;
                    case 2:
                        showAllWorkerGPM();
                        break;
                    case 3:
                        SearchAadharDetails(sc);
                        break;
                    case 4:
                        assignProWorker(sc);
                        break;
                    case 5:
                        showWorkerWorkingDay(sc);
                        break;
                    case 6:
                        deleteWorker(sc);
                        break;
                    case 7:
                        showAllWorker();
                        break;
                    case 0:
                        BDOUi.logOut();
                        break;
                    default:
                        System.out.println("Invalid Selection, try again");
                }
            } while (choice != 0);
            sc.close();
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;
        do {

//            System.out.println("1. BDO Login\n2. GPM Login \n0. Exit ");

            System.out.println(ConsoleColors.BROWN_BACKGROUND+ConsoleColors.WHITE_BOLD_BRIGHT+"Welcome to GRAM MGNREGA Application : "+ ConsoleColors.RESET);
            System.out.println(ConsoleColors.BLUE_BOLD_BRIGHT+"Choose Login Option from Below According to your Designation  : " + ConsoleColors.RESET);
            System.out.println("Press 1 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " logIn as BDO. " + ConsoleColors.RESET);
            System.out.println("Press 2 to" +ConsoleColors.PURPLE_BOLD_BRIGHT + " logIn as Gram Panchayat Member. "+ ConsoleColors.RESET);
            System.out.println("Press 3 to" +ConsoleColors.PURPLE_BOLD_BRIGHT +" EXIT. "+ ConsoleColors.RESET);
            choice = sc.nextInt();
            switch(choice) {
                case 3:
                    System.out.println("Thank you, Visit again");
                    sc.close();
                    break;
                case 1:
                    BDOLogin(sc);
                    break;
                case 2:
                    GPMLogin(sc);
                    break;
                default:
                    System.out.println("Invalid Selection, try again");
            }
        }while(choice != 0);
        sc.close();
    }
}
