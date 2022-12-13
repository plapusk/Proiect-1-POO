package user;

import java.util.ArrayList;

public final class UserDataBase {
    private static UserDataBase instance = null;
    private ArrayList<User> users;
    private UserDataBase() {

    }

    /**
     * Lazy singleton
     * @return
     */
    public static UserDataBase getInstance() {
        if (instance == null) {
            instance = new UserDataBase();
        }
        return instance;
    }

    /**
     *
     * @param name
     * @param password
     * @return
     */
    public User checkUser(final String name, final String password) {
        for (var user: users) {
            if (user.getCredentials().getName().equals(name)
                    && user.getCredentials().getPassword().equals(password)) {
                return user;
            }
        }
        return null;
    }

    /**
     *
     * @param name
     * @return
     */
    public boolean userExist(final String name) {
        for (var user: users) {
            if (user.getCredentials().getName() == name) {
                return true;
            }
        }
        return false;
    }

    /**
     *
     */
    public void newArray() {
        users = new ArrayList<>();
    }

    public ArrayList<User> getUsers() {
        return users;
    }

    public void setUsers(final ArrayList<User> users) {
        this.users = users;
    }

    /**
     *
     * @param user
     */
    public void addUser(final User user) {
        users.add(user);
    }
}
