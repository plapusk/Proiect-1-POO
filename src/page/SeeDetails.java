package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;

import java.util.ArrayList;

public final class SeeDetails extends Page {
    private static SeeDetails instance = null;

    private SeeDetails() {
        super("see details");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
        subPages.add(MoviePage.getInstance());
        subPages.add(HomePage.getInstance());
        subPages.add(Upgrades.getInstance());
        subPages.add(NotLogged.getInstance());
    }

    /**
     *
     * @param action
     * @param pageHandler
     * @return
     */
    public String onPage(final ActionsInput action, final PageHandler pageHandler) {
        if (action.getFeature().equals("purchase")) {
            if (pageHandler.getCurrentUser().buy(pageHandler.getPrintMovie().get(0))) {
                return null;
            }
        } else if (action.getFeature().equals("watch")) {
            if (pageHandler.getCurrentUser().watch(pageHandler.getPrintMovie().get(0))) {
                return null;
            }
        } else if (pageHandler.getCurrentUser().isWatched(pageHandler.getPrintMovie().
                get(0).getName())) {
            if (action.getFeature().equals("like")) {
                pageHandler.getCurrentUser().like(pageHandler.getPrintMovie().get(0).getName());
                return null;
            } else if (action.getFeature().equals("rate")) {
                return pageHandler.getCurrentUser().rate(pageHandler.getPrintMovie().get(0).
                        getName(), action.getRate());
            }
        }
        return "Error";
    }

    /**
     *
     * @param action
     * @param pageHandler
     */
    public void getMovies(final ActionsInput action, final PageHandler pageHandler) {
        ArrayList<Movie> movies = new ArrayList<>();
        Movie movie = search(pageHandler.getPrintMovie(), action.getMovie());
        if (movie != null) {
            movies.add(movie);
        }
        pageHandler.copyMovies(movies);
    }

    /**
     *
     * @param movies
     * @param name
     * @return
     */
    private Movie search(final ArrayList<Movie> movies, final String name) {
        for (var movie: movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    /**
     * Lazy singleton
     * @return
     */
    public static SeeDetails getInstance() {
        if (instance == null) {
            instance = new SeeDetails();
            instance.init();
        }
        return instance;
    }
}
