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


    public User checkUser(String name, String password) {
        for (var user: users)
            if (user.getCredentials().getName().equals(name) &&
                    user.getCredentials().getPassword().equals(password))
                return user;
        return null;
    }

    public boolean userExist(String name) {
        for (var user: users)
            if (user.getCredentials().getName() == name)
                return true;
        return false;
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

    public void addUser(User user) {
        users.add(user);
    }
}
