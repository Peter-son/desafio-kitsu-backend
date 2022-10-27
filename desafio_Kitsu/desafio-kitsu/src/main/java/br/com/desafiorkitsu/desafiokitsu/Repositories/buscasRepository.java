package br.com.desafiorkitsu.desafiokitsu.Repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import br.com.desafiorkitsu.desafiokitsu.Model.Pesquisas.buscasRealizadas;

@Repository // Anotação que determina a ´classe como um repositório
public interface buscasRepository extends JpaRepository<buscasRealizadas, Integer>{
    // Anotação para selecionar o elementos titulo e o tipo, bem como contar a quantidade de vezes que cada tipo de pesquisa foi registrada
    // no banco de dados, ordenando de acordo com os mais pesquisados  
    @Query(value = "select title, type, count(type) as Vezes_Pesquisadas from TB_BUSCAS group by type, title order by Vezes_Pesquisadas desc", nativeQuery=true)
    List<Object[]> findResearches();
}
