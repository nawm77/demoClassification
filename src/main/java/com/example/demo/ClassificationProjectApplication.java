package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.tensorflow.SavedModelBundle;

import javax.imageio.ImageIO;
import java.io.File;
import java.io.IOException;

@SpringBootApplication
public class ClassificationProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ClassificationProjectApplication.class, args);
	}


}
