package admin;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
import input.ActionsInput;
import input.Input;
import input.MoviesInput;
import input.UsersInput;
import movie.Movie;
import movie.MovieDataBase;
import page.MoviePage;
import user.User;
import user.UserDataBase;

import java.util.ArrayList;

public class CommandExecute {
    private PageHandler pageHandler;
    private final Input input;
    public CommandExecute(final Input input) {
        this.input = input;
        pageHandler = new PageHandler();
        UserDataBase.getInstance().newArray();
        UserDataBase.getInstance().setUsers(convertUserInput(input.getUsers()));
        MovieDataBase.getInstance().newArray();
        MovieDataBase.getInstance().setMovies(convertMovieInput(input.getMovies()));
    }

    private ArrayList<User> convertUserInput(final ArrayList<UsersInput> usersInputs) {
        ArrayList<User> users = new ArrayList<>();
        for (var userInput: usersInputs) {
            users.add(new User(userInput));
        }
        return users;
    }

    private ArrayList<Movie> convertMovieInput(final ArrayList<MoviesInput> moviesInputs) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (var movieInput: moviesInputs) {
            movies.add(new Movie(movieInput));
        }
        return movies;
    }

    /**
     *
     * @param mapper
     * @return output
     */
    public ArrayNode doCommand(final ObjectMapper mapper) {
        ArrayNode output = mapper.createArrayNode();
        for (var action: input.getActions()) {
            if (action.getType().equals("change page")) {
                output = changePage(mapper, output, action);
            } else if (action.getType().equals("on page")) {
                String error = pageHandler.getCurrentPage().onPage(action, pageHandler);
                if (error == null || error.equals("Error")) {
                    output.add(createError(mapper, error));
                }
            } else {
                output.add(createError(mapper, "Error"));
            }
        }
        return output;
    }

    private ArrayNode changePage(final ObjectMapper mapper,
                                 final ArrayNode output, final ActionsInput action) {
        if (action.getPage().equals("logout")) {
            pageHandler.setCurrentUser(null);
        }
        if (pageHandler.changePage(action.getPage()) == 0) {
            pageHandler.getCurrentPage().getMovies(action, pageHandler);
            if (pageHandler.getCurrentPage().getName().equals("movies")) {
                output.add(createError(mapper, null));
            }
            if (pageHandler.getCurrentPage().getName().equals("see details")) {
                if (pageHandler.getPrintMovie().size() > 0) {
                    output.add(createError(mapper, null));
                } else {
                    pageHandler.setCurrentPage(MoviePage.getInstance());
                    MoviePage.getInstance().getMovies(action, pageHandler);
                    output.add(createError(mapper, "Error"));
                }
            }
            return output;
        }

        output.add(createError(mapper, "Error"));
        return output;
    }

    private ObjectNode createError(final ObjectMapper mapper, final String error) {
        ObjectNode obj = mapper.createObjectNode();
        if (error != null) {
            obj.put("error", error);
            obj.set("currentMoviesList", mapper.createArrayNode());
            obj.put("currentUser", mapper.nullNode());
            return obj;
        } else {
            obj.put("error", mapper.nullNode());
        }

        obj.set("currentMoviesList", getMovieJSON(mapper, pageHandler.getPrintMovie()));
        if (pageHandler.getCurrentUser() == null) {
            obj.put("currentUser", mapper.nullNode());
        } else {
            obj.put("currentUser", pageHandler.getCurrentUser().getJSON(mapper));
        }
        return obj;
    }

    private ArrayNode getMovieJSON(final ObjectMapper mapper, final ArrayList<Movie> movies) {
        ArrayNode arr = mapper.createArrayNode();
        for (var movie: movies) {
            arr.add(movie.movieJSON(mapper));
        }
        return arr;
    }
}
