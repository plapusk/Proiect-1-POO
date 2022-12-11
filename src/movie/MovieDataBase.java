package movie;

import java.util.ArrayList;

public class MovieDataBase {
    private static MovieDataBase instance = null;
    public ArrayList<Movie> movies;
    private MovieDataBase(){}
    public static MovieDataBase getInstance() {
        if(instance == null) {
            instance = new MovieDataBase();
        }
        return instance;
    }

    public void newArray() {
        movies = new ArrayList<>();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
