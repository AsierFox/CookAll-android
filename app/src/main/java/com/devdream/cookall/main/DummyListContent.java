package com.devdream.cookall.main;

import com.devdream.cookall.core.entities.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyListContent {

    public static final List<Recipe> ITEMS = new ArrayList<Recipe>();

    public static final Map<String, Recipe> ITEM_MAP = new HashMap<String, Recipe>();

    private static final int COUNT = 10;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(Recipe item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }

    private static Recipe createDummyItem(int position) {
        return new Recipe(String.valueOf(position), "Item " + position, makeDetails(position));
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
