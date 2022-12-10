package admin;

import java.util.ArrayList;

public class UserDataBase {
    private static UserDataBase instance = null;
    public ArrayList<Integer> users;
    private UserDataBase(){}
    public static UserDataBase getInstance() {
        if(instance == null) {
            instance = new UserDataBase();
        }
        return instance;
    }

    void newArray() {
        users = new ArrayList<>();
    }
}
