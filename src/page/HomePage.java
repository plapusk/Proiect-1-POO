package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;

import java.util.ArrayList;

public final class HomePage extends Page {
    private static HomePage instance = null;

    private HomePage() {
        super("homepage autentificat");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
        subPages.add(NotLogged.getInstance());
        subPages.add(MoviePage.getInstance());
        subPages.add(Upgrades.getInstance());
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
     * Lazy singleton
     * @return
     */
    public static HomePage getInstance() {
        if (instance == null) {
            instance = new HomePage();
            instance.init();
        }
        return instance;
    }
}
