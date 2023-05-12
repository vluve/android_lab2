package com.vluve.mmogames;

import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailFragment extends Fragment {
    private GameViewModel gameViewModel;
    private int db_id;
    private GameModelsRepository rep;
    public DetailFragment(){
        super(R.layout.fragment_detail);
    }

    public void setDb_id(int id){
        db_id = id;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rep = new GameModelsRepository(getActivity().getApplication());

        // создаём переменные вьюшек
        AsyncTask.execute(() -> {
            ImageView title_iv = view.findViewById(R.id.game_details_title_image_imageView);
            TextView title_tv = view.findViewById(R.id.game_details_title_textView);
            TextView date_tv = view.findViewById(R.id.game_details_date_textView);
            TextView genre_tv = view.findViewById(R.id.game_details_genre_textView);
            TextView platforms_tv = view.findViewById(R.id.game_details_platforms_textView);
            TextView developer_tv = view.findViewById(R.id.game_details_developer_textView);
            TextView publisher_tv = view.findViewById(R.id.game_details_publisher_textView);
            TextView desc_tv = view.findViewById(R.id.game_details_desc_textView);

            // получаем из интента дополнительную информацию

            GamePreviewModel game = rep.selectGameByDB_ID(db_id);
            getActivity().runOnUiThread(() -> {
                // обновляем тексты и картинку
                Glide.with(getActivity()).load(game.getThumbnail()).diskCacheStrategy(DiskCacheStrategy.ALL).into(title_iv);
                title_tv.setText(game.getTitle());
                date_tv.setText(game.getRelease_date());
                platforms_tv.setText(game.getPlatform());
                genre_tv.setText(game.getGenre());
                developer_tv.setText(game.getDeveloper());
                publisher_tv.setText(game.getPublisher());
                desc_tv.setText(game.getShort_description());
            });
        });
    }



}