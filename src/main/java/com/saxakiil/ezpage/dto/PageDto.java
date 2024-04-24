package com.saxakiil.ezpage.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class PageDto {
    private String id;
    private String avatar;
    private String username;
    private String theme;
}