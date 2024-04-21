package com.saxakiil.ezpage.service;

import java.util.Optional;

import com.saxakiil.ezpage.dto.ItemDto;
import com.saxakiil.ezpage.entity.Item;
import com.saxakiil.ezpage.entity.Page;
import com.saxakiil.ezpage.entity.User;
import com.saxakiil.ezpage.repository.ItemRepository;
import com.saxakiil.ezpage.repository.PageRepository;
import com.saxakiil.ezpage.transformer.ItemTransformer;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Transactional
public class ItemService {

    private final ItemRepository itemRepository;
    private final PageRepository pageRepository;

    private final ItemTransformer itemTransformer;

    public Item create(ItemDto itemDto, User user) {
        if (itemDto.pageId() == null) {
            return null;
        }

        Optional<Page> pageOptional = pageRepository.findByUserAndId(user, itemDto.pageId());
        if (pageOptional.isEmpty()) {
            return null;
        }

        Item item = itemTransformer.toObject(itemDto);
        item.setPage(pageOptional.get());
        return itemRepository.save(item);
    }

    public boolean update(ItemDto itemDto, User user) {
        if (itemDto.id() == null) {
            return false;
        }

        Optional<Item> itemOptional = itemRepository.findByUserAndId(user, itemDto.id());

        if (itemOptional.isEmpty()) {
            return false;
        }

        itemRepository.save(itemTransformer.merge(itemOptional.get(), itemDto));
        return true;
    }

    public boolean delete(String id, User user) {
        if (id == null) {
            return false;
        }

        Optional<Item> itemOptional = itemRepository.findByUserAndId(user, id);

        if (itemOptional.isEmpty()) {
            return false;
        }

        itemRepository.delete(itemOptional.get());
        return true;
    }
}
