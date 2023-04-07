package com.vluve.mmogames;

public class GamePreviewModel {
    String title;
    String releaseDate;
    String rating;
    String genre;
    String platforms;
    String developer;
    String publisher;
    String desc;
    int image;

    public GamePreviewModel(String title, String releaseDate, String rating, String genre,
                            String platforms, String developer, String publisher, String desc, int image) {
        this.title = title;
        this.releaseDate = releaseDate;
        this.rating = rating;
        this.image = image;
        this.genre = genre;
        this.platforms = platforms;
        this.developer = developer;
        this.publisher = publisher;
        this.desc = desc;
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

    public String getGenre() {
        return genre;
    }

    public String getPlatforms() {
        return platforms;
    }

    public String getDeveloper() {
        return developer;
    }

    public String getPublisher() {
        return publisher;
    }

    public String getDesc() {
        return desc;
    }
}
