package com.example.afinochka.greendy.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.afinochka.greendy.Activities.NoteActivity;
import com.example.afinochka.greendy.Objects.Note;
import com.example.afinochka.greendy.R;
import com.example.afinochka.greendy.Services.HorizontalRecyclerViewAdapter;
import com.example.afinochka.greendy.Services.NoteRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentMain extends Fragment implements RecyclerView.OnItemTouchListener {

    private List<Note> data = new ArrayList<>();
    private List images = Arrays.asList(R.mipmap.ic_nothing, R.mipmap.ic_nothing,
            R.mipmap.ic_nothing);
    List<String> list = Arrays.asList("one", "two", "three", "four", "five", "six",
            "seven", "eight", "nine", "ten", "eleven", "twelve");

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        rootView = inflater.inflate(R.layout.fragment_main, container,
                false);

        RecyclerView noteRecyclerView = addRecyclerView(R.id.recycler_view,
                new GridLayoutManager(getContext(), 2),
                new NoteRecyclerViewAdapter(data, R.layout.main_card_note, getContext()),
                new DefaultItemAnimator());
        noteRecyclerView.setHasFixedSize(true);
        noteRecyclerView.addOnItemTouchListener(this);


        RecyclerView horizontalRecyclerView = addRecyclerView(R.id.horiz_scroll,
                new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false),
                new HorizontalRecyclerViewAdapter(list));


        return rootView;
    }

    private RecyclerView addRecyclerView(int id, RecyclerView.LayoutManager manager,
                                         RecyclerView.Adapter adapter,
                                         RecyclerView.ItemAnimator animator){
        RecyclerView rv = (RecyclerView) rootView.findViewById(id);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        prepareData(adapter);
        rv.setItemAnimator(animator);
        return rv;
    }

    private RecyclerView addRecyclerView(int id, RecyclerView.LayoutManager manager,
                                         RecyclerView.Adapter adapter){
        RecyclerView rv = (RecyclerView) rootView.findViewById(id);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        return rv;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }

    private void prepareData(RecyclerView.Adapter adapter) {

        data.add(new Note("Mad Max: Fury Road", "film 1", images));
        data.add(new Note("Inside Out", "film 2", images));
        data.add(new Note("Star Wars: Episode VII - The Force Awakens", "film 3", images));
        data.add(new Note("Shaun the Sheep", "film 4", images));
        data.add(new Note("The Martian", "film 5", images));

        adapter.notifyDataSetChanged();
    }


    @Override
    public boolean onInterceptTouchEvent(RecyclerView rv, MotionEvent e) {
        return false;
    }

    @Override
    public void onTouchEvent(RecyclerView rv, MotionEvent e) {
        Intent intent = new Intent(getContext(), NoteActivity.class);
        startActivity(intent);
        Toast.makeText(getContext(), "Click", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {

    }
}
