package admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import com.fasterxml.jackson.databind.util.JSONPObject;
import input.ActionsInput;
import input.Input;
import input.MoviesInput;
import input.UsersInput;
import movie.Movie;
import movie.MovieDataBase;
import user.User;
import user.UserDataBase;
import page.Page;

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

    public ArrayNode doCommand(ObjectMapper mapper) {
        ArrayNode output = mapper.createArrayNode();
        for (var action: input.getActions()) {
            if(action.getType().equals("change page")) {

            } else if (action.getType().equals("change page")) {

            }
        }
        return output;
    }

    private ArrayNode changePage(ObjectMapper mapper, ArrayNode output, ActionsInput action) {
        if (pageHandler.changePage(action.getPage()) == 0)
            return output;
        ObjectNode obj = mapper.createObjectNode();
        obj.put("error", "Error");
        if (pageHandler.getCurrentUser() == null) {
            obj.set("currentMoviesList", mapper.createArrayNode());
            obj.put("currentUser", mapper.nullNode());
        } else {
            //obj.set("currentMoviesList", pageHandler.getCurrentUser().)
        }
        return output;
    }
}
