package com.saxakiil.ezpage.transformer;

import com.saxakiil.ezpage.dto.ItemDto;
import com.saxakiil.ezpage.entity.Item;
import org.springframework.stereotype.Component;

@Component
public class ItemTransformer implements Transformer<ItemDto, Item> {
    @Override
    public Item toObject(ItemDto itemDto) {
        Item item = new Item();
        item.setIcon(itemDto.icon());
        item.setUrl(itemDto.url());
        item.setTitle(itemDto.title());
        return item;
    }

    @Override
    public Item merge(Item item, ItemDto itemDto) {
        item.setIcon(itemDto.icon());
        item.setUrl(itemDto.url());
        item.setTitle(itemDto.title());
        return item;
    }
}
