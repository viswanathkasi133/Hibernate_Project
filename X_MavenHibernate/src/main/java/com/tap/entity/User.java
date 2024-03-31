package com.tap.entity;

import jakarta.persistence.*;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String department;
    private String salary;
    private String email;
    private String password;

    // Parameterized constructor
    public User(String name, String department, String salary, String email, String password) {
        this.name = name;
        this.department = department;
        this.salary = salary;
        this.email = email;
        this.password = password;
    }

    // 0-parameterized constructor
    public User() {
        super();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", Name=" + name + ", department=" + department + ", salary=" + salary + ", email="
                + email + ", password=" + password + "]";
    }
}
