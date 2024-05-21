package org.example.entities;

import java.time.LocalDateTime;

public class AccessibilityFeedback {
    private int id;
    private String feedbackType;
    private final LocalDateTime dateHour;
    private int accessibilityConfigId;
    private String accessibilityText;

    public AccessibilityFeedback(int accessibilityConfigId, String accessibilityText, String feedbackType) {
        this.dateHour = LocalDateTime.now();
        this.accessibilityConfigId = accessibilityConfigId;
        this.accessibilityText = accessibilityText;
        this.feedbackType = feedbackType;
    }

    public AccessibilityFeedback(int id, int accessibilityConfigId, String accessibilityText, String feedbackType) {
        this.id = id;
        this.dateHour = LocalDateTime.now();
        this.accessibilityConfigId = accessibilityConfigId;
        this.accessibilityText = accessibilityText;
        this.feedbackType = feedbackType;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalDateTime getDateHour() {
        return dateHour;
    }

    public int getAccessibilityConfigId() {
        return accessibilityConfigId;
    }

    public void setAccessibilityConfigId(int accessibilityConfigId) {
        this.accessibilityConfigId = accessibilityConfigId;
    }

    public String getAccessibilityText() {
        return accessibilityText;
    }

    public void setAccessibilityText(String accessibilityText) {
        this.accessibilityText = accessibilityText;
    }

    public String getFeedbackType() {
        return feedbackType;
    }

    public void setFeedbackType(String feedbackType) {
        this.feedbackType = feedbackType;
    }
}
