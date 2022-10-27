package br.com.desafiorkitsu.desafiokitsu.Model.Pesquisas;

import java.time.LocalDateTime;

import javax.persistence.*;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity // Anotação para inbdicar que é uma entidade JPA
@Table(name= "TB_BUSCAS") // Anotação para indicar o nome da tabela, referente ao banco de dados
public class buscasRealizadas {
    @Id // Anotação para que o JPA a reconheça como o ID do objeto
    @GeneratedValue(strategy = GenerationType.AUTO) // Anotação para gerear automaticamente o ID
    private int id;
    @Column(nullable = false, length = 10) // Anotação que indica o nome de uma coluna e as respectivas  delimitações
    private String type;
    @Column(nullable = false, length = 80)
    private String title;
    @Column(nullable = false)
    private LocalDateTime registerDateTime;
    
}
