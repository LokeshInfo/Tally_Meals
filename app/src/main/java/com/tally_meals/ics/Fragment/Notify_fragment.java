package com.tally_meals.ics.Fragment;

import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.tally_meals.ics.Adapter.Notify_adapter;
import com.tally_meals.ics.MainActivity;
import com.tally_meals.ics.Model.Notify_data;
import com.tally_meals.ics.R;

import java.util.ArrayList;

public class Notify_fragment extends Fragment
{
    ImageView imgback;
    RecyclerView notify_recycler;
    ArrayList<Notify_data> datalist;
    Notify_adapter adapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_notify,container,false);

        imgback = view.findViewById(R.id.imgback);
        notify_recycler = (RecyclerView) view.findViewById(R.id.recycler_view);
        datalist = new ArrayList<>();

        datalist.add(new Notify_data("https://tallymeals.com"));
        datalist.add(new Notify_data("2_https://tallymeals.com"));
        datalist.add(new Notify_data("3_https://tallymeals.com"));
        datalist.add(new Notify_data("4_https://tallymeals.com"));

        ItemTouchHelper.SimpleCallback simpleItemTouchCallback = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                Toast.makeText(getActivity(), "on Move", Toast.LENGTH_SHORT).show();
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int swipeDir) {
                Toast.makeText(getActivity(), " Deleted ", Toast.LENGTH_SHORT).show();
                //Remove swiped item from list and notify the RecyclerView
                int position = viewHolder.getAdapterPosition();
                datalist.remove(position);
                adapter.notifyDataSetChanged();
            }
        };
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleItemTouchCallback);
        itemTouchHelper.attachToRecyclerView(notify_recycler);

        adapter = new Notify_adapter(getActivity(),datalist);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        notify_recycler.setLayoutManager(linearLayoutManager);
        notify_recycler.setItemAnimator(new DefaultItemAnimator());
        notify_recycler.setAdapter(adapter);

        imgback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ((MainActivity)getActivity()).onBackPressed();
            }
        });

        return view;
    }
}
