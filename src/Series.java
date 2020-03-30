import java.util.ArrayList;

public class Series extends Media {
    private ArrayList<ArrayList<Episode>> episodes;

    public Series(String name, Util.ageRatingsEnum ageRating, ArrayList<Util.genresEnum> genres) {
        super(name, ageRating, genres);
        this.episodes = new ArrayList<ArrayList<Episode>>();
    }

    public void incrementViews(int episode, int season) {
        Episode ep = getEpisode(episode, season);
        ep.incrementView();
    }

    public void addUserRating(float _userRating, int episode, int season) {
        Episode ep = getEpisode(episode, season);
        ep.addUserRating(_userRating);
    }

    private Episode getEpisode(int episode, int season) {
        if (season > this.episodes.size()) {
            System.out.println("O número da temporada digitada é invalido");
        }
        ArrayList<Episode> _season = this.episodes.get(season - 1);
        if (episode < 0 || episode > _season.size()) {
            System.out.println("O número do episódio que digitou é invalido");
        }
        return _season.get(episode);
    }
}
