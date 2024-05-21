package org.example.repositories;

import org.example.entities.User;
import org.example.infra.OracleConnection;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class UserRepository {

    public static final String TB_NAME = "TB_USER";

    public void update(int id, User user) {
        String sql = "UPDATE " + TB_NAME + " SET name = ?, last_name = ?, email = ?, birthday = ?, password = ? WHERE id = ?";
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setDate(4, Date.valueOf(user.getBirthday()));
            stmt.setString(5, user.getPassword());
            stmt.setInt(7, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void delete(int id) {
        String sql = "DELETE FROM " + TB_NAME + " WHERE id = ?";
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, id);
            stmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void create(User user) {
        String sql = "INSERT INTO " + TB_NAME + " (name, last_name, email, birthday, password) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = new OracleConnection().getConnection();
             PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getLastName());
            stmt.setString(3, user.getEmail());
            stmt.setDate(4, Date.valueOf(user.getBirthday()));
            stmt.setString(5, user.getPassword());
            stmt.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


    public Optional<User> get(int id){
        try(Connection conn = new OracleConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TB_NAME + " WHERE ID = ?")
        ){
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if(rs.next()){
                return Optional.of(new User(
                        rs.getInt("id"),
                        rs.getString("password"),
                        rs.getDate("birthday").toLocalDate(),
                        rs.getString("email"),
                        rs.getString("last_name"),
                        rs.getString("name")));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return Optional.empty();
    }

    public List<User> getAll(){
        List<User> users = new ArrayList<>();
        try(Connection conn = new OracleConnection().getConnection();
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM " + TB_NAME +" ORDER BY ID")) {
            ResultSet rs = stmt.executeQuery();
            while(rs.next()){
                users.add(new User(
                        rs.getInt("id"),
                        rs.getString("password"),
                        rs.getDate("birthday").toLocalDate(),
                        rs.getString("email"),
                        rs.getString("last_name"),
                        rs.getString("name")));
            }
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
        return users;
    }

}
