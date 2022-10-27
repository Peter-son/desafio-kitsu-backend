package br.com.desafiorkitsu.desafiokitsu.Model.Mangas;

import java.util.ArrayList;
import br.com.desafiorkitsu.desafiokitsu.Model.Mangas.AgeRatingEnum_Mangas.AgeRating;
import br.com.desafiorkitsu.desafiokitsu.Model.Mangas.MangaTypeEnum.MangaType;
import br.com.desafiorkitsu.desafiokitsu.Model.Mangas.StatusEnum.Status;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Attributes_Mangas{
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
    public Number chapterCount;
    public Number volumeCount;
    public String serialization;
    public MangaType mangaType; //Enum
}
