package admin;

import input.Sort;
import movie.Movie;
import page.NotLogged;
import page.Page;
import user.User;

import java.util.ArrayList;
import java.util.Comparator;

public class PageHandler {
    private Page currentPage;
    private User currentUser;
    private ArrayList<Movie> printMovie;
    public PageHandler() {
        printMovie = new ArrayList<>();
        currentPage = NotLogged.getInstance();
        currentUser = null;
    }

    /**
     *
     * @param name
     * @return
     */
    public int changePage(final String name) {
        Page newPage = currentPage.changePage(name);
        if (newPage == null) {
            return -1;
        }
        currentPage = newPage;
        return 0;
    }

    /**
     *
     * @param sort
     */
    public void sort(final Sort sort) {
        if (sort == null) {
            return;
        }
        int rateOrder, durationOrder;
        if (sort.getRating() == null) {
            rateOrder = 0;
        } else if (sort.getRating().equals("decreasing")) {
            rateOrder = -1;
        } else {
            rateOrder = 1;
        }
        if (sort.getDuration() == null) {
            durationOrder = 0;
        } else if (sort.getDuration().equals("decreasing")) {
            durationOrder = -1;
        } else {
            durationOrder = 1;
        }
        Comparator<Movie> comparator = (Movie m1, Movie m2) -> convertBool(durationOrder
                * Integer.valueOf(m1.getDuration()).compareTo(m2.getDuration()) == 0) * rateOrder
                * Double.valueOf(m1.getRating()).compareTo(m2.getRating()) + durationOrder
                * Integer.valueOf(m1.getDuration()).compareTo(m2.getDuration());
        printMovie.sort(comparator);
    }

    private int convertBool(final boolean x) {
        if (x) {
            return 1;
        }
        return 0;
    }

    public final Page getCurrentPage() {
        return currentPage;
    }

    public final void setCurrentPage(final Page currentPage) {
        this.currentPage = currentPage;
    }

    public final User getCurrentUser() {
        return currentUser;
    }

    public final void setCurrentUser(final User currentUser) {
        this.currentUser = currentUser;
    }

    public final ArrayList<Movie> getPrintMovie() {
        return printMovie;
    }

    public final void setPrintMovie(final ArrayList<Movie> printMovie) {
        this.printMovie = printMovie;
    }

    /**
     *
     * @param movies
     */
    public void copyMovies(final ArrayList<Movie> movies) {
        printMovie = new ArrayList<>();
        for (var movie: movies) {
            if (currentUser == null || movie.checkCountry(currentUser.
                    getCredentials().getCountry())) {
                printMovie.add(movie);
            }
        }
    }

}
