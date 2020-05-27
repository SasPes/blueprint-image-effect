package com.saspes;

import com.saspes.opencv.ImageProcessingImpl;

public class Test {

    public static void main(String[] args) {
        nu.pattern.OpenCV.loadShared();
        
        ImageProcessingImpl imageProcessing = new ImageProcessingImpl();
        imageProcessing.blueprint();
    }

}
