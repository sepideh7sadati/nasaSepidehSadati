package ir.sepidehSadati.nasa.project.services;


import ir.sepidehSadati.nasa.project.client.NasaClient;
import ir.sepidehSadati.nasa.project.entity.CameraEntity;
import ir.sepidehSadati.nasa.project.model.Photo;
import ir.sepidehSadati.nasa.project.model.SearchCriteria;
import ir.sepidehSadati.nasa.project.repo.CameraRepo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author sepideh sadati
 */
@Service
@RequiredArgsConstructor
public class NasaService {

    private final NasaClient nasaClient;

    private final CameraRepo cameraRepo;

    public List<Photo> search(SearchCriteria searchCriteria){
        return nasaClient.search(searchCriteria).getPhotos();
    }

    public List<CameraEntity> getAllCameras() {
        return cameraRepo.findAll();
    }
}
