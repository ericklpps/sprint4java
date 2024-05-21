package org.example.entities;

public class AccessibilityConfig {
    private int id;
    private int userId;
    private boolean isColorblind;
    private String colorBlindnessType;

    public AccessibilityConfig(int userId, boolean isColorblind) {
        this.userId = userId;
        this.isColorblind = isColorblind;
    }

    public boolean isColorblind() {
        return isColorblind;
    }

    public void setColorblind(boolean colorblind) {
        isColorblind = colorblind;
    }

    public String getColorBlindnessType() {
        return colorBlindnessType;
    }

    public void setColorBlindnessType(String colorBlindnessType) {
        this.colorBlindnessType = colorBlindnessType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
