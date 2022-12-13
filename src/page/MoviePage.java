package page;

import admin.PageHandler;
import input.ActionsInput;
import input.UsersInput;
import movie.Movie;
import movie.MovieDataBase;
import user.User;
import user.UserDataBase;

import java.util.ArrayList;

public class MoviePage extends Page{
    private static MoviePage instance = null;

    private MoviePage() {
        super("movies");
    }

    void init() {
        ArrayList<Page> subPages = super.getSubPages();
        subPages.add(this);
        subPages.add(NotLogged.getInstance());
        subPages.add(HomePage.getInstance());
    }

    public String onPage(ActionsInput action, PageHandler pageHandler) {
        if (action.getFeature().equals("search")) {
            pageHandler.setPrintMovie(search(action, pageHandler));
            return null;
        } else if (action.getFeature().equals("filter")){
            pageHandler.copyMovies(filter(action, pageHandler));
            return null;
        }
        return "Error";
    }

    public ArrayList<Movie> search(ActionsInput action, PageHandler pageHandler) {
        ArrayList<Movie> movies = new ArrayList<>();
        for (var movie: pageHandler.getPrintMovie()) {
            if (movie.getName().startsWith(action.getStartsWith())) {
                movies.add(movie);
            }
        }
        return movies;
    }

    public ArrayList<Movie> filter(ActionsInput action, PageHandler pageHandler) {
        pageHandler.setPrintMovie(MovieDataBase.getInstance().getMovies());
        ArrayList<Movie> movies = pageHandler.getPrintMovie();
        movies.removeIf((x) -> !x.contains(action.getFilters().getContains()));
        return movies;
    }

    public void getMovies(ActionsInput action, PageHandler pageHandler) {
        ArrayList <Movie> movies = MovieDataBase.getInstance().getMovies();
        pageHandler.copyMovies(movies);
    }
    public static MoviePage getInstance(){
        if (instance == null) {
            instance = new MoviePage();
            instance.init();
        }
        return instance;
    }
}
