package com.kovalchyk_at.a1000words.log_in;
/** поки не використовується. екземпляр для фрагменту в логінізації*/
import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kovalchyk_at.a1000words.R;


class log_in_fragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("fragm1", "myLog");
        return inflater.inflate(R.layout.log_in_fragment_layout, null);
    }
}
