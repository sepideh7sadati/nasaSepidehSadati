package ir.sepidehSadati.nasa.modeleses.model;

import lombok.Data;

/**
 * @author sepideh sadati
 */
@Data
public class SearchCriteria {
    private String apiKey;
    private Integer sol = 1000;
    private Integer page = 1;
    private String camera;
}
