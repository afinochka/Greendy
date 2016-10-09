package com.example.afinochka.greendy.Fragments;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.afinochka.greendy.Objects.Note;
import com.example.afinochka.greendy.R;
import com.example.afinochka.greendy.Services.NoteRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FragmentRequests extends Fragment {

    private List<Note> data = new ArrayList<>();
    private List images = Arrays.asList(R.mipmap.ic_nothing, R.mipmap.ic_nothing,
            R.mipmap.ic_nothing);

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.frament_requests, container, false);

        RecyclerView requestsView = addRecyclerView(R.id.requests_view,
                new LinearLayoutManager(getContext()),
                new NoteRecyclerViewAdapter(data, R.layout.my_card_note, getContext()));
        requestsView.setHasFixedSize(true);

        return rootView;
    }

    private RecyclerView addRecyclerView(int id, RecyclerView.LayoutManager manager,
                                         RecyclerView.Adapter adapter){
        RecyclerView rv = (RecyclerView) rootView.findViewById(id);
        rv.setLayoutManager(manager);
        rv.setAdapter(adapter);
        prepareData(adapter);
        return rv;
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
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
    }


}
