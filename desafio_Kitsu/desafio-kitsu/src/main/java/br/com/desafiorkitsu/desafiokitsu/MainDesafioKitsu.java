package br.com.desafiorkitsu.desafiokitsu;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;


@SpringBootApplication //Anotação que verifica automaticamente os componentes no pacote atual e seus subpacotes
//@Configuration
public class MainDesafioKitsu {

    @Value("${url.api}") //Anotação que injeta o valor de uma propriedade definida no arquivo 'application.properties'
    public String urlApi;

	@Bean //Anotação explicita de um Bean
    public WebClient webClient(WebClient.Builder builder) { //Método que retorna uma instância para realizar solicitações HTTP
        return builder
                .baseUrl(urlApi) //Configura a URL base para solicitações
                .defaultHeader(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON_VALUE) //Determina os cabeçalhos, adicionando a cada solicitação
                .build(); //Constroe a tinstância do WebClient
    }

	public static void main(String[] args) {
		SpringApplication.run(MainDesafioKitsu.class, args);
	}

}
