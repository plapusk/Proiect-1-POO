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
     *
     * @param name
     * @return
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
     *
     * @param name
     */
    public void like(final String name) {
        Movie movie = find(name);
        movie.setNumLiked(movie.getNumLiked() + 1);
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
