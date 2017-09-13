package com.kovalchyk_at.a1000words.tabbed_menu;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ExpandableListView;

import com.kovalchyk_at.a1000words.R;

import java.util.ArrayList;

/**
 * Created by Kovalchyk_at on 06.09.2017.
 */

public class Body2_tabbed_fragment extends Fragment{


    String[] groups_name = new String[] {"HTC", "Samsung", "LG"};
    String[] phonesHTC = new String[] {"Sensation", "Desire", "Wildfire", "Hero"};
    String[] phonesSams = new String[] {"Galaxy S II", "Galaxy Nexus", "Wave"};
    String[] phonesLG = new String[] {"Optimus", "Optimus Link", "Optimus Black", "Optimus One"};
    String[][] items = new String[][] {phonesHTC,phonesSams,phonesLG};

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

        ExpandableListView  mExpList = (ExpandableListView) retV.findViewById(R.id.expand_progress_list);

        ArrayList<Progress_group> mGroups = new ArrayList<Progress_group>();

        fillData(mGroups);

        Body2_tabbed_adapter mAdapter = new Body2_tabbed_adapter(retV.getContext(), mGroups);

        mExpList.setAdapter(mAdapter);


        Log.d("fragm2TAG", "myLog");
        return retV;
    }
}
