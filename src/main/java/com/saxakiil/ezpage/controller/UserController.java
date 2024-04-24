package com.saxakiil.ezpage.controller;

import com.saxakiil.ezpage.entity.User;
import com.saxakiil.ezpage.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestAttribute User user) {
        userService.delete(user);
        return ResponseEntity.ok().build();
    }
}
