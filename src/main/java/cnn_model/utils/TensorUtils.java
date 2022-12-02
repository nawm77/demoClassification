package cnn_model.utils;

import org.tensorflow.Tensor;

import java.awt.image.BufferedImage;

import java.awt.image.Raster;
import java.nio.FloatBuffer;

public class TensorUtils {
    public static Tensor<Float> grayScaleTensorFromImage(BufferedImage image, int imgWidth, int imgHeight) {

        final int channels = 1;
        // Generate image file to array
        int index = 0;
        FloatBuffer fb = FloatBuffer.allocate(imgWidth * imgHeight);
        Raster raster = image.getData();
        // Convert image file to multi-dimension array
        for (int row = 0; row < imgHeight; row++) {
            for (int column = 0; column < imgWidth; column++) {
                int pixel = raster.getSample(row, column, 0);
                fb.put(index, pixel);
                index++;
            }
        }

        return Tensor.create(new long[]{1, imgWidth, imgHeight, channels}, fb);
    }
}