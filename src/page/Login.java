package page;

import admin.PageHandler;
import input.ActionsInput;
import movie.Movie;
import user.UserDataBase;

import java.util.ArrayList;

public final class Login extends Page {
    private static Login instance = null;

    private Login() {
        super("login");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
    }

    /**
     * If we have the feature login we check if we have the right credentials. If we succeed we
     * change the page to logged in
     * @param action
     * @param pageHandler
     * @return error or success
     */
    public String onPage(final ActionsInput action, final PageHandler pageHandler) {
        if (!action.getFeature().equals("login")) {
            return "Error";
        }

        pageHandler.setCurrentUser(UserDataBase.getInstance().checkUser(
                action.getCredentials().getName(), action.getCredentials().getPassword()));

        if (pageHandler.getCurrentUser() == null) {
            pageHandler.setCurrentPage(NotLogged.getInstance());
            return "Error";
        }
        pageHandler.setCurrentPage(HomePage.getInstance());
        return null;
    }

    /**
     * change the movie list to an empty one because we have no movies on this page
     * @param action
     * @param pageHandler
     */
    public void getMovies(final ActionsInput action, final PageHandler pageHandler) {
        ArrayList<Movie> movies = new ArrayList<>();
        pageHandler.copyMovies(movies);
    }

    /**
     * Lazy Singleton
     * @return
     */
    public static Login getInstance() {
        if (instance == null) {
            instance = new Login();
            instance.init();
        }
        return instance;
    }
}
