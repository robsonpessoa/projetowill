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

    public void addEpisode(Episode episode, int season) {
        // verificar se já existe a temporada. Se já existir, pega ela, senão cria e adiciona na lista de temporadas.
        ArrayList<Episode> _season = getSeason(season);
        if (_season == null) {
            _season = new ArrayList<>();
            this.episodes.add(_season);
        }

        // adicionar o episódio no fim da lista
        _season.add(episode);
    }

    private Episode getEpisode(int episode, int season) {
        ArrayList<Episode> _season = getSeason(season);
        if (episode < 0 || episode > _season.size()) {
            System.out.println("O número do episódio que digitou é invalido");
            return null;
        }

        boolean found = false;
        Episode result = null;
        for (int i = 0; i < _season.size() && !found; ++i) {
            Episode ep = _season.get(i);
            if (ep.getNumber() == episode) {
                result = ep;
                found = true;
            }
        }

        return result;
    }

    private ArrayList<Episode> getSeason(int season) {
        if (season > this.episodes.size()) {
            System.out.println("O número da temporada digitada é invalido");
            return null;
        }
        return this.episodes.get(season - 1);
    }

    private boolean hasSeason(int season) {
        return getSeason(season) != null;
    }

    private boolean hasEpisode(int episode, int season) {
        return hasSeason(season) && getEpisode(episode, season) != null;
    }
}
