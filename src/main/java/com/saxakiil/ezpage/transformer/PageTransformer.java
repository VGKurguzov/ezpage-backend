package com.saxakiil.ezpage.transformer;

import com.saxakiil.ezpage.dto.PageDto;
import com.saxakiil.ezpage.entity.Page;
import org.springframework.stereotype.Component;

@Component
public class PageTransformer implements Transformer<PageDto, Page> {

    @Override
    public Page toObject(PageDto pageDto) {
        Page page = new Page();
        page.setAvatar(pageDto.avatar());
        page.setUsername(pageDto.username());
        page.setTheme(pageDto.theme());
        return page;
    }

    @Override
    public Page merge(Page page, PageDto pageDto) {
        page.setAvatar(pageDto.avatar());
        page.setUsername(pageDto.username());
        page.setTheme(pageDto.theme());
        return page;
    }
}
