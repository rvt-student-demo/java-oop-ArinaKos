package rvt;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class FileHandler {
    private final String filePath = "data/students.csv";

    public void saveToFile(ArrayList<Student> students) {
        File file = new File(filePath);
        file.getParentFile().mkdirs();
        try (FileWriter writer = new FileWriter(file)) {
            writer.write("firstName,lastName,email,personalCode,registrationTime\n");
            for (Student student : students) {
                writer.write(student.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error saving data to file: " + e.getMessage());
        }
    }
    public ArrayList<Student> loadFromFile() {
        ArrayList<Student> students = new ArrayList<>();
        File file = new File(filePath);
        if (!file.exists()) return students;

        try (Scanner reader = new Scanner(file)) {
            if (reader.hasNextLine()) reader.nextLine();
            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                String[] parts = line.split(",");
                if (parts.length == 5) {
                    students.add(new Student(parts[0], parts[1], parts[2], parts[3], parts[4]));
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("Save file not found.");
        }
        return students;
    }
}