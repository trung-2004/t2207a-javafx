package exam;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class ListCustomer {
    private HashMap<String, Customer> list = new HashMap<>();

    public void addCustomer() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        System.out.print("Enter email: ");
        String email = sc.nextLine();
        System.out.print("Enter phone: ");
        String phone = sc.nextLine();
        Customer customer = new Customer(name, email, phone);
        list.put(name, customer);
        System.out.println("Customer added successfully.");
    }
    public void findByName() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter name: ");
        String name = sc.nextLine();
        Customer customer = list.get(name);
        if (customer != null) {
            System.out.println("Name: " + customer.getName());
            System.out.println("Email: " + customer.getEmail());
            System.out.println("Phone: " + customer.getPhone());
        } else {
            System.out.println("Not found");
        }
    }
    public void displayAll() {
        System.out.println("\t CRM ");
        System.out.println("Name \t Phone number");
        for (Map.Entry<String, Customer> item: list.entrySet()) {
            Customer customer = item.getValue();
            System.out.println(customer.getName()+" \t "+customer.getPhone());
        }
    }
}
