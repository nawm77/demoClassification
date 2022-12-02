package cnn_model;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.ResourceLoader;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;


public class ModelTest {

    @Test
    public void creationTest() throws IOException {
        DrawModel model = new DrawModel();
        Assertions.assertEquals("/D:/demoClassification/target/classes/drawMIIT",
                model.getModelPath().getPath());
    }

    @Test
    public void nonNullPrediction() throws IOException {
        Model drawModel = new DrawModel();
        URL imageUrl = new ClassPathResource("test5.jpg").getURL();
        BufferedImage image = ImageIO.read(imageUrl);
        Assertions.assertNotEquals(drawModel.predict(image), null);
    }
}
