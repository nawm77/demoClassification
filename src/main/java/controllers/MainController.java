package controllers;

import cnn_model.DrawModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MainController {
    private final DrawModel drawModel;

    @Autowired
    public MainController(DrawModel drawModel) {
        this.drawModel = drawModel;
    }

    @GetMapping("/")
    public String mainPage(){
        return "index";
    }

    @PostMapping("/{url}")
    public String savePic(@RequestParam("url") String url){
        return url;
    }

    @GetMapping("/predict")
    public String getPredict(Model model){
        return "";
    }
}
