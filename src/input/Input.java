package input;

import java.util.ArrayList;
public class Input {
    private ArrayList<UsersInput> users;
    private ArrayList<MoviesInput> movies;
    private ArrayList<ActionsInput> actions;

    public final ArrayList<input.UsersInput> getUsers() {
        return users;
    }

    public final void setUsers(final ArrayList<input.UsersInput> users) {
        this.users = users;
    }

    public final ArrayList<input.MoviesInput> getMovies() {
        return movies;
    }

    public final void setMovies(final ArrayList<input.MoviesInput> movies) {
        this.movies = movies;
    }

    public final ArrayList<input.ActionsInput> getActions() {
        return actions;
    }

    public final void setActions(final ArrayList<input.ActionsInput> actions) {
        this.actions = actions;
    }
}
