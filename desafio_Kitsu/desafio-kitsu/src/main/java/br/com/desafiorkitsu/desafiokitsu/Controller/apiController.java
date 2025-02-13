package br.com.desafiorkitsu.desafiokitsu.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import br.com.desafiorkitsu.desafiokitsu.Model.Animes.Root;
import br.com.desafiorkitsu.desafiokitsu.Model.Animes.RootListD;
import br.com.desafiorkitsu.desafiokitsu.Model.Mangas.Root_Mangas;
import br.com.desafiorkitsu.desafiokitsu.Model.Mangas.Root_MangasListD;
import br.com.desafiorkitsu.desafiokitsu.Services.apiService;
import io.swagger.annotations.ApiOperation;

@RestController // Anotação que indica a classe pertencente ao mapeamento de dados para
                // solicitações
             
@RequestMapping("/desafio") // Anotação usada para mapear uma URI padrão
public class apiController {
    
    @Autowired // Anotação responsável por injetar um Bean na definição do campo
    apiService service;

    @ApiOperation(value = "Retorna um anime específico") // Anotação para descrever o endpoint
    @GetMapping(value = "/anime/{id}") // Anotaçãpo para tratar solicitações Get, de acordo com as expressões da URI
    public ResponseEntity<Root> animeId(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.infoAnime(id)); // Retorna o código de status e o corpo que recebe o método com um anime                                                                                                                           
    }

    @ApiOperation(value = "Retorna uma lista com os animes mais populares") // Anotação para descrever o endpoint
    @GetMapping(value = "/animesAlta") // Anotaçãpo para tratar solicitações Get, de acordo com as expressões da URI
    public RootListD animesAlta() {
        return service.listaAnimesAlta(); // Retorna o método com os animes em alta
    }

    @ApiOperation(value = "Retorna uma lista com a filtragem de um anime ou manga") // Anotação para descrever o endpoint
    @GetMapping("/filtrando/{escolha}/{atributo}/{valor}") // Anotaçãpo para tratar solicitações Get, de acordo com as
                                                           // expressões da URI
    public ResponseEntity<RootListD> filtraBusca(@PathVariable String escolha, @PathVariable String atributo,
            @PathVariable String valor) {
        return ResponseEntity.status(HttpStatus.OK).body(service.filtraAnimeManga(escolha, atributo, valor));
        // Retorna o código de status e o corpo que recebe o método com um anime ou manga                                                          
    }

    @ApiOperation(value = "Retorna um manga específico") // Anotação para descrever o endpoint
    @GetMapping(value = "/manga/{id}") // Anotaçãpo para tratar solicitações Get, de acordo com as expressões da URI
    public ResponseEntity<Root_Mangas> mangaId(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.infoManga(id)); // Retorna o código de status e o corpo que recebe o método com um manga                                                                                                                                                                                                                                 
    }

    @ApiOperation(value = "Retorna uma lista com os mangas mais populares") // Anotação para descrever o endpoint
    @GetMapping(value = "/mangasAlta") // Anotaçãpo para tratar solicitações Get, de acordo com as expressões da URI
    public Root_MangasListD Mangas() {
        return service.listaMangasAlta(); // Retorna o método com os mangas em alta
    }

    @ApiOperation(value = "Retorna um episódio de um anime específico") // Anotação para descrever o endpoint
    @GetMapping(value = "/episodio/{id}") // Anotaçãpo para tratar solicitações Get, de acordo com as expressões da URI
    public ResponseEntity<Root> episodioId(@PathVariable String id) {
    return ResponseEntity.status(HttpStatus.OK).body(service.infoEpisodio(id)); // Retorna o código de status e o corpo que recebe o método com um episódio
    }

    @ApiOperation(value = "Retorna uma lista com os itens mais pesquisados") // Anotação para descrever o endpoint
    @GetMapping(value = "/itensPesquisados") // Anotaçãpo para tratar solicitações Get, de acordo com as expressões da URI
    public List<Object[]> pesquisados(){ 
        return service.listaPesquisas(); // Retona o método com os itens mais pesquisados
    }
}
