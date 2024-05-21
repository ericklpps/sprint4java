package org.example.repositories;

import org.example.entities.AccessibilityConfig;
import org.example.infra.OracleConnection;

import java.sql.*;
import java.util.Optional;

public class AccessibilityConfigRepository {
    private static final String TB_NAME = "ACCESSIBILITY_CONFIG";

    public Optional<AccessibilityConfig> get(int id) {
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TB_NAME + " WHERE ID = ?")) {
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                AccessibilityConfig config = new AccessibilityConfig(
                        rs.getInt("USER_ID"),
                        rs.getBoolean("IS_COLORBLIND")
                );
                config.setId(rs.getInt("ID"));
                config.setColorBlindnessType(rs.getString("COLORBLINDNESS_TYPE"));
                return Optional.of(config);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

    public Optional<AccessibilityConfig> getByUserId(int userId) {
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TB_NAME + " WHERE USER_ID = ?")) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                AccessibilityConfig config = new AccessibilityConfig(
                        rs.getInt("USER_ID"),
                        rs.getBoolean("IS_COLORBLIND")
                );
                config.setId(rs.getInt("ID"));
                config.setColorBlindnessType(rs.getString("COLORBLINDNESS_TYPE"));
                return Optional.of(config);
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return Optional.empty();
    }

    public void create(AccessibilityConfig config) {
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("INSERT INTO " + TB_NAME + " (USER_ID, IS_COLORBLIND, COLORBLINDNESS_TYPE) VALUES (?, ?, ?)")) {
            stmt.setInt(1, config.getUserId());
            stmt.setBoolean(2, config.isColorblind());
            stmt.setString(3, config.getColorBlindnessType());
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void update(int id, AccessibilityConfig config) {
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("UPDATE " + TB_NAME + " SET USER_ID = ?, IS_COLORBLIND = ?, COLORBLINDNESS_TYPE = ? WHERE ID = ?")) {
            stmt.setInt(1, config.getUserId());
            stmt.setBoolean(2, config.isColorblind());
            stmt.setString(3, config.getColorBlindnessType());
            stmt.setInt(4, id);
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

    public void deleteByUserId(int userId) {
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement("DELETE FROM " + TB_NAME + " WHERE USER_ID = ?")) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}