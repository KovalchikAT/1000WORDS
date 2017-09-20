package com.kovalchyk_at.a1000words.tabbed_menu;

import android.app.Fragment;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.kovalchyk_at.a1000words.R;
import com.kovalchyk_at.a1000words.tabbed_menu.body2.Body2_tabbed_adapter;
import com.kovalchyk_at.a1000words.tabbed_menu.body2.Progress_group;
import com.kovalchyk_at.a1000words.tabbed_menu.body2.Progress_item;

import java.util.ArrayList;

/**
 * Created by Kovalchyk_at on 06.09.2017.
 */

public class Body2_tabbed_fragment extends Fragment{

    private static final String KEY_EXPLIST_STATE = "CURRENT_LIST";
    private static final String KEY_EXPLIST_SCROLL = "CURRENT_SCROLL";
    private static final String KEY_EXPLIST_ITEM = "CURRENT_ITEM";

    ExpandableListView  mExpList;

    private Parcelable mListState = null;
    private int mListPosition = 0;
    private int mItemPosition = 0;

    String[] groups_name = new String[] {"HTC", "Samsung", "LG", "jh"};
    String[] phonesHTC = new String[] {"Sensation", "Desire", "Wildfire", "Hero"};
    String[] phonesSams = new String[] {"Galaxy S II", "Galaxy Nexus", "Wave"};
    String[] phonesLG = new String[] {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};
    String[][] items = new String[][] {phonesHTC,phonesSams,phonesLG,phonesHTC};

    protected void onRestoreInstanceState(Bundle state) {
        mExpList.onRestoreInstanceState(state);

        // Retrieve list state and list/item positions
        mListState = state.getParcelable(KEY_EXPLIST_STATE);
        mListPosition = state.getInt(KEY_EXPLIST_SCROLL);
        mItemPosition = state.getInt(KEY_EXPLIST_ITEM);
    }

    public void onResume() {
        super.onResume();

        // Load data from DB and put it onto the list


        // Restore list state and list/item positions
        ExpandableListView listView = mExpList;
        if (mListState != null)
            listView.onRestoreInstanceState(mListState);
        listView.setSelectionFromTop(mListPosition, mItemPosition);
    }

    public void onSaveInstanceState(Bundle state) {
        super.onSaveInstanceState(state);

        // Save list state
        ExpandableListView listView = mExpList;
        mListState = listView.onSaveInstanceState();
        state.putParcelable(KEY_EXPLIST_STATE, mListState);

        // Save position of first visible item
        mListPosition = listView.getFirstVisiblePosition();
        state.putInt(KEY_EXPLIST_SCROLL, mListPosition);

        // Save scroll position of item
        View itemView = listView.getChildAt(0);
        mItemPosition = itemView == null ? 0 : itemView.getTop();
        state.putInt(KEY_EXPLIST_ITEM, mItemPosition);
        state.putInt("FIRST_VISIBLE_PARENT", 0);
        state.putByteArray("PARENT_IS_OPEN_ARRAY", new byte[]{0, 0, 1, 1});
    }

    public void fillData (ArrayList<Progress_group> groups ){
        for (int i=0; i<groups_name.length; i++){
            ArrayList<Progress_item>  it = new ArrayList<Progress_item>();
            for (int j=0; j<items[i].length; j++){
                it.add(new Progress_item(items[i][j], (i+j)%100));
            }
            groups.add(new Progress_group(groups_name[i], it));
        }

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View retV = inflater.inflate(R.layout.body2_tabbed_fragment, null);

        mExpList = (ExpandableListView) retV.findViewById(R.id.expand_progress_list);

        ArrayList<Progress_group> mGroups = new ArrayList<Progress_group>();

        fillData(mGroups);

        Body2_tabbed_adapter mAdapter = new Body2_tabbed_adapter(retV.getContext(), mGroups);

        mExpList.setAdapter(mAdapter);

        if (savedInstanceState != null) onRestoreInstanceState(savedInstanceState);

        Log.d("fragm2TAG", "myLog");
        return retV;
    }


}
