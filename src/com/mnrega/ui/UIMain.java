package com.mnrega.ui;

import com.mnrega.dao.BDOLogin;
import com.mnrega.dao.BDOLoginImpl;
import com.mnrega.excetion.NoRecordFoundException;
import com.mnrega.excetion.SomethingWentWrongException;

import java.util.Scanner;

import static com.mnrega.ui.BDOMainUi.*;
import static com.mnrega.ui.BDOUi.createWorker;

public class UIMain {
    static void displayBDOMenu() {
        System.out.println("1. Create Project ");
        System.out.println("2. View List of Project ");
        System.out.println("3. Create GPM ");
        System.out.println("4. View all GPM ");
        System.out.println("5. Allocate Project to GPM ");
        System.out.println("6. View all worker ");
        System.out.println("0. Log out ");
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
        System.out.print("Enter username ");
        String username = sc.next();
        System.out.print("Enter password ");
        String password = sc.next();

        if(username.equalsIgnoreCase("admin") && password.equalsIgnoreCase("admin")) {
            BDOMenu(sc);
        }else {
            System.out.println("Invalid Username and Password");
        }
    }


    static void displayGEMMenu() {
        System.out.println("1. Create worker ");
        System.out.println("2. View GP worker ");
        System.out.println("3. Search worker by Aadhar ");
        System.out.println("4. Assign project to worker ");
        System.out.println("5. View worker and working day ");
        System.out.println("6. Delete the worker ");
        System.out.println("0. Logout");
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
//                    OrderUI.purchase(sc);
                        break;
                    case 3:
                        //orderUI.viewOrderDetails();
                        break;
                    case 4:
                        //userUI.updateNameOfUser();
                        break;
                    case 5:
                        //userUI.changePassword();
                        break;
                    case 6:
                        //userUI.deleteUser();
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
            System.out.println("1. BDO Login\n2. GPM Login \n0. Exit ");
            choice = sc.nextInt();
            switch(choice) {
                case 0:
                    System.out.println("Thank you, Visit again");
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
