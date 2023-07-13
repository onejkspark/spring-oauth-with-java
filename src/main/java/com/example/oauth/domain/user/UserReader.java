package com.example.oauth.domain.user;

import com.example.oauth.core.exception.NotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import com.example.oauth.infra.repository.UserRepository;
import org.springframework.transaction.annotation.Transactional;

@Component
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class UserReader {

    private final UserRepository userRepository;

    public User getOne(Long id) {
        return userRepository.findById(id).orElseThrow(NotFoundException::new);
    }

    public User getOne(String email) {
        return userRepository.findByEmail(email).orElseThrow(NotFoundException::new);
    }
}
