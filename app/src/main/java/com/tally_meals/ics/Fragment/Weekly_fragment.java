package com.tally_meals.ics.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.tally_meals.ics.MainActivity;
import com.tally_meals.ics.R;

public class Weekly_fragment extends Fragment
{
    ImageView imgToolbar, down1 , down2;
    LinearLayout lyt1 , lyt2;
    Toolbar toolbar;
    Animation slide_down, slide_up;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_weekly,container,false);

        imgToolbar = view.findViewById(R.id.imgToolbar);
        toolbar = view.findViewById(R.id.toolbar);

        down1 = view.findViewById(R.id.ic_down);
        down2 = view.findViewById(R.id.ic_down1);

        lyt1 = view.findViewById(R.id.lyt1);
        lyt2 = view.findViewById(R.id.lyt2);


       slide_down = AnimationUtils.loadAnimation(getActivity(),
                R.anim.slide_down);

        down1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyt1.setAlpha(0.0f);
                lyt1.animate().translationX(0.1f).translationY(0.1f).alpha(1.0f).setListener(null);
                lyt1.setVisibility(View.VISIBLE);
            }
        });

        slide_up = AnimationUtils.loadAnimation(getActivity(),
                R.anim.slide_up);

        down2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lyt2.setAlpha(0.0f);
                lyt2.animate().translationX(0.1f).translationY(0.1f).alpha(1.0f).setListener(null);
                lyt2.setVisibility(View.VISIBLE);
            }
        });

        imgToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openDrawer();
            }
        });

        return view;
    }
}
