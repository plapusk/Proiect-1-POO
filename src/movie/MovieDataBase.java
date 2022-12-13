package movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

import java.util.ArrayList;

public class MovieDataBase {
    private static MovieDataBase instance = null;
    private ArrayList<Movie> movies;
    private MovieDataBase(){}
    public static MovieDataBase getInstance() {
        if(instance == null) {
            instance = new MovieDataBase();
        }
        return instance;
    }

    public Movie find(String name) {
        for (var movie: movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
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
