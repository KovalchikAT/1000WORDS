package com.kovalchyk_at.a1000words.tabbed_menu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kovalchyk_at.a1000words.R;

public class body2_tabbed_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("fragm1", "myLog");
        return inflater.inflate(R.layout.body2_tabbed_fragment, null);
    }
}