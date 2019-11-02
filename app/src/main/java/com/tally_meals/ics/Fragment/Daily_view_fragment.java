package com.tally_meals.ics.Fragment;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.tally_meals.ics.MainActivity;
import com.tally_meals.ics.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Daily_view_fragment extends Fragment
{
    ImageView imgToolbar, next, previous;
    Toolbar toolbar;
    TextView date;
    String formattedDate;
    SimpleDateFormat df;
    Calendar c;
    RelativeLayout rootlyt;
    Spinner spinner_lunch, spinner_dinner;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dailyview,container,false);

        imgToolbar = view.findViewById(R.id.imgToolbar);
        toolbar = view.findViewById(R.id.toolbar);
        next = view.findViewById(R.id.ic_next);
        previous = view.findViewById(R.id.ic_previous);
        date = view.findViewById(R.id.txdate);
        rootlyt = view.findViewById(R.id.root_dailyview);
        spinner_dinner = view.findViewById(R.id.spinner_dinner);
        spinner_lunch = view.findViewById(R.id.spinner_lunch);


        imgToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openDrawer();
            }
        });



        List<String> list = new ArrayList<String>();
        list.add(" 1 ");
        list.add(" 2 ");
        list.add(" 3 ");
        list.add(" 4 ");
        list.add(" 5 ");
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(getActivity(),
                R.layout.spinner_item, list);
        dataAdapter.setDropDownViewResource(R.layout.spinner_item);
        spinner_lunch.setAdapter(dataAdapter);
        spinner_dinner.setAdapter(dataAdapter);

         c = Calendar.getInstance();

        System.out.println("Current time => " + c.getTime());

        df = new SimpleDateFormat("dd , MMM , yyyy");
        formattedDate = df.format(c.getTime());
        date.setText(formattedDate);
        //textview.setText(formattedDate);

        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.add(Calendar.DATE, 1);
                formattedDate = df.format(c.getTime());

                Log.v("NEXT DATE : ", formattedDate);
                date.setText(""+formattedDate);
            }
        });

        previous.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                c.add(Calendar.DATE, -1);
                formattedDate = df.format(c.getTime());

                Log.v("PREVIOUS DATE : ", formattedDate);
                date.setText(""+formattedDate);
            }
        });

        return view;
    }



}
