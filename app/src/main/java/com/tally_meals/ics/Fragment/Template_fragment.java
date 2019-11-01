package com.tally_meals.ics.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.tally_meals.ics.MainActivity;
import com.tally_meals.ics.R;

public class Template_fragment extends Fragment
{
    ImageView imgToolbar;
    Toolbar toolbar;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_template,container,false);

        imgToolbar = view.findViewById(R.id.imgToolbar);
        toolbar = view.findViewById(R.id.toolbar);

        imgToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openDrawer();
            }
        });

        return view;
    }

}
