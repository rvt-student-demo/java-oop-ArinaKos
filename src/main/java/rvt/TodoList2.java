package rvt;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class TodoList2 {
    private ArrayList<String> tasks = new ArrayList<>();

    public void add(String task) {
        if (checkEventString(task)) {
            tasks.add(task);
            try (FileWriter rewritter = new FileWriter(new File("data/todo.csv"))) {
                rewritter.write("id,task");
                for (int i = 0; i < tasks.size(); i++) {
                    rewritter.write("\n" + (i + 1) + "," + tasks.get(i));
                }
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
        } else {
            System.out.println("Task must be at least 3 characters long and contain only letters, numbers and spaces");
        }
    }
    public void print() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println((i + 1) + ": " + tasks.get(i));
        }
    }

    public void markCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
            try (FileWriter rewritter = new FileWriter(new File("data/todo.csv"))) {
                rewritter.write("id,task");
                for (int i = 0; i < tasks.size(); i++) {
                    rewritter.write("\n" + (i + 1) + "," + tasks.get(i));
                }
                System.out.println("Successfully wrote to the file.");
            } catch (IOException e) {
                System.out.println("An error occurred.");
            }
        }
    }

    public ArrayList<String> getTasks() {
        return new ArrayList<>(tasks);
    }

    public void loadFromFile() {
        try (Scanner reader = new Scanner(new File("data/todo.csv"))) {
            if (reader.hasNextLine()) {
                reader.nextLine();
            }
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    tasks.add(parts[1].trim());
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("ERROR: Could not load todo list from file");
        }
    }

    public boolean checkEventString(String value) {
        return value != null && value.matches("^[a-zA-Z0-9 ]{3,}$");
    }
}