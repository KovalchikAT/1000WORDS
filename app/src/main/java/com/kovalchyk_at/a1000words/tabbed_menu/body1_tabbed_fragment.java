package com.kovalchyk_at.a1000words.tabbed_menu;
/** поки не використовується. екземпляр для фрагменту в логінізації*/

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kovalchyk_at.a1000words.R;


public class body1_tabbed_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("fragm1TAG", "myLog");
        return inflater.inflate(R.layout.body1_tabbed_fragment, null);
    }
}
