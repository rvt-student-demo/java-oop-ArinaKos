package rvt;

import java.util.ArrayList;

public class Person {
    private String name;
    private String address;

    public Person(String name, String address) {
        this.name = name;
        this.address = address;
          
    }

    @Override
    public String toString() {
        return this.name + "\n " + this.address;
    }
    public static void main(String[] args) {
        ArrayList<Person> persons = new ArrayList<Person>();
        persons.add(new Teacher("Ada lovelace", "24 Maddox St. London W1S 2QN", 1200));
        persons.add(new Student("Ollie", "6381 Hollywood Blvd. Los Angeles 90028"));

        printPersons(persons);
    }

    public static void printPersons(ArrayList<Person> persons) {
        for (int i = 0; i < persons.size(); i++) {
            System.out.println(persons.get(i));
        }
    }
}

class Student extends Person {
    private int credits;
    
    public Student(String name, String address) {
        super(name, address);
        this.credits = 0;
    }
    public void study () {
        this.credits = this.credits + 1;
    }
    @Override
    public String toString() {
        return super.toString() + "\n studiju kredītpunkti" + this.credits;
    }
}
class Teacher extends Person {
    private int salary;

    public Teacher(String name, String address, int salary) {
        super(name, address);
        this.salary = salary;
    }
    @Override
    public String toString() {
        return super.toString() + "\n alga" + this.salary + "euro/mēnesis";
    }
}
