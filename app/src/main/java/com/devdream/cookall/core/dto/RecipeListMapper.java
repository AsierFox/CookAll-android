package com.devdream.cookall.core.dto;

import com.devdream.cookall.core.api.responses.RecipeListResponse;

import org.mapstruct.Mapper;

@Mapper
public interface RecipeMapper extends BaseMapper<RecipeListResponse, RecipeDTO> {
}
