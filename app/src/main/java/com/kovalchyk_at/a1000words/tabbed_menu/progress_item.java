package com.kovalchyk_at.a1000words.tabbed_menu;

/**
 * Created by Kovalchyk_at on 11.09.2017.
 */

public class progress_item {

    String category_name;
    int progress_count;

    public progress_item(String _category_name, int _progress_count) {
        this.category_name = _category_name;
        this.progress_count = _progress_count;
    }
}