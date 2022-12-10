package input;

import java.util.ArrayList;
public class Input {
    private ArrayList<UsersInput> users;
    private ArrayList<MoviesInput> movies;
    private ArrayList<ActionsInput> actions;

    public ArrayList<input.UsersInput> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<input.UsersInput> users) {
        this.users = users;
    }

    public ArrayList<input.MoviesInput> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<input.MoviesInput> movies) {
        this.movies = movies;
    }

    public ArrayList<input.ActionsInput> getActions() {
        return actions;
    }

    public void setActions(ArrayList<input.ActionsInput> actions) {
        this.actions = actions;
    }

    @Override
    public String toString() {
        return "Input{" +
                "users=" + users +
                ", movies=" + movies +
                ", actions=" + actions +
                '}';
    }
}
