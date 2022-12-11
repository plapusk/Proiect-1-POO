package user;

public class PremiumUser implements Visitor{
    private static final int PREMIUM_FREE_MOVIES = 15;
    private int freeMovies;

    public PremiumUser(){
        freeMovies = PREMIUM_FREE_MOVIES;
    }

    public void visit(){

    }
}
