package com.example.oauth.domain.user;

import org.springframework.security.access.method.P;
import org.springframework.stereotype.Component;

import com.example.oauth.infra.repository.UserRepository;

@Component
public class UserReader {

    private final UserRepository userRepository;

    public UserReader(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    /**
     * Read Single User
     * 
     * @param id
     * @return
     */
    public User getOne(Long id) {
        // todo : check to custom exception
        return userRepository.findById(id).orElseThrow(() -> new RuntimeException("User Not Found"));
    }

}
