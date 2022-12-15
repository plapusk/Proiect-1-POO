package user;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.UsersInput;
import movie.Movie;

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
    private static final int MAX_RATE = 5;

    public User(final UsersInput usersInput) {
        credentials = new Credentials(usersInput.getCredentials());
        this.movies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
        this.ratedMovies = new ArrayList<>();
        this.tokenCount = 0;
        freeMovies = NUMBER_FREE_MOVIES;
        if (credentials.isPremium()) {
            setPremium();
        }
    }

    /**
     * @param name
     * @return if movie was watched
     */
    public final boolean isWatched(final String name) {
        for (var movie: watchedMovies) {
            if (movie.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * We pay for the movie and add it into bought list
     * @param movie
     * @return error or success
     */
    public final boolean buy(final Movie movie) {
        if ((freeMovies <= 0 || !credentials.isPremium()) && tokenCount < 2) {
            return false;
        } else if (freeMovies > 0 && credentials.isPremium()) {
            freeMovies--;
        } else {
            tokenCount -= 2;
        }
        movies.add(movie);
        return true;
    }

    /**
     * @param name
     * @return if movie was bought
     */
    public final boolean isBought(final String name) {
        for (var movie: movies) {
            if (movie.getName().equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * add movie to watched list
     * @param movie
     * @return
     */
    public final boolean watch(final Movie movie) {
        if (!isBought(movie.getName())) {
            return false;
        }
        watchedMovies.add(movie);
        return true;
    }

    /**
     * Get the movie we like add it into liked list and change statistics in Database
     * @param name
     */
    public final void like(final String name) {
        Movie likedMovie;
        for (var movie: watchedMovies) {
            if (movie.getName().equals(name)) {
                likedMovie = movie;
                likedMovie.setNumLiked(likedMovie.getNumLiked() + 1);
                likedMovies.add(likedMovie);
            }
        }
    }

    /**
     * Get the movie we rate add it into rated list and change statistics in Database
     * @param name
     * @param rate
     * @return if we rated successfully
     */
    public final String rate(final String name, final double rate) {
        if (rate < 1 || rate > MAX_RATE) {
            return "Error";
        }
        Movie ratedMovie;
        for (var movie: watchedMovies) {
            if (movie.getName().equals(name)) {
                ratedMovie = movie;
                ratedMovie.rate(rate);
                ratedMovies.add(ratedMovie);
            }
        }
        return null;
    }

    /**
     * Add tokens pay in balance
     * @param x
     */
    public final void buyTokens(final int x) {
        credentials.setBalance(credentials.getBalance() - x);
        tokenCount += x;
    }

    /**
     * @param moviesNode
     * @param mapper
     * @return ArrayNode for a list of movies
     */
    public final ArrayNode getMoviesJSON(final ArrayList<Movie> moviesNode,
                                         final ObjectMapper mapper) {
        ArrayNode arr = mapper.createArrayNode();
        for (var movie: moviesNode) {
            arr.add(movie.movieJSON(mapper));
        }
        return arr;
    }

    /**
     * @param mapper
     * @return ObjectNode for the User class
     */
    public final ObjectNode getJSON(final ObjectMapper mapper) {
        ObjectNode obj = mapper.createObjectNode();
        obj.put("credentials", credentials.getJSON(mapper));
        obj.put("tokensCount", tokenCount);
        obj.put("numFreePremiumMovies", freeMovies);
        obj.set("purchasedMovies", getMoviesJSON(movies, mapper));
        obj.set("watchedMovies", getMoviesJSON(watchedMovies, mapper));
        obj.set("likedMovies", getMoviesJSON(likedMovies, mapper));
        obj.set("ratedMovies", getMoviesJSON(ratedMovies, mapper));
        return obj;
    }

    /**
     * @return returns if the user can buy premium
     */
    public boolean hasPremiumTokens() {
        return PREMIUM_PRICE <= tokenCount;
    }

    public final Credentials getCredentials() {
        return credentials;
    }

    public final void setCredentials(final Credentials credentials) {
        this.credentials = credentials;
    }

    public final int getTokenCount() {
        return tokenCount;
    }

    public final void setTokenCount(final int tokenCount) {
        this.tokenCount = tokenCount;
    }

    public final ArrayList<Movie> getMovies() {
        return movies;
    }

    public final void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }

    public final ArrayList<Movie> getWatchedMovies() {
        return watchedMovies;
    }

    public final void setWatchedMovies(final ArrayList<Movie> watchedMovies) {
        this.watchedMovies = watchedMovies;
    }

    public final ArrayList<Movie> getLikedMovies() {
        return likedMovies;
    }

    public final void setLikedMovies(final ArrayList<Movie> likedMovies) {
        this.likedMovies = likedMovies;
    }

    /**
     * set user to premium
     */
    public void setPremium() {
        credentials.setPremium(true);
    }

    /**
     * Pay for premium
     */
    public void payPremium() {
        tokenCount -= PREMIUM_PRICE;
    }
}
