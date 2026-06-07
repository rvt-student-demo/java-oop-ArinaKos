package rvt;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Student {
    private String firstName;
    private String lastName;
    private String email;
    private String personalCode;
    private String registrationTime;
    public Student(String firstName, String lastName, String email, String personalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"));
    }
    public Student(String firstName, String lastName, String email, String personalCode, String registrationTime) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.personalCode = personalCode;
        this.registrationTime = registrationTime;
    }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }
    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getPersonalCode() { return personalCode; }
    public String getRegistrationTime() { return registrationTime; }

    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", firstName, lastName, email, personalCode, registrationTime);
    }
}