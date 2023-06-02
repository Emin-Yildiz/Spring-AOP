package com.example.aop.service;

import com.example.aop.model.User;
import com.example.aop.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(Long id) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            return foundUser.get();
        }else {
            return null;
        }
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(Long id,User user) {
        Optional<User> foundUser = userRepository.findById(id);
        if (foundUser.isPresent()) {
            User newUser = foundUser.get();
            newUser.setName(user.getName());
            newUser.setEmail(user.getEmail());
            newUser.setNumber(user.getNumber());
            return userRepository.save(newUser);
        }else {
            return null;
        }
    }
}
