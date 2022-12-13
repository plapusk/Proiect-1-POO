package input;

import java.util.ArrayList;

public class Contains {
    private ArrayList<String> actors;
    private ArrayList<String> genre;

    public ArrayList<String> getActors() {
        return actors;
    }

    public void setActors(ArrayList<String> actors) {
        this.actors = actors;
    }

    public ArrayList<String> getGenre() {
        return genre;
    }

    public void setGenre(ArrayList<String> genre) {
        this.genre = genre;
    }

    @Override
    public String toString() {
        return "Contains{" +
                "actors=" + actors +
                ", genre=" + genre +
                '}';
    }
}
