package user;

public class StandardUser implements Visitor{
    private static final int STANDARD_FREE_MOVIES = 15;
    private int freeMovies = 0;
    public StandardUser() {
        freeMovies = STANDARD_FREE_MOVIES;
    }
    public void visit(){

    }
}
