package com.mnrega.ui;

import java.util.Scanner;

public class UIMain {
    static void displayBDOMenu() {
        System.out.println("0. Log out Admin");
        System.out.println("1. Add new Category");
        System.out.println("2. View all products for a Category");
        System.out.println("3. Add new Product");
        System.out.println("4. View All Products");
        System.out.println("5. View all Users");
        System.out.println("6. View all Orders");
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
//                    CategoryUI.addCategoryUI(sc);
                    break;
                case 2:
//                    ProductUI.viewProductsByCategoryId(sc);
                    break;
                case 3:
                    //productUI.addProduct();
                    break;
                case 4:
                    //userUI.viewAllUsers();
                    break;
                case 5:
                    //orderUI.viewAllOrders();
//					SELECT U.username, P.pro_name
//					FROM orders O INNER JOIN product P ON
//					O.product_id = P.id INNER JOIN user U ON
//					U.id = O.user_id;
//					Create an object of OrderDTO
//					new OrderDTO(new ProductDTO(null, pro_name, null, null), new UserDTO(null, username, null));
                    break;
                default:
                    System.out.println("Invalid Selection, try again");
            }
        }while(choice != 0);
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
    static void displayUserMenu() {
        System.out.println("1. View All Products");
        System.out.println("2. Purchase a Product");
        System.out.println("3. View Order History");
        System.out.println("4. Update My Name");
        System.out.println("5. Update My Password");
        System.out.println("6. Delete My Account");
        System.out.println("0. Logout");
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
//                    GPMLogin(sc);
                    break;

                default:
                    System.out.println("Invalid Selection, try again");
            }
        }while(choice != 0);
        sc.close();
    }
}