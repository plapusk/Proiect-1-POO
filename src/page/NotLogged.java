package page;

import java.util.ArrayList;

public class NotLogged extends Page{
    private static NotLogged instance = null;

    private NotLogged() {
        super("logout");
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
        subPages.add(Login.getInstance());
        subPages.add(Register.getInstance());
    }

    public static NotLogged getInstance() {
        if (instance == null)
            instance = new NotLogged();
        return instance;
    }
}
