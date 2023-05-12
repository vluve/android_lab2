package com.vluve.mmogames;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;



import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment implements GamePreview_RecyclerViewInterface{

    // массив моделек
    ArrayList<GamePreviewModel> gamePreviewModels = new ArrayList<>();
    GamePreview_RecyclerViewAdapter adapter;
    private GameViewModel gameViewModel;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        RecyclerView recyclerView = view.findViewById(R.id.mmoRecyclerView); // создаём переменную RecyclerView
        // создаём адаптер и привязываем его к RecyclerView
        adapter = new GamePreview_RecyclerViewAdapter(this, getActivity(), gamePreviewModels);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        gameViewModel = new ViewModelProvider(getActivity()).get(GameViewModel.class);
        gameViewModel.getAllGames().observe(getActivity(), new Observer<List<GamePreviewModel>>() {
            @Override
            public void onChanged(@Nullable List<GamePreviewModel> games) {
                adapter.setGamePreviewModels(new ArrayList<GamePreviewModel>(games));
                adapter.notifyDataSetChanged();
                gamePreviewModels.addAll(games);
            }
        });
        loadGameModels();
    }

    @Override
    public void onItemClick(int position) {
        // заполняем интент дополнительной информацией и запускаем активность
        Intent intent = new Intent(getActivity(), DetailActivity.class);
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
                    Toast.makeText(getContext(), "Данные подгружены из API!" + loadedModels.size(), Toast.LENGTH_SHORT).show();
                    loadModelsIntoDB(loadedModels);
                }
            }

            @Override
            public void onFailure(Call<List<GamePreviewModel>> call, Throwable t) {
                Toast.makeText(getContext(), "Нет доступа к интернету :(", Toast.LENGTH_SHORT).show();
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
