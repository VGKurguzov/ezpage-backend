package com.saxakiil.ezpage.transformer;

import com.saxakiil.ezpage.dto.PageDto;
import com.saxakiil.ezpage.entity.Page;
import org.springframework.stereotype.Component;

@Component
public class PageTransformer implements Transformer<PageDto, Page> {

    @Override
    public Page toObject(PageDto pageDto) {
        Page page = new Page();
        page.setAvatar(pageDto.getAvatar());
        page.setUsername(pageDto.getUsername());
        page.setTheme(pageDto.getTheme());
        return page;
    }

    @Override
    public PageDto toDto(Page page) {
        return new PageDto(page.getId(), page.getAvatar(), page.getUsername(), page.getTheme());
    }

    @Override
    public Page merge(Page page, PageDto pageDto) {
        page.setAvatar(pageDto.getAvatar());
        page.setUsername(pageDto.getUsername());
        page.setTheme(pageDto.getTheme());
        return page;
    }
}
