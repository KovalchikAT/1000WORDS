package com.kovalchyk_at.a1000words.log_in;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.kovalchyk_at.a1000words.R;


/**
 * Created by Kovalchyk_at on 23.08.2017.
 */

public class TabbedConteinerActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_container);
        Intent intent = getIntent();

    }

}
