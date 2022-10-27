package br.com.desafiorkitsu.desafiokitsu.Model.Animes;

import java.util.ArrayList;
import br.com.desafiorkitsu.desafiokitsu.Model.Animes.AgeRatingEnum.AgeRating;
import br.com.desafiorkitsu.desafiokitsu.Model.Animes.ShowTypeEnum.ShowType;
import br.com.desafiorkitsu.desafiokitsu.Model.Animes.StatusEnum.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attributes{
    public String createdAt;
    public String updatedAt;
    public String slug;
    public String synopsis;
    public int coverImageTopOffset;
    public Titles titles;
    public String canonicalTitle;
    public ArrayList<String> abbreviatedTitles;
    public String averageRating;
    public RatingFrequencies ratingFrequencies;
    public int userCount;
    public int favoritesCount;
    public String startDate;
    public String endDate;
    public int popularityRank;
    public int ratingRank;
    public AgeRating ageRating;
    public String ageRatingGuide;
    public String subtype;
    public Status status;
    public String tba;
    public PosterImage posterImage;
    public CoverImage coverImage;
    public int episodeCount;
    public int episodeLength;
    public String youtubeVideoId;
    public ShowType showType;
    public boolean nsfw;
}
