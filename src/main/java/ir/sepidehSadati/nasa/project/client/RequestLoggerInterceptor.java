package ir.sepidehSadati.nasa.project.client;

import ir.sepidehSadati.nasa.project.entity.ApiRequestEntity;
import ir.sepidehSadati.nasa.project.repo.ApiRequestRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

/**
 * @author sepideh sadati
 */
@Component
@RequiredArgsConstructor
public class RequestLoggerInterceptor implements ClientHttpRequestInterceptor {

    private final ApiRequestRepo apiRequestRepo;

    @Override
    public ClientHttpResponse intercept(HttpRequest httpRequest, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        ApiRequestEntity apiRequest = new ApiRequestEntity();
        apiRequest.setMethod(httpRequest.getMethodValue());
        LocalDateTime start = LocalDateTime.now();
        ClientHttpResponse execute = execution.execute(httpRequest, bytes);
        LocalDateTime end = LocalDateTime.now();
        Long responseTime = ChronoUnit.MILLIS.between(start, end);
        apiRequest.setResponseTime(responseTime);
        apiRequestRepo.asyncSave(apiRequest);
        return execute;
    }

}
