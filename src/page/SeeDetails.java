package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;
import movie.MovieDataBase;
import user.UserDataBase;

import java.util.ArrayList;

public class SeeDetails extends Page{
    private static SeeDetails instance = null;

    private SeeDetails() {
        super("see details");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
        subPages.add(MoviePage.getInstance());
        subPages.add(Upgrades.getInstance());
        subPages.add(NotLogged.getInstance());
    }
    public String onPage(ActionsInput action, PageHandler pageHandler) {
        if (action.getFeature().equals("purchase")) {
            if (pageHandler.getCurrentUser().buy(action.getMovie())) {
                return null;
            }
        } else if (action.getFeature().equals("watch")) {
            if (pageHandler.getCurrentUser().watch(action.getMovie())) {
                return null;
            }
        } else if (pageHandler.getCurrentUser().isWatched(action.getMovie())) {
            if (action.getFeature().equals("like")) {
                return null;
            } else if (action.getFeature().equals("rate")) {
                return null;
            }
        }
        return "Error";
    }

    public void getMovies(ActionsInput action, PageHandler pageHandler) {
        ArrayList <Movie> movies = new ArrayList<>();
        Movie movie = search(pageHandler.getPrintMovie(), action.getMovie());
        if (movie != null)
            movies.add(movie);
        pageHandler.copyMovies(movies);
    }

    private Movie search(ArrayList<Movie> movies, String name) {
        for (var movie: movies) {
            if (movie.getName().equals(name)) {
                return movie;
            }
        }
        return null;
    }

    public static SeeDetails getInstance() {
        if (instance == null) {
            instance = new SeeDetails();
            instance.init();
        }
        return instance;
    }
}
