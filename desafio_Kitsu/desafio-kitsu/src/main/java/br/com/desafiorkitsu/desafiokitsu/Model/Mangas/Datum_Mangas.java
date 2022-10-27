package br.com.desafiorkitsu.desafiokitsu.Model.Mangas; 
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Datum_Mangas{
    public String id;
    public String type;
    public Links links;
    public Attributes_Mangas attributes;
    public Relationships relationships;
}
