package cnn_model;


import com.example.demo.cnn_model.DrawModel;
import com.example.demo.cnn_model.Model;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;


public class ModelTest {

    @Test
    public void creationTest() throws IOException {
        DrawModel model = new DrawModel();
//        Assertions.assertEquals("/D:/demoClassification/target/classes/drawMIIT",
        Assertions.assertEquals("/C:/Users/Ilya/Desktop/demoClassification/target/classes/drawMIIT",
                model.getModelPath().getPath());
    }

    @Test
    public void nonNullPrediction() throws IOException {
        Model drawModel = new DrawModel();
        URL imageUrl = new ClassPathResource("test5.jpg").getURL();
        BufferedImage image = ImageIO.read(imageUrl);
        System.out.println(Arrays.toString(drawModel.predict(image)));
        Assertions.assertNotEquals(drawModel.predict(image), null);
    }

    @Test
    public void nonNullPrediction2() throws IOException {
        Model drawModel = new DrawModel();
        URL imageUrl = new ClassPathResource("pict.jpg").getURL();
        BufferedImage image = ImageIO.read(imageUrl);
        System.out.println(Arrays.toString(drawModel.predict(image)));
        Assertions.assertNotEquals(drawModel.predict(image), null);
    }

    @Test
    public void nonNullPrediction3() throws IOException {
        Model drawModel = new DrawModel();
        URL imageUrl = new ClassPathResource("test1.jpg").getURL();
        BufferedImage image = ImageIO.read(imageUrl);
        System.out.println(Arrays.toString(drawModel.predict(image)));
        Assertions.assertNotEquals(drawModel.predict(image), null);
    }

    @Test
    public void nonNullPrediction4() throws IOException {
        Model drawModel = new DrawModel();
        URL imageUrl = new ClassPathResource("test2.jpg").getURL();
        BufferedImage image = ImageIO.read(imageUrl);
        System.out.println(Arrays.toString(drawModel.predict(image)));
        Assertions.assertNotEquals(drawModel.predict(image), null);
    }
}
