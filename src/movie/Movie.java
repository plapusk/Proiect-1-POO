package movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.Contains;
import input.MoviesInput;

import java.util.ArrayList;

public class Movie {
    private String name;
    private String year;
    private int duration;
    private ArrayList<String> genres;
    private ArrayList<String> actors;
    private ArrayList<String> countriesBanned;
    private int numWatched;
    private int numLiked;
    private int numRating;
    private double rating;
    private static final double DECIMALS = 100;

    public Movie(MoviesInput moviesInput) {
        this.name = moviesInput.getName();
        this.year = moviesInput.getYear();
        this.duration = moviesInput.getDuration();
        this.genres = moviesInput.getGenres();
        this.actors = moviesInput.getActors();
        this.countriesBanned = moviesInput.getCountriesBanned();
        this.numWatched = 0;
        this.numLiked = 0;
        this.numRating = 0;
        this.rating = 0;
    }

    public Movie(Movie moviesInput) {
        this.name = moviesInput.getName();
        this.year = moviesInput.getYear();
        this.duration = moviesInput.getDuration();
        this.genres = moviesInput.getGenres();
        this.actors = moviesInput.getActors();
        this.countriesBanned = moviesInput.getCountriesBanned();
        this.numWatched = 0;
        this.numLiked = 0;
        this.numRating = 0;
        this.rating = 0;
    }

    public boolean contains(Contains contains) {
        boolean flag = false;
        if (contains == null)
            return true;
        if (contains.getActors() != null) {
            for (var actor : contains.getActors()) {
                for (var myActor : actors) {
                    if (myActor.equals(actor)) {
                        flag = true;
                    }
                }
                if (flag)
                    flag = false;
                else
                    return false;
            }
        }
        if (contains.getGenre() != null) {
            for (var genre : contains.getGenre()) {
                for (var myGenre : genres) {
                    if (myGenre.equals(genre)) {
                        flag = true;
                    }
                }
                if (flag)
                    flag = false;
                else
                    return false;
            }
        }
        return true;
    }

    public boolean checkCountry(String country) {
        for (var banned: countriesBanned) {
            if (banned.equals(country))
                return false;
        }
        return true;
    }

    public ObjectNode movieJSON(ObjectMapper mapper) {
        ObjectNode obj = mapper.createObjectNode();
        obj.put("name", name);
        obj.put("year", Integer.valueOf(year));
        obj.put("duration", duration);
        ArrayNode arr = mapper.createArrayNode();
        for (var genre: genres)
            arr.add(genre);
        obj.set("genres", arr);
        arr = mapper.createArrayNode();
        for (var actor: actors)
            arr.add(actor);
        obj.set("actors", arr);
        arr = mapper.createArrayNode();
        for (var countrieBanned: countriesBanned)
            arr.add(countrieBanned);
        obj.set("countriesBanned", arr);
        obj.put("numLikes", numLiked);
        obj.put("rating", rating / DECIMALS);
        obj.put("numRatings", numRating);
        return obj;
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
}
