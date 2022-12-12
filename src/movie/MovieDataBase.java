package movie;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.node.ArrayNode;

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

    public ArrayNode getJSON(ObjectMapper mapper) {
        ArrayNode arr = mapper.createArrayNode();
        for (var movie: movies)
            arr.add(movie.movieJSON(mapper));
        return arr;
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
