package com.leancoder.leanapp2.services;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.leancoder.leanapp2.custom.exceptions.UserNotFoundException;
import com.leancoder.leanapp2.models.domains.User;

@Service
public class UsuarioService implements IUsuarioService {

    @Autowired
    @Qualifier("getRandomUsers")
    private List<User> users;

    /* public UsuarioService() {
        this.users = Arrays.asList(new User(1L, "Leandro", "sorryyouarebad"), new User(2L, "Martin", "leandro27p"),
                new User(3L, "Tati", "tati27p"));
    } */

    @Override
    public List<User> findAllUsers() {
        return this.users;
    }

    @Override
    public Optional<User> findUserById(Long id) {
        var user = this.users.stream().filter(u -> {
            return u.getId().equals(id);
        }).findFirst().orElseThrow(() -> {
            return new UserNotFoundException("El usuario con el id '".concat(id.toString()).concat("' no existe."));
        });
        return Arrays.asList(user).stream().findFirst();
    }

}
