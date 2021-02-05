package ir.sepidehSadati.nasa.modeleses.repo;

import ir.sepidehSadati.nasa.modeleses.entity.CameraEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author sepideh sadati
 */
@ResponseBody
public interface CameraRepo extends JpaRepository<CameraEntity, Integer> {
}
