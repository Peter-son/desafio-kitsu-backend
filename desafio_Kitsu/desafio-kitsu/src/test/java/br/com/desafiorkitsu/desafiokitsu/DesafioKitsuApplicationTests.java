package br.com.desafiorkitsu.desafiokitsu;



import org.junit.jupiter.api.Test;
//import org.springframework.beans.factory.annotation.Autowired;


//import br.com.desafiorkitsu.desafiokitsu.Model.Animes.Datum;
//import br.com.desafiorkitsu.desafiokitsu.Services.apiService;


/*import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.desafiorkitsu.desafiokitsu.Model.Animes.Datum;*/



//@SpringBootTest
//@RunWith(SpringRunner.class)
public class DesafioKitsuApplicationTests {

/* 	@Autowired
	private apiService service;*/

	@Test	
	public void ConsumoAPI() {
		/*RestTemplate template = new RestTemplate();

		UriComponents uri = UriComponentsBuilder.newInstance()
		.scheme("https")
		.host("kitsu.io")
		.path("api/edge/trending/anime")
		.build();
		//https://kitsu.io/api/edge
		ResponseEntity<Datum> entity = template.getForEntity(uri.toUriString(), Datum.class);
		System.out.println(entity.getBody().getId());
		Datum datum = service.infoAnime("4");
System.out.println(datum);*/
	}
}
