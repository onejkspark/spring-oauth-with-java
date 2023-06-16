package com.example.oauth.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.oauth.domain.user.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
}
