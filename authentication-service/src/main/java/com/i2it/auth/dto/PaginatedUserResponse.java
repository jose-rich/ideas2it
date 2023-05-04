package com.i2it.auth.dto;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class PaginatedUserResponse {
    private List<UserDto> userDtoList;
    private Long numberOfItems;
    private int numberOfPages;
}
