package org.example.entities;

import java.time.LocalDate;

public class User {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private String password;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                '}';
    }

    public User(String password, LocalDate birthday, String email, String lastName, String name) {
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
    }

    public User(int id, String password, LocalDate birthday, String email, String lastName, String name) {
        this.id = id;
        this.password = password;
        this.birthday = birthday;
        this.email = email;
        this.lastName = lastName;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
