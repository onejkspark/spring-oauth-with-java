package com.example.oauth.domain;

import jakarta.persistence.*;

@Entity(name = "USERS")
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

    protected User() {
    }

    public Long getId() {
        return id;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }
}
