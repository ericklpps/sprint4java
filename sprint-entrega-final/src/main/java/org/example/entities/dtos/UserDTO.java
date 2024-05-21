package org.example.entities.dtos;

import java.time.LocalDate;

public class UserDTO {
    private int id;
    private String name;
    private String lastName;
    private String email;
    private LocalDate birthday;
    private String password;
    private boolean isColorBlind;
    private String colorBlindnessType;

    public UserDTO() {
    }

    public UserDTO(int id, String colorBlindnessType, String name, String lastName, String email, LocalDate birthday, String password, boolean isColorBlind) {
        this.id = id;
        this.colorBlindnessType = colorBlindnessType;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.birthday = birthday;
        this.password = password;
        this.isColorBlind = isColorBlind;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getColorBlindnessType() {
        return colorBlindnessType;
    }

    public void setColorBlindnessType(String colorBlindnessType) {
        this.colorBlindnessType = colorBlindnessType;
    }

    public boolean isColorBlind() {
        return isColorBlind;
    }

    public void setColorBlind(boolean colorBlind) {
        isColorBlind = colorBlind;
    }
}
