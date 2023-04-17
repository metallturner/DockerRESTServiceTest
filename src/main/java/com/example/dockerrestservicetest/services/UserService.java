package com.example.dockerrestservicetest.services;

import com.example.dockerrestservicetest.model.User;
import com.example.dockerrestservicetest.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional(readOnly = true)
@Component
public class UserService {
    private final UserRepository userRepository;

    @SuppressWarnings("SpringJavaInjectionPointsAutowiringInspection")
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getAllUser(){
       return userRepository.findAll();
    }
    public User findById(int id){
        return userRepository.findById(id).get();
    }
    @Transactional
    public void save(User user){
        userRepository.save(user);
    }

    @Transactional
    public void deleteUser(int id){
        userRepository.deleteById(id);
    }

    @Transactional
    public void createUser(User user){
        userRepository.save(user);
    }
}
