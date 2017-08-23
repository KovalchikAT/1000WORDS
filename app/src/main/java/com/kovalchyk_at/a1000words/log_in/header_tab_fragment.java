package com.kovalchyk_at.a1000words.log_in;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kovalchyk_at.a1000words.R;

/**
 * Created by Kovalchyk_at on 23.08.2017.
 */

public class header_tab_fragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("myLog", "headerFragm");
        return inflater.inflate(R.layout.header_tab_fragment, null);
    }

}
