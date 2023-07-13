package com.example.oauth.domain.user;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.oauth.infra.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserReader {

    private final UserRepository userRepository;

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
