package page;

import java.util.ArrayList;

public class HomePage extends Page{
    private static HomePage instance = null;

    private HomePage() {
        super("homepage autentificat");
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
    }

    public static HomePage getInstance() {
        if (instance == null)
            instance = new HomePage();
        return instance;
    }
}
