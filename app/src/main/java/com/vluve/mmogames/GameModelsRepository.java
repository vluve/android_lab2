package com.vluve.mmogames;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import java.util.List;

public class GameModelsRepository {
    private GameModelDao gameModelDao;
    static LiveData<GamePreviewModel> model;
    private LiveData<List<GamePreviewModel>> allModels;

    public GameModelsRepository(Application application) {
        GameDatabase database = GameDatabase.getInstance(application);
        gameModelDao = database.gameModelDao();
        allModels = gameModelDao.getAllGames();
    }

    public void insert(GamePreviewModel model) {
        new InsertGameModelAsyncTask(gameModelDao).execute(model);
    }

    public void update(GamePreviewModel model) {
        new UpdateGameModelAsyncTask(gameModelDao).execute(model);
    }

    public void delete(GamePreviewModel model) {
        new DeleteGameModelAsyncTask(gameModelDao).execute(model);
    }

    public GamePreviewModel selectGameByDB_ID(int db_id) {
        return gameModelDao.selectGameByDB_ID(db_id);
    }

    public void deleteAllGames() {
        new DeleteAllGameModelsAsyncTask(gameModelDao).execute();
    }

    public LiveData<List<GamePreviewModel>> getAllGames() {
        return allModels;
    }

    private static class InsertGameModelAsyncTask extends AsyncTask<GamePreviewModel, Void, Void> {
        private GameModelDao gameDao;

        private InsertGameModelAsyncTask(GameModelDao gameDao) {
            this.gameDao = gameDao;
        }

        @Override
        protected Void doInBackground(GamePreviewModel... models) {
            gameDao.insert(models[0]);
            return null;
        }
    }

    private static class UpdateGameModelAsyncTask extends AsyncTask<GamePreviewModel, Void, Void> {
        private GameModelDao gameDao;

        private UpdateGameModelAsyncTask(GameModelDao gameDao) {
            this.gameDao = gameDao;
        }

        @Override
        protected Void doInBackground(GamePreviewModel... models) {
            gameDao.update(models[0]);
            return null;
        }
    }

    private static class DeleteGameModelAsyncTask extends AsyncTask<GamePreviewModel, Void, Void> {
        private GameModelDao gameDao;

        private DeleteGameModelAsyncTask(GameModelDao gameDao) {
            this.gameDao = gameDao;
        }

        @Override
        protected Void doInBackground(GamePreviewModel... models) {
            gameDao.delete(models[0]);
            return null;
        }
    }

    private static class DeleteAllGameModelsAsyncTask extends AsyncTask<Void, Void, Void> {
        private GameModelDao gameDao;

        private DeleteAllGameModelsAsyncTask(GameModelDao gameDao) {
            this.gameDao = gameDao;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            gameDao.deleteAll();
            return null;
        }
    }
}