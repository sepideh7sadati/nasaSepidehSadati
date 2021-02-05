
package ir.sepidehSadati.nasa.project.model;

import com.fasterxml.jackson.annotation.*;
import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sepideh sadati
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@Data
public class Photo {

    @JsonProperty("id")
    private Integer id;
    @JsonProperty("sol")
    private Integer sol;
    @JsonProperty("camera")
    private Camera camera;
    @JsonProperty("img_src")
    private String imgSrc;
    @JsonProperty("earth_date")
    private String earthDate;
    @JsonProperty("rover")
    private Rover rover;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
