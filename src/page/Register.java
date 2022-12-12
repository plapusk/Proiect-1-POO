package page;

import admin.PageHandler;
import input.ActionsInput;
import input.UsersInput;
import user.User;
import user.UserDataBase;

import java.util.ArrayList;

public class Register extends Page{
    private static Register instance = null;

    private Register() {
        super("register");
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
    }
    public String onPage(ActionsInput action, PageHandler pageHandler) {
        if (!action.getFeature().equals("register"))
            return "Error";

        pageHandler.setCurrentPage(NotLogged.getInstance());
        pageHandler.setUserError(null);
        if (UserDataBase.getInstance().userExist(action.getCredentials().getName()))
            return "Error";

        pageHandler.setCurrentPage(HomePage.getInstance());

        UsersInput user = new UsersInput();
        user.setCredentials(action.getCredentials());
        User newUser = new User(user);
        UserDataBase.getInstance().addUser(newUser);
        pageHandler.setUserError(newUser);
        return null;
    }
    public static Register getInstance(){
        if (instance == null)
            instance = new Register();
        return instance;
    }
}
