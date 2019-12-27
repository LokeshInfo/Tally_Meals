package com.tally_meals.ics.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

import com.tally_meals.ics.MainActivity;
import com.tally_meals.ics.R;

public class Prefrences_fragment extends Fragment
{
    ImageView imgToolbar;
    CardView card_none,card_Vegan, card_Vegetarian, cmilk, csoy, cegg, cwheat, cpeanut, cfish, csalt;
    ImageView check_none,check_vegan, check_vegetarian, ch_milk, ch_soy, ch_egg, ch_wheat, ch_peanut, ch_fish, ch_salt, ch_dal;
    int ch=0, ch1=0 , ch2=0;
    int ch3=0, ch4=0, ch5=0, ch6=0, ch7=0, ch8=0, ch9=0, ch10=0;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_prefrences,container,false);

        imgToolbar = view.findViewById(R.id.imgToolbar);

        card_Vegan = view.findViewById(R.id.card_vegan);
        card_Vegetarian = view.findViewById(R.id.card_vegetarian);
        check_vegan = view.findViewById(R.id.check_vegan);
        check_vegetarian = view.findViewById(R.id.check_vegetarian);
        card_none = view.findViewById(R.id.card_none);
        check_none = view.findViewById(R.id.check_none);

        cmilk = view.findViewById(R.id.c_milk);
        csoy = view.findViewById(R.id.c_soy);
        cegg = view.findViewById(R.id.c_egg);
        cwheat = view.findViewById(R.id.c_wheat);
        cpeanut = view.findViewById(R.id.c_peanut);
        cfish = view.findViewById(R.id.c_shelfish);
        csalt = view.findViewById(R.id.c_salt);

        ch_milk = view.findViewById(R.id.ch_milk);
        ch_soy = view.findViewById(R.id.ch_soy);
        ch_egg = view.findViewById(R.id.ch_egg);
        ch_wheat = view.findViewById(R.id.ch_wheat);
        ch_peanut = view.findViewById(R.id.ch_peanut);
        ch_fish = view.findViewById(R.id.ch_fish);
        ch_salt = view.findViewById(R.id.ch_salt);

        Click_Listeners();

        imgToolbar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).openDrawer();
            }
        });

        return  view;
    }

    private void Click_Listeners()
    {
        card_none.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch==0)
                {
                    check_none.setVisibility(View.VISIBLE);
                    check_vegetarian.setVisibility(View.INVISIBLE);
                    check_vegan.setVisibility(View.INVISIBLE);
                    ch=0; ch2 = 1; ch1 = 0;
                }
                else {
                    check_vegan.setVisibility(View.INVISIBLE);
                    ch = 0;
                }
                //Log.e("VEGAN = "," "+ch2);
            }
        });

        card_Vegetarian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch1==0) {
                    check_vegetarian.setVisibility(View.VISIBLE);
                    check_vegan.setVisibility(View.INVISIBLE);
                    check_none.setVisibility(View.INVISIBLE);
                    ch=0; ch1 = 1;  ch2 = 0;
                }
                else
                {
                    check_vegetarian.setVisibility(View.INVISIBLE);
                    ch1 = 0 ;
                }
                //Log.e("VEGETERIAN = "," "+ch1);
            }
        });



        card_Vegan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch2==0)
                {
                    check_vegan.setVisibility(View.VISIBLE);
                    check_vegetarian.setVisibility(View.INVISIBLE);
                    check_none.setVisibility(View.INVISIBLE);
                    ch=0; ch2 = 1; ch1 = 0;
                }
                else {
                    check_vegan.setVisibility(View.INVISIBLE);
                     ch2 = 0;
                }
                //Log.e("VEGAN = "," "+ch2);
            }
        });


        cmilk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch3==0)
                {
                    ch_milk.setVisibility(View.VISIBLE);    ch3=1;
                }
                else
                {
                    ch_milk.setVisibility(View.INVISIBLE);  ch3=0;
                }
            }
        });

        csoy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch4==0)
                {
                    ch_soy.setVisibility(View.VISIBLE);    ch4=1;
                }
                else
                {
                    ch_soy.setVisibility(View.INVISIBLE);  ch4=0;
                }
            }
        });

        cegg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch5==0)
                {
                    ch_egg.setVisibility(View.VISIBLE);    ch5=1;
                }
                else
                {
                    ch_egg.setVisibility(View.INVISIBLE);  ch5=0;
                }
            }
        });

        cwheat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch6==0)
                {
                    ch_wheat.setVisibility(View.VISIBLE);    ch6=1;
                }
                else
                {
                    ch_wheat.setVisibility(View.INVISIBLE);  ch6=0;
                }
            }
        });

        cpeanut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch7==0)
                {
                    ch_peanut.setVisibility(View.VISIBLE);    ch7=1;
                }
                else
                {
                    ch_peanut.setVisibility(View.INVISIBLE);  ch7=0;
                }
            }
        });

        cfish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch8==0)
                {
                    ch_fish.setVisibility(View.VISIBLE);    ch8=1;
                }
                else
                {
                    ch_fish.setVisibility(View.INVISIBLE);  ch8=0;
                }
            }
        });

        csalt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ch9==0)
                {
                    ch_salt.setVisibility(View.VISIBLE);    ch9=1;
                }
                else
                {
                    ch_salt.setVisibility(View.INVISIBLE);  ch9=0;
                }
            }
        });
    }
}
