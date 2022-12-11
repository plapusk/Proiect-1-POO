package page;

import java.util.ArrayList;

public class Login extends Page{
    private static Login instance = null;

    private Login() {
        super("login");
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
    }

    public static Login getInstance() {
        if (instance == null)
            instance = new Login();
        return instance;
    }
}
