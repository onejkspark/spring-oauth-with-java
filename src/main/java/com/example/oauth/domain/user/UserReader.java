package com.example.oauth.domain.user;

import com.example.oauth.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.oauth.infra.repository.UserRepository;

@Component
@RequiredArgsConstructor
public class UserReader {

    private final UserRepository userRepository;

    public User getOne(Long id) {
        return userRepository.findById(id)
                .orElseThrow(NotFoundException::new);
    }
}
