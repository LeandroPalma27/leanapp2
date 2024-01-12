package com.leancoder.leanapp2.services;

import java.util.List;
import java.util.Optional;

import com.leancoder.leanapp2.models.domains.User;

public interface IUsuarioService {
    
    List<User> findAllUsers();

    Optional<User> findUserById(Long id);

}
