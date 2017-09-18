package com.kovalchyk_at.a1000words.tabbed_menu;

/**
 * Created by Kovalchyk_at on 18.09.2017.
 */

public class ItemObjects {
   private String mName;
   private int mPhoto;

    public ItemObjects(String s, int img) {
        mName = s;
        mPhoto = img;
    }

    public String getName() {
        return mName;
    }

    public int getPhoto() {
        return mPhoto;
    }
}
