package org.example.repositories;

import org.example.entities.AccessibilityFeedback;
import org.example.infra.OracleConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class AccessibilityFeedbackRepository {
    private static final String TB_NAME = "ACCESSIBILITY_FEEDBACK";

    public List<AccessibilityFeedback> getAll() {
        List<AccessibilityFeedback> feedbackList = new ArrayList<AccessibilityFeedback>();
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TB_NAME + " ORDER BY ID")) {

            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                AccessibilityFeedback feedback = new AccessibilityFeedback(
                        rs.getInt("ID"),
                        rs.getInt("ACCESSIBILITY_CONFIG_ID"),
                        rs.getString("ACCESSIBILITY_TEXT"),
                        rs.getString("FEEDBACK_TYPE")
                );
                feedbackList.add(feedback);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return feedbackList;
    }

    public Optional<AccessibilityFeedback> get(int id) {
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TB_NAME + " WHERE ID = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                AccessibilityFeedback feedback = new AccessibilityFeedback(
                        rs.getInt("ID"),
                        rs.getInt("ACCESSIBILITY_CONFIG_ID"),
                        rs.getString("ACCESSIBILITY_TEXT"),
                        rs.getString("FEEDBACK_TYPE")
                );
                return Optional.of(feedback);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

    public void create(AccessibilityFeedback feedback) {
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + TB_NAME + " (ACCESSIBILITY_CONFIG_ID, ACCESSIBILITY_TEXT, FEEDBACK_TYPE, DATE_HOUR) VALUES (?, ?, ?, ?)")) {
            stmt.setInt(1, feedback.getAccessibilityConfigId());
            stmt.setString(2, feedback.getAccessibilityText());
            stmt.setString(3, feedback.getFeedbackType());
            stmt.setTimestamp(4, Timestamp.valueOf(feedback.getDateHour()));
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int id, AccessibilityFeedback feedback) {
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE " + TB_NAME + " SET ACCESSIBILITY_CONFIG_ID = ?, ACCESSIBILITY_TEXT = ?, FEEDBACK_TYPE = ?, DATE_HOUR = ? WHERE ID = ?")) {
            stmt.setInt(1, feedback.getAccessibilityConfigId());
            stmt.setString(2, feedback.getAccessibilityText());
            stmt.setString(3, feedback.getFeedbackType());
            stmt.setTimestamp(4, Timestamp.valueOf(feedback.getDateHour()));
            stmt.setInt(5, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM " + TB_NAME + " WHERE ID = ?")) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}