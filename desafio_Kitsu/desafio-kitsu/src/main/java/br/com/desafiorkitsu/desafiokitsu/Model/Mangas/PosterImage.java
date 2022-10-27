package br.com.desafiorkitsu.desafiokitsu.Model.Mangas; 
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PosterImage{
    public String tiny;
    public String large;
    public String small;
    public String medium;
    public String original;
    public Meta meta;
}
