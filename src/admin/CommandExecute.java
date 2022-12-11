package admin;

import input.Input;
import input.MoviesInput;
import input.UsersInput;
import movie.Movie;
import movie.MovieDataBase;
import user.User;
import user.UserDataBase;

import java.util.ArrayList;

public class CommandExecute {
    private PageHandler pageHandler;
    private final Input input;
    public CommandExecute(Input input) {
        this.input = input;
        pageHandler = new PageHandler();
        UserDataBase.getInstance().newArray();
        UserDataBase.getInstance().setUsers(convertUserInput(input.getUsers()));
        MovieDataBase.getInstance().newArray();
        MovieDataBase.getInstance().setMovies(convertMovieInput(input.getMovies()));
    }

    private ArrayList<User> convertUserInput(ArrayList<UsersInput> usersInputs) {
        ArrayList<User> users = new ArrayList<>();
        for (var userInput: usersInputs) {
            users.add(new User(userInput));
        }
        return users;
    }

    private ArrayList<Movie> convertMovieInput(ArrayList<MoviesInput> moviesInputs) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (var movieInput: moviesInputs) {
            movies.add(new Movie(movieInput));
        }
        return movies;
    }
}
