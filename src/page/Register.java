package page;

import admin.PageHandler;
import input.ActionsInput;
import input.UsersInput;
import movie.Movie;
import user.User;
import user.UserDataBase;

import java.util.ArrayList;

public final class Register extends Page {
    private static Register instance = null;

    private Register() {
        super("register");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
    }

    /**
     * If we have the feature login we check if the user was not used before. If we succeed we
     * change the page to logged in
     * @param action
     * @param pageHandler
     * @return
     */
    public String onPage(final ActionsInput action, final PageHandler pageHandler) {
        if (!action.getFeature().equals("register")) {
            return "Error";
        }

        pageHandler.setCurrentPage(NotLogged.getInstance());
        if (UserDataBase.getInstance().userExist(action.getCredentials().getName())) {
            return "Error";
        }

        pageHandler.setCurrentPage(HomePage.getInstance());

        UsersInput user = new UsersInput();
        user.setCredentials(action.getCredentials());
        User newUser = new User(user);
        UserDataBase.getInstance().addUser(newUser);
        pageHandler.setCurrentUser(newUser);
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
     * Lazy singleton
     * @return
     */
    public static Register getInstance() {
        if (instance == null) {
            instance = new Register();
            instance.init();
        }
        return instance;
    }
}
