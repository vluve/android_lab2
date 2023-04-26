package com.vluve.mmogames;

import com.google.gson.annotations.SerializedName;

public class GamePreviewModel {
    @SerializedName("id")
    int id;
    @SerializedName("game_url")
    String game_url;
    @SerializedName("profile_url")
    String profile_url;
    @SerializedName("title")
    String title;
    @SerializedName("release_date")
    String release_date;
    @SerializedName("genre")
    String genre;
    @SerializedName("platform")
    String platform;
    @SerializedName("developer")
    String developer;
    @SerializedName("publisher")
    String publisher;
    @SerializedName("short_description")
    String short_description;
    @SerializedName("thumbnail")
    String thumbnail;

    public GamePreviewModel(int id, String game_url, String profile_url, String title, String release_date, String genre, String platform, String developer, String publisher, String short_description, String thumbnail) {
        this.id = id;
        this.game_url = game_url;
        this.profile_url = profile_url;
        this.title = title;
        this.release_date = release_date;
        this.genre = genre;
        this.platform = platform;
        this.developer = developer;
        this.publisher = publisher;
        this.short_description = short_description;
        this.thumbnail = thumbnail;
    }

    public String getTitle() {
        return title;
    }

    public String getRelease_date() {
        return release_date;
    }

    public String getThumbnail() {
        return thumbnail;
    }

    public String getGenre() {
        return genre;
    }

    public String getPlatform() {
        return platform;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getShort_description() {
        return short_description;
    }
}
