package com.vluve.mmogames;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface GameModelDao {

    @Insert
    void insert(GamePreviewModel gamePreviewModel);

    @Update
    void update(GamePreviewModel gamePreviewModel);

    @Delete
    void delete(GamePreviewModel gamePreviewModel);

    @Query("DELETE FROM game_table")
    void deleteAll();

    @Query("SELECT * FROM game_table ORDER BY id")
    LiveData<List<GamePreviewModel>> getAllGames();

    @Query("SELECT * FROM game_table WHERE id = :db_id")
    GamePreviewModel selectGameByDB_ID(int db_id);


}
