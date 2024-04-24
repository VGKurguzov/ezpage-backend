package com.saxakiil.ezpage.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.saxakiil.ezpage.dto.PageDto;
import com.saxakiil.ezpage.entity.Page;
import com.saxakiil.ezpage.entity.User;
import com.saxakiil.ezpage.repository.PageRepository;
import com.saxakiil.ezpage.transformer.Transformer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class PageService {

    private final PageRepository pageRepository;

    private final Transformer<PageDto, Page> pageTransformer;

    public Page create(PageDto pageDto, User user) {
        Page page = pageTransformer.toObject(pageDto);
        page.setUser(user);
        return pageRepository.save(page);
    }

    public List<PageDto> findAll(User user) {
        return pageRepository.findAllByUser(user).stream()
                .map(pageTransformer::toDto)
                .collect(Collectors.toList());
    }

    public Optional<Page> find(String id) {
        return pageRepository.findById(id);
    }

    public boolean update(PageDto pageDto, User user) {
        if (pageDto.getId() == null) {
            return false;
        }
        Optional<Page> pageOptional = pageRepository.findByUserAndId(user, pageDto.getId());
        if (pageOptional.isEmpty()) {
            return false;
        }

        pageRepository.save(pageTransformer.merge(pageOptional.get(), pageDto));
        return true;
    }

    public boolean delete(PageDto pageDto, User user) {
        if (pageDto.getId() == null) {
            return false;
        }

        Optional<Page> pageOptional = pageRepository.findByUserAndId(user, pageDto.getId());
        if (pageOptional.isEmpty()) {
            return false;
        }
        pageRepository.delete(pageOptional.get());
        return true;
    }
}
