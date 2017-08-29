package com.kovalchyk_at.a1000words;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kovalchyk_at.a1000words.tabbed_menu.body1_tabbed_fragment;
import com.kovalchyk_at.a1000words.tabbed_menu.body2_tabbed_fragment;
import com.kovalchyk_at.a1000words.tabbed_menu.body3_tabbed_fragment;
import com.kovalchyk_at.a1000words.tabbed_menu.header_tab_fragment;

import java.util.ArrayList;

import static com.kovalchyk_at.a1000words.R.id.body_tabbed_fragment;
import static com.kovalchyk_at.a1000words.R.id.header_tabbed_fragment;


/**
 * Created by Kovalchyk_at on 23.08.2017.
 */

public class TabbedConteinerActivity extends AppCompatActivity {

    header_tab_fragment mHeaderTabFragment;
    ArrayList<Object>  mBodyTabbedFragment;
    FragmentTransaction mTransaction;
    Fragment mBody;
    int i=1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_container);
// // TODO: 29.08.2017 дістати та довернути перемикання фрагментів в активності

        mHeaderTabFragment  =   new header_tab_fragment();
        mBodyTabbedFragment = new ArrayList<Object>();
       // mBody = (Fragment) findViewById(R.id.body_tabbed_fragment);
        mBodyTabbedFragment.add(0, new body1_tabbed_fragment());
        mBodyTabbedFragment.add(1, new body2_tabbed_fragment());
        mBodyTabbedFragment.add(2, new body3_tabbed_fragment());

        mTransaction    =   getFragmentManager().beginTransaction().add(header_tabbed_fragment, mHeaderTabFragment).add(body_tabbed_fragment, (android.app.Fragment) mBodyTabbedFragment.get(i));
        mTransaction.commit();

    }

    protected void tabButtonOnClick(View v){
        switch (v.getId()) {
            case R.id.left_img_button:
                i++;
                if (i>2){i=0;}
                if (i<0){i=2;}
                break;
            case R.id.right_img_button:
                i--;
                if (i>2){i=0;}
                if (i<0){i=2;}
                break;
            default:
                break;

        }
        mTransaction.replace(body_tabbed_fragment, (android.app.Fragment)  mBodyTabbedFragment.get(i)).commit();

    }

}
