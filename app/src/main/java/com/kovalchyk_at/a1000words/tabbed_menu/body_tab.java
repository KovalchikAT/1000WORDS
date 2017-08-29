package com.kovalchyk_at.a1000words.tabbed_menu;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kovalchyk_at.a1000words.R;

/**
 * Created by Kovalchyk_at on 29.08.2017.
 */

public class body_tab extends Fragment{

    public body_tab(Fragment [] f ) {

    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("fragm1", "myLog");
        return inflater.inflate(R.layout.body1_tabbed_fragment, null);
    }
}
