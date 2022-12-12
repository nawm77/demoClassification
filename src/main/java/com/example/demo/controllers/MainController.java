package com.example.demo.controllers;

import com.example.demo.Models.Name;
import com.example.demo.cnn_model.DrawModel;
import com.example.demo.cnn_model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Base64;
import java.util.List;

@Controller
@RequestMapping(value = "/")
public class MainController {
    private String url = "";
    private byte[] image;
    private List predList = new ArrayList();
    private String classPred;
    @PostMapping("/saveCanvasImage")
    public String save(@RequestParam(value = "imageBase64") String imageData) {
        System.out.println(imageData);
        url = imageData.split(",")[1];
        image = Base64.getDecoder().decode(url);
        System.out.println("Took image");
        return "hey";
    }

    @GetMapping("/predict")
    public String getHi(org.springframework.ui.Model model1) {
        predList.add("Самолёт");
        predList.add("Наковальня");
        predList.add("Облако");
        predList.add("Краб");
        predList.add("Луна");
        predList.add("Квадрат");
        predList.add("Звезда");
        predList.add("Треугольник");
        predList.add("Мельница");
        predList.add("Зебра");
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(image);
            BufferedImage img = ImageIO.read(bis);
            Model model = new DrawModel();
            float[] predFloat = model.predict(img);
            List<Float> floatList = new ArrayList<>();
            float max = predFloat[0];
            for (int i = 1; i < predFloat.length; i++) {
                if (predFloat[i] > max) {
                    max = predFloat[i];
                }
                floatList.add(predFloat[i]);
            }
            classPred= (String) predList.get(floatList.indexOf(max)+1);
            System.out.println(predList.get(floatList.indexOf(max)+1));
            System.out.println(Arrays.toString(model.predict(img)));
            Name name = new Name(classPred);
            model1.addAttribute("name", name);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "hey";
    }

    @GetMapping("/paint")
    public String getPaint() {
        return "paint";
    }

    @GetMapping("/")
    public String getHello(){
        return "index";
    }
}
