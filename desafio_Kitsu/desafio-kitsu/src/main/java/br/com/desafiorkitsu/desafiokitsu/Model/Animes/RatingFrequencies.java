package br.com.desafiorkitsu.desafiokitsu.Model.Animes;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RatingFrequencies {
    @JsonProperty("2") //Anotação para indicar o nome da propriedade em JSON
    private String _2;
    @JsonProperty("3") 
    private String _3;
    @JsonProperty("4") 
    private String _4;
    @JsonProperty("5") 
    private String _5;
    @JsonProperty("6") 
    private String _6;
    @JsonProperty("7") 
    private String _7;
    @JsonProperty("8") 
    private String _8;
    @JsonProperty("9") 
    private String _9;
    @JsonProperty("10") 
    private String _10;
    @JsonProperty("11") 
    private String _11;
    @JsonProperty("12") 
    private String _12;
    @JsonProperty("13") 
    private String _13;
    @JsonProperty("14") 
    private String _14;
    @JsonProperty("15") 
    private String _15;
    @JsonProperty("16") 
    private String _16;
    @JsonProperty("17") 
    private String _17;
    @JsonProperty("18") 
    private String _18;
    @JsonProperty("19") 
    private String _19;
    @JsonProperty("20") 
    private String _20;

}
