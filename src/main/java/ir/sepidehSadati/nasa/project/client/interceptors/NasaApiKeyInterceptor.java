package ir.sepidehSadati.nasa.project.client.interceptors;

import org.springframework.http.HttpRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.client.support.HttpRequestWrapper;
import org.springframework.web.util.UriComponentsBuilder;

import java.io.IOException;
import java.net.URI;

public class NasaApiKeyInterceptor implements ClientHttpRequestInterceptor {

    private String apiKey = "oFgXCOaMqsMHIhjgchThvXxVWk2kHY9Sh5uH9gUV";

    @Override
    public ClientHttpResponse intercept(HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        HttpRequestWrapper httpRequestWrapper = addApiKey(request);
        ClientHttpResponse execute = execution.execute(httpRequestWrapper, bytes);
        if(execute.getStatusCode() == HttpStatus.FORBIDDEN){
            throw new RuntimeException("invalid api key");
        }
        return execute;
    }

    private HttpRequestWrapper addApiKey(HttpRequest request) {
        URI uri = UriComponentsBuilder.fromHttpRequest(request)
                .queryParam("api_key", apiKey)
                .queryParam("sol", 1000)
                .build().toUri();

        return new HttpRequestWrapper(request) {

            @Override
            public URI getURI() {
                return uri;
            }
        };
    }
}