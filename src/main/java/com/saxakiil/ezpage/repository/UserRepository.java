package com.saxakiil.ezpage.repository;

import java.util.Optional;

import com.saxakiil.ezpage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    Optional<User> findByTgId(Long tgId);
}