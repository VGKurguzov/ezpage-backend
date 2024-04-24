package com.saxakiil.ezpage.transformer;

import com.saxakiil.ezpage.dto.ItemDto;
import com.saxakiil.ezpage.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemTransformer implements Transformer<ItemDto, Item> {
    @Override
    public Item toObject(ItemDto itemDto) {
        Item item = new Item();
        item.setIcon(itemDto.getIcon());
        item.setUrl(itemDto.getUrl());
        item.setTitle(itemDto.getTitle());
        return item;
    }

    @Override
    public ItemDto toDto(Item item) {
        return null;
    }

    @Override
    public Item merge(Item item, ItemDto itemDto) {
        item.setIcon(itemDto.getIcon());
        item.setUrl(itemDto.getUrl());
        item.setTitle(itemDto.getTitle());
        return item;
    }
}
