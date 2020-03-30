import java.util.ArrayList;

public class Episode extends Video{
    private final int number;

    public Episode(String name, Director director, Util.ageRatingsEnum ageRating, ArrayList<Util.genresEnum> genres, int number){
        super(name, director, ageRating, genres, null);
        this.number = number;
    }
}