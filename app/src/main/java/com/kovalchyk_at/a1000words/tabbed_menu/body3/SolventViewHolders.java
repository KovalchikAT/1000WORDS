package com.kovalchyk_at.a1000words.tabbed_menu.body3;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.kovalchyk_at.a1000words.R;

/**
 * Created by Kovalchyk_at on 18.09.2017.
 */

public class SolventViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener {

    public TextView countryName;
    public ImageView countryPhoto;

    public SolventViewHolders(View itemView) {
        super(itemView);
        View retV = itemView;
        retV.setOnClickListener(this);
        countryName = (TextView) retV.findViewById(R.id.country_name);
        countryPhoto = (ImageView) retV.findViewById(R.id.country_photo);
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(view.getContext(), "Clicked Position = " + getPosition(), Toast.LENGTH_SHORT).show();
    }
}