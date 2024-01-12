package com.leancoder.leanapp2.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.leancoder.leanapp2.models.domains.User;
import com.leancoder.leanapp2.services.IUsuarioService;


@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUsuarioService usuarioService;

    @GetMapping({"/", ""})
    public String userHome() {
        int value = 100/0;
        System.out.println(value);
        return "ok 200";
    }

    @GetMapping("/show") 
    public List<User> getUsers() {
        return usuarioService.findAllUsers();
    }

    @GetMapping("/show/{id}")
    public User getUser(@PathVariable(name = "id") String id) {
        var user = usuarioService.findUserById(Long.valueOf(id).longValue());
        return user.get();
    }
    

}
