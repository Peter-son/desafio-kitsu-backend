package br.com.desafiorkitsu.desafiokitsu.Model.Animes;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Datum{
    private String id;
    private String type;
      private Links links;
      private Attributes attributes;
      private Relationships relationships;   
}