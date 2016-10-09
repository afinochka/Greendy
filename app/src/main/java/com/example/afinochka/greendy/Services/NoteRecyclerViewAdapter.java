package com.example.afinochka.greendy.Services;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afinochka.greendy.Activities.NoteActivity;
import com.example.afinochka.greendy.Objects.Note;
import com.example.afinochka.greendy.R;

import java.util.List;

public class NoteRecyclerViewAdapter extends RecyclerView.Adapter<NoteRecyclerViewAdapter.NoteViewHolder> {

    private List<Note> data;
    private int layout;
    private Context context;


    public static class NoteViewHolder extends RecyclerView.ViewHolder {

        CardView card;
        TextView noteTitle;
        TextView noteAddress;
        ImageView notePhoto;

        NoteViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.card);
            noteTitle = (TextView)itemView.findViewById(R.id.note_title);
            noteAddress = (TextView)itemView.findViewById(R.id.note_address);
            notePhoto = (ImageView)itemView.findViewById(R.id.note_photo);
        }

    }


    public NoteRecyclerViewAdapter(List<Note> data) {
        this.data = data;
    }
    public NoteRecyclerViewAdapter(List<Note> data, int layout, Context context) {
        this.data = data;
        this.layout = layout;
        this.context = context;
    }

    @Override
    public NoteViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(layout, viewGroup, false);
        return new NoteViewHolder(v);
    }

    @Override
    public void onBindViewHolder(NoteViewHolder holder, int position) {
        holder.noteTitle.setText(data.get(position).getTitle());
        holder.noteAddress.setText(data.get(position).getAddress());
        holder.notePhoto.setImageResource(R.mipmap.ic_nothing);
        holder.card.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, NoteActivity.class);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public void onAttachedToRecyclerView(RecyclerView recyclerView) {
        super.onAttachedToRecyclerView(recyclerView);
    }

    @Override
    public int getItemCount() {
        return data.size();
    }
}
