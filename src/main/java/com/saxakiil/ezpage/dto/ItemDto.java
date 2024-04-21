package com.saxakiil.ezpage.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.saxakiil.ezpage.entity.Item}
 */
public record ItemDto(String id, String icon, String url, String title, String pageId) implements Serializable {
}