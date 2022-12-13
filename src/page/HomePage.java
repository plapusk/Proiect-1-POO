package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;

import java.util.ArrayList;

public class HomePage extends Page{
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
    public String onPage(ActionsInput action, PageHandler pageHandler) {
        return "Error";
    }

    public void getMovies(ActionsInput action ,PageHandler pageHandler) {
        ArrayList <Movie> movies = new ArrayList<>();
        pageHandler.copyMovies(movies);
    }

    public static HomePage getInstance() {
        if (instance == null) {
            instance = new HomePage();
            instance.init();
        }
        return instance;
    }
}
