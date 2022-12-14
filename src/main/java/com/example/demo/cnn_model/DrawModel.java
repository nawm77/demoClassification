package com.example.demo.cnn_model;

import com.example.demo.cnn_model.utils.TensorUtils;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.tensorflow.SavedModelBundle;
import org.tensorflow.Tensor;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;

@Service
public class DrawModel implements Model {
    private final URL modelPath;

    public DrawModel() throws IOException {

        String folderName = "drawMIIT";

        modelPath = new ClassPathResource(folderName).getURL();

    }

    @Override
    public float[] predict(BufferedImage image) {
        float[] predicted;
        try (SavedModelBundle modelBundle = SavedModelBundle.load(modelPath.getPath().substring(1), "serve")) {
            Tensor<Float> imageTensor = TensorUtils.grayScaleTensorFromImage(image, 255, 255);
            Tensor<Float> result = modelBundle.session()
                    .runner()
                    .feed("serving_default_rescaling_input:0", imageTensor)
                    .fetch("StatefulPartitionedCall:0")
                    .run()
                    .get(0)
                    .expect(Float.class);
            predicted = result.copyTo(new float[1][10])[0];
        }
        return predicted;
    }

    public URL getModelPath() {
        return modelPath;
    }
}
