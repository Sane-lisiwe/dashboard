package com.crudApi.tester.services;

import com.crudApi.tester.entity.User;
import com.crudApi.tester.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    // Save a single user
    public User saveUser(User user) {
        return repository.save(user);
    }

    // Save multiple users
    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    // Get all users
    public List<User> getUsers() {
        return repository.findAll();
    }

    // Get a user by ID
    public User getUserById(int id) {
        return repository.findById(id).orElse(null);
    }

    // Update user
    // Update user
    public User updateUser(User user) {
        User existingUser = repository.findById(user.getId()).orElse(null);
        if (existingUser != null) {
            existingUser.setCompanyId(user.getCompanyId());
            existingUser.setFirstName(user.getFirstName());
            existingUser.setLastName(user.getLastName());
            existingUser.setEmail(user.getEmail());
            existingUser.setPhoneNumber(user.getPhoneNumber());
            existingUser.setDepartment(user.getDepartment());
            existingUser.setRole(user.getRole());
            existingUser.setHireDate(user.getHireDate());
            existingUser.setStatus(user.getStatus());
            return repository.save(existingUser);
        }
        return null;
    }


    // Delete a user by ID
    public String deleteUser(int id) {
        repository.deleteById(id);
        return "User removed !! " + id;
    }

}