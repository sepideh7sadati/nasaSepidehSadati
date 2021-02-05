package ir.sepidehSadati.nasa.project.repo;

import ir.sepidehSadati.nasa.project.entity.ApiRequestEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.scheduling.annotation.Async;

/**
 * @author sepideh sadati
 */
public interface ApiRequestRepo extends JpaRepository<ApiRequestEntity, Integer> {

    @Async
    default ApiRequestEntity asyncSave(ApiRequestEntity apiRequest){
         return save(apiRequest);
    }

}
