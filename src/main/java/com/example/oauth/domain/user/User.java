package com.example.oauth.domain.user;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@Entity(name = "USERS")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    public static User of(String email, String password) {
        return new User(email, password);
    }

    private User(String email, String password) {
        this.email = email;
        this.password = password;
    }
}
