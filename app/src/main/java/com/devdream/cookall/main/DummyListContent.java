package com.devdream.cookall.main;

import com.devdream.cookall.core.dto.RecipeDTO;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyListContent {

    public static final List<RecipeDTO> ITEMS = new ArrayList<RecipeDTO>();

    public static final Map<Long, RecipeDTO> ITEM_MAP = new HashMap<Long, RecipeDTO>();

    private static final int COUNT = 10;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(RecipeDTO recipe) {
        ITEMS.add(recipe);
        ITEM_MAP.put(recipe.id, recipe);
    }

    private static RecipeDTO createDummyItem(int position) {
        RecipeDTO recipe = new RecipeDTO();
        recipe.id = position;
        recipe.title = makeDetails(position);
        return recipe;
    }

    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }

}
