package com.example.afinochka.greendy.Services;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.afinochka.greendy.R;

import java.util.List;

public class HorizontalRecyclerViewAdapter
        extends RecyclerView.Adapter<HorizontalRecyclerViewAdapter.StringViewHolder> {

    private List<String> data;

    public static class StringViewHolder extends RecyclerView.ViewHolder {

        TextView title;

        StringViewHolder(View itemView) {
            super(itemView);
            title = (TextView)itemView.findViewById(R.id.title);
        }
    }


    public HorizontalRecyclerViewAdapter(List<String> data) {
        this.data = data;
    }

    @Override
    public StringViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.horiz_text_view,
                viewGroup, false);
        return new StringViewHolder(v);
    }

    @Override
    public void onBindViewHolder(StringViewHolder holder, int position) {
        holder.title.setText(data.get(position));
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
