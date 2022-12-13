package page;

import admin.PageHandler;
import input.ActionsInput;
import input.UsersInput;
import movie.Movie;
import user.User;
import user.UserDataBase;

import java.util.ArrayList;

public class Register extends Page{
    private static Register instance = null;

    private Register() {
        super("register");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
    }

    public String onPage(ActionsInput action, PageHandler pageHandler) {
        if (!action.getFeature().equals("register"))
            return "Error";

        pageHandler.setCurrentPage(NotLogged.getInstance());
        if (UserDataBase.getInstance().userExist(action.getCredentials().getName()))
            return "Error";

        pageHandler.setCurrentPage(HomePage.getInstance());

        UsersInput user = new UsersInput();
        user.setCredentials(action.getCredentials());
        User newUser = new User(user);
        UserDataBase.getInstance().addUser(newUser);
        pageHandler.setCurrentUser(newUser);
        return null;
    }

    public void getMovies(ActionsInput action, PageHandler pageHandler) {
        ArrayList <Movie> movies = new ArrayList<>();
        pageHandler.copyMovies(movies);
    }
    public static Register getInstance(){
        if (instance == null) {
            instance = new Register();
            instance.init();
        }
        return instance;
    }
}
