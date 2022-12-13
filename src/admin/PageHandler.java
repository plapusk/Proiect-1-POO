package admin;

import movie.Movie;
import page.NotLogged;
import page.Page;
import user.User;

import java.util.ArrayList;

public class PageHandler {
    private Page currentPage;
    private User currentUser;
    private ArrayList<Movie> printMovie;
    public PageHandler() {
        printMovie = new ArrayList<>();
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

    public ArrayList<Movie> getPrintMovie() {
        return printMovie;
    }

    public void setPrintMovie(ArrayList<Movie> printMovie) {
        this.printMovie = printMovie;
    }

    public void copyMovies(ArrayList<Movie> movies) {
        printMovie = new ArrayList<>();
        for (var movie: movies) {
            if (currentUser == null || movie.checkCountry(currentUser.getCredentials().getCountry())) {
                printMovie.add(movie);
            }
        }
    }


}
