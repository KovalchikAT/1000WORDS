package com.kovalchyk_at.a1000words.tabbed_menu;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.kovalchyk_at.a1000words.R;

import java.util.ArrayList;

/**
 * Created by Kovalchyk_at on 11.09.2017.
 */

public class Body2_tabbed_adapter extends BaseExpandableListAdapter{
    Context mContext;
    LayoutInflater mInflater;

    ArrayList<Progress_group> objects;

    Body2_tabbed_adapter(Context context,
                         ArrayList<Progress_group> progress_items_group){
        mContext = context;
        objects = progress_items_group;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getGroupCount() {
        return objects.size();
    }

    @Override
    public int getChildrenCount(int i) {
        return objects.get(i).items.size();
    }

    @Override
    public Object getGroup(int i) {
        return objects.get(i);
    }

    @Override
    public Object getChild(int i, int j) {
        return objects.get(i).items.get(j);
    }

    @Override
    public long getGroupId(int i) {
        return i;
    }

    @Override
    public long getChildId(int i, int j) {
        return j;
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getGroupView(int i, boolean isExpanded, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.body2_tabbed_expandable_item, null);
        }

        if (isExpanded){

        }
        else{

        }

        TextView groupLabel = (TextView) view.findViewById(R.id.item_Lable);
        groupLabel.setText(objects.get(i).category_name);
        ProgressBar bar = (ProgressBar) view.findViewById(R.id.item_progress);
        bar.setProgress(objects.get(i).progress_count);
        return view;
    }

    @Override
    public View getChildView(int i, int j, boolean isExpanded, View view, ViewGroup viewGroup) {
        if (view == null) {
            LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.body2_tabbed_item, null);
        }


        TextView questLabel = (TextView) view.findViewById(R.id.item_Lable);
        questLabel.setText(objects.get(i).items.get(j).category_name);
        ProgressBar bar = (ProgressBar) view.findViewById(R.id.item_progress);
        bar.setProgress(objects.get(i).items.get(j).progress_count);

        return view;
    }

    @Override
    public boolean isChildSelectable(int i, int i1) {
        return true;
    }
}
