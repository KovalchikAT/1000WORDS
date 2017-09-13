package com.kovalchyk_at.a1000words;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.kovalchyk_at.a1000words.tabbed_menu.Body1_tabbed_fragment;
import com.kovalchyk_at.a1000words.tabbed_menu.Body2_tabbed_fragment;
import com.kovalchyk_at.a1000words.tabbed_menu.Body3_tabbed_fragment;
import com.kovalchyk_at.a1000words.tabbed_menu.Header_tab_fragment;

import java.util.ArrayList;

import static com.kovalchyk_at.a1000words.R.id.body_tabbed_fragment;
import static com.kovalchyk_at.a1000words.R.id.header_tabbed_fragment;

//import com.kovalchyk_at.a1000words.tabbed_menu.Body2_tabbed_fragment;


/**
 * Created by Kovalchyk_at on 23.08.2017.
 */

public class TabbedConteinerActivity extends AppCompatActivity {

    Header_tab_fragment mHeaderTabFragment;
    ArrayList<Object>  mBodyTabbedFragment;
    FragmentTransaction mTransaction;

    int i=0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabbed_container);
// TODO: 29.08.2017 дістати та довернути перемикання фрагментів в активності щоб не зліталв стан при повороті екрану

        mHeaderTabFragment  =   new Header_tab_fragment();
        mBodyTabbedFragment = new ArrayList<Object>();
        mBodyTabbedFragment.add(0, new Body1_tabbed_fragment());
        mBodyTabbedFragment.add(1, new Body2_tabbed_fragment());
        mBodyTabbedFragment.add(2, new Body3_tabbed_fragment());
        mTransaction    =   getFragmentManager().beginTransaction().add(header_tabbed_fragment, mHeaderTabFragment)
                                                                    .replace(body_tabbed_fragment,
                                                                            (android.app.Fragment) mBodyTabbedFragment.get(i));
        mTransaction.commit();
    }

    protected void tabButtonOnClick(View v){
        mTransaction = getFragmentManager().beginTransaction();
        switch (v.getId()) {
            case R.id.left_img_button:
                i++;
                break;
            case R.id.right_img_button:
                i--;
                break;
            default:
                break;
        }

        if (i>mBodyTabbedFragment.size()-1){i=0;}
        if (i<0){i=mBodyTabbedFragment.size()-1;}
        mTransaction.replace(body_tabbed_fragment,
                            (android.app.Fragment) mBodyTabbedFragment.get(i)).commit();
    }
}
