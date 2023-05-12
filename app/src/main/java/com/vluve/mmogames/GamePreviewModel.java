package com.vluve.mmogames;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

@Entity(tableName = "game_table")
public class GamePreviewModel {

    @PrimaryKey(autoGenerate = true)
    private int db_id;

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

    public GamePreviewModel(int id, String title, String thumbnail, String short_description, String game_url, String genre, String platform, String publisher, String developer, String release_date, String profile_url) {
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

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getDb_id() {
        return db_id;
    }

    public void setDb_id(int db_id) {
        this.db_id = db_id;
    }

    public String getGame_url() {
        return game_url;
    }

    public void setGame_url(String game_url) {
        this.game_url = game_url;
    }

    public String getProfile_url() {
        return profile_url;
    }

    public void setProfile_url(String profile_url) {
        this.profile_url = profile_url;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setRelease_date(String release_date) {
        this.release_date = release_date;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public void setPlatform(String platform) {
        this.platform = platform;
    }

    public void setDeveloper(String developer) {
        this.developer = developer;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    public void setShort_description(String short_description) {
        this.short_description = short_description;
    }

    public void setThumbnail(String thumbnail) {
        this.thumbnail = thumbnail;
    }
}
