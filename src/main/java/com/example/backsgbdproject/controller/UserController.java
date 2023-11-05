package com.example.backsgbdproject.controller;

import com.example.backsgbdproject.entity.User;
import com.example.backsgbdproject.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/apis/users")
public class UserController extends BaseController{

    @Autowired
    private UserService userService;

    @GetMapping("/findAll")
    Iterable<User> findAll(){
        return userService.getUsers();
    }

    @GetMapping(path="/{id}")
    User getUser(HttpSession session, @PathVariable("id") Long userId) {
        getLoggedUser(session);
        return userService.getUser(userId);
    }

    @PostMapping("/insert")
    User insertUser(@RequestBody User user){
        return userService.insertUser(user);
    }

    @PostMapping(path="/login")
    public User login(HttpSession session, @RequestBody LoginUser user) {
        checkNotLoggedIn(session);
        User u = userService.matchPassword(user.username, user.password);
        session.setAttribute("simpleapp_auth_id", u.getId());
        return u;
    }

    @PostMapping(path="/register", consumes = "application/json")
    public String register(HttpSession session,  @RequestBody RegisterUser ru) {
        checkNotLoggedIn(session);
        userService.register(ru.id, ru.username, ru.password);
        return BaseController.OK_MESSAGE;
    }

    @PostMapping(path="/logout")
    public String logout(HttpSession session) {
        getLoggedUser(session);
        session.removeAttribute("simpleapp_auth_id");
        return BaseController.OK_MESSAGE;
    }

    @GetMapping(path="/check")
    public String checkLoggedIn(HttpSession session) {
        getLoggedUser(session);
        return BaseController.OK_MESSAGE;
    }

    static class LoginUser {
        public String username;
        public String password;
    }

    static class RegisterUser {
        public Long id;
        public String username;
        public String password;
    }
}