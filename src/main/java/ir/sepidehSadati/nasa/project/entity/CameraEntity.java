package ir.sepidehSadati.nasa.project.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * @author sepideh sadati
 */
@Entity(name = "camera")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CameraEntity {

    @Id
    @GeneratedValue
    private Integer id;
    private String abbreviation;
    private String title;

}
