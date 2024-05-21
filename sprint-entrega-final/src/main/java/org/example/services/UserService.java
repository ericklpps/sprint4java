package org.example.services;

import org.example.entities.User;
import org.example.repositories.UserRepository;

import java.util.List;

public class UserService {

    private final UserRepository userRepository;

    public UserService(){
        userRepository = new UserRepository();
    }

    public void create(User user){
        System.out.println("Creating user: " + user.getName());
        userRepository.create(user);
    }

    public User findById(int id) {
        System.out.println("Finding user by id: " + id);
        return userRepository.get(id).orElse(null);
    }

    public List<User> findAll() {
        System.out.println("Finding all users");
        return userRepository.getAll();
    }

    public void delete(int id) {
        System.out.println("Deleting user: " + id);
        userRepository.delete(id);
    }

    public void update(int id, User user) {
        System.out.println("Updating user: " + id);
        userRepository.update(id, user);
    }
}
