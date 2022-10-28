package br.com.desafiorkitsu.desafiokitsu.Services;


import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.desafiorkitsu.desafiokitsu.Model.Animes.Root;
import br.com.desafiorkitsu.desafiokitsu.Model.Animes.RootListD;
import br.com.desafiorkitsu.desafiokitsu.Model.Mangas.Root_Mangas;
import br.com.desafiorkitsu.desafiokitsu.Model.Mangas.Root_MangasListD;
import br.com.desafiorkitsu.desafiokitsu.Model.Pesquisas.buscasRealizadas;
import br.com.desafiorkitsu.desafiokitsu.Repositories.buscasRepository;
import reactor.core.publisher.Mono;


@Service // Anotação que indica a classe pertencente a camada de serviço
public class apiService {

    @Autowired // Anotação para injetar um Bean que gerencia o relacionamento com outros Beans
    private WebClient webClient; // Declaração de um objeto para realizar solicitações para uma api

    private final buscasRepository pesquisas;

    public apiService(buscasRepository pesquisas) {
    this.pesquisas = pesquisas;
}


    @Value("${url.api}") // Anotação que injeta o valor de uma propriedade definida no arquivo
                         // 'application.properties'                    
    private String urlApi;

    private RestTemplate rest = new RestTemplate(); // Declaração de um cliente REST usado para consumir a api

    public Root infoAnime(String id) { // Método que retorna um anime, conforme o identificador
        Mono<Root> monoAnime = this.webClient // Representação do fluxo que realiza solicitações HTTP
                .method(HttpMethod.GET) // Determina uma solicitação para o arquivo HttpMethod
                .uri("/anime/{id}", id) // Passa a url adicional com as variável
                .retrieve() // Executa a solicitação HTTP e recupera o corpo da resposta
                .bodyToMono(Root.class); // Extrai o corpo para um Mono, conforme o argumento passado

        Root rta = monoAnime.block(); // Espera execução da requisição e devolve o tipo de objeto definido

        buscasRealizadas busca = new buscasRealizadas(); // 
         busca.setType(rta.getData().getType()); // Atribuição de um valor na variável 'type' 
       busca.setTitle(rta.getData().getAttributes().getSlug()); // Atribuição de um valor na variável 'title' 
       //busca.setMensagem("primeira");
       busca.setRegisterDateTime(LocalDateTime.now(ZoneId.of("UTC"))); // Atribuição de um valor na variável 'registerDateTime', no formato UTC
       salvaBuscas(busca); // Chamada do método com com o parâmetro para salvar as buscas realizadas, 

        return rta;
    }

    public RootListD listaAnimesAlta() { // Método que retorna os animes em alta
        return rest.getForEntity(urlApi.concat("/trending/anime"), RootListD.class).getBody(); // Recupera a URI e o
                                                                                               // corpo da resposta, brm
                                                                                               // como obtem o código de
                                                                                               // status da resposta
    }

    // Método que retorna um anime ou manga, conforme o filtro estipulado para cada caso
       public RootListD filtraAnimeManga(String escolha, String atributo, String valor) {
        Mono<RootListD> monoAM = this.webClient // Representação do fluxo que realiza solicitações HTTP
                .method(HttpMethod.GET) // Determina uma solicitação para o arquivo HttpMethod
                .uri("/{escolha}?filter[{atributo}]={valor}", escolha, atributo, valor) // Passa a url adicional com as
                                                                                        // variáveis
                .retrieve() // Executa a solicitação HTTP e recupera o corpo da resposta
                .bodyToMono(RootListD.class); // Extrai o corpo para um Mono, conforme o argumento passado
        RootListD  rtl = monoAM.block(); // Espera execução da requisição e devolve o tipo de objeto definido
            return rtl;
    }

    public Root_Mangas infoManga(String id) { // Método que retorna um manga, conforme o identificador
        Mono<Root_Mangas> monoManga = this.webClient // Representação do fluxo que realiza solicitações HTTP
                .method(HttpMethod.GET) // Determina uma solicitação para o arquivo HttpMethod
                .uri("/manga/{id}", id) // Passa a url adicional com as variável
                .retrieve() // Executa a solicitação HTTP e recupera o corpo da resposta
                .bodyToMono(Root_Mangas.class); // Extrai o corpo para um Mono, conforme o argumento passado

        Root_Mangas rtm = monoManga.block(); // Espera execução da requisição e devolve o tipo de objeto definido
      
        buscasRealizadas busca = new buscasRealizadas();
         busca.setType(rtm.getData().getType()); // Atribuição de um valor na variável 'type' 
       busca.setTitle(rtm.getData().getAttributes().getSlug()); // Atribuição de um valor na variável 'title' 
       busca.setRegisterDateTime(LocalDateTime.now(ZoneId.of("UTC"))); // Atribuição de um valor na variável 'registerDateTime', no formato UTC
       salvaBuscas(busca); // Chamada do método com com o parâmetro para salvar as buscas realizadas, 
        return rtm;
    }

    public Root_MangasListD listaMangasAlta() { // Método que retorna os mangas em alta
        return rest.getForEntity(urlApi.concat("/trending/manga"), Root_MangasListD.class).getBody(); // Recupera a URI
                                                                                                      // e o corpo da
                                                                                                      // resposta, bem
                                                                                                      // como obtem o
                                                                                                      // código de
                                                                                                      // status da
                                                                                                      // resposta
    }
    public Root infoEpisodio(String id) { // Método que retorna um episodio, conforme o identificador
        Mono<Root> monoEpisodio = this.webClient // Representação do fluxo que realiza solicitações HTTP
                .method(HttpMethod.GET) // Determina uma solicitação para o arquivo HttpMethod
                .uri("/episodes/{id}", id) // Passa a url adicional com as variável
                .retrieve() // Executa a solicitação HTTP e recupera o corpo da resposta
                .bodyToMono(Root.class); // Extrai o corpo para um Mono, conforme o argumento passado

        Root rte = monoEpisodio.block(); // Espera execução da requisição e devolve o tipo de objeto definido
        
        buscasRealizadas busca = new buscasRealizadas();
         busca.setType(rte.getData().getType()); // Atribuição de um valor na variável 'type' 
       busca.setTitle(rte.getData().getAttributes().getTitles().getEn_jp()); // Atribuição de um valor na variável 'title' 
       busca.setRegisterDateTime(LocalDateTime.now(ZoneId.of("UTC"))); // Atribuição de um valor na variável 'registerDateTime', no formato UTC
       salvaBuscas(busca); // Chamada do método com com o parâmetro para salvar as buscas realizadas, 
        return rte;
    }

    @Transactional // Anotação que garante a execução em um contexto transacional (CRUD), caso ocorra algum erro em determinado processo, a atividade é revertida 
    public void salvaBuscas(buscasRealizadas busca){
               pesquisas.save(busca);
    }

    public List<Object[]> listaPesquisas(){ // Método que retorna uma lista de objetos com elementos específicos do banco de dados
        return pesquisas.findResearches();
    }
}
