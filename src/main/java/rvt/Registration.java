package rvt;

import java.util.ArrayList;

public class RegistrationSystem {
    private ArrayList<Student> students;
    private FileHandler fileHandler;
    public RegistrationSystem() {
        this.fileHandler = new FileHandler();
        this.students = fileHandler.loadFromFile();
    }
    public void register(String firstName, String lastName, String email, String personalCode) throws Exception {
        validateInput(firstName, lastName, email, personalCode);
        for (Student s : students) {
            if (s.getPersonalCode().equals(personalCode)) {
                throw new Exception("Registration failed: Personal code already exists!");
            }
            if (s.getEmail().equalsIgnoreCase(email)) {
                throw new Exception("Registration failed: Email already registered!");
            }
        }
        Student newStudent = new Student(firstName, lastName, email, personalCode);
        students.add(newStudent);
        fileHandler.saveToFile(students);
        System.out.println("Student registered successfully!");
    }
    public void remove(String personalCode) throws Exception {
        Student toRemove = null;
        for (Student s : students) {
            if (s.getPersonalCode().equals(personalCode)) {
                toRemove = s;
                break;
            }
        }
        if (toRemove == null) {
            throw new Exception("Student with this personal code not found.");
        }
        students.remove(toRemove);
        fileHandler.saveToFile(students);
        System.out.println("Student removed successfully.");
    }
    public void edit(String personalCode, String newFirstName, String newLastName, String newEmail) throws Exception {
        Student student = null;
        for (Student s : students) {
            if (s.getPersonalCode().equals(personalCode)) {
                student = s;
                break;
            }
        }
        if (student == null) {
            throw new Exception("Student with this personal code not found.");
        }
        validateInput(newFirstName, newLastName, newEmail, "000000-00000");

        student.setFirstName(newFirstName);
        student.setLastName(newLastName);
        student.setEmail(newEmail);
        fileHandler.saveToFile(students);
        System.out.println("Student details updated successfully.");
    }
    public void show() {
        if (students.isEmpty()) {
            System.out.println("No students registered.");
            return;
        }
        System.out.println("Registered Students:");
        for (int i = 0; i < students.size(); i++) {
            Student s = students.get(i);
            System.out.println((i + 1) + ". " + s.getFirstName() + " " + s.getLastName() + 
                               " | Email: " + s.getEmail() + 
                               " | Code: " + s.getPersonalCode() + 
                               " | Registered: " + s.getRegistrationTime());
        }
    }
    private void validateInput(String fName, String lName, String email, String pCode) throws Exception {
        if (fName == null || !fName.matches("^[a-zA-Z]{3,}$")) {
            throw new Exception("First name must be at least 3 letters long!");
        }
        if (lName == null || !lName.matches("^[a-zA-Z]{3,}$")) {
            throw new Exception("Last name must be at least 3 letters long!");
        }
        if (email == null || !email.matches("^[A-Za-z0-9._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$")) {
            throw new Exception("Invalid email format!");
        }
        if (pCode == null || !pCode.matches("^\\d{6}-\\d{5}$")) {
            throw new Exception("Invalid Latvian personal code format (e.g., 123456-12345)!");
        }
    }
}