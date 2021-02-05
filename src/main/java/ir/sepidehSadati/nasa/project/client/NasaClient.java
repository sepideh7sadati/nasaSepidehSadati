package ir.sepidehSadati.nasa.project.client;

import ir.sepidehSadati.nasa.project.model.NasaPhotos;
import ir.sepidehSadati.nasa.project.model.SearchCriteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;

/**
 * NasaClient is to call an external service
 *
 * @author sepideh sadati
 */
public class NasaClient extends RestTemplate {

        public NasaPhotos search(SearchCriteria searchCriteria){

        URI uri = UriComponentsBuilder.fromHttpUrl("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos")
                .queryParam("api_key", searchCriteria.getApiKey())
                .queryParam("sol", searchCriteria.getSol())
                .queryParam("camera", searchCriteria.getCamera())
                .queryParam("page", searchCriteria.getPage())
                .build().toUri();


        ResponseEntity<NasaPhotos> entity = getForEntity(uri, NasaPhotos.class);
        if(entity.getStatusCode() == HttpStatus.FORBIDDEN){
            throw new RuntimeException("Api key is invalid!");
        }
        return entity.getBody();
    }
}
