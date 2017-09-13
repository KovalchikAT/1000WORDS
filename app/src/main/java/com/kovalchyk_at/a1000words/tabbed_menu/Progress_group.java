package com.kovalchyk_at.a1000words.tabbed_menu;

import java.util.ArrayList;

/**
 * Created by Kovalchyk_at on 12.09.2017.
 */

public class Progress_group {
    String category_name;
    int progress_count;
    ArrayList<Progress_item> items;

    public Progress_group (String _category_name, ArrayList<Progress_item> it) {
        this.category_name = _category_name;
        this.progress_count = Sum(it);
        this.items = it;
    }

    private int Sum (ArrayList<Progress_item> it){
        int sum = 0;
        int i=0;
        for (; i<it.size(); i++) {
            sum += it.get(i).progress_count;
        }
        return sum*100/i;
    }
}
