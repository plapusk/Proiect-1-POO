package user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.UsersInput;
import movie.Movie;
import movie.MovieDataBase;

import java.util.ArrayList;

public class User {
    private Credentials credentials;
    private int tokenCount;
    private int freeMovies;
    private ArrayList<Movie> movies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;

    private ArrayList<Movie> ratedMovies;
    private static final int NUMBER_FREE_MOVIES = 15;
    private static final int PREMIUM_PRICE = 10;

    public User(UsersInput usersInput) {
        credentials = new Credentials(usersInput.getCredentials());
        this.movies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
        this.tokenCount = 0;
        if (credentials.isPremium())
            setPremium();
    }

    public boolean isWatched(String name) {
        for (var movie: watchedMovies) {
            if (movie.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    public boolean buy(String name) {
        if (freeMovies <= 0 && tokenCount < 2) {
            return false;
        }
        Movie movie = new Movie(MovieDataBase.getInstance().find(name));
        if (movie == null)
            return false;
        movies.add(movie);
        return true;
    }

    public Movie isBought(String name) {
        for (var movie: movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }
    public boolean watch(String name) {
        Movie movie = isBought(name);
        if (movie == null)
            return false;
        watchedMovies.add(movie);
        return true;
    }

    public void buyTokens(int x) {
        credentials.setBalance(credentials.getBalance() - x);
        tokenCount += x;
    }

    public ArrayNode getMoviesJSON(ArrayList<Movie> movies, ObjectMapper mapper) {
        ArrayNode arr = mapper.createArrayNode();
        for (var movie: movies)
            arr.add(movie.movieJSON(mapper));
        return arr;
    }

    public ObjectNode getJSON(ObjectMapper mapper) {
        ObjectNode obj = mapper.createObjectNode();
        obj.put("credentials", credentials.getJSON(mapper));
        obj.put("tokensCount", tokenCount);
        obj.put("numFreePremiumMovies", NUMBER_FREE_MOVIES);
        obj.set("purchasedMovies", getMoviesJSON(movies, mapper));
        obj.set("watchedMovies", getMoviesJSON(watchedMovies, mapper));
        obj.set("likedMovies", getMoviesJSON(likedMovies, mapper));
        obj.set("ratedMovies", getMoviesJSON(ratedMovies, mapper));
        return obj;
    }

    public boolean hasPremiumTokens() {
        return PREMIUM_PRICE <= tokenCount;
    }

    public Credentials getCredentials() {
        return credentials;
    }

    public void setCredentials(Credentials credentials) {
        this.credentials = credentials;
    }

    public int getTokenCount() {
        return tokenCount;
    }

    public void setTokenCount(int tokenCount) {
        this.tokenCount = tokenCount;
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public void setWatchedMovies(ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    public void setLikedMovies(ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    public void setPremium() {
        credentials.setPremium(true);
        freeMovies = NUMBER_FREE_MOVIES;
    }
    public void payPremium() {
        tokenCount -= PREMIUM_PRICE;
    }
}
