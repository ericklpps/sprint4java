package org.example.services;

import org.example.entities.AccessibilityConfig;
import org.example.repositories.AccessibilityConfigRepository;

import java.util.List;
import java.util.Optional;

public class AccessibilityConfigService {

    private final AccessibilityConfigRepository accessibilityConfigRepository;

    public AccessibilityConfigService() {
        this.accessibilityConfigRepository = new AccessibilityConfigRepository();
    }

    public void create(AccessibilityConfig accessibilityConfig) {
        accessibilityConfigRepository.create(accessibilityConfig);
    }

    public void deleteByUserId(int userId) {
        accessibilityConfigRepository.deleteByUserId(userId);
    }

    public AccessibilityConfig findById(int id) {
        return accessibilityConfigRepository.get(id).orElse(null);
    }

    public AccessibilityConfig findByUserId(int id) {
        return accessibilityConfigRepository.getByUserId(id).orElse(null);
    }

    public void update(int userId, AccessibilityConfig accessibilityConfig) {
        AccessibilityConfig config = findByUserId(userId);
        accessibilityConfigRepository.update(config.getId(), accessibilityConfig);
    }
}
