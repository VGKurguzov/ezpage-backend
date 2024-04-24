package com.saxakiil.ezpage.service;

import java.util.Optional;

import com.saxakiil.ezpage.entity.User;
import com.saxakiil.ezpage.repository.UserRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User create(@NonNull Long tgId) {
        User user = new User();
        user.setTgId(tgId);
        return userRepository.save(user);
    }

    public Optional<User> findByTgId(@NonNull Long tgId) {
        return userRepository.findByTgId(tgId);
    }

    public boolean delete(User user) {
        userRepository.delete(user);
        return true;
    }
}
