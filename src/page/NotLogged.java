package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;

import java.util.ArrayList;

public final class NotLogged extends Page {
    private static NotLogged instance = null;

    private NotLogged() {
        super("logout");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(Login.getInstance());
        subPages.add(Register.getInstance());
        subPages.add(HomePage.getInstance());
    }

    /**
     *
     * @param action
     * @param pageHandler
     * @return
     */
    public String onPage(final ActionsInput action, final PageHandler pageHandler) {
        return "Error";
    }

    /**
     *
     * @param action
     * @param pageHandler
     */
    public void getMovies(final ActionsInput action, final PageHandler pageHandler) {
        ArrayList<Movie> movies = new ArrayList<>();
        pageHandler.copyMovies(movies);
    }

    /**
     *
     * @return
     */
    public static NotLogged getInstance() {
        if (instance == null) {
            instance = new NotLogged();
            instance.init();
        }
        return instance;
    }
}
