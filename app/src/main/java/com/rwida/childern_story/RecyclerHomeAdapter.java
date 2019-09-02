package com.rwida.childern_story;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class RecyclerHomeAdapter extends RecyclerView.Adapter<RecyclerHomeAdapter.ExampleViewHolder> {
    private ArrayList<RecyclerHomeItem> RecyclerHomeList;

      Context context;

    public static class ExampleViewHolder extends RecyclerView.ViewHolder{

        public TextView StoryName;
        public CardView cardView;
        public Context context;

        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);
            StoryName = itemView.findViewById(R.id.tvStoryName);
            cardView = itemView.findViewById(R.id.card);
        }
    }

    public RecyclerHomeAdapter(ArrayList<RecyclerHomeItem> recyclerhomeList){
        RecyclerHomeList = recyclerhomeList;
    }

    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_view_home,parent,false);
        ExampleViewHolder evh = new ExampleViewHolder(v);
        return evh;
    }

    @Override
    public void onBindViewHolder(@NonNull final ExampleViewHolder holder, final int position) {
        RecyclerHomeItem currentItem = RecyclerHomeList.get(position);

        holder.StoryName.setText(currentItem.getStoryName());

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(holder.cardView.getContext(),StoryHtml.class);
                intent.putExtra("page",position);
                holder.cardView.getContext().startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
       return RecyclerHomeList.size();
    }
}
