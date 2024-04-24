package com.saxakiil.ezpage.dto;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class PagesResponseDto {
    private List<PageDto> pages;
}
