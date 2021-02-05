package ir.sepidehSadati.nasa.modeleses;


import ir.sepidehSadati.nasa.modeleses.services.NasaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author sepideh sadati
 */
@Controller
public class MainController {

    private NasaService nasaService;

    @Autowired
    public MainController(NasaService nasaService) {
        this.nasaService = nasaService;

    }

    @RequestMapping(value = "")
    public String index(Model model) {
        model.addAttribute("camera", nasaService.getAllCameras());
        return "index";
    }
}
