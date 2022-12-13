package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;

import java.awt.event.HierarchyBoundsAdapter;
import java.util.ArrayList;

public class NotLogged extends Page{
    private static NotLogged instance = null;

    private NotLogged() {
        super("logout");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
        subPages.add(Login.getInstance());
        subPages.add(Register.getInstance());
        subPages.add(HomePage.getInstance());
    }

    public String onPage(ActionsInput action, PageHandler pageHandler) {
        return "Error";
    }

    public void getMovies(ActionsInput action, PageHandler pageHandler) {
        ArrayList <Movie> movies = new ArrayList<>();
        pageHandler.copyMovies(movies);
    }
    public static NotLogged getInstance() {
        if (instance == null) {
            instance = new NotLogged();
            instance.init();
        }
        return instance;
    }
}
