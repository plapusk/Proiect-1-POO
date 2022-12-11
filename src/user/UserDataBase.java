package user;

import java.util.ArrayList;

public class UserDataBase {
    private static UserDataBase instance = null;
    public ArrayList<User> users;
    private UserDataBase(){}
    public static UserDataBase getInstance() {
        if(instance == null) {
            instance = new UserDataBase();
        }
        return instance;
    }

    public void newArray() {
        users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(ArrayList<User> users) {
        this.users = users;
    }
}
