package org.example.services;

import org.example.entities.AccessibilityFeedback;
import org.example.repositories.AccessibilityFeedbackRepository;

import java.util.List;
import java.util.Optional;

public class AccessibilityFeedbackService {
    private final AccessibilityFeedbackRepository feedbackRepository;

    public AccessibilityFeedbackService() {
        this.feedbackRepository = new AccessibilityFeedbackRepository();
    }

    public List<AccessibilityFeedback> getAll() {
        return feedbackRepository.getAll();
    }

    public AccessibilityFeedback get(int id) {
        return feedbackRepository.get(id).orElse(null);
    }

    public void create(AccessibilityFeedback feedback) {
        feedbackRepository.create(feedback);
    }

    public void update(int id, AccessibilityFeedback feedback) {
        if (feedbackRepository.get(id).isPresent()) {
            feedbackRepository.update(id, feedback);
        } else {
            throw new IllegalArgumentException("Feedback not found");
        }
    }

    public void delete(int id) {
        if (feedbackRepository.get(id).isPresent()) {
            feedbackRepository.delete(id);
        } else {
            throw new IllegalArgumentException("Feedback not found");
        }
    }
}