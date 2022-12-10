package com.example.demo;

import com.example.demo.cnn_model.DrawModel;
import com.example.demo.cnn_model.Model;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;

@SpringBootApplication
public class ClassificationProjectApplication {

	public static void main(String[] args) throws IOException {
		SpringApplication.run(ClassificationProjectApplication.class, args);
		Model model = new DrawModel();
		System.out.println(Arrays.toString((model.predict(ImageIO.read(new File("C:\\Users\\Ilya\\Desktop\\demoClassification\\src\\main\\resources\\test5.jpg"))))));
	}


}
