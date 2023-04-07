package com.vluve.mmogames;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements GamePreview_RecyclerViewInterface{

    // массив моделек
    ArrayList<GamePreviewModel> gamePreviewModels = new ArrayList<>();

    // массив картинок
    int[] gamePreviewImages = {R.drawable.mmo1, R.drawable.mmo2, R.drawable.mmo3, R.drawable.mmo4, R.drawable.mmo5,
            R.drawable.mmo6, R.drawable.mmo7, R.drawable.mmo8, R.drawable.mmo9, R.drawable.mmo10,
            R.drawable.mmo11, R.drawable.mmo12, R.drawable.mmo13, R.drawable.mmo14, R.drawable.mmo15,
            R.drawable.mmo16, R.drawable.mmo17, R.drawable.mmo18, R.drawable.mmo19, R.drawable.mmo20,
            R.drawable.mmo21, R.drawable.mmo22, R.drawable.mmo23, R.drawable.mmo24, R.drawable.mmo25,
            R.drawable.mmo26, R.drawable.mmo27, R.drawable.mmo28, R.drawable.mmo29, R.drawable.mmo30,
            R.drawable.mmo31, R.drawable.mmo32, R.drawable.mmo33, R.drawable.mmo34, R.drawable.mmo35,
            R.drawable.mmo36, R.drawable.mmo37, R.drawable.mmo38, R.drawable.mmo39, R.drawable.mmo40,
            R.drawable.mmo41, R.drawable.mmo42, R.drawable.mmo43, R.drawable.mmo44, R.drawable.mmo45,
            R.drawable.mmo46, R.drawable.mmo47, R.drawable.mmo48, R.drawable.mmo49, R.drawable.mmo50};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.mmoRecyclerView); // создаём переменную RecyclerView
        setupGamePreviewModels(); // заполняем массивы моделек
        // создаём адаптер и привязываем его к RecyclerView
        GamePreview_RecyclerViewAdapter adapter = new GamePreview_RecyclerViewAdapter(this, this, gamePreviewModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void setupGamePreviewModels(){
        // получаем массивы из ресурсов
        String[] gameTitles = getResources().getStringArray(R.array.mmo_games_titles);
        String[] releaseDates = getResources().getStringArray(R.array.mmo_games_dates);
        String[] ratings = getResources().getStringArray(R.array.mmo_games_ratings);
        String[] genres = getResources().getStringArray(R.array.mmo_games_genres);
        String[] developers = getResources().getStringArray(R.array.mmo_games_developers);
        String[] publishers = getResources().getStringArray(R.array.mmo_games_publishers);
        String[] platforms = getResources().getStringArray(R.array.mmo_games_platforms);
        String[] descs = getResources().getStringArray(R.array.mmo_games_descs);

        // заполняем массив моделек
        for (int i = 0; i < gameTitles.length; i++)
            gamePreviewModels.add(new GamePreviewModel(gameTitles[i], releaseDates[i], ratings[i], genres[i],
                    platforms[i], developers[i], publishers[i], descs[i], gamePreviewImages[i]));
    }

    @Override
    public void onItemClick(int position) {
        // заполняем интент дополнительной информацией и запускаем активность
        Log.w("DEBUG:", Integer.toString(position));
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("GAME_IMAGE", gamePreviewModels.get(position).getImage());
        intent.putExtra("GAME_TITLE", gamePreviewModels.get(position).getTitle());
        intent.putExtra("GAME_DATE", gamePreviewModels.get(position).getReleaseDate());
        intent.putExtra("GAME_DEVELOPER", gamePreviewModels.get(position).getDeveloper());
        intent.putExtra("GAME_PUBLISHER", gamePreviewModels.get(position).getPublisher());
        intent.putExtra("GAME_PLATFORMS", gamePreviewModels.get(position).getPlatforms());
        intent.putExtra("GAME_GENRE", gamePreviewModels.get(position).getGenre());
        intent.putExtra("GAME_DESC", gamePreviewModels.get(position).getDesc());
        startActivity(intent);
    }
}