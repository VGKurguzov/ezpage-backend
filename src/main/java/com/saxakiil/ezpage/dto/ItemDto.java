package com.saxakiil.ezpage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ItemDto {
    private String id;
    private String icon;
    private String url;
    private String title;
    private String pageId;
}