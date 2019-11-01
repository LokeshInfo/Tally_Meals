package com.tally_meals.ics.Fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.tally_meals.ics.MainActivity;
import com.tally_meals.ics.R;

import org.joda.time.DateTime;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Home_fragment extends Fragment implements DatePickerListener
{
    ImageView imgToolbar, ic_Notify, icarrow1, icarrow2;
    Toolbar toolbar;
    int currentdate;
    LinearLayout ll1 ,ll2;
    HorizontalPicker jonyCalendar;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        imgToolbar = view.findViewById(R.id.imgToolbar);
        toolbar = view.findViewById(R.id.toolbar);
        ic_Notify = view.findViewById(R.id.ic_notify);
        icarrow1 = view.findViewById(R.id.ic_dow1);
        icarrow2 = view.findViewById(R.id.ic_dow2);
        ll1 = view.findViewById(R.id.ll1);
        ll2 = view.findViewById(R.id.ll2);

        jonyCalendar = (HorizontalPicker) view.findViewById(R.id.jonycalendar);

        ic_Notify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Notify_fragment nfrag = new Notify_fragment();
                getActivity().getSupportFragmentManager().beginTransaction()
                        .replace(R.id.fragment_layout,nfrag).addToBackStack(null).commit();
            }
        });

        imgToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openDrawer();
            }
        });

        /* starts before 1 month from now */
        Calendar startDate = Calendar.getInstance();
        startDate.add(Calendar.MONTH, -1);

        /* ends after 1 month from now */
        Calendar endDate = Calendar.getInstance();
        endDate.add(Calendar.MONTH, 1);

        //jonyCalendar.setListener(this).init();

        // at init time
        jonyCalendar
                .setListener(this)
                .setDayOfWeekTextColor(getResources().getColor(R.color.light_Purple))
                .setMonthAndYearTextColor(getResources().getColor(R.color.light_Purple))
                .setDateSelectedColor(getResources().getColor(R.color.light_Purple))
                .init();


        jonyCalendar.setBackgroundColor(getResources().getColor(R.color.light_Purple2));

        Click_Listeners();

        return view;
    }


    @Override
    public void onDateSelected(DateTime dateSelected) {
        Log.e(" Jony Calendar - ","-------.    "+dateSelected.getDayOfMonth()+" --- "+dateSelected.getMonthOfYear()+
                 " --- "+dateSelected.getYear());
    }

    private void Click_Listeners()
    {
        icarrow1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll1.getVisibility() == View.GONE) {
                    ll1.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll1.setVisibility(View.GONE);
                }            }
        });


        icarrow2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ll2.getVisibility() == View.GONE) {
                    ll2.setVisibility(View.VISIBLE);
                }
                else
                {
                    ll2.setVisibility(View.GONE);
                }            }
        });

    }

}
