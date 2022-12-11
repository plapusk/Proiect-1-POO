package user;

import input.CredentialsInput;
import input.UsersInput;
import movie.Movie;

import java.util.ArrayList;

public class User {
    private Credentials credentials;
    private ArrayList<Movie> movies;
    public User(UsersInput usersInput) {
        credentials = new Credentials(usersInput.getCredentials());
        this.movies = new ArrayList<>();
    }
}
