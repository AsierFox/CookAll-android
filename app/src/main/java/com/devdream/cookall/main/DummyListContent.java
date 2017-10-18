package com.devdream.cookall.main;

import com.devdream.cookall.core.realm.entities.RecipeRealm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DummyListContent {

    public static final List<RecipeRealm> ITEMS = new ArrayList<RecipeRealm>();

    public static final Map<String, RecipeRealm> ITEM_MAP = new HashMap<String, RecipeRealm>();

    private static final int COUNT = 10;

    static {
        // Add some sample items.
        for (int i = 1; i <= COUNT; i++) {
            addItem(createDummyItem(i));
        }
    }

    private static void addItem(RecipeRealm item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.getId(), item);
    }

    private static RecipeRealm createDummyItem(int position) {
        return new RecipeRealm(String.valueOf(position), "Item " + position, makeDetails(position));
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
