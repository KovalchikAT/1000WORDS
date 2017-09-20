package com.kovalchyk_at.a1000words.tabbed_menu;

import android.app.Fragment;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kovalchyk_at.a1000words.R;
import com.kovalchyk_at.a1000words.tabbed_menu.body3.ItemObjects;
import com.kovalchyk_at.a1000words.tabbed_menu.body3.SolventRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class Body3_tabbed_fragment extends Fragment {

    private StaggeredGridLayoutManager gaggeredGridLayoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             Bundle savedInstanceState) {
        View retView = inflater.inflate(R.layout.body3_tabbed_fragment, null);

        RecyclerView recyclerView = (RecyclerView) retView.findViewById(R.id.recycler_view);
        recyclerView.setHasFixedSize(true);

        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            gaggeredGridLayoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        }else{if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_LANDSCAPE){
            gaggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        }}
            recyclerView.setLayoutManager(gaggeredGridLayoutManager);

        List<ItemObjects> gaggeredList = getListItemData();

        SolventRecyclerViewAdapter rcAdapter = new SolventRecyclerViewAdapter(retView.getContext(), gaggeredList);
        recyclerView.setAdapter(rcAdapter);

        Log.d("fragm3TAG", "myLog");
        return retView;
    }

    private List<ItemObjects> getListItemData(){
        List<ItemObjects> listViewItems = new ArrayList<ItemObjects>();
        listViewItems.add(new ItemObjects("Alkane", R.drawable.common_google_signin_btn_icon_dark));
        listViewItems.add(new ItemObjects("Ethane", R.drawable.abc_ic_star_black_36dp));
        listViewItems.add(new ItemObjects("Alkyne", R.drawable.common_google_signin_btn_icon_dark_normal));
        listViewItems.add(new ItemObjects("Benzene", R.drawable.ic_start));
        listViewItems.add(new ItemObjects("Amide", R.drawable.common_google_signin_btn_icon_dark));
        listViewItems.add(new ItemObjects("Amino Acid", R.drawable.abc_ic_star_black_36dp));
        listViewItems.add(new ItemObjects("Phenol", R.drawable.common_google_signin_btn_icon_dark_normal));
        listViewItems.add(new ItemObjects("Carbonxylic", R.drawable.ic_start));
        listViewItems.add(new ItemObjects("Nitril", R.drawable.common_google_signin_btn_icon_dark));
        listViewItems.add(new ItemObjects("Ether", R.drawable.abc_ic_star_black_36dp));
        listViewItems.add(new ItemObjects("Ester", R.drawable.common_google_signin_btn_icon_dark_normal));
        listViewItems.add(new ItemObjects("Alcohol", R.drawable.ic_start));

        return listViewItems;
    }
}
