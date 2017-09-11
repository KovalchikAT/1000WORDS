package com.kovalchyk_at.a1000words.tabbed_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;

/**
 * Created by Kovalchyk_at on 11.09.2017.
 */

public class body2_tabbed_adapter  extends BaseAdapter{
    Context mContext;
    LayoutInflater mInflater;
    ArrayList<progress_item> objects;

    body2_tabbed_adapter(Context context, ArrayList<progress_item> progress_items){
        mContext = context;
        objects = progress_items;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }


    @Override
    public int getCount() {
        return objects.size();
    }

    @Override
    public Object getItem(int position) {
        return objects.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        return null;
    }
}
