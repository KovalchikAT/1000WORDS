package com.kovalchyk_at.a1000words.tabbed_menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.ListFragment;
import android.widget.ArrayAdapter;

public class body2_tabbed_fragment extends ListFragment {

    String data [] = new String[] {"1", "2", "3"};

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, data);
        setListAdapter(adapter);
    }


}