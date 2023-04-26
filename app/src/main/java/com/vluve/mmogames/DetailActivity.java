package com.vluve.mmogames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;

public class DetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // создаём переменные вьюшек
        ImageView title_iv = findViewById(R.id.game_details_title_image_imageView);
        TextView title_tv = findViewById(R.id.game_details_title_textView);
        TextView date_tv = findViewById(R.id.game_details_date_textView);
        TextView genre_tv = findViewById(R.id.game_details_genre_textView);
        TextView platforms_tv = findViewById(R.id.game_details_platforms_textView);
        TextView developer_tv = findViewById(R.id.game_details_developer_textView);
        TextView publisher_tv = findViewById(R.id.game_details_publisher_textView);
        TextView desc_tv = findViewById(R.id.game_details_desc_textView);

        // получаем из интента дополнительную информацию
        String thumbnail = getIntent().getStringExtra("GAME_IMAGE");
        String title = getIntent().getStringExtra("GAME_TITLE");
        String date = getIntent().getStringExtra("GAME_DATE");
        String platforms = getIntent().getStringExtra("GAME_PLATFORMS");
        String genre = getIntent().getStringExtra("GAME_GENRE");
        String developer = getIntent().getStringExtra("GAME_DEVELOPER");
        String publisher = getIntent().getStringExtra("GAME_PUBLISHER");
        String desc = getIntent().getStringExtra("GAME_DESC");

        // обновляем тексты и картинку
        Glide.with(this).load(thumbnail).diskCacheStrategy(DiskCacheStrategy.ALL).into(title_iv);
        title_tv.setText(title);
        date_tv.setText(date);
        platforms_tv.setText(platforms);
        genre_tv.setText(genre);
        developer_tv.setText(developer);
        publisher_tv.setText(publisher);
        desc_tv.setText(desc);

    }
}