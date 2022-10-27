package br.com.desafiorkitsu.desafiokitsu.Model.Mangas; 
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Relationships{
    public Genres genres;
    public Categories categories;
    public Castings_Mangas castings;
    public Installments installments;
    public Mappings mappings;
    public Reviews reviews;
    public MediaRelationships mediaRelationships;
    public Characters characters;
    public Staff staff;
    public Productions productions;
    public Quotes quotes;
    public Chapters chapters;
    public MangaCharacters mangaCharacters;
    public MangaStaff mangaStaff;
}
