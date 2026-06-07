package rvt;

import java.util.ArrayList;
import java.util.Scanner;

public class TodoList1 {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        TodoList list  = new  TodoList();
        list.loadFromFile();
        while(true) {
            System.out.println("# ");
            String choice = scn.nextLine();
        } if ("help".equals(choice)) {
            System.out.println("add (Add new task)");
            System.out.println("list (Show all undone tasks)");
            System.out.println("done (Remove task as done)");
            System.out.println("done (Remove task as done(Remove from list))");
            System.out.println("stop (Exit from program)");
        } else if ("stop".equals(choice)) {
            break;
        } else {
            System.out.println("Wrong command, type 'help' for commands");
        }
    }
}