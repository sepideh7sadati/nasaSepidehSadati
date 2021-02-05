package ir.sepidehSadati.nasa.project.client;

import ir.sepidehSadati.nasa.project.repo.ApiRequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.ClientHttpRequestInterceptor;

import java.util.Collections;
import java.util.List;

@Configuration
@RequiredArgsConstructor
public class NasaRestTemplateConfig {

    private final ApiRequestRepo apiRequestRepo;

    @Bean
    public NasaClient getNasaRestTemplate(){
        NasaClient nasaRestTemplate = new NasaClient();
        nasaRestTemplate.setInterceptors(getAcceptors());
        return nasaRestTemplate;
    }

    private List<ClientHttpRequestInterceptor> getAcceptors() {
        return Collections.singletonList(new RequestLoggerInterceptor(apiRequestRepo));
    }


}
