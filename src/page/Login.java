package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;
import user.User;
import user.UserDataBase;

import java.util.ArrayList;

public class Login extends Page{
    private static Login instance = null;

    private Login() {
        super("login");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
    }
    public String onPage(ActionsInput action, PageHandler pageHandler) {
        if (!action.getFeature().equals("login"))
            return "Error";

        pageHandler.setCurrentUser(UserDataBase.getInstance().checkUser(
                action.getCredentials().getName(), action.getCredentials().getPassword()));

        if (pageHandler.getCurrentUser() == null) {
            pageHandler.setCurrentPage(NotLogged.getInstance());
            return "Error";
        }
        pageHandler.setCurrentPage(HomePage.getInstance());
        return null;
    }

    public void getMovies(ActionsInput action, PageHandler pageHandler) {
        ArrayList <Movie> movies = new ArrayList<>();
        pageHandler.copyMovies(movies);
    }

    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
            instance.init();
        }
        return instance;
    }
}
