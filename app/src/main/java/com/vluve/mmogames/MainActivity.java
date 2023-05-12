package com.vluve.mmogames;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Intent;
import android.util.Log;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements GamePreview_RecyclerViewInterface{

    // массив моделек
    ArrayList<GamePreviewModel> gamePreviewModels = new ArrayList<>();
    GamePreview_RecyclerViewAdapter adapter;
    private GameViewModel gameViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.mmoRecyclerView); // создаём переменную RecyclerView
        // создаём адаптер и привязываем его к RecyclerView
        adapter = new GamePreview_RecyclerViewAdapter(this, this, gamePreviewModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        gameViewModel = new ViewModelProvider(this).get(GameViewModel.class);
        gameViewModel.getAllGames().observe(this, new Observer<List<GamePreviewModel>>() {
            @Override
            public void onChanged(@Nullable List<GamePreviewModel> games) {
                adapter.setGamePreviewModels(new ArrayList<GamePreviewModel>(games));
                adapter.notifyDataSetChanged();
                gamePreviewModels.addAll(games);
                Toast.makeText(MainActivity.this, "Данные из БД обновлены!", Toast.LENGTH_SHORT).show();
            }
        });
        loadGameModels();
    }

    @Override
    public void onItemClick(int position) {
        // заполняем интент дополнительной информацией и запускаем активность
        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra("DB_ID", gamePreviewModels.get(position).getId());
        startActivity(intent);
    }

    private void loadGameModels() {
        RetrofitManager.getRetrofit().getGames().enqueue(new Callback<List<GamePreviewModel>>() {
            @Override
            public void onResponse(Call<List<GamePreviewModel>> call, Response<List<GamePreviewModel>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    ArrayList<GamePreviewModel> loadedModels = new ArrayList<GamePreviewModel>();
                    loadedModels.addAll(response.body());
                    Toast.makeText(MainActivity.this, "Данные подгружены из API!" + loadedModels.size(), Toast.LENGTH_SHORT).show();
                    loadModelsIntoDB(loadedModels);
                }
            }

            @Override
            public void onFailure(Call<List<GamePreviewModel>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void loadModelsIntoDB(ArrayList<GamePreviewModel> loadedModels) {
        gameViewModel.deleteAllGames();
        for (GamePreviewModel model : loadedModels) {
            gameViewModel.insert(model);
        }
    }
}