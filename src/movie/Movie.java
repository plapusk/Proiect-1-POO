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

    public Movie(final MoviesInput moviesInput) {
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

    public Movie(final Movie moviesInput) {
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

    /**
     * This functions goes through all the elements inside a Contains class and searches if they
     * also exist in their respective Array list from the movie
     * @param contains
     * @return if a movie contains the genres and actors inside a Contains class from the input
     */
    public final boolean contains(final Contains contains) {
        boolean flag = false;
        if (contains == null) {
            return true;
        }
        if (contains.getActors() != null) {
            for (var actor : contains.getActors()) {
                for (var myActor : actors) {
                    if (myActor.equals(actor)) {
                        flag = true;
                    }
                }
                if (flag) {
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        if (contains.getGenre() != null) {
            for (var genre : contains.getGenre()) {
                for (var myGenre : genres) {
                    if (myGenre.equals(genre)) {
                        flag = true;
                    }
                }
                if (flag) {
                    flag = false;
                } else {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * goes through all the  banned countries and sees if our country is banned
     * @param country
     * @return if country is banned
     */
    public final boolean checkCountry(final String country) {
        for (var banned: countriesBanned) {
            if (banned.equals(country)) {
                return false;
            }
        }
        return true;
    }

    /**
     * Adds all the relevant elements to a freshly created ObjectNode
     * @param mapper
     * @return Object Node of the movie class
     */
    public final ObjectNode movieJSON(final ObjectMapper mapper) {
        ObjectNode obj = mapper.createObjectNode();
        obj.put("name", name);
        obj.put("year", Integer.valueOf(year));
        obj.put("duration", duration);
        ArrayNode arr = mapper.createArrayNode();
        for (var genre: genres) {
            arr.add(genre);
        }
        obj.set("genres", arr);
        arr = mapper.createArrayNode();
        for (var actor: actors) {
            arr.add(actor);
        }
        obj.set("actors", arr);
        arr = mapper.createArrayNode();
        for (var countrieBanned: countriesBanned) {
            arr.add(countrieBanned);
        }
        obj.set("countriesBanned", arr);
        obj.put("numLikes", numLiked);
        obj.put("rating", rating / DECIMALS);
        obj.put("numRatings", numRating);
        return obj;
    }

    /**
     * changes the rating of a movie by the rating given by a user
     * @param x
     */
    public final void rate(final double x) {
        rating *= numRating;
        numRating++;
        rating += x * DECIMALS;
        rating /= numRating;
    }
    public final String getName() {
        return name;
    }

    public final void setName(final String name) {
        this.name = name;
    }

    public final String getYear() {
        return year;
    }

    public final void setYear(final String year) {
        this.year = year;
    }

    public final int getDuration() {
        return duration;
    }

    public final void setDuration(final int duration) {
        this.duration = duration;
    }

    public final ArrayList<String> getGenres() {
        return genres;
    }

    public final void setGenres(final ArrayList<String> genres) {
        this.genres = genres;
    }

    public final ArrayList<String> getActors() {
        return actors;
    }

    public final void setActors(final ArrayList<String> actors) {
        this.actors = actors;
    }

    public final ArrayList<String> getCountriesBanned() {
        return countriesBanned;
    }

    public final void setCountriesBanned(final ArrayList<String> countriesBanned) {
        this.countriesBanned = countriesBanned;
    }

    public final int getNumWatched() {
        return numWatched;
    }

    public final void setNumWatched(final int numWatched) {
        this.numWatched = numWatched;
    }

    public final int getNumLiked() {
        return numLiked;
    }

    public final void setNumLiked(final int numLiked) {
        this.numLiked = numLiked;
    }

    public final int getNumRating() {
        return numRating;
    }

    public final void setNumRating(final int numRating) {
        this.numRating = numRating;
    }

    public final double getRating() {
        return rating;
    }

    public final void setRating(final double rating) {
        this.rating = rating * DECIMALS;
    }
}
