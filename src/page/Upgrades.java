package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;
import user.UserDataBase;

import java.util.ArrayList;

public class Upgrades extends Page{
    private static Upgrades instance = null;

    private Upgrades() {
        super("upgrades");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
        subPages.add(MoviePage.getInstance());
        subPages.add(NotLogged.getInstance());
    }
    public String onPage(ActionsInput action, PageHandler pageHandler) {
        if (action.getFeature().equals("buy tokens") && Integer.valueOf(action.getCount()) <=
                pageHandler.getCurrentUser().getCredentials().getBalance()) {
            pageHandler.getCurrentUser().buyTokens(Integer.valueOf(action.getCount()));
            return "fine";
        } else if (action.getFeature().equals("buy premium account") &&
                pageHandler.getCurrentUser().hasPremiumTokens() &&
                !pageHandler.getCurrentUser().getCredentials().isPremium()) {
            pageHandler.getCurrentUser().setPremium();
            pageHandler.getCurrentUser().payPremium();
            return "fine";
        }
        return "Error";
    }

    public void getMovies(ActionsInput action, PageHandler pageHandler) {
        ArrayList <Movie> movies = new ArrayList<>();
        pageHandler.copyMovies(movies);
    }

    public static Upgrades getInstance() {
        if (instance == null) {
            instance = new Upgrades();
            instance.init();
        }
        return instance;
    }
}
