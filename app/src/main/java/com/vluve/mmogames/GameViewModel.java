package com.vluve.mmogames;

import android.app.Application;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.annotation.NonNull;

import java.util.List;

public class GameViewModel extends AndroidViewModel {
    private GameModelsRepository repository;
    private LiveData<List<GamePreviewModel>> allGames;


    public GameViewModel(@NonNull Application application) {
        super(application);
        repository = new GameModelsRepository(application);
        allGames = repository.getAllGames();
    }

    public void insert(GamePreviewModel model) {
        repository.insert(model);
    }

    public void update(GamePreviewModel model) {
        repository.update(model);
    }

    public void delete(GamePreviewModel model) {
        repository.delete(model);
    }

    public GamePreviewModel selectGameByDB_ID(int db_id) {
        return repository.selectGameByDB_ID(db_id);
    }
    public void deleteAllGames() {
        repository.deleteAllGames();
    }

    public LiveData<List<GamePreviewModel>> getAllGames() {
        return allGames;
    }
}