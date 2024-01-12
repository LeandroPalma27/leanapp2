package com.leancoder.leanapp2.config;

import java.util.Arrays;
import java.util.List;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.leancoder.leanapp2.models.domains.User;

@Configuration
public class BeansConfig {
    
    @Bean("getRandomUsers")
    List<User> getUsers() {
        return Arrays.asList(new User(1L, "Leandro", "sorryyouarebad"), new User(2L, "Martin", "leandro27p"),
        new User(3L, "Tati", "tati27p")); 
    }

}
