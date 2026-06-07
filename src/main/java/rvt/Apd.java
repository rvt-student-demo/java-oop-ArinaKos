package rvt;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        RegistrationSystem system = new RegistrationSystem();
        while (true) {
            System.out.print("\nCommands: register, show, remove, edit, exit\nEnter command: ");
            String command = scanner.nextLine().trim().toLowerCase();
            try {
                if ("exit".equals(command)) {
                    System.out.println("Exiting program...");
                    break;
                } else if ("register".equals(command)) {
                    System.out.print("First Name: ");
                    String fName = scanner.nextLine().trim();
                    System.out.print("Last Name: ");
                    String lName = scanner.nextLine().trim();
                    System.out.print("Email: ");
                    String email = scanner.nextLine().trim();
                    System.out.print("Personal Code (e.g. 123456-12345): ");
                    String pCode = scanner.nextLine().trim();

                    system.register(fName, lName, email, pCode);
                } else if ("show".equals(command)) {
                    system.show();
                } else if ("remove".equals(command)) {
                    System.out.print("Enter Personal Code of student to remove: ");
                    String pCode = scanner.nextLine().trim();
                    system.remove(pCode);
                } else if ("edit".equals(command)) {
                    System.out.print("Enter Personal Code of student to edit: ");
                    String pCode = scanner.nextLine().trim();
                    System.out.print("New First Name: ");
                    String fName = scanner.nextLine().trim();
                    System.out.print("New Last Name: ");
                    String lName = scanner.nextLine().trim();
                    System.out.print("New Email: ");
                    String email = scanner.nextLine().trim();

                    system.edit(pCode, fName, lName, email);
                } else {
                    System.out.println("Unknown command! Available: register, show, remove, edit, exit");
                }
            } catch (Exception e) {
                System.out.println("[ERROR] " + e.getMessage());
            }
        }
        scanner.close();
    }
}