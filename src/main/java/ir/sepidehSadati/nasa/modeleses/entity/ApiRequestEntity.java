package ir.sepidehSadati.nasa.modeleses.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

/**
 * @author sepideh sadati
 */
@Entity(name = "api_request")
@Data
public class ApiRequestEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String method;
    private Long responseTime;
    private LocalDateTime creation = LocalDateTime.now();

}
