package com.vluve.mmogames;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = GamePreviewModel.class, version = 3)
public abstract class GameDatabase extends RoomDatabase {
    private static GameDatabase instance;
    public abstract GameModelDao gameModelDao();

    public static synchronized GameDatabase getInstance(Context context){
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                            GameDatabase.class, "game_models_database")
                    .fallbackToDestructiveMigration()
                    .build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private GameModelDao gameDao;

        private PopulateDbAsyncTask(GameDatabase db) {
            gameDao = db.gameModelDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            //gameDao.insert(new GamePreviewModel(1136,"Overwatch 2","https://www.mmobomb.com/g/1136/thumbnail.jpg","Big changes come to the Overwatch formula in this sequel...and so does PvE content, eventually.","https://www.mmobomb.com/open/overwatch-2","Shooter","PC (Windows)","Activision Blizzard King","Blizzard Entertainment","2022-10-04","https://www.mmobomb.com/overwatch-2"));
            //gameDao.insert(new GamePreviewModel("Title 2", "Description 2", 2));
            //gameDao.insert(new GamePreviewModel("Title 3", "Description 3", 3));
            return null;
        }
    }
}
