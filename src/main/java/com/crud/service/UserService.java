package com.crud.service;

import com.crud.entity.User;
import com.crud.repository.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository repository;

    public User saveUser(User user) {
        return repository.save(user);
    }

    public List<User> saveUsers(List<User> users) {
        return repository.saveAll(users);
    }

    public List<User> getUsers() {
        return repository.findAll();
    }

    public User getUserById(int userid) {
        return repository.findById(userid).orElse(null);
    }

    public String deleteUser(int userid) {
        repository.deleteById(userid);
        return "user removed !! " + userid;
    }

//    public User updateUser(User user) {
//    	User existingUser = repository.findById(user.getUserid()).orElse(null);
//    	existingUser.setName(user.getName());
//    	existingUser.setQuantity(user.getQuantity());
//    	existingUser.setPrice(user.getPrice());
//        return repository.save(existingUser);
//    }


}
