package com.vluve.mmogames;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GamePreview_RecyclerViewAdapter extends RecyclerView.Adapter<GamePreview_RecyclerViewAdapter.MyViewHolder>{
    Context context;
    ArrayList<GamePreviewModel> gamePreviewModels;

    public GamePreview_RecyclerViewAdapter(Context context, ArrayList<GamePreviewModel> gamePreviewModels) {
        this.context = context;
        this.gamePreviewModels = gamePreviewModels;
    }

    @NonNull
    @Override
    public GamePreview_RecyclerViewAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.recycler_view_item, parent, false);
        return new GamePreview_RecyclerViewAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull GamePreview_RecyclerViewAdapter.MyViewHolder holder, int position) {
        holder.titleTextView.setText(gamePreviewModels.get(position).getTitle());
        holder.dateTextView.setText(gamePreviewModels.get(position).getReleaseDate());
        holder.ratingTextView.setText(gamePreviewModels.get(position).getRating());
        holder.imageView.setImageResource(gamePreviewModels.get(position).getImage());
    }

    @Override
    public int getItemCount() {
        return gamePreviewModels.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView titleTextView, dateTextView, ratingTextView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            imageView = itemView.findViewById(R.id.mmo_game_preview_imageView);
            titleTextView = itemView.findViewById(R.id.mmo_game_preview_title_textView);
            dateTextView = itemView.findViewById(R.id.mmo_game_preview_date_textView);
            ratingTextView = itemView.findViewById(R.id.mmo_game_preview_rating_textView);
        }
    }
}
