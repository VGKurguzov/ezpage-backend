package com.saxakiil.ezpage.controller;

import com.saxakiil.ezpage.dto.ItemDto;
import com.saxakiil.ezpage.entity.Item;
import com.saxakiil.ezpage.entity.User;
import com.saxakiil.ezpage.service.ItemService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/items")
@RequiredArgsConstructor
public class ItemController {

    private final ItemService itemService;

    @PostMapping
    public ResponseEntity<Item> create(@RequestBody ItemDto itemDto, @RequestAttribute User user) {
        return ResponseEntity.ok(itemService.create(itemDto, user));
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody ItemDto itemDto, @RequestAttribute User user) {
        boolean isUpdate = itemService.update(itemDto, user);
        return isUpdate ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody String id, @RequestAttribute User user) {
        boolean isDelete = itemService.delete(id, user);
        return isDelete ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

