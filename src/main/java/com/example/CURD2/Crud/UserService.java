package com.example.CURD2.Crud;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.CURD2.Crud.entity.User;

@Service
public class UserService {
    @Autowired
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public List<User> getAllUsers(){
        return userRepository.findAll();
    }
    public Optional<User> getUserById(Long id){
        return userRepository.findById(id);
    }

    public User createUser(User user){
        return userRepository.save(user);
    }

    
    public User updatedUser(Long id, User user){
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            System.out.println("User not found");
            return null;
        }

        User data = optionalUser.get();

        data.setUsername(user.getUsername());
        return userRepository.save(data);
    }

    public String deleteUser(Long id) {
        Optional<User> optionalUser = userRepository.findById(id);

        if (!optionalUser.isPresent()) {
            System.out.println("User not found");
            return null;
        }
        // userRepository.deleteById(id);
        userRepository.deleteById(id);
        return "User Delete";

    }

}