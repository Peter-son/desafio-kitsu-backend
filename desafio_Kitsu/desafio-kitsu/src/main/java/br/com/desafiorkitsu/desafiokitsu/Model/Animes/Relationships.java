package br.com.desafiorkitsu.desafiokitsu.Model.Animes;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Relationships{
    private Genres genres;
    private Categories categories;
    private Castings castings;
    private Installments installments;
    private Mappings mappings;
    private Reviews reviews;
    private MediaRelationships mediaRelationships;
    private Characters characters;
    private Staff staff;
    private Productions productions;
    private Quotes quotes;
    private Episodes episodes;
    private StreamingLinks streamingLinks;
    private AnimeProductions animeProductions;
    private AnimeCharacters animeCharacters;
    private AnimeStaff animeStaff; 
   }
