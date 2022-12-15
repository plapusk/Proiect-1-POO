package movie;

import java.util.ArrayList;

public final class MovieDataBase {
    private static MovieDataBase instance = null;
    private ArrayList<Movie> movies;
    private MovieDataBase() {

    }

    /**
     * lazy singleton
     * @return instance
     */
    public static MovieDataBase getInstance() {
        if (instance == null) {
            instance = new MovieDataBase();
        }
        return instance;
    }

    /**
     * Goes through all the movies and checks if they have the same name
     * @param name
     * @return the movie with the given name
     */
    public Movie find(final String name) {
        for (var movie: movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    /**
     * init a new MovieDataBase
     */
    public void newArray() {
        movies = new ArrayList<>();
    }

    public ArrayList<Movie> getMovies() {
        return movies;
    }

    public void setMovies(final ArrayList<Movie> movies) {
        this.movies = movies;
    }
}
