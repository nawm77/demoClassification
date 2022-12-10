package com.example.demo.controllers;

import com.example.demo.cnn_model.DrawModel;
import com.example.demo.cnn_model.Model;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.util.Arrays;
import java.util.Base64;

@Controller
@RequestMapping(value="/")
public class MainController {
    private String url = "";
    private byte[] image;
    private final String fileName = "test.jpg";

    @PostMapping("/saveCanvasImage")
    public String save(@RequestParam(value = "imageBase64") String imageData) {
        url = imageData.split(",")[1];
        image = Base64.getDecoder().decode(url);
        return "hey";
    }

    @GetMapping("/hey")
    public String getHi() {
        try {
            ByteArrayInputStream bis = new ByteArrayInputStream(image);
            BufferedImage img = ImageIO.read(bis);
            Model model = new DrawModel();
            System.out.println(model.predict(img));
            System.out.println(img);
            System.out.println(Arrays.toString(model.predict(img)));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "hey";
    }
}
