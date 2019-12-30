package com.tally_meals.ics.Fragment;

import android.app.Dialog;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import com.github.jhonnyx2012.horizontalpicker.DatePickerListener;
import com.github.jhonnyx2012.horizontalpicker.HorizontalPicker;
import com.jaredrummler.materialspinner.MaterialSpinner;
import com.tally_meals.ics.MainActivity;
import com.tally_meals.ics.R;

import org.joda.time.DateTime;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Home_fragment extends Fragment implements DatePickerListener
{
    ImageView imgToolbar, ic_Notify;
    //icarrow1, icarrow2;
    Toolbar toolbar;
    TextView rate1, rate2;
    int currentdate;
    LinearLayout ll1 ,ll2;
    HorizontalPicker jonyCalendar;
    MaterialSpinner spinner_lunch,spinner_lunch1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_home,container,false);

        imgToolbar = view.findViewById(R.id.imgToolbar);
        toolbar = view.findViewById(R.id.toolbar);
        ic_Notify = view.findViewById(R.id.ic_notify);
        //icarrow1 = view.findViewById(R.id.ic_dow1);
        //icarrow2 = view.findViewById(R.id.ic_dow2);
        ll1 = view.findViewById(R.id.ll1);
        ll2 = view.findViewById(R.id.ll2);
        rate1 = view.findViewById(R.id.rate1);
        rate2 = view.findViewById(R.id.rate2);
        spinner_lunch = view.findViewById(R.id.spinner_lunch);
        spinner_lunch1 = view.findViewById(R.id.spinner_lunch1);

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
                .showTodayButton(false)
                .init();


        jonyCalendar.setBackgroundColor(getResources().getColor(R.color.light_Purple2));
        jonyCalendar.setDate(new DateTime());

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
        List<String> list = new ArrayList<String>();
        list.add(" 1 ");
        list.add(" 2 ");
        list.add(" 3 ");
        list.add(" 4 ");
        list.add(" 5 ");
        spinner_lunch.setItems(list);
        spinner_lunch.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                //Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });
        spinner_lunch1.setItems(list);
        spinner_lunch1.setOnItemSelectedListener(new MaterialSpinner.OnItemSelectedListener<String>() {

            @Override public void onItemSelected(MaterialSpinner view, int position, long id, String item) {
                //Snackbar.make(view, "Clicked " + item, Snackbar.LENGTH_LONG).show();
            }
        });

        rate1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_dialog();
            }
        });

        rate2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                show_dialog();
            }
        });
    }

    private void show_dialog(){
        final Dialog dialog = new Dialog(getActivity());
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.dialog_rate_meal);

        Window window = dialog.getWindow();
        window.setLayout(WindowManager.LayoutParams.FILL_PARENT, WindowManager.LayoutParams.WRAP_CONTENT);

        ImageView cancel = dialog.findViewById(R.id.cancel);
        Button submit = dialog.findViewById(R.id.submit);

        cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();            }        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                dialog.dismiss();           }     });

        dialog.show();
        dialog.setCanceledOnTouchOutside(true);
    }


}
