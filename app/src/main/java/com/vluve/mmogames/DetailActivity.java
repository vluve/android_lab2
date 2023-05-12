package com.vluve.mmogames;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import android.os.AsyncTask;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

import java.util.ArrayList;
import java.util.List;

public class DetailActivity extends AppCompatActivity {

    private GameViewModel gameViewModel;
    private GameModelsRepository rep;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        rep = new GameModelsRepository(this.getApplication());

        // создаём переменные вьюшек
        AsyncTask.execute(() -> {
            ImageView title_iv = findViewById(R.id.game_details_title_image_imageView);
        TextView title_tv = findViewById(R.id.game_details_title_textView);
        TextView date_tv = findViewById(R.id.game_details_date_textView);
        TextView genre_tv = findViewById(R.id.game_details_genre_textView);
        TextView platforms_tv = findViewById(R.id.game_details_platforms_textView);
        TextView developer_tv = findViewById(R.id.game_details_developer_textView);
        TextView publisher_tv = findViewById(R.id.game_details_publisher_textView);
        TextView desc_tv = findViewById(R.id.game_details_desc_textView);

        // получаем из интента дополнительную информацию
        int db_id = getIntent().getIntExtra("DB_ID", -1);
        GamePreviewModel game = rep.selectGameByDB_ID(db_id);
        runOnUiThread(() -> {
            // обновляем тексты и картинку
            Glide.with(DetailActivity.this).load(game.getThumbnail()).diskCacheStrategy(DiskCacheStrategy.ALL).into(title_iv);
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