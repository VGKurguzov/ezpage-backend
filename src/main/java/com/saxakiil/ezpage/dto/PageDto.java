package com.saxakiil.ezpage.dto;

import java.io.Serializable;

/**
 * DTO for {@link com.saxakiil.ezpage.entity.Page}
 */
public record PageDto(String id, String avatar, String username, String theme) implements Serializable {
}