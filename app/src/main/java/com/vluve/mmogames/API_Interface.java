package com.vluve.mmogames;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface API_Interface {
    @GET("games")
    Call<List<GamePreviewModel>> getGames();
}
