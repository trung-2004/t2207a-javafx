package exam;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListCustomer list = new ListCustomer();
        Scanner sc = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("***** Customer Relationship *****");
            System.out.println("MENU--------------- ");
            System.out.println("1. Add new customer");
            System.out.println("2. Find by name");
            System.out.println("3. Display all");
            System.out.println("0. Exit");
            select = sc.nextInt();
            switch (select) {
                case 1:
                    list.addCustomer();
                    break;
                case 2:
                    list.findByName();
                    break;
                case 3:
                    list.displayAll();
                    break;
            }
        } while (select != 0);
    }
}
