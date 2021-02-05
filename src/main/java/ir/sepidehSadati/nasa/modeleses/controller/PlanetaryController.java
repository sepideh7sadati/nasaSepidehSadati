package ir.sepidehSadati.nasa.modeleses.controller;


import ir.sepidehSadati.nasa.modeleses.entity.CameraEntity;
import ir.sepidehSadati.nasa.modeleses.model.Photo;
import ir.sepidehSadati.nasa.modeleses.model.SearchCriteria;
import ir.sepidehSadati.nasa.modeleses.services.NasaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;


/**
 * PlanetaryController is to display a list of photos
 *
 * @author sepideh sadati
 */
@Controller
@RequestMapping("/planetary")
@RequiredArgsConstructor
public class PlanetaryController {

    private final NasaService nasaService;
    /**
     * searchPhotos is to search pictures
     * @return is List<Photo>
     * @author sepideh sadati
     */
    @GetMapping
    public @ResponseBody
    List<Photo> searchPhotos(SearchCriteria searchCriteria) {
        return nasaService.search(searchCriteria);
    }
    /**
     * getAllCameras is get information cameras
     *
     * @author sepideh sadati
     */
    @GetMapping("/camera")
    public @ResponseBody
    List<CameraEntity> getAllCameras() {
        return nasaService.getAllCameras();
    }


}
