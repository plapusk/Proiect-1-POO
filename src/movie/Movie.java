package movie;

import input.MoviesInput;

import java.util.ArrayList;

public class Movie {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private boolean watched;
    private boolean liked;

    public Movie(MoviesInput moviesInput) {
        this.name = moviesInput.getName();
        this.year = moviesInput.getYear();
        this.duration = moviesInput.getDuration();
        this.genres = moviesInput.getGenres();
        this.actors = moviesInput.getActors();
        this.countriesBanned = moviesInput.getCountriesBanned();
        this.watched = false;
        this.liked = false;
    }

    public Movie(Movie moviesInput) {
        this.name = moviesInput.getName();
        this.year = moviesInput.getYear();
        this.duration = moviesInput.getDuration();
        this.genres = moviesInput.getGenres();
        this.actors = moviesInput.getActors();
        this.countriesBanned = moviesInput.getCountriesBanned();
        this.watched = false;
        this.liked = false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public int getDuration() {
        return duration;
    }

    public void setDuration(int duration) {
        this.duration = duration;
    }

    public ArrayList<String> getGenres() {
        return genres;
    }

    public void setGenres(ArrayList<String> genres) {
        this.genres = genres;
    }

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public void setCountriesBanned(ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public boolean isWatched() {
        return watched;
    }

    public void setWatched(boolean watched) {
        this.watched = watched;
    }

    public boolean isLiked() {
        return liked;
    }

    public void setLiked(boolean liked) {
        this.liked = liked;
    }
}
