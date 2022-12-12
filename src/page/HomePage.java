package page;

import admin.PageHandler;
import input.ActionsInput;

import java.util.ArrayList;

public class HomePage extends Page{
    private static HomePage instance = null;

    private HomePage() {
        super("homepage autentificat");
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
        subPages.add(NotLogged.getInstance());
    }

    public String onPage(ActionsInput action, PageHandler pageHandler) {
        pageHandler.setUserError(pageHandler.getCurrentUser());
        return "Error";
    }

    public static HomePage getInstance() {
        if (instance == null)
            instance = new HomePage();
        return instance;
    }
}
