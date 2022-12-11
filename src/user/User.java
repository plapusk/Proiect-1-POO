package user;

import input.CredentialsInput;
import input.UsersInput;
import movie.Movie;

import java.util.ArrayList;

public class User {
    private Credentials credentials;
    private ArrayList<Movie> movies;
    private ArrayList<Movie> watchedMovies;
    private ArrayList<Movie> likedMovies;
    public User(UsersInput usersInput) {
        credentials = new Credentials(usersInput.getCredentials());
        this.movies = new ArrayList<>();
        this.watchedMovies = new ArrayList<>();
        this.likedMovies = new ArrayList<>();
    }
}
