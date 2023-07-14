package com.example.oauth.web.api;

import com.example.oauth.domain.user.User;
import com.example.oauth.infra.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class UserController {

    private final UserRepository userRepository;

    @GetMapping("users")
    public List<User> getAll() {
        return userRepository.findAll();
    }
}
