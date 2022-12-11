package page;

import java.util.ArrayList;

public class Register extends Page{
    private static Register instance = null;

    private Register() {
        super("register");
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
    }

    public static Register getInstance(){
        if (instance == null)
            instance = new Register();
        return instance;
    }
}
