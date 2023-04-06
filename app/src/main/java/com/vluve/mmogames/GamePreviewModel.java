package com.vluve.mmogames;

public class GamePreviewModel {
    String title;
    String releaseDate;
    String rating;
    int image;

    public GamePreviewModel(String title, String releaseDate, String rating, int image) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.image = image;
    }

    public String getTitle() {
        return title;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public String getRating() {
        return rating;
    }

    public int getImage() {
        return image;
    }
}
