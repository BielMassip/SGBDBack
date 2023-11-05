package com.example.backsgbdproject.service;

import com.example.backsgbdproject.controller.exceptions.ServiceException;
import com.example.backsgbdproject.entity.User;
import com.example.backsgbdproject.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepo userRepo;

    public Iterable<User> getUsers(){
        return userRepo.findAll();
    }

    public User insertUser(User user){
        return userRepo.save(user);
    }

    public void deleteUser(Long id){
        userRepo.deleteById(id);
    }

    public User getUser(Long id) {
        Optional<User> uo = userRepo.findById(id);
        if (uo.isPresent())
            return uo.get();
        else
            throw new ServiceException(String.format("User with id = % dos not exists", id));
    }

    public User register(Long id, String username, String password) {

        List<User> uUsername = userRepo.findByUsername(username);
        if (uUsername.size() > 0)
            throw new ServiceException("Username already exists");

        User nu = new User(id, username, password);
        userRepo.save(nu);
        return nu;
    }

    public User matchPassword(String username, String password) {

        List<User> uUsername = userRepo.findByUsername(username);

        if (uUsername.size() == 0) throw new ServiceException("User does not exists");

        User u = uUsername.get(0);

        if (u.getPassword().equals(password))
            return u;
        else
            throw new ServiceException("Password does not match");
    }
}

