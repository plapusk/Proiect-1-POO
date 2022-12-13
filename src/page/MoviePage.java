package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;
import movie.MovieDataBase;

import java.util.ArrayList;

public final class MoviePage extends Page {
    private static MoviePage instance = null;

    private MoviePage() {
        super("movies");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
        subPages.add(NotLogged.getInstance());
        subPages.add(HomePage.getInstance());
        subPages.add(SeeDetails.getInstance());
    }

    /**
     *
     * @param action
     * @param pageHandler
     * @return
     */
    public String onPage(final ActionsInput action, final PageHandler pageHandler) {
        if (action.getFeature().equals("search")) {
            pageHandler.setPrintMovie(search(action, pageHandler));
            return null;
        } else if (action.getFeature().equals("filter")) {
            pageHandler.copyMovies(filter(action, pageHandler));
            return null;
        }
        return "Error";
    }

    /**
     *
     * @param action
     * @param pageHandler
     * @return
     */
    public ArrayList<Movie> search(final ActionsInput action, final PageHandler pageHandler) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (var movie: pageHandler.getPrintMovie()) {
            if (movie.getName().startsWith(action.getStartsWith())) {
                movies.add(movie);
            }
        }
        return movies;
    }

    /**
     *
     * @param action
     * @param pageHandler
     * @return
     */
    public ArrayList<Movie> filter(final ActionsInput action, final PageHandler pageHandler) {
        pageHandler.copyMovies(MovieDataBase.getInstance().getMovies());
        ArrayList<Movie> movies = pageHandler.getPrintMovie();
        movies.removeIf((x) -> !x.contains(action.getFilters().getContains()));
        pageHandler.sort(action.getFilters().getSort());
        return movies;
    }

    /**
     *
     * @param action
     * @param pageHandler
     */
    public void getMovies(final ActionsInput action, final PageHandler pageHandler) {
        ArrayList<Movie> movies = MovieDataBase.getInstance().getMovies();
        pageHandler.copyMovies(movies);
    }

    /**
     * Lazy Singleton
     * @return
     */
    public static MoviePage getInstance() {
        if (instance == null) {
            instance = new MoviePage();
            instance.init();
        }
        return instance;
    }
}
