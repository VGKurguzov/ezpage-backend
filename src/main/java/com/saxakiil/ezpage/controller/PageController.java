package com.saxakiil.ezpage.controller;

import java.util.List;
import java.util.Optional;

import com.saxakiil.ezpage.dto.PageDto;
import com.saxakiil.ezpage.dto.PageResponseDto;
import com.saxakiil.ezpage.dto.PagesResponseDto;
import com.saxakiil.ezpage.entity.Page;
import com.saxakiil.ezpage.entity.User;
import com.saxakiil.ezpage.service.PageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pages")
@RequiredArgsConstructor
public class PageController {

    private final PageService pageService;

    @PostMapping
    public ResponseEntity<PageResponseDto> create(@RequestBody PageDto pageDto, @RequestAttribute User user) {
        Page page = pageService.create(pageDto, user);
        return ResponseEntity.ok(new PageResponseDto(page));
    }

    @GetMapping
    public ResponseEntity<PagesResponseDto> findAllPagesByUser(@RequestAttribute User user) {
        return ResponseEntity.ok(new PagesResponseDto(pageService.findAll(user)));
    }

    @GetMapping("/{id}")
    public ResponseEntity<PageResponseDto> findPageByUserAndId(@PathVariable String id) {
        Optional<Page> optionalPage = pageService.find(id);
        return optionalPage.map(page -> ResponseEntity.ok(new PageResponseDto(page)))
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping
    public ResponseEntity<Void> update(@RequestBody PageDto pageDto, @RequestAttribute User user) {
        boolean isUpdate = pageService.update(pageDto, user);
        return isUpdate ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@RequestBody PageDto pageDto, @RequestAttribute User user) {
        boolean isDelete = pageService.delete(pageDto, user);
        return isDelete ? ResponseEntity.ok().build() : ResponseEntity.notFound().build();
    }
}

