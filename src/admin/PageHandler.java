package admin;

import page.NotLogged;
import page.Page;
import user.User;

public class PageHandler {
    private Page currentPage;
    private User currentUser;
    private User userError;
    public PageHandler() {
        currentPage = NotLogged.getInstance();
        currentUser = null;
    }

    public int changePage(String name) {
        Page newPage = currentPage.changePage(name);
        if (newPage == null) {
            return -1;
        }
        currentPage = newPage;
        return 0;
    }

    public Page getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(Page currentPage) {
        this.currentPage = currentPage;
    }

    public User getCurrentUser() {
        return currentUser;
    }

    public void setCurrentUser(User currentUser) {
        this.currentUser = currentUser;
    }

    public User getUserError() {
        return userError;
    }

    public void setUserError(User userError) {
        this.userError = userError;
    }
}
