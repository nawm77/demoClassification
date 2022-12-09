package com.example.demo.cnn_model;

import java.awt.image.BufferedImage;

public interface Model {
    float[] predict(BufferedImage image);
}
